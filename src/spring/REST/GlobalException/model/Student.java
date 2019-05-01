package spring.REST.GlobalException.model;

public class Student {

    private String firstName;
    private String lastName;

    private boolean active;

    private int id;

    public Student(String firstName, String lastName, boolean active, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
