package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;
import model.CustomerTableModel;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerController implements Initializable {
    List<TreeItem<CustomerTableModel>> treeItemList = new ArrayList<>();
    @FXML
    TreeTableView<CustomerTableModel> table;
    @FXML
    TreeTableColumn<CustomerTableModel,String> col_id;
    @FXML
    TreeTableColumn<CustomerTableModel,String> col_accountNum;
    @FXML
    TreeTableColumn<CustomerTableModel,String> col_fname;
    @FXML
    TreeTableColumn<CustomerTableModel,String> col_lname;
    @FXML
    Button btn_addpeople;
    @FXML
    public void add_to_inventory(){
        btn_addpeople.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    Parent root = FXMLLoader.load(getClass().getResource("../view/FXML/addModal.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Human Resource");
                    stage.setScene(new Scene(root));
                    stage.show();

                }catch(Exception ex){
                    System.out.println(ex.toString());
                }

            }
        });

    }
    public void getTableData(){
        col_id.setCellValueFactory(new TreeItemPropertyValueFactory<>("id"));
        col_accountNum.setCellValueFactory(new TreeItemPropertyValueFactory<>("accountName"));
        col_fname.setCellValueFactory(new TreeItemPropertyValueFactory<>("firstname"));
        col_lname.setCellValueFactory(new TreeItemPropertyValueFactory<>("lastname"));
        //fallback!
        TreeItem<CustomerTableModel> account1 = new TreeItem<>(new CustomerTableModel("1","39203","Elijah","Abgao"));

        try {
            DatabaseController dbconn = new DatabaseController();
            ResultSet res =dbconn.DBConnection().createStatement().executeQuery("SELECT id,accountName,lname,fname FROM customer");
            TreeItem<CustomerTableModel> accounts = new TreeItem<>(new CustomerTableModel("CUSTOMER","","",""));
            while(res.next()){
                treeItemList.add(new TreeItem<>(new CustomerTableModel(String.valueOf(res.getInt("id")),
                        res.getString("accountName"),res.getString("fname"),res.getString("lname"))));
                accounts.getChildren().clear();


            }
            for (TreeItem<CustomerTableModel> customer: treeItemList) {
                accounts.getChildren().add(customer);
                customer.getChildren().add(account1);
            }
            table.setRoot(accounts);
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getTableData();
    }

}
