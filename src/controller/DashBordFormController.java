package controller;

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


    public void btnRegisterOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("RegisterForm");
    }

    public void btnAttendanceOnAction(MouseEvent mouseEvent) {
    }

    public void btnAssignWorkOutOnAction(MouseEvent mouseEvent) {
    }

    public void btnWorkoutOnAction(MouseEvent mouseEvent) {
    }

    public void btnProductOnAction(MouseEvent mouseEvent) {
    }

    public void btnStoreOnAction(MouseEvent mouseEvent) {
    }

    public void btnDashBoardOnAction(MouseEvent mouseEvent) throws IOException {
        setUi("MainForm");
    }

    public void btnEmailOnAction(MouseEvent mouseEvent) {
    }

    public void btnMembersOnAction(MouseEvent mouseEvent) {
    }
}
