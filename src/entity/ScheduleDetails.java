package entity;

public class ScheduleDetails {
    private String equId;
    private String schId;

    public ScheduleDetails() {
    }

    public ScheduleDetails(String equId, String schId) {
        this.equId = equId;
        this.schId = schId;
    }

    public String getEquId() {
        return equId;
    }

    public void setEquId(String equId) {
        this.equId = equId;
    }

    public String getSchId() {
        return schId;
    }

    public void setSchId(String schId) {
        this.schId = schId;
    }
}
