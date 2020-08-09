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
import model.ProductTableModel;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {
    List<TreeItem<ProductTableModel>> treeItemList = new ArrayList<>();
    @FXML
    TreeTableView<ProductTableModel> table;
    @FXML
    TreeTableColumn<ProductTableModel,String> col_id;
    @FXML
    TreeTableColumn<ProductTableModel,String> col_pname;
    @FXML
    TreeTableColumn<ProductTableModel,String> col_pcode;
    @FXML
    TreeTableColumn<ProductTableModel,String> col_stock;
    @FXML
    Button btn_addpeople;
    @FXML
    public void add_to_inventory(){
        btn_addpeople.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try{
                    Parent root = FXMLLoader.load(getClass().getResource("../view/FXML/addProductModal.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Inventory");

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
        col_pname.setCellValueFactory(new TreeItemPropertyValueFactory<>("productName"));
        col_pcode.setCellValueFactory(new TreeItemPropertyValueFactory<>("productCode"));
        col_stock.setCellValueFactory(new TreeItemPropertyValueFactory<>("stocks"));
        try {
            DatabaseController dbconn = new DatabaseController();
            ResultSet res = dbconn.DBConnection().createStatement().executeQuery("SELECT * FROM product");
            TreeItem<ProductTableModel> products = new TreeItem<>(new ProductTableModel("","","",0));
            while(res.next()){
                treeItemList.add(new TreeItem<>(new ProductTableModel(String.valueOf(res.getInt("id")),
                        res.getString("pname"),res.getString("pcode"),res.getInt("quantity"))));

                //products.getChildren().clear();

            }
            for(int i = 0; i < treeItemList.size(); ++i){
                products.getChildren().add(treeItemList.get(i));

            }

            table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<ProductTableModel>>() {
                @Override
                public void changed(ObservableValue<? extends TreeItem<ProductTableModel>> observableValue,
                                    TreeItem<ProductTableModel> productTableModelTreeItem, TreeItem<ProductTableModel> t1) {
                    //prevent the user from clicking the parent entry
                    if(!t1.getValue().getProductName().equals("")){
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("../view/FXML/addProductModal.fxml"));
                            Parent parent = loader.load();
                            Scene scene = new Scene(parent);
                            //WTF!
                            ProductModalController mc = loader.getController();
                            mc.editProduct(t1.getValue().getId());
                            Stage window = new Stage();
                            window.setScene(scene);
                            window.show();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            table.setRoot(products);
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getTableData();
    }

}
