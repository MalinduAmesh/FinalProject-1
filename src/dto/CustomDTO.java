package dto;

public class CustomDTO {

    private String attendID;
    private String customerID;
    private String attendDate;

    private String custID;
    private String custName;
    private String custNic;
    private String custAddress;
    private String custContact;
    private String custDOB;
    private String custGender;
    private String custEmail;

    private String equipmentId;
    private String equipmentName;
    private int equipmentQty;
    private double equipmentCost;

    private String InstructID;
    private String InstructName;
    private String InstructGender;
    private String InstructNumber;
    private String InstructJoinDate;
    private String InstructCost;
    private String InstructPayMonth;

    private String OrderDetailID;
    private String orederDetailQTY;
    private String orederDetailUnitP;

    private String ordersID;
    private String ordersDate;
    private String ordersCustomerID;
    private String ordType;

    private String payID;
    private String payType;
    private String payAmount;
    private String payStatus;

    private String regID;
    private String regInsId;
    private String regCusId;
    private String reMmemShip;
    private String regStartDate;
    private String regEndDate;
    private String regFeeType;
    private String regFee;

    private String schId;
    private String schGoal;
    private String schType;
    private String schLevel;
    private String schDuration;
    private String schPerWeek;
    private String schPerTime;

    private String suplimId;
    private String suplimName;
    private String suplimQTY;
    private double suplimCost;

    private double total;
    private String discount;
    private String totalQTy;

    private String memShipid;
    private String name;
    private String duration;
    private String Fee;

    private String assWorkId;
    private String assMemID;
    private String assSchID;
    private String assInDate;
    private String assOutDate;



    public CustomDTO(String customerID, String schGoal, String assWorkId, String assInDate, String assOutDate) {
        this.customerID = customerID;
        this.schGoal = schGoal;
        this.assWorkId = assWorkId;
        this.assInDate = assInDate;
        this.assOutDate = assOutDate;
    }

    public CustomDTO(String equipmentId, String equipmentName, double equipmentCost, String schGoal) {
            this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentCost = equipmentCost;
        this.schGoal = schGoal;
    }

    public CustomDTO(String custID, String custName, String custNic, String custAddress, String custContact, String custDOB, String custGender, String custEmail, String regID, String regInsId, String regCusId, String reMmemShip, String regStartDate, String regEndDate, String regFeeType, String regFee) {
        this.custID = custID;
        this.custName = custName;
        this.custNic = custNic;
        this.custAddress = custAddress;
        this.custContact = custContact;
        this.custDOB = custDOB;
        this.custGender = custGender;
        this.custEmail = custEmail;
        this.regID = regID;
        this.regInsId =regInsId;
        this.regCusId = regCusId;
        this.reMmemShip = reMmemShip;
        this.regStartDate = regStartDate;
        this.regEndDate = regEndDate;
        this.regFeeType = regFeeType;
        this.regFee = regFee;

    }


    public CustomDTO(String suplimId, String suplimName, double suplimCost,  String discount, String totalQTy,double total) {
        this.suplimId = suplimId;
        this.suplimName = suplimName;
        this.suplimCost = suplimCost;
        this.discount = discount;
        this.totalQTy = totalQTy;
        this.total = total;
    }


