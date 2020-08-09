package controller;


import model.Customer;
import model.Employee;
import model.Product;
import view.CustomerView;
import view.EmployeeView;
import view.ProductView;

// handles the logic and functions for models
public class DataController {
    private Customer customerModel;
    private CustomerView customerView;
    private Employee employeeModel;
    private EmployeeView employeeView;
    private Product productModel;
    private ProductView productView;

    //Customer and Employees
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

    // Products
    private String pname;
    private String pcode;
    private String desc;
    private String status;
    private int quantity;
    private double price;
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

    public void pushProductData(String pname, String pcode,String desc,String status, int quantity, double price){
        this.pname = pname;
        this.pcode = pcode;
        this.desc = desc;
        this.status = status;
        this.quantity = quantity;
        this.price = price;
        this.key = "product_data";
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

    public void ProductController(Product model, ProductView view){
        this.productModel = model;
        this.productView = view;
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

            case "product_date":
                productModel.ProductData(this.pname,this.pcode,this.desc,this.quantity,this.price);
                productView.printProductInfo(this.pname,this.pcode,this.desc,this.status,this.quantity,this.price);
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

            case "product_data":
                productView.pushdata_product(this.pname,this.pcode,this.desc,this.status,this.quantity,this.price);
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
            case "product_data":
                Product product = new Product();
                ProductView productView = new ProductView();
                ProductController(product,productView);
                updateView(this.key);
                pushData(this.key);
                break;
        }
    }
}
