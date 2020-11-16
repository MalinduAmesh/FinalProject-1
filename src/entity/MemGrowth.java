package entity;

public class MemGrowth {

    private String grID;
    private String grdate;
    private String grCusId;
    private String weigth;
    private String height;
    private String waist;
    private String thigh;
    private String arms;
    private String chest;

    public MemGrowth() {
    }

    public MemGrowth(String grID, String grdate, String grCusId, String weigth, String height, String waist, String thigh, String arms, String chest) {
        this.grID = grID;
        this.grdate = grdate;
        this.grCusId = grCusId;
        this.weigth = weigth;
        this.height = height;
        this.waist = waist;
        this.thigh = thigh;
        this.arms = arms;
        this.chest = chest;
    }

    public String getGrID() {
        return grID;
    }

    public void setGrID(String grID) {
        this.grID = grID;
    }

    public String getGrdate() {
        return grdate;
    }

    public void setGrdate(String grdate) {
        this.grdate = grdate;
    }

    public String getGrCusId() {
        return grCusId;
    }

    public void setGrCusId(String grCusId) {
        this.grCusId = grCusId;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getThigh() {
        return thigh;
    }

    public void setThigh(String thigh) {
        this.thigh = thigh;
    }

    public String getArms() {
        return arms;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }
}
