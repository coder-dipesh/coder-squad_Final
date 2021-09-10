package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import static java.util.Objects.requireNonNull;

public class Dashboard_Admin extends Application{

        @Override
        public void start(Stage stage) throws Exception {
<<<<<<< HEAD

            Parent root = FXMLLoader.load(requireNonNull(getClass().getResource("../resource/dashboard_admin.fxml")));
=======
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/dashboard_admin.fxml")));
>>>>>>> b4c252226cc407f7727286a1652f56c7cc079bd3
            stage.setTitle("All IN ONE STORE - Admin Dashboard");
            stage.getIcons().add(new Image("src/img/icon.png"));
            stage.setScene(new Scene(root,1500,820));
            stage.show();

            };

        public static void main(String[] args) {
            launch(args);
        }



}





