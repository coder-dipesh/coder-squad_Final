package code;

//Necessary Imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class CreateCategoryController {

    @FXML
    private Button closeCreateCategory;
    @FXML
    private Button saveCreateCategory;
    @FXML
    private TextField addCategory;
    @FXML
    private TextField removeCategory;

    // Save create Category

    public void saveCreateCategory(){



    }


    // To close window
    public void closeCreateCategory(ActionEvent event) throws Exception {
        try {
            Stage stageClose = ((Stage) closeCreateCategory.getScene().getWindow());
            stageClose.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }





}
