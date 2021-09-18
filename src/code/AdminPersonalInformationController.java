package code;

//Necessary Imports
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class AdminPersonalInformationController {

    // Calling database connection
    AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
    Connection connectDB = AuthenticationDatabaseConnection.getConnection();


    // User Details Section
    @FXML
    private TextField userFname;
    @FXML
    private TextField userLname;
    @FXML
    private TextField userEmail;
    @FXML
    private TextField userUsername;
    @FXML
    private Button btnCloseWindow;


    // User Data Show
    public void setData(String firstName, String lastName, String emailID, String userName){

        System.out.println("Data are " + firstName);
        System.out.println("Data are " + lastName);
        System.out.println("Data are " + emailID);
        System.out.println("Data are " + userName);

        // Setting data to respective fields

        userFname.setText(firstName);
        userLname.setText(lastName);
        userEmail.setText(emailID);
        userUsername.setText(userName);


    }


    // Close current Scene if close button pressed
    public void btnCloseWindow(){
        try {
            Stage stageClose = ((Stage) btnCloseWindow.getScene().getWindow());
            stageClose.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }






}
