package bo.custom.Impl;

import bo.custom.AddEquipmentBO;
import dto.EquipmentDTO;
import javafx.collections.ObservableList;

public class AddEquipmentBOImpl implements AddEquipmentBO {

    @Override
    public boolean addEqupment(EquipmentDTO a) {
        return false;
    }

    @Override
    public boolean deleteEquipment(String s) {
        return false;
    }

    @Override
    public boolean updateEquipment(EquipmentDTO a) {
        return false;
    }

    @Override
    public EquipmentDTO searchEqupment(String s) {
        return null;
    }

    @Override
    public ObservableList<EquipmentDTO> getAllEqupment() {
        return null;
    }
}
