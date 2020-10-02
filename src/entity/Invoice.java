package entity;

import javafx.collections.ObservableList;

public class Invoice {

    private String inoId;
    private String inoDate;
    private String inoCus;
    private String inoPayId;



    public Invoice() {
    }

    public Invoice(String inoId, String inoDate, String inoCus, String inoPayId) {
        this.inoId = inoId;
        this.inoDate = inoDate;
        this.inoCus = inoCus;
        this.inoPayId = inoPayId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "inoId='" + inoId + '\'' +
                ", inoDate='" + inoDate + '\'' +
                ", inoCus='" + inoCus + '\'' +
                ", inoPayId='" + inoPayId + '\'' +
                '}';
    }

    public String getInoId() {
        return inoId;
    }

    public void setInoId(String inoId) {
        this.inoId = inoId;
    }

    public String getInoDate() {
        return inoDate;
    }

    public void setInoDate(String inoDate) {
        this.inoDate = inoDate;
    }

    public String getInoCus() {
        return inoCus;
    }

    public void setInoCus(String inoCus) {
        this.inoCus = inoCus;
    }

    public String getInoPayId() {
        return inoPayId;
    }

    public void setInoPayId(String inoPayId) {
        this.inoPayId = inoPayId;
    }
}
