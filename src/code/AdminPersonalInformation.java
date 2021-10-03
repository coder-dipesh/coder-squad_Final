package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class AdminPersonalInformation extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/admin_personal_information.fxml")));
        stage.setTitle("All IN ONE STORE - User Details");
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(new Image("img/icon.png"));
        stage.setScene(new Scene(root,700,400));
        stage.show();
    }

    public static void main(String[] args) { launch(args);}

}
