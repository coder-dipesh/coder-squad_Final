package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Update_ID_Enter extends Application {

    @Override
    public void start(Stage stage_update1) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/update_ID_enter.fxml")));
        stage_update1.setTitle("All in one store");
        stage_update1.setScene(new Scene(root,600,400));
        stage_update1.show();
    }

    public static void main(String[] args) { launch(args);}

}
