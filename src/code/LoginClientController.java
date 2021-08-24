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


public class LoginClientController {


    @FXML
    private Button actionClientLogin;
    @FXML
    private Label warningmessageClientLogin;
    @FXML
    private Label successmessageClientLogin;
    @FXML
    private TextField usernameClientLogin ;
    @FXML
    private PasswordField hiddenpasswordClientLogin;
    @FXML
    private TextField visiblepasswordClientLogin;
    @FXML
    private CheckBox showpasswordClientLogin;
    @FXML
    private Hyperlink forgotPaswordClient;
//    @FXML
//    private Hyperlink redirectClientSignup;

    private String username = "dipesh";
    private String password = "111";

    public void actionClientLogin(ActionEvent event){
        if(usernameClientLogin.getText().isBlank()!=true && hiddenpasswordClientLogin.getText().isBlank()!=true){
            validateLogin();
        }
        else{
            warningmessageClientLogin.setText("Invalid Login! Please try again.");
        }

    }


// Password Visibality

    public void changeVisibilityLogin(ActionEvent event) {

        if (showpasswordClientLogin.isSelected()) {
            visiblepasswordClientLogin.setText(hiddenpasswordClientLogin.getText());
            visiblepasswordClientLogin.setVisible(true);
            hiddenpasswordClientLogin.setVisible(false);
            return;
        }
        hiddenpasswordClientLogin.setText(visiblepasswordClientLogin.getText());
        hiddenpasswordClientLogin.setVisible(true);
        visiblepasswordClientLogin.setVisible(false);
    }


    // Validating Login data
    public void validateLogin(){

        if (usernameClientLogin.getText().equals(username) && hiddenpasswordClientLogin.getText().equals(password)){
            successmessageClientLogin.setText("Login Success! Please wait.");


        }
        else{
            warningmessageClientLogin.setText("Invalid Login! Please try again.");

        }

    }

    private void createAccountForm() {
    }

    //
    @FXML
    private void redirectClientSignup(){

        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/registration_client.fxml")));
            Stage registerClientstage = new Stage();
            registerClientstage.setTitle("All IN ONE STORE - Client Registration");
            registerClientstage.getIcons().add(new Image("src/img/icon.png"));
            registerClientstage.setScene(new Scene(root,1500,820));
            registerClientstage.show();


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();

        }


    }

}

