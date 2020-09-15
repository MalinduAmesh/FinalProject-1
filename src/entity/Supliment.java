package entity;

public class Supliment {

    private String suplimId;
    private String suplimName;
    private String suplimQTY;
    private String suplimCost;

    public Supliment() {
    }

    public Supliment(String suplimId, String suplimName, String suplimQTY, String suplimCost) {
        this.suplimId = suplimId;
        this.suplimName = suplimName;
        this.suplimQTY = suplimQTY;
        this.suplimCost = suplimCost;
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
