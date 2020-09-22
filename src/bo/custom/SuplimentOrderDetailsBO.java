package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.OrdersDTO;
import dto.SuplimentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface SuplimentOrderDetailsBO extends SuperBO {

    public SuplimentDTO searchSupliment(String s) throws SQLException, ClassNotFoundException;
    public CustomerDTO searchCustomer(String s) throws SQLException, ClassNotFoundException;
    public boolean purchaseSupliment(OrdersDTO dto);
    public String getLastId() throws SQLException, ClassNotFoundException;

    public ObservableList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
    public ObservableList<SuplimentDTO> getAllSupliment() throws SQLException, ClassNotFoundException;
}
