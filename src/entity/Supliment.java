package entity;

public class Supliment {

    private String suplimId;
    private String suplimName;
    private int suplimQTY;
    private double suplimCost;

    public Supliment() {
    }

    public Supliment(String suplimId, String suplimName, int suplimQTY, double suplimCost) {
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

    public int getSuplimQTY() {
        return suplimQTY;
    }

    public void setSuplimQTY(int suplimQTY) {
        this.suplimQTY = suplimQTY;
    }

    public double getSuplimCost() {
        return suplimCost;
    }

    public void setSuplimCost(double suplimCost) {
        this.suplimCost = suplimCost;
    }
}
