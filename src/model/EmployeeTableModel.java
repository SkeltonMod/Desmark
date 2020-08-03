package model;

public class EmployeeTableModel {

    private String id;
    private String firstname;
    private String lastname;
    private String employeeID;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public EmployeeTableModel(String id, String firstname, String lastname, String employeeID) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.employeeID = employeeID;
    }
}
