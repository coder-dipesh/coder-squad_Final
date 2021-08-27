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
import javafx.event.*;

import java.io.File;
import java.net.URL;
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
        if (usernameAdminLogin.getText().isBlank() != true && passwordAdminLogin.getText().isBlank() != true) {
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
            AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
            Connection connectDB = connect.getConnection();

            String url = "jdbc:mysql://127.0.0.1:3306/codersquad";
            String user = "root";
            String dbPassword = "root";
            String username = usernameAdminLogin.getText();
            String password = passwordAdminLogin.getText();

            try {
                connection = DriverManager.getConnection(url, user, dbPassword);
                preparedStatement = connection.prepareStatement("SELECT password FROM admin_register WHERE username= ? ");
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();

                if (!resultSet.isBeforeFirst()) {
                    warningmessageAdminLogin.setText("Invalid login! Username does not match.");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("First Error - Username Wrong");
                    alert.show();
                } else {
                    while (resultSet.next()) {
                        String retrivedPassword = resultSet.getString("password");

                        if (retrivedPassword.equals(password)) {
                            successmessageAdminLogin.setText("Login sucessfull!");
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Wooo Hooo... Successfully Logged Into the SYSTEM...");
                            alert.show();

                            // Redirect to Dashboard Page
                            dashboardAdmin();

                        } else {
                            warningmessageAdminLogin.setText("Invalid login! Password does not match.");
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("Second Error - Password Wrong");
                            alert.show();
                        }
                    }
                } }catch(SQLException throwables){
                    throwables.printStackTrace();
                }
            }




    // Password Visibality on check
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
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/registration_admin.fxml")));
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



    private void dashboardAdmin() {

    }
    }



