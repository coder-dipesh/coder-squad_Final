package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Registration_Client extends Application {

    @Override
    public void start(Stage Stage1) throws Exception{

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/registration_client.fxml")));
        Stage1.setTitle("All IN ONE STORE - Client Registration");
        Stage1.getIcons().add(new Image("src/img/icon.png"));
        Stage1.setScene(new Scene(root,1500,820));
        Stage1.show();
}
    public static void main(String[] args) {
        launch(args);
    }
}