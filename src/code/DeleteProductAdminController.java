package code;

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


    public void btndeleteProductAdmin(){
        AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
        Connection connectDB = connect.getConnection();

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

                if (!resultSet.isBeforeFirst()) {

                    successMessage.setText("");
                    warningMessage.setText("Product ID not found.");

                } else {

                    String query = "DELETE FROM product_admin WHERE product_id = '" + productID + "' ";
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(query);

                    warningMessage.setText("");
                    successMessage.setText("Product removed successfully.");

                    deleteProductAdmin.setText("");

                    DashboardAdminController dash = new DashboardAdminController();

                    dash.tableList.clear();
                    dash.showTable();



                }
        }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    // To close window
    public void closeDeleteProduct(ActionEvent event) throws Exception {
        try {
            Stage stageClose = ((Stage) closeDeleteProduct.getScene().getWindow());
            stageClose.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }



}
