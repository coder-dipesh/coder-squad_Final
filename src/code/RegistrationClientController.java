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


    // Register Client Insert data to database
    public void registerClient(){

        AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
        Connection connectDB = connect.getConnection();

        String firstname = firstnameClient.getText();
        String lastname = lastnameClient.getText();
        String emailaddress = emailaddressClient.getText();
        String username = usernameClient.getText();
        String password = hiddenpasswordClientRegister.getText();

        String insertFields = "INSERT INTO client_register(first_name, last_name, email_id, username, password) VALUES ('";
        String insertValues = firstname + "','" +lastname +"','" + emailaddress +"','" + username +"','" + password +"')";
        String insertToRegister = insertFields + insertValues;

        try{

            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            successmessageClientRegister.setText("Registration Successfull!");

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


    // Register Client Button action
    public void actionClientRegister(ActionEvent event){
        if(firstnameClient.getText().isBlank()!=true && lastnameClient.getText().isBlank()!=true &&
                emailaddressClient.getText().isBlank()!=true && usernameClient.getText().isBlank()!=true &&
                hiddenpasswordClientRegister.getText().isBlank()!=true ) {
                    registerClient();
                    successmessageClientRegister.setText("Registration Successfull!");
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
