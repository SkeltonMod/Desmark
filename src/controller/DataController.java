package controller;


import model.Customer;
import model.Employee;
import view.CustomerView;
import view.EmployeeView;

// handles the logic and functions for models
public class DataController {
    private Customer customerModel;
    private CustomerView customerView;
    private Employee employeeModel;
    private EmployeeView employeeView;


    private String key = "";
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
                                 String accountnum, String occupation, String gender,String bday, String number, String civilstatus,String imagelocation) {

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
        this.imageLocation = imagelocation;
        this.key = "customer_data";
        System.out.println("Data Key: "+this.key);
        printDetail();
    }
    public void pushEmployeeData(String fname, String lname, String address, String email,
                                 String accountnum, String occupation, String gender,String bday, String number, String civilstatus,String imagelocation) {

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
        this.imageLocation = imagelocation;
        this.key = "employee_data";
        System.out.println("Data Key: "+this.key);
        printDetail();
    }

    public void CustomerController(Customer model, CustomerView view){
        this.customerModel = model;
        this.customerView = view;
    }

    public void EmployeeController(Employee model, EmployeeView view){
        this.employeeModel = model;
        this.employeeView = view;
    }

    public void updateView(String key){
        switch (key){
            case "customer_data":
                customerModel.CustomerData(this.firstName,this.lastName,this.address,this.email,this.accountName,this.occupation,
                        this.gender,this.birthday,this.number,this.civilStatus);

                customerView.printCustomerInfo(this.firstName,this.lastName, this.address, this.number,
                        this.email,this.gender,this.birthday,this.accountName,this.occupation,this.civilStatus,this.imageLocation);

                break;
            case "employee_data":
                employeeModel.EmployeeData(this.firstName,this.lastName,this.address,this.email,this.accountName,this.occupation,
                        this.gender,this.birthday,this.number,this.civilStatus);
                employeeView.printEmployeeInfo(this.firstName,this.lastName, this.address, this.number,
                        this.email,this.gender,this.birthday,this.accountName,this.occupation,this.civilStatus,this.imageLocation);
                break;

        }
    }

    public void pushData(String key){
        switch (key){
            case "customer_data":
                customerView.pushdata_customers(this.firstName,this.lastName, this.address, this.number,
                        this.email,this.gender,this.birthday,this.accountName,this.occupation,this.civilStatus);
                break;
            case "employee_data":
                employeeView.pushdata_employees(this.firstName,this.lastName, this.address, this.number,
                        this.email,this.gender,this.birthday,this.accountName,this.occupation,this.civilStatus);
                break;

        }
    }
    //prints the view data
    public void printDetail(){
        switch (this.key){
            case "customer_data":
                Customer customer = new Customer();
                CustomerView customerview = new CustomerView();
                CustomerController(customer,customerview);
                updateView(this.key);
                pushData(this.key);
                break;
            case "employee_data":
                Employee employee = new Employee();
                EmployeeView employeeView = new EmployeeView();
                EmployeeController(employee,employeeView);
                updateView(this.key);
                pushData(this.key);
                break;
        }
    }
}
