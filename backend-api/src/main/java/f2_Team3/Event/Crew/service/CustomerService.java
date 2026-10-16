package f2_Team3.Event.Crew.service;

import f2_Team3.Event.Crew.entity.Customer;
import f2_Team3.Event.Crew.repository.CustomerRepository;
import f2_Team3.Event.Crew.dto.CustomerDTO;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository CustomerRepository;

    public CustomerService(CustomerRepository CustomerRepository) {
        this.CustomerRepository = CustomerRepository;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
    Customer customer = new Customer();

    customer.setName(customerDTO.getName());
    customer.setEmail(customerDTO.getEmail());
    customer.setPassWord(customerDTO.getPassWord());
    customer.setPhoneNumber(customerDTO.getPhoneNumber());

    Customer savedCustomer = CustomerRepository.save(customer);

    CustomerDTO response = new CustomerDTO(
            savedCustomer.getName(),
            savedCustomer.getEmail(),
            savedCustomer.getPassWord(),
            savedCustomer.getPhoneNumber()
    );

    response.setId(savedCustomer.getId());

    return response;
}

public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
    Customer customer = CustomerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

    customer.setName(customerDTO.getName());
    customer.setEmail(customerDTO.getEmail());
    customer.setPassWord(customerDTO.getPassWord());
    customer.setPhoneNumber(customerDTO.getPhoneNumber());

    Customer updatedCustomer = CustomerRepository.save(customer);

    CustomerDTO response = new CustomerDTO(
            updatedCustomer.getName(),
            updatedCustomer.getEmail(),
            updatedCustomer.getPassWord(),
            updatedCustomer.getPhoneNumber()
    );

    response.setId(updatedCustomer.getId());

    return response;
}

}
