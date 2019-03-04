package spring.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringFormController {

    @RequestMapping("/showSpringForm")
    public String showForm(Model theModel){

        theModel.addAttribute("student", new Student());

        return "springFormDemo";
    }

    @RequestMapping("/processSpringForm")
    public String processForm(@ModelAttribute("student") Student student){

        System.out.println(student.getLastName());

        return "springFormDone";
    }
}
