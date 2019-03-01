package spring.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/map")
public class MappingController {

    @RequestMapping("/showMapForm")
    public String showForm(){
        return "mapForm";
    }

    @RequestMapping("/processMapForm")
    public String processForm( @RequestParam("userName") String name,
                               Model model){

        name = name.toLowerCase();

        String message = "Hi! Im From the Mapping Map! " + name;

        model.addAttribute("message", message);

        return "mapOutput";
    }
}
