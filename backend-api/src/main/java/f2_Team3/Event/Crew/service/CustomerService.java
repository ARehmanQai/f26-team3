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

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
    Customer customer = CustomerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

    customer.setName(updatedCustomer.getName());
    customer.setEmail(updatedCustomer.getEmail());
    customer.setPassWord(updatedCustomer.getPassWord());
    customer.setPhoneNumber(updatedCustomer.getPhoneNumber());

    return CustomerRepository.save(customer);
}
}
