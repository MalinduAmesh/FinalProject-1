package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PaymentFormController {
    public JFXTextField txtMemName;
    public JFXTextField txtAttToatal;
    public JFXTextField txtWorkOutType;
    public JFXComboBox cmbMemberID;
    public JFXDatePicker txtDate;
    public Label lblPayId;
    public JFXTextField txtTotal;
    public JFXTextField txtBalance;
    public JFXTextField txtPaidFee;
    public TableView tblPayments;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colDate;
    public TableColumn colAmount;
    public JFXRadioButton rdoCash;
    public JFXRadioButton rdoCard;

    public void cmbMemberIDOnAction(ActionEvent actionEvent) {
    }

    public void btnPayOnAction(ActionEvent actionEvent) {
    }

    public void btnRdoShowOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction(ActionEvent actionEvent) {
    }
}
