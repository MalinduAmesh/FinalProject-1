package bo.custom.Impl;

import bo.custom.AddEquipmentBO;
import dao.custom.EquipmentDAO;
import dao.custom.Impl.EquipmentDAOImpl;
import dto.EquipmentDTO;
import entity.Equipment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddEquipmentBOImpl implements AddEquipmentBO {

    EquipmentDAO equipmentDAO = new EquipmentDAOImpl();

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
    public ObservableList<EquipmentDTO> getAllEqupment() throws SQLException, ClassNotFoundException {
        ArrayList<Equipment> list = equipmentDAO.getAll();
        ObservableList<EquipmentDTO> allEquipment = FXCollections.observableArrayList();
        for (Equipment equipment:list) {
            allEquipment.add(new EquipmentDTO(
                    equipment.getEquipmentId(),
                    equipment.getEquipmentName(),
                    equipment.getEquipmentQty(),
                    equipment.getEquipmentCost()
            ));
        }
        return allEquipment;
    }
}
