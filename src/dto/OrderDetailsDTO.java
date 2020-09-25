package dto;

public class OrderDetailsDTO {
    private String OrderDetailID;
    private String suplimeID;
    private int orederDetailQTY;
    private double orederDetailUnitP;



    public OrderDetailsDTO() {
    }

    public OrderDetailsDTO(String orderDetailID, String suplimeID, int orederDetailQTY, double orederDetailUnitP) {
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

    public int getOrederDetailQTY() {
        return orederDetailQTY;
    }

    public void setOrederDetailQTY(int orederDetailQTY) {
        this.orederDetailQTY = orederDetailQTY;
    }

    public double getOrederDetailUnitP() {
        return orederDetailUnitP;
    }

    public void setOrederDetailUnitP(double orederDetailUnitP) {
        this.orederDetailUnitP = orederDetailUnitP;
    }
}
