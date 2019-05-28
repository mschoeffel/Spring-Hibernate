package spring.FinalCRUD.src.main.java.com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
public class WebController {

    private EmployeeService employeeService;

    public WebController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping("/index.html")
    public String showHome(Model model){
        model.addAttribute("employees", employeeService.findAll());
        return "index.html";
    }

    @GetMapping("/show/{id}")
    public String showEmployee(Model model, @PathVariable int id){
        try{
            Employee employee = employeeService.findById(id);
            model.addAttribute("employee", employee);
        } catch(Exception e){
            model.addAttribute("error", e.getLocalizedMessage());
        }
        return "employee.html";
    }

    @GetMapping("/show")
    public String showEmployee(Model model){

        model.addAttribute("employee", new Employee());

        return "employee.html";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(Model model, @ModelAttribute("employee") Employee employee){
        employeeService.save(employee);

        model.addAttribute("message", "Save Successful");

        return "redirect:/web/index.html";
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
