package dto;

public class CustomerDTO {
    private String custID;
    private String custName;
    private String custAddress;
    private String custContact;
    private String custDOB;
    private String custGender;
    private String custEmail;
    private String custWeigth;
    private String custHeight;

    public CustomerDTO() {
    }

    public CustomerDTO(String custID, String custName, String custAddress, String custContact, String custDOB, String custGender, String custEmail, String custWeigth, String custHeight) {
        this.custID = custID;
        this.custName = custName;
        this.custAddress = custAddress;
        this.custContact = custContact;
        this.custDOB = custDOB;
        this.custGender = custGender;
        this.custEmail = custEmail;
        this.custWeigth = custWeigth;
        this.custHeight = custHeight;

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

    public String getCustWeigth() {
        return custWeigth;
    }

    public void setCustWeigth(String custWeigth) {
        this.custWeigth = custWeigth;
    }

    public String getCustHeight() {
        return custHeight;
    }

    public void setCustHeight(String custHeight) {
        this.custHeight = custHeight;
    }
}
