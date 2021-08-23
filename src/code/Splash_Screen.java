package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Splash_Screen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/splash_screen.fxml")));
        stage.setTitle("All In One Store");
        stage.setScene(new Scene(root,1500,820));
        stage.show();
    }


    public static void main(String[] args) { launch(args);}

}


