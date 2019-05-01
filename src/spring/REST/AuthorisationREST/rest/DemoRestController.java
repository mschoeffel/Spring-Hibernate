package spring.REST.AuthorisationREST.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.REST.AuthorisationREST.error.StudentNotFound;
import spring.REST.AuthorisationREST.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DemoRestController {

	// add code for the "/hello" endpoint

	private List<Student> result;

	@PostConstruct
	private void initData(){
		result = new ArrayList<>();

		result.add(new Student("John", "Doe", true, 1));
		result.add(new Student("Susan", "Mueller", true, 2));
		result.add(new Student("Marry", "Doe", false, 3));
	}

	@GetMapping("/student/{studentId}")
	public Student getStudents(@PathVariable int studentId) {

		if(studentId >= result.size() || studentId < 0){
			throw new StudentNotFound("Student Id not found: " + studentId);
		}

		return result.get(studentId);
	}

	@GetMapping("/accessDenied")
	public void accessDenied() {
		throw new RuntimeException("Access denied");
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return result;
	}
}
