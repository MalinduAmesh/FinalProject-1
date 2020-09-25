package controller;

import bo.custom.Impl.PlaceOrderBOImpl;
import bo.custom.PlaceOrderBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SuplimentOrderDetailsFormController {

    public JFXRadioButton rdoCash;
    public JFXRadioButton rdoCard;
    public JFXTextField txtTotalkkkk;
    public JFXTextField txtTotal;
    public JFXTextField lblOrdID;
    public JFXTextField txtCustEmail;
    public JFXTextField txtCustContact;

    PlaceOrderBO placeOrderBO = new PlaceOrderBOImpl();

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
    public TableColumn <CustomDTO,String> colID;
    public JFXTextField txtOrderDate;
    public static String paymentType;


    public void initialize() throws SQLException, ClassNotFoundException {
        setDate();
        genarateOrderID();
        setValuestoCustomercmb();
        setValuestoSuplimentcmb();

        colID.setCellValueFactory(new PropertyValueFactory<>("suplimId"));
        colSupName.setCellValueFactory(new PropertyValueFactory<>("suplimName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("suplimCost"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("total"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("totalQTy"));
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
        ObservableList<SuplimentDTO>list = placeOrderBO.getAllSupliment();
        for (SuplimentDTO suplimentDTO: list) {
            cmbSuplimetnId.getItems().add(suplimentDTO.getSuplimId());
        }

    }

    private void setValuestoCustomercmb() throws SQLException, ClassNotFoundException {

        cmbCustomerId.getItems().add("None");

        ObservableList<CustomerDTO> customerDTOS = placeOrderBO.getAllCustomer();
        for (CustomerDTO  customerDTO: customerDTOS) {
            cmbCustomerId.getItems().add(customerDTO.getCustID());

        }
    }

    private void genarateOrderID() throws SQLException, ClassNotFoundException {
/*
        String lastId = getLastOrderId();
        if (lastId != null){
            lastId = lastId.split("[A-Z]")[1];
            lastId = "D00" + (Integer.parseInt(lastId));
            lblOrdID.setText(lastId);
        }else {
            lblOrdID.setText("D001");
        }
*/

    }

    private String getLastOrderId() throws SQLException, ClassNotFoundException {
        return placeOrderBO.getLastId();
    }

    private void setDate(){

        String date = LocalDate.now().toString();
        txtOrderDate.setText(date);

    }

    public void cmbCustomerIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        CustomerDTO customerDTO = placeOrderBO.searchCustomer(cmbCustomerId.getSelectionModel().getSelectedItem().toString());
        txtCustomerName.setText(customerDTO.getCustName());
    }

    public void cmbSuplimetnIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        SuplimentDTO suplimentDTO = placeOrderBO.searchSupliment(cmbSuplimetnId.getSelectionModel().getSelectedItem().toString());
        txtID.setText(suplimentDTO.getSuplimId());
        txtProductName.setText(suplimentDTO.getSuplimName());
        txtAvalbleQTY.setText(suplimentDTO.getSuplimQTY()+"");
        txtPrice.setText(suplimentDTO.getSuplimCost()+"");
    }

    public void btnpaidOnAction(ActionEvent actionEvent) {
        OrdersDTO o = new OrdersDTO();

        o.setOrdersID(lblOrdID.getText());
        o.setOrdersDate(txtOrderDate.getText());
        o.setOrdersCustomerID(cmbCustomerId.getSelectionModel().getSelectedItem()+"");

        ObservableList<OrderDetailsDTO> orderDetailList = FXCollections.observableArrayList();
        ObservableList<SuplimentDTO> suplimentList = FXCollections.observableArrayList();
        for (int i=0;i<tblSupliment.getItems().size();i++){

            System.out.println("debug");
            orderDetailList.add(new OrderDetailsDTO(lblOrdID.getText(),tblSupliment.getItems().get(i).getSuplimId(),Integer.parseInt(tblSupliment.getItems().get(i).getTotalQTy()),tblSupliment.getItems().get(i).getTotal()));

            int availableQTY = Integer.parseInt(txtAvalbleQTY.getText());
            int changedQTY = Integer.parseInt(txtQTY.getText());
            int newQTY = availableQTY-changedQTY;

            suplimentList.add(new SuplimentDTO(tblSupliment.getItems().get(i).getSuplimId(),tblSupliment.getItems().get(i).getSuplimName(),newQTY,Double.parseDouble(txtPrice.getText())));
        }

        o.setAllOrderDetails(orderDetailList);
        o.setSuplimentDetailList(suplimentList);

        try {
            boolean isAdded = placeOrderBO.purchaseOrder(o);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Addedd!", ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Faild", ButtonType.OK).show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    ArrayList<CustomDTO> customDTOS = new ArrayList<>();


    public void btnAddToCartOnAction(ActionEvent actionEvent) {
        CustomDTO c = new CustomDTO(txtID.getText(),txtProductName.getText(),Double.parseDouble(txtPrice.getText()),txtQTY.getText(),txtDiscount.getText(),Double.parseDouble(txtTotal.getText()));
        customDTOS.add(c);
        tblSupliment.getItems().add(c);

    }

    public void calEvent(KeyEvent keyEvent) {

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

   /* public void rdoCashOnAction(ActionEvent actionEvent) {
        rdoCard.setSelected(false);
        paymentType = "via CASH";
    }

    public void rdoCardOnAction(ActionEvent actionEvent) {
        rdoCash.setSelected(false);
        paymentType = "via CARD";
    }
*/
    public void btnRemoveOnAction(ActionEvent actionEvent) {

    }

    public void btnRemovedOnAction(ActionEvent actionEvent) {
        tblSupliment.getItems().remove(tblSupliment.getSelectionModel().getSelectedItem());
    }
}