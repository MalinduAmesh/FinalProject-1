package controller;

import bo.custom.AddEquipmentBO;
import bo.custom.Impl.AddEquipmentBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.EquipmentDTO;
import entity.Equipment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

public class EquipmentFormController {

    public JFXTextField txtAvalQTY;
    public JFXTextField txtEquName;
    public JFXTextField txtID;
    public JFXTextField txtPrice;
    public JFXButton btnAdd;
    public JFXButton btnClear;
    public JFXButton btnUpdate;
    public JFXButton btnRemove;
    public JFXComboBox cmbEquID;

    @FXML
    private TableView<EquipmentDTO> tblEqupment;

    @FXML
    private TableColumn<EquipmentDTO, String> colID;

    @FXML
    private TableColumn<EquipmentDTO, String> colName;

    @FXML
    private TableColumn<EquipmentDTO, String> colQty;

    @FXML
    private TableColumn<EquipmentDTO, String> colOneItem;


    AddEquipmentBO addEquipmentBO = new AddEquipmentBOImpl();

    public void initialize() throws SQLException, ClassNotFoundException {

        setValuesTocmb();
        colID.setCellValueFactory(new PropertyValueFactory<>("equipmentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("equipmentQty"));
        colOneItem.setCellValueFactory(new PropertyValueFactory<>("equipmentCost"));

        tblEqupment.setItems(loadAllTables());

    }

    private void setValuesTocmb() throws SQLException, ClassNotFoundException {
        cmbEquID.getItems().add("None");


        ObservableList<EquipmentDTO>arrayList = addEquipmentBO.getAllEqupment();
        for (EquipmentDTO dto: arrayList) {

            cmbEquID.getItems().add(dto.getEquipmentId());

        }
    }

    public void cmbEquIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        EquipmentDTO dto = addEquipmentBO.setAllEquipment(cmbEquID.getSelectionModel().getSelectedItem().toString());
        txtID.setText(dto.getEquipmentId());
        txtEquName.setText(dto.getEquipmentName());
        txtAvalQTY.setText(dto.getEquipmentQty()+"");
        txtPrice.setText(dto.getEquipmentCost()+"");
    }

    private ObservableList<EquipmentDTO> loadAllTables() throws SQLException, ClassNotFoundException {
        ObservableList<EquipmentDTO> list = addEquipmentBO.getAllEqupment();
        ObservableList<EquipmentDTO> equipmentDTOS = FXCollections.observableArrayList();

        for (EquipmentDTO dto: list) {

            equipmentDTOS.add(
                    new EquipmentDTO(
                            dto.getEquipmentId(),
                            dto.getEquipmentName(),
                             dto.getEquipmentQty(),
                           dto.getEquipmentCost()
                    )
            );

        }

        return equipmentDTOS;
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txtID.getText();
        String name = txtEquName.getText();
        int qty = Integer.parseInt(txtAvalQTY.getText());
        double price = Double.parseDouble(txtPrice.getText());

        EquipmentDTO dto = new EquipmentDTO(id,name,qty,price);
        boolean isAdded = addEquipmentBO.addEqupment(dto);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
        }
    }
    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {


            String id = txtID.getText();
            String name = txtEquName.getText();
            int qty = Integer.parseInt(txtAvalQTY.getText());
            double price = Double.parseDouble(txtPrice.getText());

            EquipmentDTO dto = new EquipmentDTO(id, name, qty, price);
            boolean isUpdated = addEquipmentBO.updateEquipment(dto);

            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Faild", ButtonType.OK).show();
            }
        }catch (NullPointerException ex){

        }
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String id = txtID.getText();
        boolean isDeleted = addEquipmentBO.deleteEquipment(id);
        if (isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"Added",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        txtID.setText("");
        txtAvalQTY.setText("");
        txtPrice.setText("");
        txtEquName.setText("");
    }


    public void txtNameOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        EquipmentDTO dto = addEquipmentBO.search(txtEquName.getText());
        txtPrice.setText(String.valueOf(dto.getEquipmentCost()));
        txtAvalQTY.setText(String.valueOf(dto.getEquipmentQty()));
        txtID.setText(dto.getEquipmentId());
    }
}
