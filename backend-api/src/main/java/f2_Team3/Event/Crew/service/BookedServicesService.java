package f2_Team3.Event.Crew.service;

import f2_Team3.Event.Crew.dto.BookedServicesDTO;
import f2_Team3.Event.Crew.entity.BookedServices;
import f2_Team3.Event.Crew.entity.Customer;
import f2_Team3.Event.Crew.entity.EventService;
import f2_Team3.Event.Crew.repository.BookedServicesRepository;
import f2_Team3.Event.Crew.repository.CustomerRepository;
import f2_Team3.Event.Crew.repository.EventServiceRepository;
import f2_Team3.Event.Crew.entity.TimeSlot;
import f2_Team3.Event.Crew.repository.TimeSlotRepository;

import org.springframework.stereotype.Service;

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

    public void cancelBooking(Long customerId, Long bookingId) {
    BookedServices booking = bookedServicesRepository.findById(bookingId)
        .orElseThrow(() -> new NotFoundException("Booking not found"));

     if (!booking.getCustomer().getId().equals(customerId)) {
        throw new NotFoundException("Booking not found");
    }

    booking.setStatus("CANCELLED");
    bookedServicesRepository.save(booking);
    }
}
