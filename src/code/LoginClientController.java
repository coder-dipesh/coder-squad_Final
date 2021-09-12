package code;


//Necessary Imports

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import  javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.sql.*;
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
    @FXML
    private Hyperlink redirectClientSignup;


    public void setActionClientLogin(ActionEvent event){
        if(!usernameClientLogin.getText().isBlank() && !hiddenpasswordClientLogin.getText().isBlank()){

            validateLoginClient();

            // To close previous window
            try {
                Stage stageClose = ((Stage) actionClientLogin.getScene().getWindow());
                stageClose.close();

            }catch(Exception e){
                e.printStackTrace();
            }

        }
        else{
            warningmessageClientLogin.setText("Invalid Login! Please try again.");
        }

    }


    // Validate data from Database
    public void validateLoginClient(){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
        Connection connectDB = connect.getConnection();

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

    // Redirects to Client Dashboard
    private void dashboardClient() {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/dashboard_client.fxml")));
            Stage dashboardClient = new Stage();
            dashboardClient.setTitle("All IN ONE STORE - Client Dashboard");
            dashboardClient.getIcons().add(new Image("src/img/icon.png"));
            dashboardClient.setScene(new Scene(root,1500,820));
            dashboardClient.show();
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();

        }

    }


    // Password Visibility

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

    // Change Password of code.admin

    public void forgotpasswordClient(){

        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/forgot_password_client.fxml")));
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.getIcons().add(new Image("src/img/icon.png"));
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
            registerClientstage.getIcons().add(new Image("src/img/icon.png"));
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

}

