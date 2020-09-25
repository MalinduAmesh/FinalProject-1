package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminDashBoardFormController {
    public AnchorPane root;

    private void initialize() throws IOException {
        setUi("InstructorForm");

    }

    private void setUi(String s) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+s+".fxml")));
    }

    public void btnStaffOnAction(ActionEvent actionEvent) throws IOException {
        setUi("InstructorForm");
    }

    public void btnEquipmentOnAction(ActionEvent actionEvent) {
    }

    public void btnSuplimentOnAction(ActionEvent actionEvent) {
    }

    public void btnPaymentOnAction(ActionEvent actionEvent) {
    }
}
