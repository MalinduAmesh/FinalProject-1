package dto;

import entity.Invoice;
import entity.OrderDetails;
import javafx.collections.ObservableList;

public class PaymentDTO {

    private String payId;
    private String payType;
    private String payAmount;
    private String status;

    ObservableList<InvoiceDTO>invoiceDTOS;
    ObservableList<OrderDetailsDTO>orderDetailsDTOS;
    ObservableList<SuplimentDTO>suplimentDTOS;

    public PaymentDTO(String payId, String payType, String payAmount, String status, ObservableList<InvoiceDTO> invoiceDTOS, ObservableList<OrderDetailsDTO> orderDetailsDTOS, ObservableList<SuplimentDTO> suplimentDTOS) {
        this.payId = payId;
        this.payType = payType;
        this.payAmount = payAmount;
        this.status = status;
        this.invoiceDTOS = invoiceDTOS;
        this.orderDetailsDTOS = orderDetailsDTOS;
        this.suplimentDTOS = suplimentDTOS;
    }

    public ObservableList<InvoiceDTO> getInvoiceDTOS() {
        return invoiceDTOS;
    }

    public void setInvoiceDTOS(ObservableList<InvoiceDTO> invoiceDTOS) {
        this.invoiceDTOS = invoiceDTOS;
    }

    public ObservableList<OrderDetailsDTO> getOrderDetailsDTOS() {
        return orderDetailsDTOS;
    }

    public void setOrderDetailsDTOS(ObservableList<OrderDetailsDTO> orderDetailsDTOS) {
        this.orderDetailsDTOS = orderDetailsDTOS;
    }

    public ObservableList<SuplimentDTO> getSuplimentDTOS() {
        return suplimentDTOS;
    }

    public void setSuplimentDTOS(ObservableList<SuplimentDTO> suplimentDTOS) {
        this.suplimentDTOS = suplimentDTOS;
    }

    public PaymentDTO() {
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "payId='" + payId + '\'' +
                ", payType='" + payType + '\'' +
                ", payAmount='" + payAmount + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public PaymentDTO(String payId, String payType, String payAmount, String status) {
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
