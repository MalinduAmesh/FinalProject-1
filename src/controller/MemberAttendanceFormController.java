package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class MemberAttendanceFormController {
    public JFXTextField txtMemberName;
    public JFXComboBox txtMemberId;
    public JFXDatePicker txtDate;
    public TableView tblAttendance;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colDate;
    public JFXTextField txtSearch;
    public JFXTextField txtInstructorNsme;
    public JFXComboBox txtInstructorID;
    public JFXTextField cmbInstructorSearch;
    public JFXDatePicker txtInstrDate;
    public TableView tblInstructor;
    public TableColumn colID1;
    public JFXTextField cmbMemberSearchOnAction;
    public JFXDatePicker txtMemberDate;
    public TableView tblMemberAttendance;
    public TableColumn colInstrucorID;
    public TableColumn colInstrucName;
    public TableColumn colInstruDate;
    public TableColumn colMemberID;
    public TableColumn colMemberName;
    public TableColumn colMemberDate;

    public void btnAddOnAction(MouseEvent mouseEvent) {
    }

    public void btnClearOnAction(MouseEvent mouseEvent) {
    }

    public void memberAddOnAction(ActionEvent actionEvent) {
    }

    public void clearOnAction(ActionEvent actionEvent) {
    }

    public void InstructorAddOnAction(ActionEvent actionEvent) {
    }
}
