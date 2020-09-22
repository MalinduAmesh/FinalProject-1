package controller;

import bo.custom.Impl.SuplimentOrderDetailsBOImpl;
import bo.custom.SuplimentOrderDetailsBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.CustomDTO;
import dto.CustomerDTO;
import dto.OrdersDTO;
import dto.SuplimentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.time.LocalDate;

public class SuplimentOrderDetailsFormController {

    public JFXRadioButton rdoCash;
    public JFXRadioButton rdoCard;
    public JFXTextField txtTotalkkkk;
    public JFXTextField txtTotal;
    SuplimentOrderDetailsBO suplimentOrderDetailsBO = new SuplimentOrderDetailsBOImpl();

    public JFXTextField txtID;
    public JFXTextField txtCustomerName;
    public JFXComboBox cmbCustomerId;
    public JFXComboBox cmbSuplimetnId;
    public JFXTextField txtProductName;
    public JFXTextField txtDiscount;
    public JFXTextField txtAmount;
    public JFXTextField txtAvalbleQTY;
    public JFXTextField txtQTY;
    public JFXTextField txtPrice;
    public TableView<CustomDTO> tblSupliment;
    public TableColumn<CustomDTO,String> colSupName;
    public TableColumn<CustomDTO,String> colPrice;
    public TableColumn <CustomDTO,String> colQty;
    public TableColumn <CustomDTO,String> colDiscount;
    public TableColumn <CustomDTO,String> colTotal;
    public JFXTextField txtOrderDate;
    public Label lblOrdID;


    public void initialize() throws SQLException, ClassNotFoundException {
        setDate();
        genarateOrderID();
        setValuestoCustomercmb();
        setValuestoSuplimentcmb();
    }

    private void calculate(){
        int addQty = Integer.parseInt(txtQTY.getText());
        int price = Integer.parseInt(txtPrice.getText());
        int total = Integer.parseInt(txtTotal.getText());

        int totalX = addQty+price;

        txtTotal.setText(String.valueOf(totalX)) ;
    }
    private void setValuestoSuplimentcmb() throws SQLException, ClassNotFoundException {

        cmbSuplimetnId.getItems().add("None");
        ObservableList<SuplimentDTO>list = suplimentOrderDetailsBO.getAllSupliment();
        for (SuplimentDTO suplimentDTO: list) {
            cmbSuplimetnId.getItems().add(suplimentDTO.getSuplimId());
        }

    }

    private void setValuestoCustomercmb() throws SQLException, ClassNotFoundException {

        cmbCustomerId.getItems().add("None");

        ObservableList<CustomerDTO> customerDTOS = suplimentOrderDetailsBO.getAllCustomer();
        for (CustomerDTO  customerDTO: customerDTOS) {
            cmbCustomerId.getItems().add(customerDTO.getCustID());

        }
    }

    private void genarateOrderID() throws SQLException, ClassNotFoundException {
        String lastId = getLastOrderId();
        if (lastId != null){
            lastId = lastId.split("[A-Z]")[1];
            lastId = "C00" + (Integer.parseInt(lastId));
            lblOrdID.setText(lastId);
        }else {
            lblOrdID.setText("C001");
        }

    }

    private String getLastOrderId() throws SQLException, ClassNotFoundException {
        return suplimentOrderDetailsBO.getLastId();
    }

    private void setDate(){

        String date = LocalDate.now().toString();
        txtOrderDate.setText(date);

    }

    public void cmbCustomerIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        CustomerDTO customerDTO =suplimentOrderDetailsBO.searchCustomer(cmbCustomerId.getSelectionModel().getSelectedItem().toString());
        txtCustomerName.setText(customerDTO.getCustName());
    }

    public void cmbSuplimetnIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        SuplimentDTO suplimentDTO = suplimentOrderDetailsBO.searchSupliment(cmbSuplimetnId.getSelectionModel().getSelectedItem().toString());
        txtID.setText(suplimentDTO.getSuplimId());
        txtProductName.setText(suplimentDTO.getSuplimName());
        txtAvalbleQTY.setText(suplimentDTO.getSuplimQTY());
        txtPrice.setText(suplimentDTO.getSuplimCost());
    }

    public void btnpaidOnAction(ActionEvent actionEvent) {

    }

    public void btnClearOnAction(ActionEvent actionEvent) {


    }


    public void btnAddToCartOnAction(ActionEvent actionEvent) {

        CustomDTO c = new CustomDTO(txtProductName.getText(),txtPrice.getText(),txtAvalbleQTY.getText(),txtDiscount.getText(),txtTotal.getText());
        tblSupliment.getItems().clear();
        tblSupliment.getItems().add(c);
        colSupName.setCellValueFactory(new PropertyValueFactory<>("orederDetailQTY"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("orederDetailUnitP"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("suplimName"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("total"));






    }

    public void calEvent(KeyEvent keyEvent) {



/*
     double price=Double.parseDouble(txtPrice.getText());
     double qty=Double.parseDouble(txtQTY.getText());
     double cal=price*qty;

     txtTotal.setText(String.valueOf(cal));

*/

    }

    public void txtDiscountOnAction(KeyEvent keyEvent) {

        double price = Double.parseDouble(txtPrice.getText());
        double qty = Double.parseDouble(txtQTY.getText());
        double discount = Double.parseDouble(txtDiscount.getText());

        double tot =0;

        if (discount == 0){
            tot=(price*qty);
            txtTotal.setText(Double.toString(tot));
        }else {
            tot = (price*qty*discount/100);
            txtTotal.setText(Double.toString(tot));
        }


    }



    /*CustomDTO c=new CustomDTO(txtCustomerName.getText(),txtRentID.getText(),txtRentDate.getValue()+"",cmbVehicle.getValue()+"",Double.parseDouble(txtRentAdvance.getText()),cmbRentStatus.getValue()+"");
        tblRentForm.getItems().clear();
        tblRentForm.getItems().add(c);
        colCustomerName.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("customerName"));
        colRentID.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("rentID"));
        colRentDate.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("rentDate"));
        colVehicle.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("name"));
        colAdvance.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("rentAdvance"));
        colRentStatus.setCellValueFactory(new PropertyValueFactory<CustomDTO,String>("rentStatus"));*/
}