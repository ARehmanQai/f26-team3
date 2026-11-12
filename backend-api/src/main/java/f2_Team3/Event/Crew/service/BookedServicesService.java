package f2_Team3.Event.Crew.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import f2_Team3.Event.Crew.dto.BookedServicesDTO;
import f2_Team3.Event.Crew.dto.TimeSlotDTO;
import f2_Team3.Event.Crew.entity.BookedServices;
import f2_Team3.Event.Crew.entity.Customer;
import f2_Team3.Event.Crew.entity.EventService;
import f2_Team3.Event.Crew.entity.Provider;
import f2_Team3.Event.Crew.entity.TimeSlot;
import f2_Team3.Event.Crew.repository.BookedServicesRepository;
import f2_Team3.Event.Crew.repository.CustomerRepository;
import f2_Team3.Event.Crew.repository.EventServiceRepository;
import f2_Team3.Event.Crew.entity.TimeSlot;
import f2_Team3.Event.Crew.repository.TimeSlotRepository;

@Service
public class BookedServicesService {

    private final BookedServicesRepository bookedServicesRepository;
    private final CustomerRepository customerRepository;
    private final EventServiceRepository eventServiceRepository;
    private final TimeSlotRepository timeSlotRepository;

    public BookedServicesService(BookedServicesRepository bookedServicesRepository, CustomerRepository customerRepository, EventServiceRepository eventServiceRepository, TimeSlotRepository timeSlotRepository) {
        this.bookedServicesRepository = bookedServicesRepository;
        this.customerRepository = customerRepository;
        this.eventServiceRepository = eventServiceRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

public BookedServicesDTO bookService(BookedServicesDTO bookedServicesDTO) {

    Customer customer = customerRepository.findById(bookedServicesDTO.getCustomerId())
        .orElseThrow(() -> new NotFoundException("Customer not found"));

    EventService eventService = eventServiceRepository.findById(bookedServicesDTO.getEventServiceId())
        .orElseThrow(() -> new NotFoundException("Event service not found"));

    TimeSlot timeSlot = timeSlotRepository.findById(bookedServicesDTO.getTimeSlotId())
        .orElseThrow(() -> new NotFoundException("Time slot not found"));

    BookedServices booking = new BookedServices(
        "BOOKED",
        bookedServicesDTO.getNotes(),
        bookedServicesDTO.getLocation(),
        customer,
        eventService,
        timeSlot
    );

    BookedServices savedBooking = bookedServicesRepository.save(booking);

    BookedServicesDTO response = new BookedServicesDTO(
        savedBooking.getCustomer().getId(),
        savedBooking.getEventService().getId(),
        savedBooking.getStatus(),
        savedBooking.getNotes(),
        savedBooking.getLocation()
    );

    response.setId(savedBooking.getId());
    response.setTimeSlotId(savedBooking.getTimeSlot().getId());

    return response;
}

    @Transactional
    public void cancelBooking(Long customerId, Long bookingId) {

        BookedServices booking = bookedServicesRepository.findById(bookingId)
                .orElseThrow(() ->
                        new NotFoundException("Booking not found"));

        if (!booking.getCustomer().getId().equals(customerId)) {
            throw new NotFoundException("Booking not found");
        }

        if ("COMPLETED".equalsIgnoreCase(booking.getStatus())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "A completed booking cannot be cancelled.");
        }

        booking.setStatus("CANCELLED");
        bookedServicesRepository.save(booking);
    }

    @Transactional
    public BookedServicesDTO rescheduleBooking(
            Long customerId,
            Long bookingId,
            TimeSlotDTO timeSlotDTO) {

        BookedServices booking = bookedServicesRepository.findById(bookingId)
                .orElseThrow(() ->
                        new NotFoundException("Booking not found"));

        if (!booking.getCustomer().getId().equals(customerId)) {
            throw new NotFoundException("Booking not found");
        }

        if ("CANCELLED".equalsIgnoreCase(booking.getStatus())
                || "COMPLETED".equalsIgnoreCase(booking.getStatus())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Only active bookings can be rescheduled.");
        }

        validateBookingTimes(
                timeSlotDTO.getStartTime(),
                timeSlotDTO.getEndTime());

        Provider provider = booking.getEventService().getProvider();

        if (provider == null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "This event service has no provider assigned.");
        }

        ensureNoConflict(
                provider.getId(),
                timeSlotDTO.getStartTime(),
                timeSlotDTO.getEndTime(),
                bookingId);

        TimeSlot currentSlot = booking.getTimeSlot();
        TimeSlot updatedSlot;

        if (currentSlot == null) {
            // Supports an older booking that has no associated slot.
            updatedSlot = new TimeSlot(
                    timeSlotDTO.getStartTime(),
                    timeSlotDTO.getEndTime());

            updatedSlot.setProvider(provider);
            updatedSlot = timeSlotService.createTimeSlot(updatedSlot);
        } else {
            // Preserve the existing slot record while changing its times.
            TimeSlot timeUpdate = new TimeSlot(
                    timeSlotDTO.getStartTime(),
                    timeSlotDTO.getEndTime());

            updatedSlot = timeSlotService.updateTimeSlot(
                    currentSlot.getId(),
                    timeUpdate);
        }

        booking.setTimeSlot(updatedSlot);

        return toDTO(bookedServicesRepository.save(booking));
    }

    private void validateBookingTimes(
            LocalDateTime startTime,
            LocalDateTime endTime) {

        if (startTime == null || endTime == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Start time and end time are required.");
        }

        if (!startTime.isAfter(LocalDateTime.now())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Start time must be in the future.");
        }

        if (!endTime.isAfter(startTime)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "End time must be after start time.");
        }
    }

    private void ensureNoConflict(
            Long providerId,
            LocalDateTime newStart,
            LocalDateTime newEnd,
            Long bookingIdToIgnore) {

        List<BookedServices> providerBookings =
                bookedServicesRepository
                        .findByEventService_Provider_Id(providerId);

        for (BookedServices existing : providerBookings) {

            if (bookingIdToIgnore != null
                    && bookingIdToIgnore.equals(existing.getId())) {
                continue;
            }

            String status = existing.getStatus();

            if ("CANCELLED".equalsIgnoreCase(status)
                    || "COMPLETED".equalsIgnoreCase(status)) {
                continue;
            }

            TimeSlot existingSlot = existing.getTimeSlot();

            if (existingSlot == null) {
                continue;
            }

            boolean overlaps =
                    newStart.isBefore(existingSlot.getEndTime())
                    && newEnd.isAfter(existingSlot.getStartTime());

            if (overlaps) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "This provider already has a booking during that time.");
            }
        }
    }

    private BookedServicesDTO toDTO(BookedServices booking) {

        BookedServicesDTO dto = new BookedServicesDTO(
                booking.getCustomer().getId(),
                booking.getEventService().getId(),
                booking.getStatus(),
                booking.getNotes(),
                booking.getLocation());

        dto.setId(booking.getId());

        if (booking.getTimeSlot() != null) {
            dto.setStartTime(booking.getTimeSlot().getStartTime());
            dto.setEndTime(booking.getTimeSlot().getEndTime());
        }

        return dto;
    }
}