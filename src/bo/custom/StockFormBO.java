package bo.custom;

import bo.SuperBO;
import dto.EquipmentDTO;
import dto.SuplimentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface StockFormBO extends SuperBO {
    ObservableList<SuplimentDTO> loadSupliments() throws SQLException, ClassNotFoundException;

    ObservableList<EquipmentDTO> loadAllEquipment() throws SQLException, ClassNotFoundException;
}
