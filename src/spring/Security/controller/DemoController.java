package spring.Security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return "security/home";
	}

	@GetMapping("/leaders")
	public String showLeaders() {

		return "security/leaders";
	}

	@GetMapping("/accessDenied")
	public String showDenied() {

		return "accessDenied";
	}
}
