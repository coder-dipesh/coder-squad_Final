package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Registration_Client extends Application {
    public void start(Stage Stage1) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/registration_client.fxml")));
        Stage1.setTitle("All in one store");
        Stage1.setScene(new Scene(root,1500,820));
        Stage1.show();
}
    public static void main(String[] args) {
        launch(args);
    }
}