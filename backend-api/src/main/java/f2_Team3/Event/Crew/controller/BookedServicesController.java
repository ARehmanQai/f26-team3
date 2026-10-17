package f2_Team3.Event.Crew.controller;

import f2_Team3.Event.Crew.dto.BookedServicesDTO;
import f2_Team3.Event.Crew.service.BookedServicesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers/{customerId}/subscriptions")

public class BookedServicesController {

    private final BookedServicesService bookedServicesService;
    public BookedServicesController(BookedServicesService bookedServicesService){
        this.bookedServicesService = bookedServicesService;
    }

     @PostMapping
    public ResponseEntity<BookedServicesDTO> bookService(
            @PathVariable Long customerId,
            @Valid @RequestBody BookedServicesDTO bookedServicesDTO) {

        bookedServicesDTO.setCustomerId(customerId);

        BookedServicesDTO createdBooking =
                bookedServicesService.bookService(bookedServicesDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }
    
}
