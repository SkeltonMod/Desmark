package view;

import controller.DatabaseController;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductView {
    private DatabaseController dbconn = new DatabaseController();
    public void printProductInfo(String pname,String pcode, String desc,String status,int quantity, double price){
        System.out.println("Product Name: " + pname);
        System.out.println("Product Code: " + pcode);
        System.out.println("Desc: " + desc);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Status: " + status);

    }

    // push to mysql
    public void pushdata_product(String pname,String pcode, String desc,String status,int quantity, double price){
        try{
            String sql = "INSERT INTO `product` (`pname`, `pcode`, `description`, `quantity`, `price`, `status`) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = dbconn.DBConnection().prepareStatement(sql);
            ps.setString(1,pname);
            ps.setString(2,pcode);
            ps.setString(3,desc);
            ps.setInt(4,Integer.valueOf(quantity));
            ps.setDouble(5,Double.valueOf(price));
            ps.setString(6,status);
            ps.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}