package spring.REST.GlobalException.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.REST.GlobalException.error.StudentErrorResponse;
import spring.REST.GlobalException.error.StudentNotFound;
import spring.REST.GlobalException.model.Student;

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

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFound e){
		StudentErrorResponse response = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	//Catch All Exception Handler (see 64)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e){
		StudentErrorResponse response = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/student/{studentId}")
	public Student getStudents(@PathVariable int studentId) {

		if(studentId >= result.size() || studentId < 0){
			throw new StudentNotFound("Student Id not found: " + studentId);
		}

		return result.get(studentId);
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return result;
	}
	
}
