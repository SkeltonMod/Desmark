package model;

public class Customer {
    private String firstname;
    private String lastname;
    private String imageLocation;
    private String nsoLocation;
    private String address;
    private String email;
    private String accountName;
    private String occupation;
    private String gender;
    private String bday;
    private String number;


    public void CustomerData(String firstname, String lastname,
                             String address, String email,
                             String accountName, String occupation,
                             String gender, String bday ,String number,
                             String civilStatus) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.accountName = accountName;
        this.occupation = occupation;
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
        return accountName;
    }

    public String getOccupation() {
        return occupation;
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


    private String civilStatus;


    public String getFullName(){
        return firstname +" "+ lastname;
    }

    public void setName(String fname, String lname){
        this.firstname = fname;
        this.lastname = lname;
    }


}
