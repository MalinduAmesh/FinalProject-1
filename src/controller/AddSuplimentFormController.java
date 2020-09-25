package controller;

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

public class AddSuplimentFormController {
    public JFXTextField txtID;
    AddSuplimentBo addSuplimentBo = new AddSuplimentBOImpl();
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

/*    public TableView tblSupliment;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colCost;
    */
    public JFXTextField txtCost;
    public JFXTextField txtAvalbleQty;
    public JFXTextField txtName;
    public JFXComboBox cmbID;
    public JFXTextField txtTotQty;
    public JFXTextField txtAddQty;


public void initialize() throws SQLException, ClassNotFoundException {

    colID.setCellValueFactory(new PropertyValueFactory<>("suplimId"));
    colName.setCellValueFactory(new PropertyValueFactory<>("suplimName"));
    colQty.setCellValueFactory(new PropertyValueFactory<>("suplimQTY"));
    colCost.setCellValueFactory(new PropertyValueFactory<>("suplimCost"));

    tblSupliment.setItems(loadAllTables());


    setValuesToCmbBox();
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
    private void loadAllTextField(){
    }

    public void btnAddOnAction(MouseEvent mouseEvent) {

        String id =txtID.getText();
        String name = txtName.getText();
        String qty = txtTotQty.getText();
        String cost = txtCost.getText();

        SuplimentDTO suplimentDTO = new SuplimentDTO(id,name,Integer.parseInt(qty),Double.parseDouble(cost));

        boolean isAdded = false;
        try {
            isAdded = addSupliment(suplimentDTO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK).show();

        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Faild",ButtonType.NO).show();

        }
    }

    private boolean addSupliment(SuplimentDTO suplimentDTO) throws SQLException, ClassNotFoundException {
        return addSuplimentBo.addSupliment(suplimentDTO);
    }

    public void clear(){
    txtName.setText("");
    txtTotQty.setText("");
    txtCost.setText("");
    }
    public void btnClearONAction(MouseEvent mouseEvent) {
    clear();
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

        String id = txtID.getText();
        String name = txtName.getText();
        String TotQty = txtTotQty.getText();
        String cost = txtCost.getText();

        SuplimentDTO suplimentDTO =new SuplimentDTO(id,name,Integer.parseInt(TotQty),Double.parseDouble(cost));

        try {
            boolean isUpdate = addSuplimentBo.updateSupliment(suplimentDTO);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Update",ButtonType.OK).show();
            }
            else {
                new Alert(Alert.AlertType.CONFIRMATION,"Faild",ButtonType.OK).show();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
    }
}

    public void txtTotQtyOnAction(ActionEvent actionEvent) {
        sumTotal();
    }


    public void txtAddQtyOnAction(ActionEvent actionEvent) {
        sumTotal();
    }
}
 /*   public void initialize() throws SQLException, ClassNotFoundException {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOperate.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadAllCustomers();


        // Bot
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            *//*System.out.println(newValue);
            System.out.println(oldValue);*//*

            txtId.setText(newValue.getId());
            txtName.setText(newValue.getName());
            txtAddress.setText(newValue.getAddress());
            txtSalary.setText(newValue.getSalary()+"");

        });


    }



    public void newCustomerOnAction(ActionEvent actionEvent) {
    }

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        if (btnSave.getText().equalsIgnoreCase("Save")){

            CustomerDTO dto= new CustomerDTO(
                    txtId.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    Double.parseDouble(txtSalary.getText())
            );

            PreparedStatement stm = DBConnection.getInstance().
                    getConnection().prepareStatement(
                    "INSERT INTO Customer VALUES(?,?,?,?)");
            stm.setString(1,dto.getId());
            stm.setString(2,dto.getName());
            stm.setString(3,dto.getAddress());
            stm.setObject(4,dto.getSalary());

            if(stm.executeUpdate()>0){
                new Alert(Alert.AlertType.CONFIRMATION,
                        "Saved!", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING,
                        "Try Again!", ButtonType.OK).show();
            }

        }else{
            //update
        }
*/