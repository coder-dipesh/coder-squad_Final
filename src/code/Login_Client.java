package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Login_Client extends Application {
    @Override
    public void start(Stage clientLoginStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/login_client.fxml")));
        clientLoginStage.setTitle("All IN ONE STORE - Client Login");
        clientLoginStage.setResizable(false);
        clientLoginStage.getIcons().add(new Image("src/img/icon.png"));
        clientLoginStage.setScene(new Scene(root,1500,820));
        clientLoginStage.show();
    }


    public static void main(String[] args) { launch(args);}

}


