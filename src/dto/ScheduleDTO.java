package dto;

public class ScheduleDTO {
    private String schId;
    private String schGoal;
    private String schType;
    private String schLevel;
    private String schDuration;
    private String schPerWeek;
    private String schPerTime;

    public ScheduleDTO() {
    }

    public ScheduleDTO(String schId, String schGoal, String schType, String schLevel, String schDuration, String schPerWeek, String schPerTime) {
        this.schId = schId;
        this.schGoal = schGoal;
        this.schType = schType;
        this.schLevel = schLevel;
        this.schDuration = schDuration;
        this.schPerWeek = schPerWeek;
        this.schPerTime = schPerTime;
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
}
