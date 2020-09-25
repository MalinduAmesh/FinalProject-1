package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.OrdersDTO;
import dto.SuplimentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {


    SuplimentDTO searchSupliment(String s) throws SQLException, ClassNotFoundException;
     CustomerDTO searchCustomer(String s) throws SQLException, ClassNotFoundException;
     boolean purchaseOrder(OrdersDTO dto) throws SQLException, ClassNotFoundException;
     String getLastId() throws SQLException, ClassNotFoundException;

     ObservableList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
     ObservableList<SuplimentDTO> getAllSupliment() throws SQLException, ClassNotFoundException;
}
