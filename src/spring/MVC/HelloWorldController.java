package spring.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/showForm2")
    public String showForm2(){
        return "helloworld-form2";
    }

    @RequestMapping("/processForm2")
    public String letsSayHi(HttpServletRequest request, Model model){

        String theName = request.getParameter("userName");

        theName = theName.toUpperCase();

        String message = "Hi! " + theName;

        model.addAttribute("message", message);

        return "helloworld2";
    }

}
