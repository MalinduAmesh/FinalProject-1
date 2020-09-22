package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBordFormController {

    public AnchorPane root;

    public void initialize() throws IOException {
        defalt();
        //setUi("MainForm");
    }

    private void setUi(String m) throws IOException {
        root.getChildren().clear();;
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/"+ m + ".fxml")));


    }
    public  void defalt() throws IOException {
        setUi("MainForm");
    }






    public void btnAttendanceOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("MemberAttendanceForm");

    }

    public void btnAssignWorkOutOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("WorkOutForm");
    }

    public void btnProductOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("SuplimentOrderForm");
    }

    public void btnStoreOnAction(MouseEvent mouseEvent) {
    }

    public void btnDashBoardOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("MainForm");
    }

    public void btnEmailOnAction(MouseEvent mouseEvent) {

    }

    public void btnMembersOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("MemberForm");
    }


    public void registerUser(MouseEvent mouseEvent) throws IOException {
        setUi("RegisterForm");
    }

    public void btnPaymentOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("MemberPaymentForm");
    }

    public void btnExitOnAction(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
