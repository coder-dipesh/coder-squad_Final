package code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class RegisterAdminController {

    @FXML
    private CheckBox showpasswordAdmin;
    @FXML
    private TextField firstnameAdmin;
    @FXML
    private TextField lastnameAdmin;
    @FXML
    public  TextField emailaddressAdmin;
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
    @FXML
    private Label invalidEmail;
    @FXML
    private Label confirmValidEmail;



    // Register Admin Insert data to database

    public void registerUser(){
      AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
        Connection connectDB = connect.getConnection();

        String firstname = firstnameAdmin.getText();
        String lastname = lastnameAdmin.getText();
        String emailaddress = emailaddressAdmin.getText();
        String username = usernameAdmin.getText();
        String password = passwordAdmin.getText();

        try {
            String query = "SELECT * FROM admin_register WHERE username= ? ";
            PreparedStatement preparedStmt = connectDB.prepareStatement(query);
            preparedStmt.setString(1, username);
            ResultSet resultSet = preparedStmt.executeQuery();


            if (resultSet.isBeforeFirst()){
                successRegisterAdmin.setVisible(false);
                warningRegisterAdmin.setVisible(true);
                warningRegisterAdmin.setText("Username Already Taken!");



            }
            else {
                String insertFields = "INSERT INTO admin_register(first_name, last_name, email_id, username, password) VALUES ('";
                String insertValues = firstname + "','" + lastname + "','" + emailaddress + "','" + username + "','" + password + "')";
                String insertToRegister = insertFields + insertValues;

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);

                warningRegisterAdmin.setVisible(false);
                successRegisterAdmin.setVisible(true);
                successRegisterAdmin.setText("Registration Success");

                firstnameAdmin.setText("");
                lastnameAdmin.setText("");
                emailaddressAdmin.setText("");
                usernameAdmin.setText("");
                passwordAdmin.setText("");
                confirmValidEmail.setVisible(false);





            } }
        catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    // Register Button

    public void actionSignupAdmin(ActionEvent event){

        if(!firstnameAdmin.getText().isBlank() && !lastnameAdmin.getText().isBlank() &&
                !emailaddressAdmin.getText().isBlank() && !usernameAdmin.getText().isBlank() &&
                !passwordAdmin.getText().isBlank()) {

            EmailValidator emailValidator = new EmailValidator();
            if(!emailValidator.validate(emailaddressAdmin.getText().trim())) {

                    confirmValidEmail.setVisible(false);
                    invalidEmail.setVisible(true);

                System.out.print("Invalid Email ID");
            }else {
                    invalidEmail.setVisible(false);
                    confirmValidEmail.setVisible(true);

                System.out.println("Valid email");
                registerUser();
            }
        }
        else{
            warningRegisterAdmin.setText("Please Fill all the data.");
        }}




    // Password Visibility on check
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

            Parent root = FXMLLoader.load(getClass().getResource("../resource/login_admin.fxml"));
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
