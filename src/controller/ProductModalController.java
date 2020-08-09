package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class ProductModalController implements Initializable {
    @FXML
    Button btn_nso;
    @FXML
    Button btn_add;
    @FXML
    AnchorPane mainTabPane;
    @FXML
    TextField txt_id;
    @FXML
    TextField txt_pname;
    @FXML
    TextField txt_pcode;
    @FXML
    TextArea txt_desc;
    @FXML
    TextField txt_price;
    @FXML
    TextField txt_stock;
    @FXML
    ComboBox cbn_status;
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txt_id.setVisible(false);
        cbn_status.getItems().clear();
        cbn_status.getItems().addAll("Active","Inactive");

    }

    public void pushdata_product(){
        //the most stupidest idea
        String pname = txt_pname.getText();
        String pcode = txt_pcode.getText();
        String description = txt_desc.getText();
        double price = Double.valueOf(txt_price.getText());
        int stock =Integer.valueOf(txt_stock.getText());
        String status = cbn_status.getValue().toString();
        DataController dt_controller = new DataController();
        dt_controller.pushProductData(pname,pcode,description,status,stock,price);
    }
    public void editProduct(String id){
        txt_id.setVisible(true);
        txt_id.setEditable(false);
        btn_add.setText("Edit Product");
        try{
            String sql = "UPDATE `product` SET `pname` = ?, `pcode` = ?, `description` = ?, `quantity` = ?, `price` = ?, `status` = ? WHERE `product`.`id` = ?";
            DatabaseController dbconn = new DatabaseController();
            ResultSet res = dbconn.DBConnection().createStatement().executeQuery("SELECT * FROM product WHERE id="+id);
            if(res.next()){
                txt_id.setText(String.valueOf(res.getInt("id")));
                txt_pname.setText(res.getString("pname"));
                txt_pcode.setText(res.getString("pcode"));
                txt_desc.setText(res.getString("description"));
                txt_stock.setText(String.valueOf(res.getInt("quantity")));
                txt_price.setText(Double.toString(res.getDouble("price")));
                cbn_status.getSelectionModel().select(res.getString("status"));
                btn_add.setOnAction(e->{
                    try {
                        PreparedStatement ps = dbconn.DBConnection().prepareStatement(sql);
                        ps.setString(1,txt_pname.getText());
                        ps.setString(2,txt_pcode.getText());
                        ps.setString(3,txt_desc.getText());
                        ps.setInt(4,Integer.valueOf(txt_stock.getText()));
                        ps.setDouble(5,Double.valueOf(txt_price.getText()));
                        ps.setString(6,cbn_status.getSelectionModel().getSelectedItem().toString());
                        ps.setInt(7,Integer.valueOf(txt_id.getText()));
                        ps.executeUpdate();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                });
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}


