package code;

//Necessary Imports

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;


public class DashboardAdminController implements Initializable {

    AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
    Connection connectDB = AuthenticationDatabaseConnection.getConnection();


    @FXML
    private Button createCategory;
    @FXML
    private Button addProduct;
    @FXML
    private Button deleteProduct;
    @FXML
    private Button btnUpdateProduct;
    @FXML
    public Button buttonLogout;
    @FXML
    private TextField searchField;
    @FXML
    private Button userDetails;
    @FXML
    private Label welcomeUsername;

    // Product Table
    @FXML
    public TableView <Table> tableProduct;
    @FXML
    private TableColumn<Table, Integer> colID;
    @FXML
    private TableColumn<Table, Integer> colQuantity;
    @FXML
    private TableColumn<Table, String>  colName;
    @FXML
    private TableColumn<Table, String>  colCategory;
    @FXML
    private TableColumn<Table, Integer>  colPrice;
    @FXML
    private TableColumn<Table, String>  colDescription;

    // Update Page

    @FXML
    private TextField pidUpdate;
    @FXML
    private TextField pnameUpdate;
    @FXML
    private ComboBox<String> pcategoryUpdate;
    @FXML
    private TextField ppriceUpdate;
    @FXML
    private Button btnUpdate;
    @FXML
    private TextField pdescriptionUpdate;
    @FXML
    private TextField pquantityUpdate;
    @FXML
    private Button btnUpdateTable;





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
    public void btnUpdateProduct(ActionEvent event){
        try {
            Statement stmt = connectDB.createStatement();
            Table product = tableProduct.getSelectionModel().getSelectedItem();

            String query = "UPDATE product_admin SET product_qty = '" + pquantityUpdate.getText() + "', product_name = '" + pnameUpdate.getText() + "',category = '" + pcategoryUpdate.getSelectionModel().getSelectedItem() + "'," +
                    "price = '" + ppriceUpdate.getText() + "', description = '" + pdescriptionUpdate.getText() + "' WHERE product_id = '" + pidUpdate.getText() + "' ";

            stmt.executeUpdate(query);
            tableList.clear();
            showTable();

        } catch (Exception e) {
            e.printStackTrace();
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
    public void searchButton() {
    }



    // Redirects to user details
    public void userDetails(){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/user_details.fxml")));
            Stage stage_user_details = new Stage();
            stage_user_details.setTitle("All IN ONE STORE - User Details");
            stage_user_details.setResizable(false);
            stage_user_details .getIcons().add(new Image("src/img/icon.png"));
            stage_user_details .setScene(new Scene(root,700,400));
            stage_user_details .show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


    // Logout features
    public void logout() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure do you want to Logout?");

        if(alert.showAndWait().get() == ButtonType.OK){
            try {
                Stage stageClose = ((Stage) buttonLogout.getScene().getWindow());
                stageClose.getIcons().add(new Image("src/img/icon.png"));
                stageClose.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }




    // Observable list for storing database data
    ObservableList<Table> tableList = FXCollections.observableArrayList();

    // Insert data to Observable list (tableList)
    public void showTable(){
        String query = "SELECT * FROM product_admin";
        Statement stmt;
        ResultSet rs;

        try {
            Connection connectDB = AuthenticationDatabaseConnection.getConnection();
            stmt =connectDB.createStatement();
            rs = stmt.executeQuery(query);
            Table table;
            table = null;

            while (rs.next()){
                table = new Table(rs.getString("product_id"),rs.getString("product_qty"),
                        rs.getString("product_name"), rs.getString("category"),
                        rs.getString("description"),rs.getString("price"));
                tableList.add(table);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    // Refresh the table
    public void refresh(){

        colID.setCellValueFactory(new PropertyValueFactory<Table,Integer>("product_id"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<Table,Integer>("product_qty"));
        colName.setCellValueFactory(new PropertyValueFactory<Table,String>("product_name"));
        colCategory.setCellValueFactory(new PropertyValueFactory<Table,String>("category"));
        colPrice.setCellValueFactory(new PropertyValueFactory<Table,Integer>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<Table,String>("description"));
        tableProduct.setItems(tableList);

    }


    // To update table after adding data or deleting data
    public void btnUpdateTable(){
        tableList.clear();
        showTable();
        addListenerTable();
        refresh();
    }


    // Action Listener for table Product
    private void addListenerTable(){

        tableProduct.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{
            if (newSelection != null){
                btnUpdateProduct.setDisable(false);
                deleteProduct.setDisable(false);

                pidUpdate.setText("" + newSelection.getProduct_id());
                pnameUpdate.setText(newSelection.getProduct_name());
                pcategoryUpdate.getSelectionModel().select(newSelection.getCategory()); // Get category from database
                ppriceUpdate.setText(newSelection.getPrice());
                pquantityUpdate.setText(newSelection.getProduct_qty());
                pdescriptionUpdate.setText(newSelection.getDescription());

            }else{
                pidUpdate.setText("");
                pnameUpdate.setText("");
                pcategoryUpdate.getSelectionModel().selectFirst(); // Reset combo box
                ppriceUpdate.setText("");
                pdescriptionUpdate.setText("");
                pquantityUpdate.setText("");

                btnUpdateProduct.setDisable(true);
                deleteProduct.setDisable(true);

            }
        });


    }





    // Initializing Methods
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTable();
        addListenerTable();
        refresh();




        Table product ;


        // Search product from table through searchfield keyword

        // Initial Phase Filter code

        FilteredList<Table> filteredData = new FilteredList<>(tableList, b-> true);

        searchField.textProperty().addListener(((observable, oldValue, newValue) -> {

            filteredData.setPredicate(table -> {

                // If no search value then display all records -- no changes
                if (newValue.isEmpty() || newValue.isBlank() || newValue ==null){
                    return true;
                }

                String searchValue = searchField.getText();
                searchValue = newValue.toLowerCase();

                if(table.getProduct_id().toString().contains(searchValue)){
                    return true; // It means found match in Product Name
                }
                else if(table.getProduct_name().toLowerCase().contains(searchValue)){
                    return true; // It means found match in Product Name
                }
                else if(table.getCategory().toLowerCase().contains(searchValue)){
                    return true;  // It means found match in Product Category
                }
                else if(table.getDescription().toLowerCase().contains(searchValue)){
                    return true;   // It means found match in Product Description
                }
                else if(table.getProduct_qty().toString().contains(searchValue)) {
                    return true;  // It means found match in Product Quantity
                }
                else if(table.getPrice().toString().contains(searchValue)){
                    return true;  // It means found match in Product Price
                }
                else {
                    return false; // no match found
                }
            });

            // Sorting
            SortedList<Table> sortedData = new SortedList<> (filteredData);

            // Bind sorted data with  Table

            sortedData.comparatorProperty().bind(tableProduct.comparatorProperty());
            tableProduct.setItems(sortedData);
        }));

    }

}