package code;

//Necessary Imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Forgot_Password extends Application {


    @Override
    public void start(Stage stage) throws Exception {
    try {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/forgot_password_admin.fxml")));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image("src/img/icon.png"));
        stage.setScene(new Scene(root, 500, 450));
        stage.show();

    }catch(Exception e){
        e.printStackTrace();
        e.getCause();
    }
    }


    public static void main(String[] args) { launch(args);}
}

