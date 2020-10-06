package entity;

public class Attendance {

    private String attendID;
    private String customerID;
    private String InstId;
    private String attendDate;
    private String attInTime;

    public Attendance() {
    }

    public Attendance(String attendID, String customerID, String attendDate) {
        this.attendID = attendID;
        this.customerID = customerID;
        this.attendDate = attendDate;
    }

    public Attendance(String attendID, String customerID, String instId, String attendDate, String attInTime) {
        this.attendID = attendID;
        this.customerID = customerID;
        InstId = instId;
        this.attendDate = attendDate;
        this.attInTime = attInTime;
    }

    public String getAttInTime() {
        return attInTime;
    }

    public void setAttInTime(String attInTime) {
        this.attInTime = attInTime;
    }

    public Attendance(String attendID) {
        this.attendID = attendID;
    }


    public String getInstId() {
        return InstId;
    }

    public void setInstId(String instId) {
        InstId = instId;
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