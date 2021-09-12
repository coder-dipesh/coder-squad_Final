package code;


//Necessary Imports
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;


public class DashboardClientController implements Initializable {

    @FXML
    private Button btnLogout;
    @FXML
    private Button btnAddToCart;
    @FXML
    private Button btnDeleteProduct;
    @FXML
    private Button  btnUserDetails;
    @FXML
    private TextField searchField;
    @FXML
    private Label loginUsername;

    // Product Table
    @FXML
    public TableView <Table> tableView;
    @FXML
    private TableColumn<Table, Integer> id;
    @FXML
    private TableColumn<Table, Integer> qty;
    @FXML
    private TableColumn<Table, String>  name;
    @FXML
    private TableColumn<Table, String>  category;
    @FXML
    private TableColumn<Table, Integer>  price;
    @FXML
    private TableColumn<Table, String>  description;

    // Cart Table
    @FXML
    public TableView <Table> cart;
    @FXML
    private TableColumn<Table, Integer> cartID;
    @FXML
    private TableColumn<Table, Integer> cartQuantity;
    @FXML
    private TableColumn<Table, String>  cartName;
    @FXML
    private TableColumn<Table, String>  cartCategory;
    @FXML
    private TableColumn<Table, Integer>  cartPrice;
    @FXML
    private TableColumn<Table, String>  cartDescription;


    // Logout Client from Dashboard
    public void logout() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure do you want to Logout?");

        if(alert.showAndWait().get() == ButtonType.OK){
            try {
                Stage stageClose = ((Stage) btnLogout.getScene().getWindow());
                stageClose.getIcons().add(new Image("src/img/icon.png"));
                stageClose.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    // Enable PopUp Window to show Personal Information
    public void clientPersonalInformation(){
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../resource/client_personal_information.fxml")));
            Stage stage_user_details = new Stage();
            stage_user_details.setTitle("All IN ONE STORE - Client Personal Information");
            stage_user_details.setResizable(false);
            stage_user_details .getIcons().add(new Image("src/img/icon.png"));
            stage_user_details .setScene(new Scene(root,700,400));
            stage_user_details .show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


//======================================================================================================================
//========================================= TABLE VIEW DISPLAY =========================================================
//======================================================================================================================


    // Observable list for storing database data
    ObservableList<Table> tableData = FXCollections.observableArrayList();

    // Insert data to Observable list--> (tableList)
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
                tableData.add(table);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    // Set data to respective column of Table view
    public void setData(){

        id.setCellValueFactory(new PropertyValueFactory<Table,Integer>("product_id"));
        qty.setCellValueFactory(new PropertyValueFactory<Table,Integer>("product_qty"));
        name.setCellValueFactory(new PropertyValueFactory<Table,String>("product_name"));
        category.setCellValueFactory(new PropertyValueFactory<Table,String>("category"));
        price.setCellValueFactory(new PropertyValueFactory<Table,Integer>("price"));
        description.setCellValueFactory(new PropertyValueFactory<Table,String>("description"));
        tableView.setItems(tableData);

    }


    // Search product from table through searchfield keyword
    public void searchFeature(){

        // Initial Phase Filter code
        FilteredList<Table> filteredData = new FilteredList<>(tableData, b-> true);

        searchField.textProperty().addListener(((observable, oldValue, newValue) -> {

            filteredData.setPredicate(table -> {

                // If no search value then display all records -- no changes
                if (newValue.isEmpty() || newValue.isBlank() || newValue ==null){
                    return true;
                }

                // Getting search field data and changing to lowercase
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
            sortedData.comparatorProperty().bind(tableView.comparatorProperty());
            tableView.setItems(sortedData);

        }));
    }

//=======================================  View Database data   ========================================================


//======================================================================================================================
//========================================  Cart  Table   ==============================================================


    // Observable list for storing data
    ObservableList<Table> products = FXCollections.observableArrayList();


    // Set values to respective columns of tableView
    private void initialize(){
        cartID.setCellValueFactory(new PropertyValueFactory<Table,Integer>("product_id"));
        cartQuantity.setCellValueFactory(new PropertyValueFactory<Table,Integer>("product_qty"));
        cartName.setCellValueFactory(new PropertyValueFactory<Table,String>("product_name"));
        cartCategory.setCellValueFactory(new PropertyValueFactory<Table,String>("category"));
        cartPrice.setCellValueFactory(new PropertyValueFactory<Table,Integer>("price"));
        cartDescription.setCellValueFactory(new PropertyValueFactory<Table,String>("description"));

    }


    // Display data on cart table on click
    public void addToCart(){

        Table selection = tableView.getSelectionModel().getSelectedItem();
        if (selection != null){
            cart.getItems().add(new Table(selection.getProduct_id(),selection.getProduct_qty(),selection.getProduct_name(),
                    selection.getCategory(),selection.getPrice(),selection.getDescription()));
        }
    }



    //Initializing Methods
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initialize();
        showTable();
        setData();
        searchFeature();
    }

}