    public CustomDTO(String attendID, String customerID, String attendDate, String custID, String custName, String custNic, String custAddress, String custContact, String custDOB, String custGender, String custEmail, String equipmentId, String equipmentName, int equipmentQty, double equipmentCost, String instructID, String instructName, String instructGender, String instructNumber, String instructJoinDate, String instructCost, String instructPayMonth, String orderDetailID, String orederDetailQTY, String orederDetailUnitP, String ordersID, String ordersDate, String ordersCustomerID, String ordType, String payID, String payType, String payAmount, String payStatus, String regID, String regInsId, String regCusId, String reMmemShip, String regStartDate, String regEndDate, String regFeeType, String regFee, String schId, String schGoal, String schType, String schLevel, String schDuration, String schPerWeek, String schPerTime, String suplimId, String suplimName, String suplimQTY, double suplimCost, double total, String discount, String totalQTy, String memShipid, String name, String duration, String fee) {
        this.attendID = attendID;
        this.customerID = customerID;
        this.attendDate = attendDate;
        this.custID = custID;
        this.custName = custName;
        this.custNic = custNic;
        this.custAddress = custAddress;
        this.custContact = custContact;
        this.custDOB = custDOB;
        this.custGender = custGender;
        this.custEmail = custEmail;
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentQty = equipmentQty;
        this.equipmentCost = equipmentCost;
        InstructID = instructID;
        InstructName = instructName;
        InstructGender = instructGender;
        InstructNumber = instructNumber;
        InstructJoinDate = instructJoinDate;
        InstructCost = instructCost;
        InstructPayMonth = instructPayMonth;
        OrderDetailID = orderDetailID;
        this.orederDetailQTY = orederDetailQTY;
        this.orederDetailUnitP = orederDetailUnitP;
        this.ordersID = ordersID;
        this.ordersDate = ordersDate;
        this.ordersCustomerID = ordersCustomerID;
        this.ordType = ordType;
        this.payID = payID;
        this.payType = payType;
        this.payAmount = payAmount;
        this.payStatus = payStatus;
        this.regID = regID;
        this.regInsId = regInsId;
        this.regCusId = regCusId;
        this.reMmemShip = reMmemShip;
        this.regStartDate = regStartDate;
        this.regEndDate = regEndDate;
        this.regFeeType = regFeeType;
        this.regFee = regFee;
        this.schId = schId;
        this.schGoal = schGoal;
        this.schType = schType;
        this.schLevel = schLevel;
        this.schDuration = schDuration;
        this.schPerWeek = schPerWeek;
        this.schPerTime = schPerTime;
        this.suplimId = suplimId;
        this.suplimName = suplimName;
        this.suplimQTY = suplimQTY;
        this.suplimCost = suplimCost;
        this.total = total;
        this.discount = discount;
        this.totalQTy = totalQTy;
        this.memShipid = memShipid;
        this.name = name;
        this.duration = duration;
        Fee = fee;
    }

    public String getAssWorkId() {
        return assWorkId;
    }

    public void setAssWorkId(String assWorkId) {
        this.assWorkId = assWorkId;
    }

    public String getAssMemID() {
        return assMemID;
    }

    public void setAssMemID(String assMemID) {
        this.assMemID = assMemID;
    }

    public String getAssSchID() {
        return assSchID;
    }

    public void setAssSchID(String assSchID) {
        this.assSchID = assSchID;
    }

    public String getAssInDate() {
        return assInDate;
    }

    public void setAssInDate(String assInDate) {
        this.assInDate = assInDate;
    }

    public String getAssOutDate() {
        return assOutDate;
    }

    public void setAssOutDate(String assOutDate) {
        this.assOutDate = assOutDate;
    }

    public String getAttendID() {
        return attendID;
    }

    public void setAttendID(String attendID) {
        this.attendID = attendID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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

    public int getEquipmentQty() {
        return equipmentQty;
    }

    public void setEquipmentQty(int equipmentQty) {
        this.equipmentQty = equipmentQty;
    }

    public double getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(double equipmentCost) {
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

    public String getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        OrderDetailID = orderDetailID;
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

    public String getRegInsId() {
        return regInsId;
    }

    public void setRegInsId(String regInsId) {
        this.regInsId = regInsId;
    }

    public String getRegCusId() {
        return regCusId;
    }

    public void setRegCusId(String regCusId) {
        this.regCusId = regCusId;
    }

    public String getReMmemShip() {
        return reMmemShip;
    }

    public void setReMmemShip(String reMmemShip) {
        this.reMmemShip = reMmemShip;
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

    public String getSchId() {
        return schId;
    }

    public void setSchId(String schId) {
        this.schId = schId;
    }

    public String getSchGoal() {
        return schGoal;
    }

    public void setSchGoal(String schGoal) {
        this.schGoal = schGoal;
    }

    public String getSchType() {
        return schType;
    }

    public void setSchType(String schType) {
        this.schType = schType;
    }

    public String getSchLevel() {
        return schLevel;
    }

    public void setSchLevel(String schLevel) {
        this.schLevel = schLevel;
    }

    public String getSchDuration() {
        return schDuration;
    }

    public void setSchDuration(String schDuration) {
        this.schDuration = schDuration;
    }

    public String getSchPerWeek() {
        return schPerWeek;
    }

    public void setSchPerWeek(String schPerWeek) {
        this.schPerWeek = schPerWeek;
    }

    public String getSchPerTime() {
        return schPerTime;
    }

    public void setSchPerTime(String schPerTime) {
        this.schPerTime = schPerTime;
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

    public double getSuplimCost() {
        return suplimCost;
    }

    public void setSuplimCost(double suplimCost) {
        this.suplimCost = suplimCost;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTotalQTy() {
        return totalQTy;
    }

    public void setTotalQTy(String totalQTy) {
        this.totalQTy = totalQTy;
    }

    public String getMemShipid() {
        return memShipid;
    }

    public void setMemShipid(String memShipid) {
        this.memShipid = memShipid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }
}