import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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


}