package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Splash_Screen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load((getClass().getResource("../resource/splash_screen.fxml")));
        stage.setTitle("All IN ONE STORE - Welcome");
        stage.setResizable(false); // Doesnot allow to resize window
        stage.getIcons().add(new Image("img/icon.png"));
        stage.setScene(new Scene(root,1500,820));
        stage.show();
    }
    public static void main(String[] args) { launch(args);}

}
