package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberForm extends SuperBO {

    CustomerDTO searchAllMemeName();

    ObservableList<CustomerDTO> loadTables() throws SQLException, ClassNotFoundException;
}
