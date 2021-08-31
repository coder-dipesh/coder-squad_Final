package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Update1 extends Application {

    @Override
    public void start(Stage stage_update1) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resource/update1.fxml"));
        stage_update1.setTitle("All in one store");
        stage_update1.setScene(new Scene(root,600,400));
        stage_update1.show();
    }


    public static void main(String[] args) { launch(args);}

}
