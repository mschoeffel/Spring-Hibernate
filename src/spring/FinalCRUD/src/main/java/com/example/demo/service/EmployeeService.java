package spring.FinalCRUD.src.main.java.com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public Employee save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
