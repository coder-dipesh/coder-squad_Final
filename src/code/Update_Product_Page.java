package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Update_Product_Page extends Application {

    @Override
    public void start(Stage stage_update_product_page) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resource/update_product_page.fxml"));
        stage_update_product_page.setTitle("All in one store");
        stage_update_product_page.setScene(new Scene(root,1500,820));
        stage_update_product_page.show();
    }


    public static void main(String[] args) { launch(args);}

}
