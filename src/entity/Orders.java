package entity;

public class Orders {
    private String ordersID;
    private String ordersDate;
    private String ordersCustomerID;
    private String ordType;

    public Orders() {
    }

    public Orders(String ordersID, String ordersDate, String ordersCustomerID, String ordType) {
        this.ordersID = ordersID;
        this.ordersDate = ordersDate;
        this.ordersCustomerID = ordersCustomerID;
        this.ordType = ordType;
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
}

