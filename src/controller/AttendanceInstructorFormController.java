package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class AttendanceInstructorFormController {
    public JFXComboBox cmbInsID;
    public JFXTextField txtInsName;
    public JFXTimePicker txtINTime;
    public JFXTimePicker txtOverTime;
    public JFXTextField txtDate;
    public Label lblAttID;
    public JFXComboBox cmbSearchINOUT;
    public JFXButton btnAdd;
    public JFXButton btnUpdateAdd;
    public JFXButton btnClear;

    public void initialize(){
        txtINTime.setVisible(false);
    }
    public void txtINTimeOnAction(ActionEvent actionEvent) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void cmbSearchINOUTOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateAddOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }
}
