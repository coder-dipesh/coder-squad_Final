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
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

public class RegistrationClientController {


    @FXML
    private CheckBox showpasswordClientRegister;
    @FXML
    private TextField firstnameClient;
    @FXML
    private TextField lastnameClient;
    @FXML
    private TextField emailaddressClient;
    @FXML
    private TextField usernameClient;
    @FXML
    private PasswordField hiddenpasswordClientRegister;
    @FXML
    private TextField visiblepasswordClientRegister;
    @FXML
    private TextField showpasswordAdminRegister;
    @FXML
    private Button actionClientRegister;
    @FXML
    private Hyperlink redirectClientLogin;
    @FXML
    private Label successmessageClientRegister;
    @FXML
    private Label warningmessageClientRegister;



// Register Button

    public void actionClientRegister(ActionEvent event){
        if(firstnameClient.getText().isBlank()!=true && lastnameClient.getText().isBlank()!=true &&
                emailaddressClient.getText().isBlank()!=true && usernameClient.getText().isBlank()!=true &&
                hiddenpasswordClientRegister.getText().isBlank()!=true ) {
            successmessageClientRegister.setText("Registration Successfull");
        }
        else{
            warningmessageClientRegister.setText("Please fill all the details.");
        }
    }

// Redirect to login page
    public void redirectClientLogin(){

        try{
            Parent root = FXMLLoader.load(getClass().getResource("../resource/login_client.fxml"));
            Stage clientRegisterStage = new Stage();
            clientRegisterStage.setTitle("All IN ONE STORE - Client Login");
            clientRegisterStage.getIcons().add(new Image("src/img/icon.png"));
            clientRegisterStage.setScene(new Scene(root,1500,820));
            clientRegisterStage.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

// Password Visibality
public void changeVisibilityRegister(ActionEvent event) {

    if (showpasswordClientRegister.isSelected()) {
        visiblepasswordClientRegister.setText(hiddenpasswordClientRegister.getText());
        visiblepasswordClientRegister.setVisible(true);
        hiddenpasswordClientRegister.setVisible(false);
        return;
    }
    hiddenpasswordClientRegister.setText(visiblepasswordClientRegister.getText());
    hiddenpasswordClientRegister.setVisible(true);
    visiblepasswordClientRegister.setVisible(false);
}

}
