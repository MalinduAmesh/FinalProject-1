package entity;

public class Schedule {

    private String schedulID;
    private String schedulName;
    private String equipID;
    private String schedulAddTime;
    private String schedulDuration;

    public Schedule() {
    }

    public Schedule(String schedulID, String schedulName, String equipID, String schedulAddTime, String schedulDuration) {
        this.schedulID = schedulID;
        this.schedulName = schedulName;
        this.equipID = equipID;
        this.schedulAddTime = schedulAddTime;
        this.schedulDuration = schedulDuration;
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

    public String getEquipID() {
        return equipID;
    }

    public void setEquipID(String equipID) {
        this.equipID = equipID;
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
}
