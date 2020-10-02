package entity;

import dto.RegisterDTO;
import javafx.collections.ObservableList;

public class Customer {
    @Override
    public String toString() {
        return "Customer{" +
                "custID='" + custID + '\'' +
                ", custName='" + custName + '\'' +
                ", custNic='" + custNic + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custContact='" + custContact + '\'' +
                ", custDOB='" + custDOB + '\'' +
                ", custGender='" + custGender + '\'' +
                ", custEmail='" + custEmail + '\'' +
                '}';
    }

    private String custID;
    private String custName;
    private String custNic;
    private String custAddress;
    private String custContact;
    private String custDOB;
    private String custGender;
    private String custEmail;

    public Customer() {
    }

    public Customer(String custID) {
        this.custID = custID;
    }

    public Customer(String custID, String custName) {
        this.custID = custID;
        this.custName = custName;
    }

    public Customer(String custID, String custName, String custNic, String custAddress, String custContact, String custDOB) {
        this.custID = custID;
        this.custName = custName;
        this.custNic = custNic;
        this.custAddress = custAddress;
        this.custContact = custContact;
        this.custDOB = custDOB;
    }

    public Customer(String custID, String custName, String custNic, String custAddress, String custContact, String custDOB, String custGender, String custEmail) {
        this.custID = custID;
        this.custName = custName;
        this.custNic = custNic;
        this.custAddress = custAddress;
        this.custContact = custContact;
        this.custDOB = custDOB;
        this.custGender = custGender;
        this.custEmail = custEmail;
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
