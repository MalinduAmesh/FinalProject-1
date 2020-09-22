package dto;

import java.util.ArrayList;

public class OrdersDTO {
    private String ordersID;
    private String ordersDate;
    private String ordersCustomerID;
    private String ordType;
    private ArrayList<OrderDetailsDTO> allOrderDetails;

    public OrdersDTO() {
    }

    public OrdersDTO(String ordersID, String ordersDate, String ordersCustomerID, String ordType, ArrayList<OrderDetailsDTO> allOrderDetails) {
        this.ordersID = ordersID;
        this.ordersDate = ordersDate;
        this.ordersCustomerID = ordersCustomerID;
        this.ordType = ordType;
        this.allOrderDetails = allOrderDetails;
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

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public ArrayList<OrderDetailsDTO> getAllOrderDetails() {
        return allOrderDetails;
    }

    public void setAllOrderDetails(ArrayList<OrderDetailsDTO> allOrderDetails) {
        this.allOrderDetails = allOrderDetails;
    }
}
