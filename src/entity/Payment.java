package entity;

import javafx.collections.ObservableList;

public class Payment {

    private String payId;
    private String payType;
    private String payAmount;
    private String status;

    public Payment() {
    }
    ObservableList<Invoice>invoices;
    ObservableList<OrderDetails>orderDetails;
    ObservableList<Supliment>supliments;

    public Payment(String payId, String payType, String payAmount, String status, ObservableList<Invoice> invoices, ObservableList<OrderDetails> orderDetails, ObservableList<Supliment> supliments) {
        this.payId = payId;
        this.payType = payType;
        this.payAmount = payAmount;
        this.status = status;
        this.invoices = invoices;
        this.orderDetails = orderDetails;
        this.supliments = supliments;
    }

    public ObservableList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ObservableList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public ObservableList<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ObservableList<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ObservableList<Supliment> getSupliments() {
        return supliments;
    }

    public void setSupliments(ObservableList<Supliment> supliments) {
        this.supliments = supliments;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payId='" + payId + '\'' +
                ", payType='" + payType + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Payment(String payId, String payType, String payAmount, String status) {
        this.payId = payId;
        this.payType = payType;
        this.payAmount = payAmount;
        this.status = status;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
