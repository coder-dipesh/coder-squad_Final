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

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;


public class DashboardClientController implements Initializable {

    // Calling database connection class
    AuthenticationDatabaseConnection connect = new AuthenticationDatabaseConnection();
    Connection connectDB = connect.getConnection();


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
    private Label welcomeUsername;
    @FXML
    private Label cartWarning;

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
    public TableView <Table> cartTable;
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
                stageClose.getIcons().add(new Image("img/icon.png"));
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
            stage_user_details .getIcons().add(new Image("img/icon.png"));
            stage_user_details .setScene(new Scene(root,700,400));
            stage_user_details .show();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }


    String us;
    // Get data from login page
    public void usrName(String username){

        us=username;
        System.out.println(username);
        welcomeUsername.setText(username);

    }

    String firstName;
    String lastName ;
    String emailId ;
    String userName ;

    // Fetched Data From login
    public void dataUser(){

        // Store data
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        String usernameClient =us ;
        System.out.println(usernameClient);
        String url = "jdbc:mysql://127.0.0.1:3306/codersquad";
        String user = "root";
        String dbPassword = "root";



        try {
            connection = DriverManager.getConnection(url, user, dbPassword);
            preparedStatement = connection.prepareStatement("SELECT * FROM client_register WHERE username= '"+ usernameClient +"' ");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                firstName = resultSet.getString("first_name");
                lastName = resultSet.getString("last_name");
                emailId = resultSet.getString("email_id");
                userName = resultSet.getString("username");
            }

            System.out.println(firstName + lastName + emailId + userName);



        } catch (SQLException e) {
            e.printStackTrace();

        }

        // Sending data to new Window
        try {
            // Loading FXML of second class
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resource/client_personal_information.fxml"));
            Parent main = loader.load();


            // Get controller of second
            ClientPersonalInformationController personal = (ClientPersonalInformationController) loader.getController();


            // Calling method and passing data
            personal.setData(firstName,lastName,emailId,userName);


            // Opening New stage for dashboard
            Stage stage = new Stage();
            stage.setScene(new Scene(main,800,400));
            stage.setTitle("All IN ONE STORE - Client Personal Information");
            stage.setResizable(false);
            stage.getIcons().add(new Image("img/icon.png"));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
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


    // Search product from table through search field keyword
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
    ObservableList<Table> products =  FXCollections.observableArrayList();



    // Display data on cart table on click
    public void addToCart(){
        Table selection = tableView.getSelectionModel().getSelectedItem();

        if (selection != null) {
            String id = selection.getProduct_id();
            String qty = selection.getProduct_qty();
            String name = selection.getProduct_name();
            String category = selection.getCategory();
            String price = selection.getPrice();
            String description = selection.getDescription();

            // Check if product already available or not
            try {
                String q = "SELECT * FROM cart WHERE product_id= '"+ id +"' ";
                PreparedStatement s = connectDB.prepareStatement(q);
                ResultSet rss = s.executeQuery();

                if(!rss.isBeforeFirst()){

                    // ADD to cart table view and refresh view
                    products.clear();

                    // INSERT IN DATABASE CART
                    try {
                        String query = "INSERT INTO cart(product_id,product_qty,product_name,category,price,description) " +
                                "VALUES('" + id + "','" + qty + "','" + name + "'," +
                                "'" + category + "','" + price + "','" + description + "')";
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(query);

                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();
                    }


                    // Show in cart table
                    String query = "SELECT * FROM cart";
                    Statement stmt;
                    ResultSet rs;

                    try {
                        Connection connectDB = AuthenticationDatabaseConnection.getConnection();
                        stmt = connectDB.createStatement();
                        rs = stmt.executeQuery(query);
                        Table table;

                        while (rs.next()) {
                            table = new Table(rs.getString("product_id"), rs.getString("product_qty"),
                                    rs.getString("product_name"), rs.getString("category"),
                                    rs.getString("description"), rs.getString("price"));
                            products.add(table);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }

                    // Show in table view
                    cartID.setCellValueFactory(new PropertyValueFactory<Table, Integer>("product_id"));
                    cartQuantity.setCellValueFactory(new PropertyValueFactory<Table, Integer>("product_qty"));
                    cartName.setCellValueFactory(new PropertyValueFactory<Table, String>("product_name"));
                    cartCategory.setCellValueFactory(new PropertyValueFactory<Table, String>("category"));
                    cartPrice.setCellValueFactory(new PropertyValueFactory<Table, Integer>("price"));
                    cartDescription.setCellValueFactory(new PropertyValueFactory<Table, String>("description"));
                    cartTable.setItems(products);



                }
                else{
                    cartWarning.setText("Product Already in Cart!");
                }

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

        }
    }


    // Remove from cart
     public void removeFromCart(){

        Table selected = cartTable.getSelectionModel().getSelectedItem();
        if(selected!=null){

            String id = selected.getProduct_id();

            // Check if product already available or not
            try {
                String q = "DELETE  FROM cart WHERE product_id= '"+ id +"' ";
                Statement s = connectDB.createStatement();
                s.executeUpdate(q);

                    // ADD to cart table view and refresh view
                    products.clear();

                    // INSERT IN DATABASE CART
                    try {
                        String query = "INSERT INTO cart(product_id,product_qty,product_name,category,price,description) " +
                                "VALUES('" + id + "','" + qty + "','" + name + "'," +
                                "'" + category + "','" + price + "','" + description + "')";
                        Statement statement = connectDB.createStatement();
                        statement.executeUpdate(query);

                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();
                    }


                    // Show in cart table
                    String query = "SELECT * FROM cart";
                    Statement stmt;
                    ResultSet rs;

                    try {
                        Connection connectDB = AuthenticationDatabaseConnection.getConnection();
                        stmt = connectDB.createStatement();
                        rs = stmt.executeQuery(query);
                        Table table;

                        while (rs.next()) {
                            table = new Table(rs.getString("product_id"), rs.getString("product_qty"),
                                    rs.getString("product_name"), rs.getString("category"),
                                    rs.getString("description"), rs.getString("price"));
                            products.add(table);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }

                    // Show in table view
                    cartID.setCellValueFactory(new PropertyValueFactory<Table, Integer>("product_id"));
                    cartQuantity.setCellValueFactory(new PropertyValueFactory<Table, Integer>("product_qty"));
                    cartName.setCellValueFactory(new PropertyValueFactory<Table, String>("product_name"));
                    cartCategory.setCellValueFactory(new PropertyValueFactory<Table, String>("category"));
                    cartPrice.setCellValueFactory(new PropertyValueFactory<Table, Integer>("price"));
                    cartDescription.setCellValueFactory(new PropertyValueFactory<Table, String>("description"));
                    cartTable.setItems(products);


            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

        }

     }



    public void btnClearCart(){

        // Clear the table view
        products.clear();

        // Clear the Whole Cart
        try {
            String query = "TRUNCATE TABLE cart";
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }


    //Initializing Methods
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showTable();
        setData();
        searchFeature();

        btnUserDetails.setOnAction(event -> dataUser());

    }

}
