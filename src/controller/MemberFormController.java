package controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MemberFormController {


    public void btnRegisterOnAction(MouseEvent mouseEvent) throws IOException {
        DashBordFormController dashBordFormController = new DashBordFormController();
        dashBordFormController.registerUser(mouseEvent);
    }
}
