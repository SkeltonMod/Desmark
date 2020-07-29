package view;

import controller.DatabaseController;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerView {
    //debug
    private DatabaseController dbconn = new DatabaseController();
    public void printCustomerInfo(String firstname, String lastname, String address,
                                  String number, String email, String gender,String bday,String accountNum,
                                  String occupation, String civilStatus,String imagelocation){
        System.out.println("Full Name: " + firstname + " " + lastname);
        System.out.println("Address: " + address);
        System.out.println("Number: " + number);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Birthday: " + bday);
        System.out.println("Account Number: " + accountNum);
        System.out.println("Occupation: " + occupation);
        System.out.println("Civil Status: " + civilStatus);
        System.out.println("Civil Status: " + imagelocation);

    }

    // push to mysql
    public void pushdata_customers(String firstname, String lastname, String address,
                         String number, String email, String gender,String bday,String accountNum,
                         String occupation, String civilStatus){
    try{
        String sql = "INSERT INTO customer(fname,lname,address,email,accountName,occupation,civilstatus,gender,bday,phone,image,certifcate)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = dbconn.DBConnection().prepareStatement(sql);
        ps.setString(1,firstname);
        ps.setString(2,lastname);
        ps.setString(3,address);
        ps.setString(4,email);
        ps.setString(5,accountNum);
        ps.setString(6,occupation);
        ps.setString(7,civilStatus);
        ps.setString(8,gender);
        ps.setString(9,bday);
        ps.setString(10,number);
        ps.setString(11,firstname);
        ps.setString(12,firstname);
        ps.executeUpdate();
    } catch (SQLException ex){
        ex.printStackTrace();
    }

    }
}
