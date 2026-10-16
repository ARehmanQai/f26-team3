package f2_Team3.Event.Crew.service;

import f2_Team3.Event.Crew.entity.Customer;
import f2_Team3.Event.Crew.repository.CustomerRepository;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository CustomerRepository;

    public CustomerService(CustomerRepository CustomerRepository) {
        this.CustomerRepository = CustomerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return CustomerRepository.save(customer);
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
