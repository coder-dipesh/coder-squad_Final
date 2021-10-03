package code;


//Necessary Imports

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.ResourceBundle;


public class LoginClientController implements Initializable {


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
    @FXML
    private Hyperlink redirectClientSignup;


    public void setActionClientLogin(){
        if(!usernameClientLogin.getText().isBlank() && !hiddenpasswordClientLogin.getText().isBlank()){

            validateLoginClient();

        }
        else{
            warningmessageClientLogin.setText("Invalid Login! Please try again.");
        }

    }


    // Validate data from Database
    public void validateLoginClient(){

        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        String url = "jdbc:mysql://127.0.0.1:3306/codersquad";
        String user = "root";
        String dbPassword = "root";
        String username = usernameClientLogin.getText();
        String password = hiddenpasswordClientLogin.getText();

        try {
            connection = DriverManager.getConnection(url, user, dbPassword);
            preparedStatement = connection.prepareStatement("SELECT password FROM client_register WHERE username= ? ");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                warningmessageClientLogin.setText("");
                warningmessageClientLogin.setVisible(false);
                warningmessageClientLogin.setVisible(true);
                warningmessageClientLogin.setText("Invalid login! Username does not match.");

            } else {
                while (resultSet.next()) {
                    String retrivedPassword = resultSet.getString("password");

                    if (retrivedPassword.equals(password)) {
                        warningmessageClientLogin.setVisible(false);
                        successmessageClientLogin.setVisible(true);
                        successmessageClientLogin.setText("Login successful!");

                        // Redirect to Client Dashboard Page
                        dashboardClient();

                        // To clear the fields
                        usernameClientLogin.setText("");
                        hiddenpasswordClientLogin.setText("");

                    } else {
                        successmessageClientLogin.setVisible(false);
                        warningmessageClientLogin.setText("Invalid login! Password does not match.");
                    }
                }
            } }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    // Username field access
    public void passData()  {

        try {
            // Loading FXML of second class
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/dashboard_client.fxml"));
            Parent main = loader.load();


            // Get controller of second
            DashboardClientController dashboard = loader.getController();


            // Calling method and passing data
            dashboard.usrName(usernameClientLogin.getText());


            // Opening New stage for dashboard
            Stage stage = new Stage();
            stage.setScene(new Scene(main,1500,820));
            stage.setTitle("All IN ONE STORE - Client Dashboard");
            stage.setResizable(false);
            stage.getIcons().add(new Image("img/icon.png"));
            stage.show();


            // Clearing fields after successful login
            usernameClientLogin.setText("");
            hiddenpasswordClientLogin.setText("");


            // To close previously opened window
            try {
                Stage stageClose = ((Stage) actionClientLogin.getScene().getWindow());
                stageClose.close();

            }catch(Exception e){
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    // Redirects to Client Dashboard
    private void dashboardClient() {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/dashboard_client.fxml")));
            Stage dashboardClient = new Stage();
            dashboardClient.setTitle("All IN ONE STORE - Client Dashboard");
            dashboardClient.getIcons().add(new Image("img/icon.png"));
            dashboardClient.setScene(new Scene(root,1500,820));
            dashboardClient.show();
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();

        }

    }


    // Password Visibility

    public void changeVisibilityLogin() {

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

    // Change Password of code.admin

    public void forgotpasswordClient(){

        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/forgot_password_client.fxml")));
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.getIcons().add(new Image("img/icon.png"));
            stage.setScene(new Scene(root, 500, 450));
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


    public void redirectClientSignup(){

        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/registration_client.fxml")));
            Stage registerClientstage = new Stage();
            registerClientstage.setTitle("All IN ONE STORE - Client Registration");
            registerClientstage.getIcons().add(new Image("img/icon.png"));
            registerClientstage.setScene(new Scene(root,1500,820));
            registerClientstage.show();


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();

        }

        // To close previously opened window
        try {
            Stage stageClose = ((Stage) redirectClientSignup.getScene().getWindow());
            stageClose.close();

        }catch(Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        actionClientLogin.setOnAction(event -> passData());

    }
}

