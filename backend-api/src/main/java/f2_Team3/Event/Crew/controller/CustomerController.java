package f2_Team3.Event.Crew.controller;

import f2_Team3.Event.Crew.service.CustomerService;
import org.springframework.web.bind.annotation.RestController;
import f2_Team3.Event.Crew.dto.CustomerDTO;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;


@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

@PostMapping("/api/customers")
public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
    CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);

    URI location = URI.create("/api/customers/" + createdCustomer.getId());

    return ResponseEntity.created(location).body(createdCustomer);
}

@PutMapping("/api/customers/{id}")
public ResponseEntity<CustomerDTO> updateCustomer(
        @PathVariable Long id,
        @RequestBody @Valid CustomerDTO customerDTO) {

    CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);

    return ResponseEntity.ok(updatedCustomer);
}

}