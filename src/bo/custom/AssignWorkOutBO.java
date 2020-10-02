package bo.custom;

import bo.SuperBO;
import dto.AssignWorkOutDTO;
import dto.CustomDTO;
import dto.CustomerDTO;
import dto.ScheduleDTO;
import entity.Schedule;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AssignWorkOutBO extends SuperBO {
    ArrayList<CustomerDTO> getAllMemID() throws SQLException, ClassNotFoundException;

    CustomerDTO setAllValuesTotxt(String toString) throws SQLException, ClassNotFoundException;

    ArrayList<ScheduleDTO> getAllSchID() throws SQLException, ClassNotFoundException;

    ScheduleDTO setSchValuesTotxt(String toString) throws SQLException, ClassNotFoundException;

    String getAssWorkLastID() throws SQLException, ClassNotFoundException;


    boolean addAssignWorkOut(AssignWorkOutDTO assignWorkOutDTO) throws SQLException, ClassNotFoundException;

    ArrayList<AssignWorkOutDTO> loadTable(String s) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> getAllMemSearchID() throws SQLException, ClassNotFoundException;
}
