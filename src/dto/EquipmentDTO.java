package dto;

public class EquipmentDTO {
    private String equipmentId;
    private int equipmentQty;
    private String equipmentName;
    private double equipmentCost;

    public EquipmentDTO() {
    }

    public EquipmentDTO(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public EquipmentDTO(String equipmentId,  String equipmentName,int equipmentQty, double equipmentCost) {
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

    public int getEquipmentQty() {
        return equipmentQty;
    }

    public void setEquipmentQty(int equipmentQty) {
        this.equipmentQty = equipmentQty;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public double getEquipmentCost() {
        return equipmentCost;
    }

    public void setEquipmentCost(double equipmentCost) {
        this.equipmentCost = equipmentCost;
    }
}
