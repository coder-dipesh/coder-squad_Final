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
import javafx.event.ActionEvent;

import java.util.Objects;

public class SplashScreenController {

    @FXML
    private Button adminPanelOnAction;
    @FXML
    private Button clientPanelOnAction;

    // Redirects to the Admin Registration

    public void adminPanelOnAction(){
    try {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/login_admin.fxml")));
        Stage redirectToAdminStage = new Stage();
        redirectToAdminStage.setTitle("All IN ONE STORE - Admin Login");
        redirectToAdminStage.getIcons().add(new Image("src/img/icon.png"));
        redirectToAdminStage.setScene(new Scene(root,1500,820));
        redirectToAdminStage.show();

        }
    catch (Exception e){
        e.printStackTrace();
        e.getCause();
    }


    }


    // Redirects to the Client Registration

    public void clientPanelOnAction(){
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/login_client.fxml")));
            Stage redirectToClientStage = new Stage();
            redirectToClientStage.setTitle("All IN ONE STORE - Client Login");
            redirectToClientStage.getIcons().add(new Image("src/img/icon.png"));
            redirectToClientStage.setScene(new Scene(root,1500,820));
            redirectToClientStage.show();


        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


}
