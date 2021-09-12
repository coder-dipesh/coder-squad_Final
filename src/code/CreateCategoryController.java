package code;

//Necessary Imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.*;


public class CreateCategoryController {

    @FXML
    private Button closeCreateCategory;
    @FXML
    private Button saveCreateCategory;
    @FXML
    private TextField addCategory;
    @FXML
    private TextField removeCategory;
    @FXML
    private Label successMessage;
    @FXML
    private Label warningMessage;

    // Calling database class
    AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
    Connection connectDB = connect.getConnection();


    // Check which task to perform
    public void saveCreateCategory() {

        // Checks which task to perform either addCategory or removeCategory
        if (addCategory.getText().isBlank()){

            removeCreateCategory();

        }
        else {

            addCreateCategory();

        }

    }


    // Add category to category table
    public void addCreateCategory(){

        String categoryAdd = addCategory.getText();
        AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
        Connection connectDB = connect.getConnection();

        ResultSet resultSet = null;

        // Checks if category is already available or not
        try {
                String query = "SELECT * FROM category WHERE category= ? ";
                PreparedStatement preparedStmt = connectDB.prepareStatement(query);
                preparedStmt.setString(1, categoryAdd);
                resultSet = preparedStmt.executeQuery();

            if (resultSet.isBeforeFirst()) {
                successMessage.setText("");
                warningMessage.setText("Category already available!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert into category table
        try {
            String query = "INSERT INTO category(category) VALUES(?)";
            PreparedStatement preparedStmt = connectDB.prepareStatement(query);
            preparedStmt.setString(1, categoryAdd);
            preparedStmt.executeUpdate();

            warningMessage.setText("");
            successMessage.setText("Category added successfully.");


            System.out.println("Data insert Successfully");

            addCategory.setText("");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    // Remove category from table
    public void removeCreateCategory(){

        String categoryRemove = removeCategory.getText();

        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM category WHERE category= ? ";
            PreparedStatement preparedStmt = connectDB.prepareStatement(query);
            preparedStmt.setString(1, categoryRemove);
            resultSet = preparedStmt.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                successMessage.setText("");
                warningMessage.setText("Category not available!");
            }
            else{

                // Remove the category from category table
                try {
                    String data = categoryRemove.toString();
                    String queryDelete = "DELETE FROM category WHERE category = '"+ data +"' ";
                    PreparedStatement preparedStmtIn = connectDB.prepareStatement(queryDelete);
                    preparedStmtIn.executeUpdate();

                    warningMessage.setText("");
                    successMessage.setText("Category removed successfully.");

                    System.out.println("Data deleted Successfully");

                    removeCategory.setText("");


                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // To close present window
    public void closeCreateCategory(ActionEvent event) throws Exception {
        try {
            Stage stageClose = ((Stage) closeCreateCategory.getScene().getWindow());
            stageClose.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
