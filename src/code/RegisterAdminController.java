package code;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

public class RegisterAdminController {

    @FXML
    private CheckBox showpasswordAdmin;
    @FXML
    private TextField firstnameAdmin;
    @FXML
    private TextField lastnameAdmin;
    @FXML
    private TextField emailaddressAdmin;
    @FXML
    private TextField usernameAdmin;
    @FXML
    private PasswordField passwordAdmin;
    @FXML
    private TextField showpasswordAdminRegister;
    @FXML
    private Button actionSignupAdmin;
    @FXML
    private Hyperlink redirectLoginAdmin;
    @FXML
    private Label successRegisterAdmin;
    @FXML
    private Label warningRegisterAdmin;


    // Register Button

    public void actionSignupAdmin(ActionEvent event){
        if(firstnameAdmin.getText().isBlank()!=true && lastnameAdmin.getText().isBlank()!=true &&
                emailaddressAdmin.getText().isBlank()!=true && usernameAdmin.getText().isBlank()!=true &&
                passwordAdmin.getText().isBlank()!=true ) {

            successRegisterAdmin.setText("Registration Success");

        }else{

            warningRegisterAdmin.setText("Please Fill all the data.");

        }

    }



    // Password Visibality on check
    public void changeVisibilitySignup(ActionEvent event) {

        if (showpasswordAdmin.isSelected()) {
            showpasswordAdminRegister.setText(passwordAdmin.getText());
            showpasswordAdminRegister.setVisible(true);
            passwordAdmin.setVisible(false);
            return;
        }
        passwordAdmin.setText(showpasswordAdminRegister.getText());
        passwordAdmin.setVisible(true);
        showpasswordAdminRegister.setVisible(false);
    }

// Redirects to the Login page
    public void redirectLoginAdmin(){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/login_admin.fxml")));
            Stage redirectStage = new Stage();
            redirectStage.setTitle("All IN ONE STORE - Admin Login");
            redirectStage.getIcons().add(new Image("src/img/icon.png"));
            redirectStage.setScene(new Scene(root,1500,820));
            redirectStage.show();


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }



    }


}
