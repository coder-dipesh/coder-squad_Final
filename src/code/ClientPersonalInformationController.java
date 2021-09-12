package code;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClientPersonalInformationController {

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
