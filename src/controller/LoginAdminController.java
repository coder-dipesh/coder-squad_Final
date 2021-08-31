package controller;

//Necessary Imports
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import  javafx.stage.Stage;
import javafx.event.*;
import javafx.stage.StageStyle;


import java.sql.*;
import java.util.Objects;


public class LoginAdminController {

    @FXML
    private Button actionLoginAdmin;
    @FXML
    private Label warningmessageAdminLogin;
    @FXML
    private TextField usernameAdminLogin;
    @FXML
    private Label successmessageAdminLogin;
    @FXML
    private PasswordField passwordAdminLogin;
    @FXML
    private TextField visiblepasswordAdminLogin;
    @FXML
    private CheckBox showpasswordAdminLogin;
    @FXML
    private Hyperlink redirectAdminSignup;


        // Action while clicking Login button

        public void setActionLoginAdmin(ActionEvent event) {
        if (!usernameAdminLogin.getText().isBlank() && !passwordAdminLogin.getText().isBlank()) {
            validateLoginAdmin();
        } else {
            warningmessageAdminLogin.setText("Invalid Login! Please try again.");
        }

    }


        // Validate data from Database
        public void validateLoginAdmin(){

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            String url = "jdbc:mysql://127.0.0.1:3306/codersquad";
            String user = "root";
            String dbPassword = "prasid890";
            String username = usernameAdminLogin.getText();
            String password = passwordAdminLogin.getText();

            try {
                connection = DriverManager.getConnection(url, user, dbPassword);
                preparedStatement = connection.prepareStatement("SELECT password FROM admin_register WHERE username= ? ");
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();

                if (!resultSet.isBeforeFirst()) {
                    warningmessageAdminLogin.setText("Invalid login! Username does not match.");

                } else {
                    while (resultSet.next()) {
                        String retrivedPassword = resultSet.getString("password");

                        if (retrivedPassword.equals(password)) {
                            successmessageAdminLogin.setText("Login sucessfull!");

                            // Redirect to Dashboard Page
                            dashboardAdmin();

                        } else {
                            warningmessageAdminLogin.setText("Invalid login! Password does not match.");

                        }
                    }
                } }catch(SQLException throwables){
                    throwables.printStackTrace();
                }
            }




    // Password Visibility on check
        public void changeVisibility (ActionEvent event){
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

        // Redirect to Admin Signup
        public void redirectAdminSignup (ActionEvent event){
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/admin/registration_admin.fxml")));
                Stage registerAdminstage = new Stage();
                registerAdminstage.setTitle("All IN ONE STORE - Admin Signup");
                registerAdminstage.getIcons().add(new Image("src/img/icon.png"));
                registerAdminstage.setScene(new Scene(root, 1500, 820));
                registerAdminstage.show();


            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();

            }

        }


// Redirects to Admin Dashboard after validating login details

    private void dashboardAdmin() {

    }

    // Change Password of admin

    public void forgotpasswordAdmin(){

        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/admin/forgot_password_admin.fxml")));
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
    }







