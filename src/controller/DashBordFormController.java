package controller;

import animatefx.animation.*;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBordFormController {

    public AnchorPane root;
    public JFXButton btnAttendance;
    public JFXButton btnMem;
    public JFXButton btnInstructor;
    public JFXButton btnProduct;
    public JFXButton btnStock;
    public JFXButton btnWorkOut;
    public JFXButton btnHome;
    public JFXButton btnMemAttendance;


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
    
    public void btnMemberOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/MemberForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();
    }

    public void btnInstructorOnAction(ActionEvent actionEvent) throws IOException {
        setUi("InstructorForm");

    }

    public void btnAttndanceOnAction(ActionEvent actionEvent) throws IOException {

        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/AttendanceMemberForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();

    }

    public void ExittOnAction(ActionEvent actionEvent) {

        Platform.exit();
    }
    public void workOutOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/WorkOutForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();
    }

    public void btnProductSOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SuplimentOrderForm");
    }

    public void btnStockOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/StockForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();
    }

    public void btnHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MainForm");
    }

    public void btnExitOnAction(MouseEvent mouseEvent) {

    }

    public void btnMemAttendanceOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/MemberAttendanceForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();

    }
}
