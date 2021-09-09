package code;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import static java.util.Objects.requireNonNull;
import java.util.Objects;

public class Dashboard_Admin extends Application{

        @Override
        public void start(Stage stage) throws Exception {

            Parent root = FXMLLoader.load(getClass().getResource("../resource/dashboard_admin.fxml"));
            stage.setTitle("All IN ONE STORE - Admin Dashboard");
            stage.getIcons().add(new Image("src/img/icon.png"));
            stage.setScene(new Scene(root,1500,820));
            stage.show();

            };

        public static void main(String[] args) {
            launch(args);
        }



}





