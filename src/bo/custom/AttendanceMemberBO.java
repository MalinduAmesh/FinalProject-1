package bo.custom;

import bo.SuperBO;
import dto.AttendanceDTO;
import dto.CustomerDTO;
import dto.InstructorDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface AttendanceMemberBO extends SuperBO {
    ObservableList<CustomerDTO> setValuesTocmb() throws SQLException, ClassNotFoundException;

    CustomerDTO setCusValuesTotxt(String toString) throws SQLException, ClassNotFoundException;

    ObservableList<InstructorDTO> setInsValuestotxt() throws SQLException, ClassNotFoundException;

    InstructorDTO setVlauesTotxt(String toString) throws SQLException, ClassNotFoundException;

    String getAttLastID() throws SQLException, ClassNotFoundException;

    boolean addMemAttandance(AttendanceDTO attendanceDTO) throws Exception;
}
