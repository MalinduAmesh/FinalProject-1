package bo.custom;

import bo.SuperBO;
import dto.*;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface MakeWorkOutDetailsBO extends SuperBO {


    EquipmentDTO searchEquipment(String s) throws SQLException, ClassNotFoundException;
    boolean createSchedule(OrdersDTO dto) throws SQLException, ClassNotFoundException;

    String getLastId() throws SQLException, ClassNotFoundException;

    ObservableList<EquipmentDTO> getAllEquipments() throws SQLException, ClassNotFoundException;
    ObservableList<ScheduleDTO> getAllSchedule() throws SQLException, ClassNotFoundException;


}