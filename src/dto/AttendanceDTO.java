package dto;

public class AttendanceDTO {
    private String attendID;
    private String customerID;
    private String instId;
    private String attendDate;
    private String attInTime;

    public AttendanceDTO() {
    }

    public AttendanceDTO(String attendID, String customerID, String instId, String attendDate, String attInTime) {
        this.attendID = attendID;
        this.customerID = customerID;
        this.instId = instId;
        this.attendDate = attendDate;
        this.attInTime = attInTime;
    }

    public AttendanceDTO(String customerID, String instId, String attendDate) {
        this.customerID = customerID;
        this.instId = instId;
        this.attendDate = attendDate;
    }

    public String getAttInTime() {
        return attInTime;
    }

    public void setAttInTime(String attInTime) {
        this.attInTime = attInTime;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId;
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
}
