package bo.custom;

import bo.SuperBO;
import dto.CustomDTO;
import dto.SuplimentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface SuplimentOrderBO extends SuperBO {


    ObservableList<CustomDTO> loadTables() throws SQLException, ClassNotFoundException;
}
