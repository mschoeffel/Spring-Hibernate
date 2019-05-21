package spring.FinalCRUD.src.main.java.com.example.demo.exception;

public class EmployeeErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    public EmployeeErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public EmployeeErrorResponse(String message) {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}