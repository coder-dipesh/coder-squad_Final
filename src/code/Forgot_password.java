package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Forgot_password extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resource/forgot_password.fxml"));
        stage.setTitle("All in one store");
        stage.setScene(new Scene(root,300,200));
        stage.show();
    }


    public static void main(String[] args) { launch(args);}
}

