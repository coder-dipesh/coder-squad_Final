package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


public class Registration_Admin extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/registration_admin.fxml")));
        primaryStage.setTitle("All IN ONE STORE - Admin Registration");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("src/img/icon.png"));
        primaryStage.setScene(new Scene(root,1500,820));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
