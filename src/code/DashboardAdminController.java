package code;

//Necessary Imports

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DashboardAdminController {
    @FXML
    private Button buttonLogout;


    // Logout features
    public void logout() {
        try {
            Stage stageClose = ((Stage) buttonLogout.getScene().getWindow());
            stageClose.close();

        } catch (Exception e) {
            e.printStackTrace();


        }

    }
}