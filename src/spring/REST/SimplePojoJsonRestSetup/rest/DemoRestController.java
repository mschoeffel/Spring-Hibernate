package spring.REST.SimplePojoJsonRestSetup.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.REST.SimplePojoJsonRestSetup.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

	// add code for the "/hello" endpoint
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> result = new ArrayList<>();

		result.add(new Student("John", "Doe", true, 1));
		result.add(new Student("Susan", "Mueller", true, 2));
		result.add(new Student("Marry", "Doe", false, 3));

		return result;
	}
	
}
