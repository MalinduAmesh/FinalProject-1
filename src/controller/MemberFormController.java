package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MemberFormController {


    public AnchorPane root;

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        AnchorPane pane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/RegisterForm.fxml"));
        root.getChildren().setAll(pane.getChildren());
    }
}
