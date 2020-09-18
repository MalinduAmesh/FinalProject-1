package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SuplimentOrderFormController {
    public AnchorPane root;


    public void sellOnAction(MouseEvent mouseEvent) throws IOException {

        root.getChildren().clear();
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("../view/SuplimentOrderDetailsForm.fxml"));
        root.getChildren().setAll(anchorPane.getChildren());
    }
}
