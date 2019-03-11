package spring.MVC;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class SpringFormValidationController {

    @RequestMapping("processValidation")
    public String processValidation(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "springFormValidation";
        } else{
            return "springFormValidationDone";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("showValidation")
    public String showValidation(Model model){
        model.addAttribute("customer", new Customer());
        return "springFormValidation";
    }

}
