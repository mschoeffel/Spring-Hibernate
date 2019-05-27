package spring.FinalCRUD.src.main.java.com.example.demo.controller;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {

    private EmployeeService employeeService;

    public WebController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/login.html")
    public String showLogin(){
        return "login.html";
    }

    @GetMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @GetMapping("/index.html")
    public String showHome(Model model){
        model.addAttribute("employees", employeeService.findAll());
        return "index.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(Model model, @PathVariable int id){
        try {
            employeeService.deleteById(id);
            model.addAttribute("message", "Delete Successful");
        } catch(RuntimeException e){
            model.addAttribute("error", e.getLocalizedMessage());
        }

        return "redirect:/web/index.html";
    }

}
