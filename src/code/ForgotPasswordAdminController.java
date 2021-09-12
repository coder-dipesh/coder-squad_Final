package code;


//Necessary Imports
import javafx.fxml.FXML;
import javafx.scene.control.*;
import  javafx.stage.Stage;
import javafx.event.*;
import java.sql.*;


public class ForgotPasswordAdminController {
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

    // Close current window on click
    public void closeButton(ActionEvent event) throws Exception {
        try {
            Stage stageClose = ((Stage) closeButton.getScene().getWindow());
            stageClose.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }


    // Update password on save button click
    public void isPasswordMatched(ActionEvent event) throws Exception{
        if (!hiddenPassword.getText().isBlank() && !hiddenConfirmPassword.getText().isBlank()){

            if(hiddenPassword.getText().equals( hiddenConfirmPassword.getText())){
                successMessage.setText("");
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
    public void saveOnClickButton()  {

        // Checks if any fields are empty
        if (!hiddenPassword.getText().isBlank() && !hiddenConfirmPassword.getText().isBlank()) {

            // Check if password matched or not
            if (hiddenPassword.getText().equals(hiddenConfirmPassword.getText())) {
                successMessage.setText("Password Updated !");

                // Calling database connection
                AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
                Connection connectDB = connect.getConnection();

                String getPassword = hiddenPassword.getText();
                String confirmPassword = hiddenConfirmPassword.getText();
                String getUsername = usernameReset.getText();

                try {
                    // Updating data of database
                    String query = "UPDATE admin_register SET password = ? WHERE username = ?";
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
