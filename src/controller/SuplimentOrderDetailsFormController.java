package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class SuplimentOrderDetailsFormController {
    public JFXTextField txtCustomerName;
    public JFXComboBox cmbCustomerId;
    public JFXComboBox cmbSuplimetnId;
    public JFXTextField txtProductName;
    public JFXTextField txtDiscount;
    public JFXTextField txtAmount;
    public JFXTextField txtAvalbleQTY;
    public JFXTextField txtQTY;
    public JFXTextField txtPrice;
    public JFXTextField txtTotal;
    public TableView tblSupliment;
    public TableColumn colSupName;
    public TableColumn colPrice;
    public TableColumn colQty;
    public TableColumn colDiscount;
    public TableColumn colTotal;


    public void AddOnAction(MouseEvent mouseEvent) {
    }

    public void paidOnAction(MouseEvent mouseEvent) {
    }

    public void ClearOnAction(MouseEvent mouseEvent) {
    }
}
