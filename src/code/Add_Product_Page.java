package code;

// Necessary Imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class Add_Product_Page extends Application {

    @Override
    public void start(Stage stage_add_product_page) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/add_product_page.fxml")));
        stage_add_product_page.setTitle("All in one store - Add Product Admin");
        stage_add_product_page.setResizable(false);
        stage_add_product_page.getIcons().add(new Image("img/icon.png"));
        stage_add_product_page.setScene(new Scene(root,1500,820));
        stage_add_product_page.show();
    }

    public static void main(String[] args) { launch(args);}

}
