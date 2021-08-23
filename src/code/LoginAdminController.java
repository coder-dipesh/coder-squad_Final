package code;

//Necessary Imports
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import  javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;


public class LoginAdminController{

    @FXML
    private Button actionLoginAdmin;
    @FXML
    private Label warningmessageAdminLogin;
    @FXML
    private TextField usernameAdminLogin ;
    @FXML
    private Label successmessageAdminLogin;
    @FXML
    private PasswordField passwordAdminLogin;
    @FXML
    private TextField visiblepasswordAdminLogin;
    @FXML
    private CheckBox showpasswordAdminLogin;



    private String username = "dipesh";
    private String password = "111";

    // Action while clicking signup button
    public void setActionLoginAdmin(ActionEvent event){
        if(usernameAdminLogin.getText().isBlank()!=true && passwordAdminLogin.getText().isBlank()!=true){
            validateLogin();
        }
        else{
            warningmessageAdminLogin.setText("Invalid Login! Please try again.");
        }

    }

    // Validating Login data
    public void validateLogin(){

        if (usernameAdminLogin.getText().equals(username) && passwordAdminLogin.getText().equals(password)){
            successmessageAdminLogin.setText("Login Success! Please wait.");
            createAccountForm();

        }
        else{
            warningmessageAdminLogin.setText("Invalid Login! Please try again.");

        }

    }


    // Password Visibality on check
    public void changeVisibility(ActionEvent event) {
        if (showpasswordAdminLogin.isSelected()) {
            visiblepasswordAdminLogin.setText(passwordAdminLogin.getText());
            visiblepasswordAdminLogin.setVisible(true);
            passwordAdminLogin.setVisible(false);
            return;
        }
        passwordAdminLogin.setText(visiblepasswordAdminLogin.getText());
        passwordAdminLogin.setVisible(true);
        visiblepasswordAdminLogin.setVisible(false);
    }

    // Account Register Form

    public void createAccountForm(){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/registration_admin.fxml")));
            Stage registerAdminstage = new Stage();
            registerAdminstage.setTitle("All IN ONE STORE - Admin Login");
            registerAdminstage.getIcons().add(new Image("src/img/icon.png"));
            registerAdminstage.setScene(new Scene(root,1500,820));
            registerAdminstage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
        }
    }



