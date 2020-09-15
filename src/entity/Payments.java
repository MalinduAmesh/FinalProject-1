package entity;

public class Payments {

    private String payID;
    private String customerId;
    private String payType;
    private String payAmount;
    private String payStatus;

    public Payments() {
    }

    public Payments(String payID, String customerId, String payType, String payAmount, String payStatus) {
        this.payID = payID;
        this.customerId = customerId;
        this.payType = payType;
        this.payAmount = payAmount;
        this.payStatus = payStatus;
    }

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
}
