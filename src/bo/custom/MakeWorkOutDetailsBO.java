package bo.custom;

import bo.SuperBO;
import dto.*;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MakeWorkOutDetailsBO extends SuperBO {


    ObservableList<EquipmentDTO> getAllEquipment() throws SQLException, ClassNotFoundException;

    ObservableList<ScheduleDTO> getAllSchedule() throws SQLException, ClassNotFoundException;


    EquipmentDTO setAllEquipmentsTotxt(String a) throws SQLException, ClassNotFoundException;

    ScheduleDTO setAllSchudelsTotxt(String toString) throws SQLException, ClassNotFoundException;

    String genarateSchLastID() throws SQLException, ClassNotFoundException;

    boolean createSchedule(ScheduleDTO dto) throws SQLException, ClassNotFoundException;
}