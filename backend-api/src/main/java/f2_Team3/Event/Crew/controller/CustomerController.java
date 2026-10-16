package f2_Team3.Event.Crew.controller;

import f2_Team3.Event.Crew.service.CustomerService;
import org.springframework.web.bind.annotation.RestController;
import f2_Team3.Event.Crew.dto.CustomerDTO;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

@PostMapping("/api/customers")
public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
    CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);

    URI location = URI.create("/api/customers/" + createdCustomer.getId());

    return ResponseEntity.created(location).body(createdCustomer);
}

}