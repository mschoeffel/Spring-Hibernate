package spring.FinalCRUD.src.main.java.com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
