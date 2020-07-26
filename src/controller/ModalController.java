package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModalController implements Initializable {
    @FXML
    AnchorPane mainTabPane;
    @FXML
    TextField txt_fname;
    @FXML
    TextField txt_lname;
    @FXML
    TextArea txt_address;
    @FXML
    TextField txt_accountnum;
    @FXML
    TextField txt_number;
    @FXML
    TextField txt_occupation;
    @FXML
    TextField txt_email;
    @FXML
    ComboBox cbn_civilstatus;
    @FXML
    ImageView img_id;
    @FXML
    DatePicker dp_bday;
    @FXML
    ComboBox cbn_gender;
    @FXML
    ComboBox cbn_gender2;

    private String imageLocation;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cbn_gender.getItems().clear();
        cbn_gender.getItems().addAll("Male","Female");

        cbn_civilstatus.getItems().clear();
        cbn_civilstatus.getItems().addAll("Single","Married","Way Oten");
        img_id.setImage(new Image("http://localhost/img/Elijah"));
    }
    public void pushData_customers(){
        //the most stupidest idea
        String firstname = txt_fname.getText();
        String lastname = txt_lname.getText();
        String address = txt_address.getText();
        String gender = cbn_gender.getValue().toString();
        String civilstatus = cbn_civilstatus.getValue().toString();
        String number = txt_number.getText();
        String email = txt_email.getText();
        String birthday = dp_bday.getValue().toString();
        String occupation = txt_occupation.getText();
        String accountnum = txt_accountnum.getText();
        String imageLocation = this.imageLocation;


        DataController dt_controller = new DataController();
        dt_controller.getImagePath(imageLocation);
        dt_controller.pushCustomerData(firstname,lastname,address,email,accountnum,
                occupation,gender,birthday,number,civilstatus);

    }
    public void getImage(){
        if(!txt_fname.getText().equals("")){
            File accountimage;
            FileChooser filechoose = new FileChooser();
            FileChooser.ExtensionFilter fileExt = new FileChooser.ExtensionFilter("Image Files"
                    ,"*.png","*.jpeg","*.jpg");
            filechoose.getExtensionFilters().add(fileExt);
            accountimage = filechoose.showOpenDialog(mainTabPane.getScene().getWindow());
            if(accountimage != null){
                String imagepath = accountimage.getAbsolutePath();
                System.out.println(accountimage.getName());
                System.out.println(imagepath);
                img_id.setFitHeight(206);
                img_id.setFitWidth(241);
                img_id.setImage(new Image("file:"+imagepath));

                this.imageLocation = imagepath;
                saveImage(imagepath);
            }
        }else {
            System.out.println("Please Enter your Name First! (This will be used to find the image)");
        }
    }

    public void saveImage(String imageLocation){
        try{
            BufferedImage bi = ImageIO.read(new File(imageLocation));
            File output = new File("/opt/lampp/htdocs/img/"+txt_fname.getText());
            ImageIO.write(bi,"png",output);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}


