package dto;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class OrdersDTO {
    private String ordersID;
    private String ordersDate;
    private String ordersCustomerID;
    private ObservableList<OrderDetailsDTO> allOrderDetails;
    private ObservableList<SuplimentDTO> suplimentDetailList;

    public OrdersDTO() {
    }

    public OrdersDTO(String ordersID, String ordersDate, String ordersCustomerID,ObservableList<OrderDetailsDTO> allOrderDetails) {
        this.ordersID = ordersID;
        this.ordersDate = ordersDate;
        this.ordersCustomerID = ordersCustomerID;

        this.allOrderDetails = allOrderDetails;
    }

    public OrdersDTO(String ordersID, String ordersDate, String ordersCustomerID,ObservableList<OrderDetailsDTO> allOrderDetails, ObservableList<SuplimentDTO> suplimentDetailList) {
        this.ordersID = ordersID;
        this.ordersDate = ordersDate;
        this.ordersCustomerID = ordersCustomerID;
        this.allOrderDetails = allOrderDetails;
        this.suplimentDetailList = suplimentDetailList;
    }

    public String getOrdersID() {
        return ordersID;
    }

    public void setOrdersID(String ordersID) {
        this.ordersID = ordersID;
    }

    public String getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(String ordersDate) {
        this.ordersDate = ordersDate;
    }

    public String getOrdersCustomerID() {
        return ordersCustomerID;
    }

    public void setOrdersCustomerID(String ordersCustomerID) {
        this.ordersCustomerID = ordersCustomerID;
    }

    public ObservableList<OrderDetailsDTO> getAllOrderDetails() {
        return allOrderDetails;
    }

    public void setAllOrderDetails(ObservableList<OrderDetailsDTO> allOrderDetails) {
        this.allOrderDetails = allOrderDetails;
    }

    public ObservableList<SuplimentDTO> getSuplimentDetailList() {
        return suplimentDetailList;
    }

    public void setSuplimentDetailList(ObservableList<SuplimentDTO> suplimentDetailList) {
        this.suplimentDetailList = suplimentDetailList;
    }
}
