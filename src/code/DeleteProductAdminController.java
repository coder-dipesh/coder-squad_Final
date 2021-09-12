package code;

// Necessary Imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteProductAdminController {

    @FXML
    private Button closeDeleteProduct;
    @FXML
    private TextField deleteProductAdmin;
    @FXML
    private Button btndeleteProductAdmin;
    @FXML
    private Label warningMessage;
    @FXML
    private Label successMessage;

    //Calling Database Connection class
    AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
    Connection connectDB = connect.getConnection();


    // Delete product details related to product ID
    public void btndeleteProductAdmin(){

        String productID = deleteProductAdmin.getText();
        try {
            String queryCheck = "SELECT * FROM product_admin WHERE product_id= ? ";
            PreparedStatement preparedStmt = connectDB.prepareStatement(queryCheck);
            preparedStmt.setString(1, productID);
            ResultSet resultSet = preparedStmt.executeQuery();

            if (deleteProductAdmin.getText().isBlank()) {
                successMessage.setText("");
                warningMessage.setText("Field cannot be empty!");

            } else {

                //Checking whether product id is available or not
                if (!resultSet.isBeforeFirst()) {
                    successMessage.setText("");
                    warningMessage.setText("Product ID not found.");

                } else {
                    // Deleting data respective to productID
                    String query = "DELETE FROM product_admin WHERE product_id = '" + productID + "' ";
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(query);

                    warningMessage.setText("");
                    successMessage.setText("Product removed successfully.");

                    deleteProductAdmin.setText("");

                }
        }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }


    // To close currently opened window
    public void closeDeleteProduct(ActionEvent event) throws Exception {

        try {

            Stage stageClose = ((Stage) closeDeleteProduct.getScene().getWindow());
            stageClose.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }



}
