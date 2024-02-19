package Personal.AIEats.Controller;

import Personal.AIEats.Service.CustomerService;
import Personal.AIEats.Service.RiderService;
import Personal.AIEats.dto.OrderRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RiderController {
    private final RiderService riderService;

    @Autowired
    public RiderController(RiderService riderService)
    {
        this.riderService = riderService;
    }

    @GetMapping("/rider")
    public String RiderHome()
    {
        System.out.println("check");
        return "RiderHome";
    }

    @GetMapping("/rider/RequstList")
    public String findAllRequest(Model model)
    {
        List<OrderRequestDTO> orderRequestDTOList = riderService.findAllRequest();
        model.addAttribute("requestList", orderRequestDTOList);
        return "allrequestListForRider";
    }


}
