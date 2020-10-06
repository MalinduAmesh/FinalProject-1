package controller;

import animatefx.animation.*;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public ImageView btnLogin;
    public ImageView con;
    public JFXPasswordField txtPass;
    public AnchorPane root;


    public void txtUserNameOnAction(ActionEvent actionEvent) {
    }

    public void txtPasswordOnAction(ActionEvent actionEvent) {
    }

    public void lblIconOnAction(MouseEvent mouseEvent) {
        new Swing(con).play();
    }

    public void btnLoginOnAcrtion(MouseEvent mouseEvent) throws IOException {
        //new FadeIn(btnLogin).play();



    }

    public void btnLoginOnAcrtionnnn(KeyEvent keyEvent) throws IOException {


    }



    public void btnLoginOnAcrtionFucka(MouseEvent mouseEvent) throws IOException {

        new FadeIn(btnLogin).play();
        String userName = txtUserName.getText().trim();
        String password = txtPass.getText().trim();



        if(userName.length() > 0 && password.length()>0){
            if (userName.equalsIgnoreCase("1")&&password.equals("1")){

                setForm();

            }else {
                txtUserName.setUnFocusColor(Paint.valueOf("red"));
                txtPass.setUnFocusColor(Paint.valueOf("red"));
            }
        }
    }

    public void enter(MouseEvent mouseEvent) {
        new FadeIn(btnLogin).play();
    }

    public void ExitOnAction(MouseEvent mouseEvent) {
        Platform.exit();
    }
    private void setForm() throws IOException {
        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBordForm.fxml"))));
        stage.centerOnScreen();

    }
}
