package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.*;
import java.util.*;

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



    // Email Validate

//    public static boolean emailValidate(String input) {
////        String emailPattern = "^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}";
////        String emailPattern ="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
//        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\."+
//                "[a-zA-Z0-9_+&*-]+)*@" +
//                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
//                "A-Z]{2,7}$";
//        Pattern pattern = Pattern.compile(emailPattern);
//        Matcher matcher = pattern.matcher(input);
//
//        return pattern.matcher(emailPattern).matches();
//    }
//    public void validateEmail(){
//        boolean valid =emailValidate();
//        if (valid){
//                    confirmValidEmail.setVisible(true);
//        }else {
//            invalidEmail.setVisible(true);
//        }
//
//    }

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
                warningRegisterAdmin.setText("Username Already Taken!");

            }
            else {
                String insertFields = "INSERT INTO admin_register(first_name, last_name, email_id, username, password) VALUES ('";
                String insertValues = firstname + "','" + lastname + "','" + emailaddress + "','" + username + "','" + password + "')";
                String insertToRegister = insertFields + insertValues;

                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);
                successRegisterAdmin.setText("Registration Success");

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

                registerUser();

//                String email = emailaddressAdmin.getText();
//                boolean valid = emailValidate(emailaddressAdmin.getText());

//                if (valid){
//                    confirmValidEmail.setVisible(true);
//                    registerUser();
//                }else {
//                    invalidEmail.setVisible(true);
//                    warningRegisterAdmin.setText("Invalid Email!");
//                }
        }
        else{
            warningRegisterAdmin.setText("Please Fill all the data.");
        }
    }



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

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/admin/login_admin.fxml")));
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
