package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Create_Category extends Application {

    @Override
    public void start(Stage stage_create_category) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("../resource/create_category.fxml"));
        stage_create_category.setTitle("All in one store - Create Category Admin");
        stage_create_category.getIcons().add(new Image("src/img/icon.png"));
        stage_create_category.setScene(new Scene(root,600,400));
        stage_create_category.show();
    }

    public static void main(String[] args) { launch(args);}

}
