package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WorkOutFormController {
    public JFXTextField txtSearch;
    public AnchorPane root;
    public TableView tblWorkOutDetails;
    public TableColumn colPhoto;
    public TableColumn colMemberName;
    public TableColumn colLevel;
    public TableColumn colGoal;
    public TableColumn colTools;


    public void AssignworkoutOnAction(MouseEvent mouseEvent) throws IOException {


    }

    public void btnCreateWorkOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        AnchorPane poot = FXMLLoader.load(this.getClass().getResource("../view/MakeWorkoutDetailsForm.fxml"));
        root.getChildren().setAll(poot.getChildren());
    }

    public void AssignworkoutOnActionn(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("../view/AssignWorkOutForm.fxml"));
        root.getChildren().setAll(pane.getChildren());
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        AnchorPane poot = FXMLLoader.load(this.getClass().getResource("../view/WorkOutForm.fxml"));
        root.getChildren().setAll(poot.getChildren());
    }
}
