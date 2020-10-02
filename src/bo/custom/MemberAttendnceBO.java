package bo.custom;

import bo.SuperBO;
import dto.AttendanceDTO;
import dto.CustomerDTO;
import dto.InsAttendanceDTO;
import dto.InstructorDTO;
import entity.Attendance;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberAttendnceBO extends SuperBO {


    String getMemLastId() throws SQLException, ClassNotFoundException;

    String getInsLastID() throws SQLException, ClassNotFoundException;


    ArrayList<CustomerDTO> getAllMemID() throws SQLException, ClassNotFoundException;


    CustomerDTO setAllMemTotxt(String toString) throws SQLException, ClassNotFoundException;

    InstructorDTO setAllInsTotxt(String toString) throws SQLException, ClassNotFoundException;

    ArrayList<InstructorDTO> getAllInsID() throws SQLException, ClassNotFoundException;


    boolean addMemAttandance(AttendanceDTO attendanceDTO) throws SQLException, ClassNotFoundException;

    boolean addInstructor(InsAttendanceDTO insAttendanceDTO) throws SQLException, ClassNotFoundException;
}
