package spring.REST.FancyRestAll.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.REST.FancyRestAll.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

	private List<Student> result;

	@PostConstruct
	private void initData(){
		result = new ArrayList<>();

		result.add(new Student("John", "Doe", true, 1));
		result.add(new Student("Susan", "Mueller", true, 2));
		result.add(new Student("Marry", "Doe", false, 3));
	}

	//Here the additional path variable added to the mapping will return the student at the index Id
	@GetMapping("/student/{studentId}")
	public Student getStudents(@PathVariable int studentId) { //Here received the bound variable
		return result.get(studentId);
	}

	//Here no additional path variable added to the mapping will return all students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return result;
	}
	
}
