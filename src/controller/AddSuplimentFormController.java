package controller;

import bo.BOFactory;
import bo.custom.AddSuplimentBo;
import bo.custom.Impl.AddSuplimentBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.CustomerDTO;
import dto.SuplimentDTO;
import entity.Supliment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AddSuplimentFormController {
    public JFXTextField txtID;
    public Button btnAdd;
    public Button btnClear;
    public Button btnUpdate;
    public Button btnDelete;
    AddSuplimentBo addSuplimentBo = (AddSuplimentBo) BOFactory.getInstance().getBO(BOFactory.BOTypes.ADDSUPLIMENT);
    public JFXComboBox cmbSearchID;

    @FXML
    private TableView<SuplimentDTO> tblSupliment;

    @FXML
    private TableColumn<SuplimentDTO, String> colName;

    @FXML
    private TableColumn<SuplimentDTO, String> colQty;

    @FXML
    private TableColumn<SuplimentDTO, String> colCost;

    @FXML
    private TableColumn<SuplimentDTO, String> colID;


    @FXML
    private TableColumn<SuplimentDTO, String> colTools;

    public JFXTextField txtCost;
    public JFXTextField txtAvalbleQty;
    public JFXTextField txtName;
    public JFXTextField txtTotQty;
    public JFXTextField txtAddQty;


public void initialize() throws SQLException, ClassNotFoundException {
    setToTable();


    setValuesToCmbBox();
}

    public void setToTable() throws SQLException, ClassNotFoundException {

            genarateID();
            colID.setCellValueFactory(new PropertyValueFactory<>("suplimId"));
            colName.setCellValueFactory(new PropertyValueFactory<>("suplimName"));
            colQty.setCellValueFactory(new PropertyValueFactory<>("suplimQTY"));
            colCost.setCellValueFactory(new PropertyValueFactory<>("suplimCost"));

            tblSupliment.setItems(loadAllTables());

        }

    private void genarateID() throws SQLException, ClassNotFoundException {
    String lastid = addSuplimentBo.getLastId();

    if (lastid!=null){
        lastid =lastid.split("[A-Z]")[1];
        lastid ="Z00"+(Integer.parseInt(lastid)+1);
        txtID.setText(lastid);
    }else {
        txtID.setText("Z001");
    }
    }

    private ObservableList<SuplimentDTO> loadAllTables() throws SQLException, ClassNotFoundException {
        ObservableList<SuplimentDTO> all = addSuplimentBo.getAllSupliment();
        ObservableList<SuplimentDTO> allSupliment = FXCollections.observableArrayList();


        for (SuplimentDTO dto:all) {
            allSupliment.add(new SuplimentDTO(
                    dto.getSuplimId(),
                    dto.getSuplimName(),
                    dto.getSuplimQTY(),
                    dto.getSuplimCost()
            ));
        }
        return allSupliment;
    }

    private void setValuesToCmbBox() throws SQLException, ClassNotFoundException {
        cmbSearchID.getItems().add("None");
        ObservableList<SuplimentDTO> list =addSuplimentBo.getAllSupliment();
        for (SuplimentDTO suplimentDTO:list) {
            cmbSearchID.getItems().add(suplimentDTO.getSuplimId());
        }
    }

    public void btnAddOnAction(MouseEvent mouseEvent) {

    try {

        String id = txtID.getText();
        String name = txtName.getText();
        String qty = txtTotQty.getText();
        String cost = txtCost.getText();

        SuplimentDTO suplimentDTO = new SuplimentDTO(id, name, Integer.parseInt(qty), Double.parseDouble(cost));

        boolean isAdded = false;
        try {
            isAdded = addSupliment(suplimentDTO);
        } catch (SQLException throwables) {

        } catch (ClassNotFoundException e) {

        }
        if (isAdded) {
            new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK).show();

        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Faild", ButtonType.NO).show();

        }
    }catch (NumberFormatException ex){

    }
    }

    private boolean addSupliment(SuplimentDTO suplimentDTO) throws SQLException, ClassNotFoundException {
        return addSuplimentBo.addSupliment(suplimentDTO);
    }
    



    public void sumTotal(){

    int avlqty =Integer.parseInt(txtAvalbleQty.getText());
    int addqty =Integer.parseInt(txtAddQty.getText());
    int totqty =Integer.parseInt(txtTotQty.getText());

        totqty = avlqty+addqty;

        int tot = totqty;
        txtTotQty.setText(String.valueOf(tot));

    }
    public void btnUpdateOnAction(MouseEvent mouseEvent) {

        try {
            int avlqty =Integer.parseInt(txtAvalbleQty.getText());
            int addqty =Integer.parseInt(txtAddQty.getText());
            int totqty =Integer.parseInt(txtTotQty.getText());

            totqty = avlqty+addqty;

            String totx =String.valueOf(totqty);

            txtTotQty.setText(String.valueOf(totqty));

            String id = txtID.getText();
            String name = txtName.getText();
            String TotQty = totx;
            String cost = txtCost.getText();

            SuplimentDTO suplimentDTO = new SuplimentDTO(id, name, Integer.parseInt(TotQty), Double.parseDouble(cost));

            try {
                boolean isUpdate = addSuplimentBo.updateSupliment(suplimentDTO);
                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Update", ButtonType.OK).show();
                } else {
                    new Alert(Alert.AlertType.CONFIRMATION, "Faild", ButtonType.OK).show();

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException ex) {

        }
    }


    public void cmbSearchOnAction(ActionEvent actionEvent) {
        SuplimentDTO suplimentDTO = null;
        try {
            suplimentDTO = addSuplimentBo.searchSupliment(cmbSearchID.getSelectionModel().getSelectedItem().toString());
            txtID.setText(suplimentDTO.getSuplimId());
            txtName.setText(suplimentDTO.getSuplimName());
            txtTotQty.setText(suplimentDTO.getSuplimQTY()+"");
            txtAvalbleQty.setText(suplimentDTO.getSuplimQTY()+"");
            txtCost.setText(suplimentDTO.getSuplimCost()+"");
        } catch (SQLException throwables) {

        } catch (ClassNotFoundException e) {

    }catch (NullPointerException ex){
            
        }
}

    public void txtTotQtyOnAction(ActionEvent actionEvent) {
        sumTotal();
    }


    public void txtAddQtyOnAction(ActionEvent actionEvent) {
        sumTotal();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    txtID.setText("");
    txtCost.setText("");
    txtTotQty.setText("");
    txtCost.setText("");
    txtAvalbleQty.setText("");
    txtAddQty.setText("");
    txtName.setText("");
    cmbSearchID.setValue("");
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    
    String id = cmbSearchID.getValue().toString();
    boolean isDeleted = addSuplimentBo.deleteSupliment(id);
    if (isDeleted){
        new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK).show();
    }else {
        new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
    }
    }

    public void btnClearONAction(MouseEvent mouseEvent) {
    }
}
