package model;

public class Employee {
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String employeeID;
    private String job_title;
    private String civilStatus;
    private String gender;
    private String bday;
    private String number;
    private String imageLocation;
    private String nsoLocation;


    public void EmployeeData(String firstname, String lastname,
                             String address, String email,
                             String employeeID, String job_title,
                             String gender, String bday ,String number,
                             String civilStatus) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.employeeID = employeeID;
        this.job_title = job_title;
        this.gender = gender;
        this.number = number;
        this.bday = bday;
        this.civilStatus = civilStatus;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getBday() {
        return bday;
    }

    public String getEmail() {
        return email;
    }

    public String getAccountName() {
        return employeeID;
    }

    public String getOccupation() {
        return job_title;
    }

    public String getGender() {
        return gender;
    }

    public String getNumber() {
        return number;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public String getFullName(){
        return firstname +" "+ lastname;
    }

    public void setName(String fname, String lname){
        this.firstname = fname;
        this.lastname = lname;
    }


}
