package spring.FinalCRUD.src.main.java.com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login.html")
    public String showLogin(){
        return "login.html";
    }

    @GetMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @GetMapping("/accessDenied.html")
    public String showAccessDenied(Model model){
        model.addAttribute("accessError", true);

        return "login.html";
    }
}
