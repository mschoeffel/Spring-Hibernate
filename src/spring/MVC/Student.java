package spring.MVC;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private LinkedHashMap<String, String> countrySelect;
    private String programming;
    private boolean newsletter;

    public Student(){
        countrySelect = new LinkedHashMap<>();
        countrySelect.put("germany", "Germany");
        countrySelect.put("austria", "Austria");
        countrySelect.put("usa", "USA");
        countrySelect.put("france", "France");
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountrySelect() {
        return countrySelect;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProgramming() {
        return programming;
    }

    public void setProgramming(String programming) {
        this.programming = programming;
    }

    public boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }
}
