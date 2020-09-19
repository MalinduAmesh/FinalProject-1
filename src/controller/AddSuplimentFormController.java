package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class AddSuplimentFormController {
    public TableView tblSupliment;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colCost;
    public JFXTextField txtCost;
    public JFXTextField txtAvalbleQty;
    public JFXTextField txtName;
    public JFXComboBox cmbID;
    public JFXTextField txtTotQty;
    public JFXTextField txtAddQty;

    public void btnAddOnAction(MouseEvent mouseEvent) {
    }

    public void btnClearONAction(MouseEvent mouseEvent) {
    }
}
