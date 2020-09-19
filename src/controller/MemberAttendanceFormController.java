package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
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

    public void btnAddOnAction(MouseEvent mouseEvent) {
    }

    public void btnClearOnAction(MouseEvent mouseEvent) {
    }
}
