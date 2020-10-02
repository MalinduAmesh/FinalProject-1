package entity;

public class Equipment {
    private String equipmentId;
    private String equipmentName;
    private int equipmentQty;
    private double equipmentCost;

    public Equipment() {
    }

    public Equipment(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Equipment(String equipmentId, String equipmentName, int equipmentQty, double equipmentCost) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentQty = equipmentQty;
        this.equipmentCost = equipmentCost;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId='" + equipmentId + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentQty=" + equipmentQty +
                ", equipmentCost=" + equipmentCost +
                '}';
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getEquipmentQty() {
        return equipmentQty;
    }

    public void setEquipmentQty(int equipmentQty) {
        this.equipmentQty = equipmentQty;
    }

    public double getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(double equipmentCost) {
        this.equipmentCost = equipmentCost;
    }
}
