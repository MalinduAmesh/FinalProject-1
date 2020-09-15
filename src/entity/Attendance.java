package entity;

public class Attendance {

    private String attendID;
    private String customerID;
    private String attendDate;

    public Attendance() {
    }

    public Attendance(String attendID, String customerID, String attendDate) {
        this.attendID = attendID;
        this.customerID = customerID;
        this.attendDate = attendDate;
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