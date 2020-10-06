package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.InvoiceDTO;
import dto.PaymentDTO;
import dto.SuplimentDTO;
import entity.Invoice;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {


    SuplimentDTO searchSupliment(String s) throws SQLException, ClassNotFoundException;
     CustomerDTO searchCustomer(String s) throws SQLException, ClassNotFoundException;
     boolean purchaseOrder(PaymentDTO dto) throws SQLException, ClassNotFoundException;
     String getLastId() throws SQLException, ClassNotFoundException;

     ObservableList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;
     ObservableList<SuplimentDTO> getAllSupliment() throws SQLException, ClassNotFoundException;

    String getLastPayID() throws SQLException, ClassNotFoundException;

    String genaratePayID() throws SQLException, ClassNotFoundException;
}
