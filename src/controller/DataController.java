package controller;


import model.Customer;
import view.CustomerView;

import java.sql.SQLException;
// handles the logic and functions for models
public class DataController {
    private Customer customerModel;
    private CustomerView customerView;


    private String firstName = "";
    private String lastName = "";
    private String address = "";
    private String email = "";
    private String imageLocation = "";
    private String nsoLocation = "";
    private String accountName = "";
    private String occupation = "";
    private String gender = "";
    private String birthday = "";
    private String number = "";
    private String civilStatus = "";

    public void getImagePath(String imagepath){

        this.imageLocation = imagepath;
        System.out.println("The Image path is: "+ this.imageLocation);
    }
    // parse the passed data
    public void pushCustomerData(String fname, String lname, String address, String email,
                                 String accountnum, String occupation, String gender,String bday, String number, String civilstatus) {

        this.firstName = fname;
        this.lastName = lname;
        this.address = address;
        this.email = email;
        this.accountName = accountnum;
        this.occupation = occupation;
        this.gender = gender;
        this.number = number;
        this.birthday = bday;
        this.civilStatus = civilstatus;
        printDetail();
    }

    public void CustomerController(Customer model, CustomerView view){
        this.customerModel = model;
        this.customerView = view;
    }
    public void upadateView(){

        customerModel.CustomerData(this.firstName,this.lastName,this.address,this.email,this.accountName,this.occupation,
                this.gender,this.birthday,this.number,this.civilStatus);

        customerView.printCustomerInfo(this.firstName,this.lastName, this.address, this.number,
                this.email,this.gender,this.birthday,this.accountName,this.occupation,this.civilStatus);
    }

    public void pushData(){
        customerView.pushdata_customers(this.firstName,this.lastName, this.address, this.number,
                this.email,this.gender,this.birthday,this.accountName,this.occupation,this.civilStatus);
    }
    //prints the view data
    public void printDetail(){
        Customer customer = new Customer();
        CustomerView customerview = new CustomerView();
        CustomerController(customer,customerview);
        upadateView();
        pushData();

    }
}
