package Personal.AIEats.Controller;

import Personal.AIEats.Service.UserService;
import Personal.AIEats.dto.MemberDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

    private final UserService userService;

    @Autowired
    public MemberController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/")
    public String LoginHome()
    {
        return "Login";
    }

    @GetMapping("/member/save")
    public String SignupForm(){
        return "Signup";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO)
    {
        System.out.println("MemberController.save");
        System.out.println("memberEmail= " + memberDTO);
        userService.save(memberDTO);
        return "Login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session)
    {
        MemberDTO loginResult = userService.login(memberDTO);
        System.out.println(loginResult);

        if(loginResult != null)
        {
            session.setAttribute("memberID" , loginResult.getMemberID());
            return "SelectMode.html";
        }
        else{
            //login 실패
            return "Login";
        }
    }

    @GetMapping("/member/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "Login";
    }



}
