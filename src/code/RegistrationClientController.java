package code;


// Necessary Imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    @FXML
    private Label invalidEmail;
    @FXML
    private Label confirmValidEmail;


    // Calling database connection class
    AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
    Connection connectDB = connect.getConnection();



    // Register clients to the system
    public void registerClient(){

        String firstname = firstnameClient.getText();
        String lastname = lastnameClient.getText();
        String emailaddress = emailaddressClient.getText();
        String username = usernameClient.getText();
        String password = hiddenpasswordClientRegister.getText();

        try {
            String query = "SELECT * FROM client_register WHERE username= ? ";
            PreparedStatement preparedStmt = connectDB.prepareStatement(query);
            preparedStmt.setString(1, username);
            ResultSet resultSet = preparedStmt.executeQuery();

            // Checking if username already taken or not
            if (resultSet.isBeforeFirst()){
                successmessageClientRegister.setVisible(false);
                warningmessageClientRegister.setVisible(true);
                warningmessageClientRegister.setText("Username Already Taken!");
            }
            else {
                // Inserting data into database after validation
                String insertFields = "INSERT INTO client_register(first_name, last_name, email_id, username, password) VALUES ('";
                String insertValues = firstname + "','" + lastname + "','" + emailaddress + "','" + username + "','" + password + "')";
                String insertToRegister = insertFields + insertValues;

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);

                warningmessageClientRegister.setVisible(false);
                successmessageClientRegister.setVisible(true);
                successmessageClientRegister.setText("Registration Success");

                //Resetting  Fields after successful registration
                firstnameClient.setText("");
                lastnameClient.setText("");
                emailaddressClient.setText("");
                usernameClient.setText("");
                hiddenpasswordClientRegister.setText("");
                confirmValidEmail.setVisible(false);


            } }
        catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }



    // Register Client Button action
    public void actionClientRegister(ActionEvent event){

        // Checking if any fields are empty or not
        if(!firstnameClient.getText().isBlank() && !lastnameClient.getText().isBlank() &&
                !emailaddressClient.getText().isBlank() && !usernameClient.getText().isBlank() &&
                !hiddenpasswordClientRegister.getText().isBlank()) {

            // Validating Email Address
            EmailValidator emailValidator = new EmailValidator();
            if(!emailValidator.validate(emailaddressClient.getText().trim())) {

                confirmValidEmail.setVisible(false);
                invalidEmail.setVisible(true);

                System.out.print("Invalid Email ID \n");

            }else {
                invalidEmail.setVisible(false);
                confirmValidEmail.setVisible(true);

                System.out.println("Valid email");

                // After successful validations redirecting to registerClient
                registerClient();
            }
        }
        else{
            warningmessageClientRegister.setText("Please fill all the details.");
        }
    }



    // Redirect to Client Login Section
    public void redirectClientLogin(){

        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/login_client.fxml")));
            Stage clientRegisterStage = new Stage();
            clientRegisterStage.setResizable(false);
            clientRegisterStage.setTitle("All IN ONE STORE - Client Login");
            clientRegisterStage.getIcons().add(new Image("src/img/icon.png"));
            clientRegisterStage.setScene(new Scene(root,1500,820));
            clientRegisterStage.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        // To close previously opened window
        try {
            Stage stageClose = ((Stage) redirectClientLogin.getScene().getWindow());
            stageClose.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }



    // Password Visibility on check
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
