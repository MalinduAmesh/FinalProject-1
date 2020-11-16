package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.MemGrowthDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface MemGrowingBo extends SuperBO {
    ObservableList<CustomerDTO> setValuesTocmb() throws SQLException, ClassNotFoundException;

    boolean AddGrowth(MemGrowthDTO memGrowthDTO) throws SQLException, ClassNotFoundException;

    String getLastId() throws SQLException, ClassNotFoundException;
}
