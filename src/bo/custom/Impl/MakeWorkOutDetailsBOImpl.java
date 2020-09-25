package bo.custom.Impl;

import bo.custom.MakeWorkOutDetailsBO;
import dao.custom.EquipmentDAO;
import dao.custom.Impl.EquipmentDAOImpl;
import dao.custom.Impl.ScheduleDAOImpl;
import dao.custom.Impl.ScheduleDetailsDAOImpl;
import dao.custom.ScheduleDAO;
import dao.custom.ScheduleDetailsDAO;
import dto.*;
import entity.Equipment;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class MakeWorkOutDetailsBOImpl implements MakeWorkOutDetailsBO {

    EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
    ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
    ScheduleDetailsDAO scheduleDetailsDAO = new ScheduleDetailsDAOImpl();


    @Override
    public EquipmentDTO searchEquipment(String s) throws SQLException, ClassNotFoundException {
        Equipment a = equipmentDAO.searchName(s);
        return new EquipmentDTO(a.getEquipmentId(),a.getEquipmentName(),a.getEquipmentQty(),a.getEquipmentCost());
    }

    @Override
    public boolean createSchedule(OrdersDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {


        return null;
    }

    @Override
    public ObservableList<EquipmentDTO> getAllEquipments() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ObservableList<ScheduleDTO> getAllSchedule() throws SQLException, ClassNotFoundException {
        return null;
    }
}
