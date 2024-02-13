package Personal.AIEats.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Login";
    }

    @GetMapping("/Signup")
    public String Signup() { return "Signup"; }

    @GetMapping("/Mode")
    public String SelectMode(Model model)
    {
        return "SelectMode";
    }

    @GetMapping("/Home")
    public String Home(Model model)
    {
        return "Home";
    }

    @GetMapping("/Store")
    public String Store(Model model)
    {
        return "Combination";
    }


}
