package controller;
import com.mysql.cj.jdbc.*;
import java.sql.*;

public class DatabaseController {
    String db_host = "jdbc:mysql://localhost:3306/desmarkdb";
    String db_username = "root";
    String db_pasword = "";
    // Create a connection
    public Connection DBConnection() throws SQLException{
        Connection conn = null;
        // load the class
        try{
            System.out.println("Function Call");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_host,db_username,db_pasword);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return conn;
    }

}
