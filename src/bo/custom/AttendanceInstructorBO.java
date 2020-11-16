package bo.custom;

import bo.SuperBO;
import dto.InsAttendanceDTO;
import dto.InstructorDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface AttendanceInstructorBO extends SuperBO {
    ObservableList<InstructorDTO> setValues() throws SQLException, ClassNotFoundException;

    InstructorDTO loadAllvaluesTotxt(String toString) throws SQLException, ClassNotFoundException;

    ObservableList<InsAttendanceDTO> setAttValuesTocmb() throws SQLException, ClassNotFoundException;

    InsAttendanceDTO setValuesTotxt(String toString) throws SQLException, ClassNotFoundException;

    String genarateAttID() throws SQLException, ClassNotFoundException;

    boolean markAttendance(InsAttendanceDTO insAttendanceDTO) throws SQLException, ClassNotFoundException;

    boolean updateAttendance(InsAttendanceDTO insAttendanceDTO) throws SQLException, ClassNotFoundException;
}
