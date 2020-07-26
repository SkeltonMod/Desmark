package controller;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller{
    @FXML
    Pane pn_inventory;
    @FXML
    FlowPane fpn_list;
    @FXML
    Button btn_addpeople;
    @FXML
    Button btnHome;
    @FXML
    StackPane maincontent;
    //make a list of all the buttons
    List<Button> buttonList = new ArrayList<>();
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
    @FXML
    public void btnHomeclick(ActionEvent event){
        FXMLLoader fxml = new FXMLLoader();

        try{
            fxml.load(getClass().getResource("/view/FXML/Overview.fxml").openStream());
        }catch (IOException ex){
            ex.printStackTrace();
        }

        AnchorPane root = fxml.getRoot();
        maincontent.getChildren().clear();
        maincontent.getChildren().add(root);
    }
    @FXML
    public void btnCustomerClick(ActionEvent event){
        FXMLLoader fxml = new FXMLLoader();
        try{
            fxml.load(getClass().getResource("/view/FXML/AddCustomer.fxml").openStream());
        }catch (IOException ex){
            ex.printStackTrace();
        }

        AnchorPane root = fxml.getRoot();
        maincontent.getChildren().clear();
        maincontent.getChildren().add(root);
    }
    public void bind_data(){


    }
    public void refresh_list(){
        System.out.println("Add");
        buttonList.add(new Button());
        fpn_list.getChildren().clear();
        fpn_list.getChildren().addAll(buttonList);
        //iterate thru all the buttons and add some shit
        add_event_listener(1,"Brann Jofran");
    }
    public void add_event_listener(int id, String name){
        for(Button button: buttonList){
            button.setId(String.valueOf(id));
            button.setText(name);
            button.getStyleClass().add("middle-pane-buttons");
            button.setTextFill(Color.rgb(254,252,238));
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println(button.getId().toString());
                }
            });
        }
    }

}