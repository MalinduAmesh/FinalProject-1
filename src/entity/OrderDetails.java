package entity;

public class OrderDetails {
    private String OrderDetailID;
    private String suplimeID;
    private String orederDetailQTY;
    private String orederDetailUnitP;

    public OrderDetails() {
    }

    public OrderDetails(String orderDetailID, String suplimeID, String orederDetailQTY, String orederDetailUnitP) {
        OrderDetailID = orderDetailID;
        this.suplimeID = suplimeID;
        this.orederDetailQTY = orederDetailQTY;
        this.orederDetailUnitP = orederDetailUnitP;
    }

    public String getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        OrderDetailID = orderDetailID;
    }

    public String getSuplimeID() {
        return suplimeID;
    }

    public void setSuplimeID(String suplimeID) {
        this.suplimeID = suplimeID;
    }

    public String getOrederDetailQTY() {
        return orederDetailQTY;
    }

    public void setOrederDetailQTY(String orederDetailQTY) {
        this.orederDetailQTY = orederDetailQTY;
    }

    public String getOrederDetailUnitP() {
        return orederDetailUnitP;
    }

    public void setOrederDetailUnitP(String orederDetailUnitP) {
        this.orederDetailUnitP = orederDetailUnitP;
    }
}
