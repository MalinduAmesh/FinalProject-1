package bo.custom.Impl;

import bo.custom.AddEquipmentBO;
import dao.CrudUtil;
import dao.DAOFactory;
import dao.custom.EquipmentDAO;
import dao.custom.Impl.EquipmentDAOImpl;
import dto.EquipmentDTO;
import entity.Equipment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddEquipmentBOImpl implements AddEquipmentBO {

    EquipmentDAO equipmentDAO = (EquipmentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EQUIPMENT);

    @Override
    public boolean addEqupment(EquipmentDTO a) throws SQLException, ClassNotFoundException {
        Equipment equipment = new Equipment(a.getEquipmentId(),a.getEquipmentName(),a.getEquipmentQty(),a.getEquipmentCost());
        return equipmentDAO.add(equipment);
    }

    @Override
    public boolean deleteEquipment(String s) throws SQLException, ClassNotFoundException {
        return equipmentDAO.delete(s);
    }

    @Override
    public boolean updateEquipment(EquipmentDTO a) throws SQLException, ClassNotFoundException {

        Equipment equipment = new Equipment(a.getEquipmentId(),a.getEquipmentName(),a.getEquipmentQty(),a.getEquipmentCost());
        return equipmentDAO.update(equipment);
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

    @Override
    public EquipmentDTO setAllEquipment(String a) throws SQLException, ClassNotFoundException {
        Equipment equipment =equipmentDAO.search(a);
        return  new EquipmentDTO(equipment.getEquipmentId(),equipment.getEquipmentName(),equipment.getEquipmentQty(),equipment.getEquipmentCost());
    }

    @Override
    public EquipmentDTO search(String text) throws SQLException, ClassNotFoundException {
        Equipment equipment = equipmentDAO.searchName(text);
        return new EquipmentDTO(equipment.getEquipmentId(),equipment.getEquipmentName(),equipment.getEquipmentQty(),equipment.getEquipmentCost());
    }

    @Override
    public String GetLastId() throws SQLException, ClassNotFoundException {

        String sql ="Select equId from equipment order BY equId desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next()?rst.getString("equId"):null;
    }
}
