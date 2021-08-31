package controller;


//Necessary Imports
import javafx.fxml.FXML;
import javafx.scene.control.*;
import  javafx.stage.Stage;
import javafx.event.*;
import java.sql.*;


public class ForgotPasswordClientController {
    @FXML
    private javafx.scene.control.Button closeButton;
    @FXML
    private Button saveOnClickButton;
    @FXML
    private PasswordField hiddenPassword;
    @FXML
    private CheckBox checkboxVisiblePassword;
    @FXML
    private TextField visiblePassword;
    @FXML
    private TextField visibleConfirmPassword;
    @FXML
    private PasswordField hiddenConfirmPassword;
    @FXML
    private CheckBox checkboxHiddenPassword;
    @FXML
    private Label successMessage;
    @FXML
    private Label warningMessage;
    @FXML
    private TextField usernameReset;

    // Window CLose on click Cancel Button
    public void closeButton(ActionEvent event) throws Exception {
        try {
            Stage stageClose = ((Stage) closeButton.getScene().getWindow());
            stageClose.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    // Update on Save Click

    public void isPasswordMatched(ActionEvent event) throws Exception{
        if (!hiddenPassword.getText().isBlank() && !hiddenConfirmPassword.getText().isBlank()){
            if(hiddenPassword.getText().equals( hiddenConfirmPassword.getText())){
//                successMessage.setText("Password matched !");
            }else{
                warningMessage.setText("Password does not match !");
            }
        }else {
            warningMessage.setText("Fields cannot be empty!");
        }

    }

    // Password Visibility on check
    public void checkboxVisiblePassword (ActionEvent event){
        if (checkboxVisiblePassword.isSelected()) {
            visiblePassword.setText(hiddenPassword.getText());
            visiblePassword.setVisible(true);
            hiddenPassword.setVisible(false);
            return;
        }
        hiddenPassword.setText(visiblePassword.getText());
        hiddenPassword.setVisible(true);
        visiblePassword.setVisible(false);
    }

    // Password Visibility on check For Confirm Password

    public void checkboxHiddenPassword (ActionEvent event){
        if (checkboxHiddenPassword.isSelected()) {
            visibleConfirmPassword.setText(hiddenConfirmPassword.getText());
            visibleConfirmPassword.setVisible(true);
            hiddenConfirmPassword.setVisible(false);
            return;
        }
        hiddenConfirmPassword.setText(visibleConfirmPassword.getText());
        hiddenConfirmPassword.setVisible(true);
        visibleConfirmPassword.setVisible(false);
    }

    // Update data from database
    public void saveOnClickButton() throws SQLException {
        if (!hiddenPassword.getText().isBlank() && !hiddenConfirmPassword.getText().isBlank()) {
            if (hiddenPassword.getText().equals(hiddenConfirmPassword.getText())) {
                successMessage.setText("Password Updated !");

                // Update data to database

                AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
                Connection connectDB = connect.getConnection();

                String getPassword = hiddenPassword.getText();
                String confirmPassword = hiddenConfirmPassword.getText();
                String getUsername = usernameReset.getText();

                try {
                    String query = "UPDATE client_register SET password = ? WHERE username = ?";
                    PreparedStatement preparedStmt = connectDB.prepareStatement(query);
                    preparedStmt.setString(1, getPassword);
                    preparedStmt.setString(2, getUsername);
                    preparedStmt.executeUpdate();
                }
                catch(Exception e){
                    e.printStackTrace();
                    e.getCause();
                }

            } else {
                warningMessage.setText("Password does not match !");
            }
        } else {
            warningMessage.setText("Fields cannot be empty!");
        }

    }
}
