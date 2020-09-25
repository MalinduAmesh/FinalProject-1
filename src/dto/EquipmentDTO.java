package dto;

public class EquipmentDTO {
    private String equipmentId;
    private String equipmentQty;
    private String equipmentName;
    private String equipmentCost;

    public EquipmentDTO() {
    }

    public EquipmentDTO(String equipmentId, String equipmentQty, String equipmentName, String equipmentCost) {
        this.equipmentId = equipmentId;
        this.equipmentQty = equipmentQty;
        this.equipmentName = equipmentName;
        this.equipmentCost = equipmentCost;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentQty() {
        return equipmentQty;
    }

    public void setEquipmentQty(String equipmentQty) {
        this.equipmentQty = equipmentQty;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(String equipmentCost) {
        this.equipmentCost = equipmentCost;
    }
}
