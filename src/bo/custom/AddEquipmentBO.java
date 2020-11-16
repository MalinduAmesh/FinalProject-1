package bo.custom;

import bo.SuperBO;
import dto.EquipmentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface AddEquipmentBO extends SuperBO {
    public boolean addEqupment(EquipmentDTO a) throws SQLException, ClassNotFoundException;
    public boolean deleteEquipment(String s) throws SQLException, ClassNotFoundException;
    public boolean updateEquipment(EquipmentDTO a) throws SQLException, ClassNotFoundException;
    public EquipmentDTO searchEqupment(String s);
    public ObservableList<EquipmentDTO> getAllEqupment() throws SQLException, ClassNotFoundException;

    EquipmentDTO setAllEquipment(String toString) throws SQLException, ClassNotFoundException;

    EquipmentDTO search(String text) throws SQLException, ClassNotFoundException;

    String GetLastId() throws SQLException, ClassNotFoundException;
}
