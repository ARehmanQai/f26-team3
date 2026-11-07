package f2_Team3.Event.Crew.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import f2_Team3.Event.Crew.service.CustomerService;
import f2_Team3.Event.Crew.dto.CustomerDTO;

@Controller
public class CustomerPageController {
    private final CustomerService customerService;

    public CustomerPageController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/profile/{id}")
    public String showProfile(@PathVariable Long id, Model model) {
        CustomerDTO customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer/profile";
    }

    @GetMapping("/customer/dashboard/{id}")
    public String showDashboard(@PathVariable Long id, Model model) {
        CustomerDTO customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer/dashboard";
    }

    @PostMapping("/customer/profile/{id}")
    public String updateProfile(
        @PathVariable Long id,
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam String phoneNumber,
        @RequestParam(required = false) String password,
        RedirectAttributes redirectAttributes) {

    CustomerDTO customer = customerService.getCustomerById(id);

    customer.setName(name);
    customer.setEmail(email);
    customer.setPhoneNumber(phoneNumber);

    if (password != null && !password.isBlank()) {
        customer.setPassWord(password);
    }

    customerService.updateCustomer(id, customer);

    redirectAttributes.addFlashAttribute("successMessage",
            "Your profile has been updated successfully.");

    return "redirect:/customer/profile/" + id;
}


}