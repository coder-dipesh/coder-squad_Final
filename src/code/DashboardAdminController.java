package code;

//Necessary Imports

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class DashboardAdminController {

    @FXML
    private Button createCategory;
    @FXML
    private Button addProduct;
    @FXML
    private Button deleteProduct;
    @FXML
    private Button updateProduct;
    @FXML
    private Button buttonLogout;

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private Button userDetails;


    // Create Product Category feature

    public void createCategory(){
        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/create_category.fxml")));
            Stage stage_create_category = new Stage();
            stage_create_category.setTitle("All in one store - Create Category Admin");
            stage_create_category.getIcons().add(new Image("src/img/icon.png"));
            stage_create_category.setScene(new Scene(root,600,400));
            stage_create_category.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }



    }



    // Add product feature

    public void addProduct(){
        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/add_product_page.fxml")));
            Stage stage_add_product_page = new Stage();
            stage_add_product_page.setTitle("All in one store - Add Product Admin");
            stage_add_product_page.getIcons().add(new Image("src/img/icon.png"));
            stage_add_product_page.setScene(new Scene(root,1500,820));
            stage_add_product_page.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }



    }

    // Update products feature

    public void updateProduct(){
        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/update_ID_enter.fxml")));
            Stage stage_update_product_page = new Stage();
            stage_update_product_page.setTitle("All in one store - Add Product Admin");
            stage_update_product_page.getIcons().add(new Image("src/img/icon.png"));
            stage_update_product_page.setScene(new Scene(root,600,400));
            stage_update_product_page.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

    // Delete Products feature

    public void deleteProduct(){
        try{

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/delete_product_page.fxml")));
            Stage stage_delete_product_page = new Stage();
            stage_delete_product_page.setTitle("All in one store - Add Product Admin");
            stage_delete_product_page.getIcons().add(new Image("src/img/icon.png"));
            stage_delete_product_page.setScene(new Scene(root,600,400));
            stage_delete_product_page.show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

    // Search Button Feature

public void searchButton(){





}

 // To view Loggedin User Details

public void userDetails(){


}



    // Logout features
    public void logout() {
        try {
            Stage stageClose = ((Stage) buttonLogout.getScene().getWindow());
            stageClose.close();

        } catch (Exception e) {
            e.printStackTrace();


        }

    }
}