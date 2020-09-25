package entity;

public class Equipment {
    private String equipmentId;
    private String equipmentName;
    private String equipmentQty;
    private String equipmentCost;

    public Equipment() {
    }

    public Equipment(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Equipment(String equipmentId, String equipmentName, String equipmentQty, String equipmentCost) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentQty = equipmentQty;
        this.equipmentCost = equipmentCost;
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

    public String getEquipmentQty() {
        return equipmentQty;
    }

    public void setEquipmentQty(String equipmentQty) {
        this.equipmentQty = equipmentQty;
    }

    public String getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(String equipmentCost) {
        this.equipmentCost = equipmentCost;
    }
}
