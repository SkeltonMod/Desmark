package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;
import model.EmployeeTableModel;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {
    List<TreeItem<EmployeeTableModel>> treeItemList = new ArrayList<>();
    List<TreeItem<EmployeeTableModel>> emails = new ArrayList<>();

    @FXML
    TreeTableView<EmployeeTableModel> table;
    @FXML
    TreeTableColumn<EmployeeTableModel,String> col_id;
    @FXML
    TreeTableColumn<EmployeeTableModel,String> col_employeeID;
    @FXML
    TreeTableColumn<EmployeeTableModel,String> col_fname;
    @FXML
    TreeTableColumn<EmployeeTableModel,String> col_lname;
    @FXML
    Button btn_addpeople;
    @FXML
    public void add_to_inventory(){
        btn_addpeople.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    Parent root = FXMLLoader.load(getClass().getResource("../view/FXML/addEmployeeModal.fxml"));
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
        col_employeeID.setCellValueFactory(new TreeItemPropertyValueFactory<>("employeeID"));
        col_fname.setCellValueFactory(new TreeItemPropertyValueFactory<>("firstname"));
        col_lname.setCellValueFactory(new TreeItemPropertyValueFactory<>("lastname"));
        try {
            DatabaseController dbconn = new DatabaseController();
            ResultSet res = dbconn.DBConnection().createStatement().executeQuery("SELECT * FROM employee");
            TreeItem<EmployeeTableModel> accounts = new TreeItem<>(new EmployeeTableModel("EMPLOYEE","","",""));
            while(res.next()){
                treeItemList.add(new TreeItem<>(new EmployeeTableModel(
                        String.valueOf(res.getInt("id")),res.getString("fname"),res.getString("lname"),
                        res.getString("employeeID")
                )));
                emails.add(new TreeItem<>(new EmployeeTableModel("",
                        "",res.getString("email"),"")));
                accounts.getChildren().clear();
            }
            for(int i = 0; i<treeItemList.size();++i){

                TreeItem<EmployeeTableModel> employee = treeItemList.get(i);
                accounts.getChildren().add(employee);
                employee.getChildren().add(emails.get(i));

            }
            table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
                @Override
                public void changed(ObservableValue<? extends TreeItem<EmployeeTableModel>> observableValue,
                                    TreeItem<EmployeeTableModel> employeeTableModelTreeItem, TreeItem<EmployeeTableModel> t1) {
                    //prevent the user from clicking the parent entry
                    if (!t1.getValue().getId().equals("EMPLOYEE")) {
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("../view/FXML/addEmployeeModal.fxml"));
                            Parent parent = loader.load();
                            Scene scene = new Scene(parent);
                            //WTF!
                            EmployeeModalController mc = loader.getController();
                            mc.editCustomer(t1.getValue().getId());
                            Stage window = new Stage();
                            window.setScene(scene);
                            window.show();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
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
