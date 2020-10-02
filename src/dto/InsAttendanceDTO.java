package dto;

public class InsAttendanceDTO {

    private String insAttID;
    private String insID;
    private String insAttDate;

    public InsAttendanceDTO() {
    }

    public InsAttendanceDTO(String insAttID, String insID, String insAttDate) {
        this.insAttID = insAttID;
        this.insID = insID;
        this.insAttDate = insAttDate;
    }

    public String getInsAttID() {
        return insAttID;
    }

    public void setInsAttID(String insAttID) {
        this.insAttID = insAttID;
    }

    public String getInsID() {
        return insID;
    }

    public void setInsID(String insID) {
        this.insID = insID;
    }

    public String getInsAttDate() {
        return insAttDate;
    }

    public void setInsAttDate(String insAttDate) {
        this.insAttDate = insAttDate;
    }
}