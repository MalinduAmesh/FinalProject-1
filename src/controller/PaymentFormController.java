package controller;

import bo.BOFactory;
import bo.custom.Impl.PaymentBoImpl;
import bo.custom.PaymentBo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.ArrayList;

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
    public JFXTextField searchTable;

    PaymentBo paymentBo = (PaymentBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.PAYMENT);

    public void initialize() throws SQLException, ClassNotFoundException {
    }

    private void setValuesTocmb() throws SQLException, ClassNotFoundException {
    }

    private void genaratePayID() throws SQLException, ClassNotFoundException {
    }

    public void cmbMemberIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    }
    public void btnPayOnAction(ActionEvent actionEvent) {
    }

    public void btnRdoShowOnAction(ActionEvent actionEvent) {
    }

    public void ClearOnAction(ActionEvent actionEvent) {
    }

    public void rdoCashOnAction(ActionEvent actionEvent) {
    }

    public void rdoCardOnAction(ActionEvent actionEvent) {
    }

    public void searchTableOnAction(ActionEvent actionEvent) {
    }
}
