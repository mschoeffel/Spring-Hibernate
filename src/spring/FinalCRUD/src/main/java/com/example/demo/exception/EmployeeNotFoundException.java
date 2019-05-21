package spring.FinalCRUD.src.main.java.com.example.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
