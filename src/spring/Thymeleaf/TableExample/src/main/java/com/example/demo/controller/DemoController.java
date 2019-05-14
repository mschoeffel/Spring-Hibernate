package spring.Thymeleaf.TableExample.src.main.java.com.example.demo.controller;

import com.example.demo.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class DemoController {

    @GetMapping("/list")
    public String listEmployees(Model theModel){

        Employee emp1 = new Employee(1, "John", "Doe", "john@doe.com");
        Employee emp2 = new Employee(2, "Joe", "Test", "Joe@Test.net");
        Employee emp3 = new Employee(3, "Susan", "Mueller", "Susan@webmail.com");

        List<Employee> list = new ArrayList<>();

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);

        theModel.addAttribute("data", list);

        return "list-employees";
    }
}
