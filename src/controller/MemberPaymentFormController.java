package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class MemberPaymentFormController {
    public JFXComboBox txtMemberID;
    public JFXTextField txtMemberName;
    public JFXTextField txtAttTotal;
    public JFXTextField txtWorkOutType;
    public JFXDatePicker txtDate;
    public JFXTextField txtTotal;
    public JFXTextField txtBalance;
    public JFXTextField txtCash;
    public TableView tblOrder;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colDate;
    public TableColumn colAmount;

    public void btnAddOnAction(MouseEvent mouseEvent) {
    }

    public void btnClearOnAction(MouseEvent mouseEvent) {
    }
}
