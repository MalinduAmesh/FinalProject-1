package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class EquipmentFormController {
    public JFXTextField txtTotalQty;
    public JFXTextField txtNowQty;
    public JFXTextField txtAvalQTY;
    public JFXTextField txtEquName;
    public JFXComboBox txtEquID;
    public JFXTextField txtOneItem;
    public JFXTextField txtTottalFee;
    public TableView tblEqupment;
    public TableColumn colImage;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colOneItem;
    public TableColumn colTotal;

    public void btnAddOnAction(MouseEvent mouseEvent) {
    }

    public void btnclearOnAction(MouseEvent mouseEvent) {
    }
}
