package dto;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class CustomerDTO {
    private String custID;
    private String custName;
    private String custNic;
    private String custAddress;
    private String custContact;
    private String custDOB;
    private String custGender;
    private String custEmail;

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "custID='" + custID + '\'' +
                ", custName='" + custName + '\'' +
                ", custNic='" + custNic + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custContact='" + custContact + '\'' +
                ", custDOB='" + custDOB + '\'' +
                ", custGender='" + custGender + '\'' +
                ", custEmail='" + custEmail + '\'' +
                ", regID='" + regID + '\'' +
                ", traID='" + traID + '\'' +
                ", cusID='" + cusID + '\'' +
                ", memShip='" + memShip + '\'' +
                ", regStartDate='" + regStartDate + '\'' +
                ", regEndDate='" + regEndDate + '\'' +
                ", regFeeType='" + regFeeType + '\'' +
                ", regFee='" + regFee + '\'' +
                '}';
    }

    private String regID;
    private String traID;
    private String cusID;
    private String memShip;
    private String regStartDate;
    private String regEndDate;
    private String regFeeType;
    private String regFee;

    public CustomerDTO(String custID) {
        this.custID = custID;
    }

    public CustomerDTO(String custID, String custName, String custNic, String custAddress, String custContact, String custDOB) {
        this.custID = custID;
        this.custName = custName;
        this.custNic = custNic;
        this.custAddress = custAddress;
        this.custContact = custContact;
        this.custDOB = custDOB;
    }

    public CustomerDTO(String custID, String custName) {
        this.custID = custID;
        this.custName = custName;
    }

    public CustomerDTO(String custID, String custName, String custNic, String custAddress, String custContact, String custDOB, String custGender, String custEmail, String regID, String traID, String cusID, String memShip, String regStartDate, String regEndDate, String regFeeType, String regFee) {
        this.custID = custID;
        this.custName = custName;
        this.custNic = custNic;
        this.custAddress = custAddress;
        this.custContact = custContact;
        this.custDOB = custDOB;
        this.custGender = custGender;
        this.custEmail = custEmail;
        this.regID = regID;
        this.traID = traID;
        this.cusID = cusID;
        this.memShip = memShip;
        this.regStartDate = regStartDate;
        this.regEndDate = regEndDate;
        this.regFeeType = regFeeType;
        this.regFee = regFee;
    }

    public CustomerDTO() {
    }

    public CustomerDTO(String custID, String custName, String custContact, String custEmail) {
        this.custID = custID;
        this.custName = custName;
        this.custContact=custContact;
        this.custEmail=custEmail;
    }

    public CustomerDTO(String custID, String custName, String custNic, String custAddress, String custContact, String custDOB, String custGender, String custEmail) {
        this.custID = custID;
        this.custName = custName;
        this.custNic = custNic;
        this.custAddress = custAddress;
        this.custContact = custContact;
        this.custDOB = custDOB;
        this.custGender = custGender;
        this.custEmail = custEmail;
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
    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustNic() {
        return custNic;
    }

    public void setCustNic(String custNic) {
        this.custNic = custNic;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustContact() {
        return custContact;
    }

    public void setCustContact(String custContact) {
        this.custContact = custContact;
    }

    public String getCustDOB() {
        return custDOB;
    }

    public void setCustDOB(String custDOB) {
        this.custDOB = custDOB;
    }

    public String getCustGender() {
        return custGender;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }
}