package controller;

import animatefx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBordFormController {

    public AnchorPane root;


    public void initialize() throws IOException {
        defalt();
    }

    private void setUi(String m) throws IOException {
        root.getChildren().clear();;
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+ m + ".fxml")));


    }
    public  void defalt() throws IOException {
        setUi("MainForm");
    }

    public void btnProductOnAction(MouseEvent mouseEvent) throws IOException {

    }

    public void btnMemberOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MemberForm");
    }

    public void btnInstructorOnAction(ActionEvent actionEvent) throws IOException {
        setUi("InstructorForm");

    }

    public void btnAttndanceOnAction(ActionEvent actionEvent) throws IOException {

        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/MemberAttendanceForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new BounceIn(stage).play();
        /*etUi("MemberAttendanceForm");*/

    }

    public void ExittOnAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void btnPaymentttOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PaymentForm");
    }
    public void btnExitOnAction(MouseEvent mouseEvent) {

    }

    public void workOutOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/WorkOutForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new BounceIn(stage).play();
        /*setUi("WorkOutForm");*/
    }

    public void btnProductSOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SuplimentOrderForm");
    }
}
