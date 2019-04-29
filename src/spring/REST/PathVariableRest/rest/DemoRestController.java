package spring.REST.PathVariableRest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.REST.PathVariableRest.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

	//Here the additional path variable added to the mapping
	@GetMapping("/student/{studentId}")
	public Student getStudents(@PathVariable int studentId) { //Here received the bound variable
		List<Student> result = new ArrayList<>();

		result.add(new Student("John", "Doe", true, 1));
		result.add(new Student("Susan", "Mueller", true, 2));
		result.add(new Student("Marry", "Doe", false, 3));

		return result.get(studentId);
	}
	
}
