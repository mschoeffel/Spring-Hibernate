package spring.MVC;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @Pattern(regexp = "^[0-9]{5}", message = "only 5 digits allowed in german postal codes")
    @NotNull(message = "is required")
    private String postalCode;

    @Min(value = 0, message = "must be grater then or equal to zero")
    @Max(value = 10, message = "must be less or equal than 10")
    private int tickets;

    @NotNull(message = "is required")
    private Integer invoiceNumber;

    @CustomAnnotation(value = "CUS", message = "must start with CUS")
    private String customerNumber;

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

    public int getTickets() { return tickets; }

    public void setTickets(int tickets) { this.tickets = tickets; }

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public Integer getInvoiceNumber() { return invoiceNumber; }

    public void setInvoiceNumber(Integer invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public String getCustomerNumber() { return customerNumber; }

    public void setCustomerNumber(String customerNumber) { this.customerNumber = customerNumber; }
}
