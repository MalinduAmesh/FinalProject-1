package bo.custom;

import bo.SuperBO;
import dto.*;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RegisterBO extends SuperBO {

    
    String getLastCustomerCode() throws SQLException, ClassNotFoundException;

    String getlastRegisterID() throws SQLException, ClassNotFoundException;

    ArrayList<MemberShipDTO> getAllMemShip() throws SQLException, ClassNotFoundException;

    MemberShipDTO searchMemShip(String toString) throws SQLException, ClassNotFoundException;

    CustomDTO searchAllCusReg(String toString);

    ArrayList<RegisterDTO> getAllRegID() throws SQLException, ClassNotFoundException;

    boolean registerCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<InstructorDTO> getAllInstructorID() throws SQLException, ClassNotFoundException;

    InstructorDTO searchAllInstrutors(String toString) throws SQLException, ClassNotFoundException;
}
