package code;

//Necessary Imports
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddProductAdminController implements Initializable{

    @FXML
    private TextField pidAddProduct;
    @FXML
    private TextField pnameAddProduct;
    @FXML
    private ComboBox <String> pcategoryAddProduct;
    @FXML
    private TextField ppriceAddProduct;
    @FXML
    private TextField pquantityAddProduct;
    @FXML
    private TextField pdescriptionAddProduct;

    @FXML
    private Button btnAddProduct;
    @FXML
    private Label warningAddProduct;
    @FXML
    private Label successAddProduct;


    // Calling database connection class

    AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
    Connection connectDB = connect.getConnection();

    // Implementing Initializable
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateCategory();
    }

    // Fetch data and show in dropdown

    public void populateCategory(){
        PreparedStatement pst;
        ResultSet rst;
        ObservableList<String> category = FXCollections.observableArrayList();
        try {
            // Fetching all the data from database
            String query = "select * from category ";
            pst = connectDB.prepareStatement(query);
            rst = pst.executeQuery();

            // Adding data to Observable List
            while(rst.next()){
                category.add(rst.getString("category"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        // Observable list items to comboBox
        pcategoryAddProduct.setItems(category);
    }


    // Adding data into database
    public void btnAddProduct(){

        // Getting all data from fields
        String productID = pidAddProduct.getText();
        String productName = pnameAddProduct.getText();
        String productQuantity = pquantityAddProduct.getText();
        String productCategory = pcategoryAddProduct.getValue();
        String productPrice = ppriceAddProduct.getText();
        String productDescription = pdescriptionAddProduct.getText();



        try {
            String queryCheck = "SELECT * FROM product_admin WHERE product_id= ? ";
            PreparedStatement preparedStmt = connectDB.prepareStatement(queryCheck);
            preparedStmt.setString(1,productID);
            ResultSet resultSet = preparedStmt.executeQuery();

            if (resultSet.isBeforeFirst()){

                successAddProduct.setText("");
                warningAddProduct.setText("Product ID already taken.");

            }
            else{
                if(pidAddProduct.getText().isBlank() && pnameAddProduct.getText().isBlank()  && ppriceAddProduct.getText().isBlank()){

                    successAddProduct.setText("");
                    warningAddProduct.setText("Fields cannot be empty!");


                }else {

                    String query = "INSERT INTO product_admin(product_id,product_qty,product_name,category,price,description) " +
                            "VALUES('" + productID + "','"+ productQuantity +"','" + productName + "'," +
                            "'" + productCategory + "','" + productPrice + "','"+ productDescription +"')";
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(query);

                    warningAddProduct.setText("");
                    successAddProduct.setText("Product added successfully.");

                    //Update table after entering data to it
                    DashboardAdminController dash = new DashboardAdminController();
                    dash.tableList.clear();
                    dash.showTable();

                    ppriceAddProduct.setText("");
                    pcategoryAddProduct.setValue("");
                    pnameAddProduct.setText("");
                    pidAddProduct.setText("");
                    pquantityAddProduct.setText("");
                    pdescriptionAddProduct.setText("");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }

    }


}
