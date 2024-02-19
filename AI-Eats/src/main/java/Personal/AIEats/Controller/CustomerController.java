package Personal.AIEats.Controller;

import Personal.AIEats.Service.CustomerService;
import Personal.AIEats.dto.OrderRequestDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public String customerHome()
    {
        return "customerHome";
    }

    @GetMapping("/customer/pizza")
    public String pizza()
    {
        return "PizzaStoreList";
    }

    @GetMapping("/customer/pizza/Jongwon")
    public String JongPizza()
    {
        return "JongwonMenu";
    }

    @GetMapping("/customer/pizza/Combination")
    public String Combination()
    {
        return "Combination.html";
    }

    @PostMapping("/customer/menuRequest")
    public String RequestMenu(@ModelAttribute OrderRequestDTO orderRequestDTO)
    {
        System.out.println("OrderRequestDTO = " + orderRequestDTO);
        customerService.RequestRegister(orderRequestDTO);
        return "JongwonMenu";
    }

    @GetMapping("/customer/myRequestList")
    public String findAllmyRequest(HttpSession session, Model model)
    {
        List<OrderRequestDTO> orderRequestDTOS = customerService.findAllRequest((String)session.getAttribute("memberID"));
        model.addAttribute("requestList", orderRequestDTOS);
        return "myRequestList";
    }

    @GetMapping("/customer/myRequestList/{id}")
    public String DetailByID(@PathVariable Long id, Model model)
    {
        OrderRequestDTO orderRequestDTO = customerService.findByID(id);
        model.addAttribute("request", orderRequestDTO);
        return "requestDetail";
    }

    @GetMapping("/customer/myRequestList/delete/{id}")
    public String delete(@PathVariable Long id)
    {
        customerService.delete(id);
        return "redirect:/customer/myRequestList";
    }
}
