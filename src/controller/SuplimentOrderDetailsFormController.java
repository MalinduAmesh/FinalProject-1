package controller;

import bo.custom.Impl.PlaceOrderBOImpl;
import bo.custom.PlaceOrderBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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

    public Label lblPayments;
    public Label lblSupliments;
    public JFXComboBox cmbType;
    public CheckBox chkPayment;
    public CheckBox chkSupliment;
    public JFXTextField txtAttToatal;
    public JFXTextField txtWorkOutType;
    public JFXComboBox cmbMemberID;
    public JFXDatePicker txtDate;
    public JFXTextField txtBalance;
    public JFXTextField txtPaidCash;

    public JFXTextField txtMemName;
    public Label lblOrdId;
    public JFXTextField txtMemShip;
    public JFXTextField txtGoalName;
    public JFXTextField txtTotal;
    public JFXTextField txtCustEmail;
    public JFXTextField txtCustContact;
    public JFXTextField txtID;
    public JFXTextField txtCustomerName;
    public JFXComboBox cmbCustomerId;
    public JFXComboBox cmbSuplimetnId;
    public JFXTextField txtProductName;
    public JFXTextField txtDiscount;
    public JFXTextField txtAvalbleQTY;
    public JFXTextField txtQTY;
    public JFXTextField txtPrice;
    public TableView<CustomDTO> tblSupliment;
    public TableColumn<CustomDTO, String> colSupName;
    public TableColumn<CustomDTO, String> colPrice;
    public TableColumn<CustomDTO, String> colQty;
    public TableColumn<CustomDTO, String> colDiscount;
    public TableColumn<CustomDTO, String> colTotal;
    public TableColumn<CustomDTO, String> colID;
    public JFXTextField txtOrderDate;
    public JFXTextField txtMemSalary;
    public JFXRadioButton rdoCash;
    public JFXRadioButton rdoCard;
    public Label lblPayID;
    private String cardType;

    PlaceOrderBO placeOrderBO = new PlaceOrderBOImpl();


    public void initialize() throws SQLException, ClassNotFoundException {
        setValuesTopayAndSup();
        setDate();
        genarateOrderID();
        setValuestoCustomercmb();
        setValuestoSuplimentcmb();
        setVisibaleFalse();
        loadColoumsInTable();

        genateID();
        genaratePayId();


    }

    private void genaratePayId() throws SQLException, ClassNotFoundException {
        String lastId = placeOrderBO.genaratePayID();
        System.out.println("debug1");

        if (lastId != null) {
            System.out.println("debug2");
            lastId = lastId.split("[A-Z]")[1];
            lastId = "P00" + (Integer.parseInt(lastId) + 1);
            lblPayID.setText(lastId);
        } else {
            lblPayID.setText("P001");
        }
    }

    private void genateID() throws SQLException, ClassNotFoundException {


        String lastid = placeOrderBO.getLastPayID();
        System.out.println("debug1");
        if (lastid != null) {
            System.out.println("debug2");
            lastid = lastid.split("[A-Z]")[1];
            lastid = "D00" + (Integer.parseInt(lastid) + 1);
            lblOrdId.setText(lastid);

        } else {
            lblOrdId.setText("D001");
        }
    }


    private void loadColoumsInTable() {
        colID.setCellValueFactory(new PropertyValueFactory<>("suplimId"));
        colSupName.setCellValueFactory(new PropertyValueFactory<>("suplimName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("suplimCost"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("totalQTy"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    private void setVisibaleFalse() {
        cmbSuplimetnId.setVisible(false);
        lblSupliments.setVisible(false);
        txtID.setVisible(false);
        txtProductName.setVisible(false);
        txtPrice.setVisible(false);
        txtAvalbleQTY.setVisible(false);
        txtQTY.setVisible(false);
        txtDiscount.setVisible(false);
    }

    private void setValuesTopayAndSup() {

        cmbType.getItems().add("Order Payment");
        cmbType.getItems().add("Monthly Payment");
    }


    private void calculate() {
        int addQty = Integer.parseInt(txtQTY.getText());
        int price = Integer.parseInt(txtPrice.getText());
        int total = Integer.parseInt(txtTotal.getText());

        int totalX = addQty + price;

        txtTotal.setText(String.valueOf(totalX));
    }

    private void setValuestoSuplimentcmb() throws SQLException, ClassNotFoundException {

        ObservableList<SuplimentDTO> list = placeOrderBO.getAllSupliment();
        for (SuplimentDTO suplimentDTO : list) {
            cmbSuplimetnId.getItems().add(suplimentDTO.getSuplimId());
        }

    }

    private void setValuestoCustomercmb() throws SQLException, ClassNotFoundException {

        ObservableList<CustomerDTO> customerDTOS = placeOrderBO.getAllCustomer();
        for (CustomerDTO customerDTO : customerDTOS) {
            cmbCustomerId.getItems().add(customerDTO.getCustID());

        }
    }

    private void genarateOrderID() throws SQLException, ClassNotFoundException {

    }

    private void setDate() {

        String date = LocalDate.now().toString();
        txtOrderDate.setText(date);

    }

    public void cmbCustomerIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        CustomerDTO customerDTO = placeOrderBO.searchCustomer(cmbCustomerId.getSelectionModel().getSelectedItem().toString());
        txtCustomerName.setText(customerDTO.getCustName());
        txtCustContact.setText(customerDTO.getCustContact());
        txtCustEmail.setText(customerDTO.getCustEmail());
    }

    public void cmbSuplimetnIdOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        SuplimentDTO suplimentDTO = placeOrderBO.searchSupliment(cmbSuplimetnId.getSelectionModel().getSelectedItem().toString());
        txtID.setText(suplimentDTO.getSuplimId());
        txtProductName.setText(suplimentDTO.getSuplimName());
        txtAvalbleQTY.setText(suplimentDTO.getSuplimQTY() + "");
        txtPrice.setText(suplimentDTO.getSuplimCost() + "");
    }

    public void btnpaidOnAction(ActionEvent actionEvent) {
        Add();
    }

    public void Add() {

        PaymentDTO o = new PaymentDTO();

        o.setPayId(lblPayID.getText());
        o.setPayAmount(txtTotal.getText());
        o.setPayType(rdoCard.getText());
        o.setStatus(cmbType.getSelectionModel().getSelectedItem().toString());

        System.out.println(o);

        ObservableList<OrderDetailsDTO> orderDetailList = FXCollections.observableArrayList();
        ObservableList<SuplimentDTO> suplimentList = FXCollections.observableArrayList();
        ObservableList<InvoiceDTO> invoiceList = FXCollections.observableArrayList();

        for (int i = 0; i < 1; i++) {


            invoiceList.add(new InvoiceDTO(
                    lblOrdId.getText(),
                    txtOrderDate.getText(),
                    cmbCustomerId.getValue().toString(),
                    lblPayID.getText()
            ));
        }
        o.setInvoiceDTOS(invoiceList);

        for (int i = 0; i < tblSupliment.getItems().size(); i++) {


            orderDetailList.add(new OrderDetailsDTO(

                    lblOrdId.getText(),
                    tblSupliment.getItems().get(i).getSuplimId(),
                    Integer.parseInt(tblSupliment.getItems().get(i).getTotalQTy()),
                    tblSupliment.getItems().get(i).getTotal()));

            System.out.println(orderDetailList);

            int availableQTY = Integer.parseInt(txtAvalbleQTY.getText());
            int changedQTY = Integer.parseInt(txtQTY.getText());
            int newQTY = availableQTY - changedQTY;

            suplimentList.add(new SuplimentDTO(

                    tblSupliment.getItems().get(i).getSuplimId(),
                    tblSupliment.getItems().get(i).getSuplimName(),
                    newQTY,
                    Double.parseDouble(txtPrice.getText())));

            System.out.println(suplimentList);

        }
        System.out.println("check1");


        o.setOrderDetailsDTOS(orderDetailList);
        o.setSuplimentDTOS(suplimentList);

        try {
            boolean isAdded = placeOrderBO.purchaseOrder(o);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Addedd!", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Faild", ButtonType.OK).show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void radioButto() {
        ;
    }

    public void btnClearOnAction(ActionEvent actionEvent) {

    }

    ArrayList<CustomDTO> customDTOS = new ArrayList<>();


    public void min() {

        double val1 = Double.parseDouble(txtTotal.getText());
        int val2 = Integer.parseInt(txtPaidCash.getText());

        double tot = val2 - val1;

        txtBalance.setText(String.valueOf(tot));

    }

    public void btnAddToCartOnAction(ActionEvent actionEvent) {
        CustomDTO c = new CustomDTO(
                txtID.getText(),
                txtProductName.getText(),
                Double.parseDouble(txtPrice.getText()),
                txtQTY.getText(), txtDiscount.getText(),
                Double.parseDouble(txtTotal.getText()));

        customDTOS.add(c);

        tblSupliment.getItems().add(c);

    }

    public void calEvent(KeyEvent keyEvent) {

    }

    public void txtDiscountOnAction(KeyEvent keyEvent) {

        double price = Double.parseDouble(txtPrice.getText());
        double qty = Double.parseDouble(txtQTY.getText());
        double discount = Double.parseDouble(txtDiscount.getText());

        double tot = 0;

        if (discount == 0) {
            tot = (price * qty);
            txtTotal.setText(Double.toString(tot));
        } else {
            tot = (price * qty * discount / 100);
            txtTotal.setText(Double.toString(tot));
        }
    }




/*   public void rdoCashOnAction(ActionEvent actionEvent) {
        rdoCard.setSelected(false);
        paymentType = "via CASH";
    }

    public void rdoCardOnAction(ActionEvent actionEvent) {
        rdoCash.setSelected(false);
        paymentType = "via CARD";
    }*/


    public void btnRemovedOnAction(ActionEvent actionEvent) {
        tblSupliment.getItems().remove(tblSupliment.getSelectionModel().getSelectedItem());
    }

    public void cmbTypeOnAction(ActionEvent actionEvent) {

        int index = cmbType.getSelectionModel().getSelectedIndex();

        if (index == 0) {
            System.out.println("asdasdasd");

            cmbSuplimetnId.setVisible(true);
            lblPayments.setVisible(false);
            lblSupliments.setVisible(true);
            txtID.setVisible(true);
            txtProductName.setVisible(true);
            txtPrice.setVisible(true);
            txtAvalbleQTY.setVisible(true);
            txtQTY.setVisible(true);
            txtDiscount.setVisible(true);

            txtGoalName.setVisible(false);
            txtMemShip.setVisible(false);
            txtMemSalary.setVisible(false);


        } else {
            lblPayments.setVisible(true);
            lblSupliments.setVisible(false);


            txtGoalName.setVisible(true);
            txtMemShip.setVisible(true);
            txtMemSalary.setVisible(true);


            txtID.setVisible(false);
            txtProductName.setVisible(false);
            txtPrice.setVisible(false);
            txtAvalbleQTY.setVisible(false);
            txtQTY.setVisible(false);
            txtDiscount.setVisible(false);
            cmbSuplimetnId.setVisible(false);


            System.out.println("fuck");
        }


        {
        }
    }

    public void chkPaymentOnAction(ActionEvent actionEvent) {

        if (chkPayment != null) {
            chkSupliment.disabledProperty();
            chkPayment.setVisible(true);

        } else {
            chkSupliment.setVisible(true);
            chkPayment.setVisible(false);
        }
    }

    public void chkSuplimentOnAction(ActionEvent actionEvent) {
        if (chkSupliment != null) {
            chkPayment.setVisible(false);
            chkSupliment.setVisible(true);
        }
    }

    public void cmbMemberIDOnAction(ActionEvent actionEvent) {
    }

    public void txtPaidCashOnAction(ActionEvent actionEvent) {

        min();
    }

    public void rdoCashOnAction(ActionEvent actionEvent) {
        rdoCard.setSelected(false);
    }

    public void rdoCardOnAction(ActionEvent actionEvent) {
        rdoCash.setSelected(false);
    }

    public void txtQTYOnAcion(ActionEvent actionEvent) {
        //txtDiscount.requestFocus();
    }
}