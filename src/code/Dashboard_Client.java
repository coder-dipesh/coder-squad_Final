package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import static java.util.Objects.requireNonNull;

public class Dashboard_Client extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(requireNonNull(getClass().getResource("../resource/dashboard_client.fxml")));
        stage.setTitle("All IN ONE STORE - Client Dashboard");
        stage.setResizable(false);
        stage.getIcons().add(new Image("img/icon.png"));
        stage.setScene(new Scene(root,1500,820));
        stage.show();

    };

    public static void main(String[] args) {
        launch(args);
    }



}





