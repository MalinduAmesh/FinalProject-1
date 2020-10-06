package entity;

public class Register {

    private String regID;
    private String traID;
    private String cusID;
    private String memShip;
    private String regStartDate;
    private String regEndDate;
    private String regFeeType;
    private String regFee;

    public Register() {
    }

    public Register(String regID, String traID, String cusID, String memShip, String regStartDate, String regEndDate, String regFeeType, String regFee) {
        this.regID = regID;
        this.traID = traID;
        this.cusID = cusID;
        this.memShip = memShip;
        this.regStartDate = regStartDate;
        this.regEndDate = regEndDate;
        this.regFeeType = regFeeType;
        this.regFee = regFee;
    }

    public String getRegID() {
        return regID;
    }

    public void setRegID(String regID) {
        this.regID = regID;
    }

    public String getTraID() {
        return traID;
    }

    public void setTraID(String traID) {
        this.traID = traID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getMemShip() {
        return memShip;
    }

    public void setMemShip(String memShip) {
        this.memShip = memShip;
    }

    public String getRegStartDate() {
        return regStartDate;
    }

    public void setRegStartDate(String regStartDate) {
        this.regStartDate = regStartDate;
    }

    public String getRegEndDate() {
        return regEndDate;
    }

    public void setRegEndDate(String regEndDate) {
        this.regEndDate = regEndDate;
    }

    public String getRegFeeType() {
        return regFeeType;
    }

    public void setRegFeeType(String regFeeType) {
        this.regFeeType = regFeeType;
    }

    public String getRegFee() {
        return regFee;
    }

    public void setRegFee(String regFee) {
        this.regFee = regFee;
    }
}