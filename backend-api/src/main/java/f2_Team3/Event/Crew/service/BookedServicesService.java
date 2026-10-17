package f2_Team3.Event.Crew.service;

import f2_Team3.Event.Crew.dto.BookedServicesDTO;
import f2_Team3.Event.Crew.entity.BookedServices;
import f2_Team3.Event.Crew.entity.Customer;
import f2_Team3.Event.Crew.entity.EventService;
import f2_Team3.Event.Crew.repository.BookedServicesRepository;
import f2_Team3.Event.Crew.repository.CustomerRepository;
import f2_Team3.Event.Crew.repository.EventServiceRepository;

import org.springframework.stereotype.Service;

@Service
public class BookedServicesService {
    
    private final BookedServicesRepository bookedServicesRepository;
    private final CustomerRepository customerRepository;
    private final EventServiceRepository eventServiceRepository;

    public BookedServicesService(BookedServicesRepository bookedServicesRepository, CustomerRepository customerRepository, EventServiceRepository eventServiceRepository) {
        this.bookedServicesRepository = bookedServicesRepository;
        this.customerRepository = customerRepository;
        this.eventServiceRepository = eventServiceRepository;
    }

    public BookedServicesDTO bookService(BookedServicesDTO bookedServicesDTO) {
        Customer customer = customerRepository.findById(bookedServicesDTO.getCustomerId())
            .orElseThrow(() -> new NotFoundException("Customer not found"));

        EventService eventService = eventServiceRepository.findById(bookedServicesDTO.getEventServiceId())
            .orElseThrow(() -> new NotFoundException("Event service not found"));

                BookedServices booking = new BookedServices("BOOKED", bookedServicesDTO.getNotes(), bookedServicesDTO.getLocation(), customer, eventService);

                BookedServices savedBooking = bookedServicesRepository.save(booking);

                BookedServicesDTO response = new BookedServicesDTO(
                    savedBooking.getCustomer().getId(),
                    savedBooking.getEventService().getId(),
                    savedBooking.getStatus(),
                    savedBooking.getNotes(),
                    savedBooking.getLocation()
                                                );

           response.setId(savedBooking.getId());

    return response;
    }
}
