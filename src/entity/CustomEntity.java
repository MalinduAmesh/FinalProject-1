package entity;

public class CustomEntity {
    private String attendID;
    //private String customerID;
    private String attendDate;

    private String custID;
    private String custName;
    private String custAddress;
    private String custContact;
    private String custDOB;
    private String custGender;
    private String custEmail;
    private String custWeigth;
    private String custHeight;

    private String equipmentId;
    private String equipmentName;
    private String equipmentImage;
    private String equipmentQty;
    private String equipmentCost;

    private String InstructID;
    private String InstructName;
    private String InstructGender;
    private String InstructNumber;
    private String InstructJoinDate;
    private String InstructCost;
    private String InstructPayMonth;

    //private String OrderDetailID;
    //private String suplimeID;
    private String orederDetailQTY;
    private String orederDetailUnitP;

    private String ordersID;
    private String ordersDate;
    //private String ordersCustomerID;

    private String payID;
    //private String customerId;
    private String payType;
    private String payAmount;
    private String payStatus;

    private String regID;
    //private String traID;
    //private String cusID;
    private String memShip;
    private String regStartDate;
    private String regEndDate;
    private String regFeeType;
    private String regFee;

    private String schedulID;
    private String schedulName;
    //private String equipID;
    private String schedulAddTime;
    private String schedulDuration;

    private String suplimId;
    private String suplimName;
    private String suplimQTY;
    private String suplimCost;

    public CustomEntity() {
    }

    public CustomEntity(String attendID, String attendDate, String custID, String custName, String custAddress, String custContact, String custDOB, String custGender, String custEmail, String custWeigth, String custHeight, String equipmentId, String equipmentName, String equipmentImage, String equipmentQty, String equipmentCost, String instructID, String instructName, String instructGender, String instructNumber, String instructJoinDate, String instructCost, String instructPayMonth, String orederDetailQTY, String orederDetailUnitP, String ordersID, String ordersDate, String payID, String payType, String payAmount, String payStatus, String regID, String memShip, String regStartDate, String regEndDate, String regFeeType, String regFee, String schedulID, String schedulName, String schedulAddTime, String schedulDuration, String suplimId, String suplimName, String suplimQTY, String suplimCost) {
        this.attendID = attendID;
        this.attendDate = attendDate;
        this.custID = custID;
        this.custName = custName;
        this.custAddress = custAddress;
        this.custContact = custContact;
        this.custDOB = custDOB;
        this.custGender = custGender;
        this.custEmail = custEmail;
        this.custWeigth = custWeigth;
        this.custHeight = custHeight;
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentImage = equipmentImage;
        this.equipmentQty = equipmentQty;
        this.equipmentCost = equipmentCost;
        InstructID = instructID;
        InstructName = instructName;
        InstructGender = instructGender;
        InstructNumber = instructNumber;
        InstructJoinDate = instructJoinDate;
        InstructCost = instructCost;
        InstructPayMonth = instructPayMonth;
        this.orederDetailQTY = orederDetailQTY;
        this.orederDetailUnitP = orederDetailUnitP;
        this.ordersID = ordersID;
        this.ordersDate = ordersDate;
        this.payID = payID;
        this.payType = payType;
        this.payAmount = payAmount;
        this.payStatus = payStatus;
        this.regID = regID;
        this.memShip = memShip;
        this.regStartDate = regStartDate;
        this.regEndDate = regEndDate;
        this.regFeeType = regFeeType;
        this.regFee = regFee;
        this.schedulID = schedulID;
        this.schedulName = schedulName;
        this.schedulAddTime = schedulAddTime;
        this.schedulDuration = schedulDuration;
        this.suplimId = suplimId;
        this.suplimName = suplimName;
        this.suplimQTY = suplimQTY;
        this.suplimCost = suplimCost;
    }

    public String getAttendID() {
        return attendID;
    }

    public void setAttendID(String attendID) {
        this.attendID = attendID;
    }

    public String getAttendDate() {
        return attendDate;
    }

    public void setAttendDate(String attendDate) {
        this.attendDate = attendDate;
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

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentImage() {
        return equipmentImage;
    }

    public void setEquipmentImage(String equipmentImage) {
        this.equipmentImage = equipmentImage;
    }

    public String getEquipmentQty() {
        return equipmentQty;
    }

    public void setEquipmentQty(String equipmentQty) {
        this.equipmentQty = equipmentQty;
    }

    public String getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(String equipmentCost) {
        this.equipmentCost = equipmentCost;
    }

    public String getInstructID() {
        return InstructID;
    }

    public void setInstructID(String instructID) {
        InstructID = instructID;
    }

    public String getInstructName() {
        return InstructName;
    }

    public void setInstructName(String instructName) {
        InstructName = instructName;
    }

    public String getInstructGender() {
        return InstructGender;
    }

    public void setInstructGender(String instructGender) {
        InstructGender = instructGender;
    }

    public String getInstructNumber() {
        return InstructNumber;
    }

    public void setInstructNumber(String instructNumber) {
        InstructNumber = instructNumber;
    }

    public String getInstructJoinDate() {
        return InstructJoinDate;
    }

    public void setInstructJoinDate(String instructJoinDate) {
        InstructJoinDate = instructJoinDate;
    }

    public String getInstructCost() {
        return InstructCost;
    }

    public void setInstructCost(String instructCost) {
        InstructCost = instructCost;
    }

    public String getInstructPayMonth() {
        return InstructPayMonth;
    }

    public void setInstructPayMonth(String instructPayMonth) {
        InstructPayMonth = instructPayMonth;
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

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
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

    public String getRegID() {
        return regID;
    }

    public void setRegID(String regID) {
        this.regID = regID;
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

    public String getSchedulID() {
        return schedulID;
    }

    public void setSchedulID(String schedulID) {
        this.schedulID = schedulID;
    }

    public String getSchedulName() {
        return schedulName;
    }

    public void setSchedulName(String schedulName) {
        this.schedulName = schedulName;
    }

    public String getSchedulAddTime() {
        return schedulAddTime;
    }

    public void setSchedulAddTime(String schedulAddTime) {
        this.schedulAddTime = schedulAddTime;
    }

    public String getSchedulDuration() {
        return schedulDuration;
    }

    public void setSchedulDuration(String schedulDuration) {
        this.schedulDuration = schedulDuration;
    }

    public String getSuplimId() {
        return suplimId;
    }

    public void setSuplimId(String suplimId) {
        this.suplimId = suplimId;
    }

    public String getSuplimName() {
        return suplimName;
    }

    public void setSuplimName(String suplimName) {
        this.suplimName = suplimName;
    }

    public String getSuplimQTY() {
        return suplimQTY;
    }

    public void setSuplimQTY(String suplimQTY) {
        this.suplimQTY = suplimQTY;
    }

    public String getSuplimCost() {
        return suplimCost;
    }

    public void setSuplimCost(String suplimCost) {
        this.suplimCost = suplimCost;
    }
}
