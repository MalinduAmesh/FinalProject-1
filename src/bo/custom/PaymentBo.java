package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PaymentBo extends SuperBO {
    String getLastPayID() throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> getAllCustomerID() throws SQLException, ClassNotFoundException;


    CustomerDTO setAllMemVAluesTotxt(String toString) throws SQLException, ClassNotFoundException;
}
