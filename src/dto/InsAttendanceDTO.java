package dto;

public class InsAttendanceDTO {

    private String insAttID;
    private String insID;
    private String insAttInDate;
    private String insAttInTime;
    private String insAttOutTime;

    public InsAttendanceDTO(String insAttID) {
        this.insAttID = insAttID;
    }

    public InsAttendanceDTO(String insAttID, String insID, String insAttInDate, String insAttInTime) {
        this.insAttID = insAttID;
        this.insID = insID;
        this.insAttInDate = insAttInDate;
        this.insAttInTime = insAttInTime;
    }

    public InsAttendanceDTO() {

    }

    @Override
    public String toString() {
        return "InsAttendanceDTO{" +
                "insAttID='" + insAttID + '\'' +
                ", insID='" + insID + '\'' +
                ", insAttInDate='" + insAttInDate + '\'' +
                ", insAttInTime='" + insAttInTime + '\'' +
                ", insAttOutTime='" + insAttOutTime + '\'' +
                '}';
    }

    public InsAttendanceDTO(String insAttID, String insID, String insAttInDate, String insAttInTime, String insAttOutTime) {
        this.insAttID = insAttID;
        this.insID = insID;
        this.insAttInDate = insAttInDate;
        this.insAttInTime = insAttInTime;
        this.insAttOutTime = insAttOutTime;
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

    public String getInsAttInDate() {
        return insAttInDate;
    }

    public void setInsAttInDate(String insAttInDate) {
        this.insAttInDate = insAttInDate;
    }

    public String getInsAttInTime() {
        return insAttInTime;
    }

    public void setInsAttInTime(String insAttInTime) {
        this.insAttInTime = insAttInTime;
    }

    public String getInsAttOutTime() {
        return insAttOutTime;
    }

    public void setInsAttOutTime(String insAttOutTime) {
        this.insAttOutTime = insAttOutTime;
    }
}
