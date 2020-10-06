package controller;

import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StockFormController {
    public JFXButton btnEqupment;
    public JFXButton btnProducts;
    public ImageView btnSearch;
    public JFXButton btnBack;
    public AnchorPane root;

    public void initialize(){

    }

    public void btnEqupmentOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/AddEquipmentForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();

    }

    public void btnProductsOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/AddSuplimentForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();
    }

    public void btnSearchOnAction(MouseEvent mouseEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/StockForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();
    }
}
