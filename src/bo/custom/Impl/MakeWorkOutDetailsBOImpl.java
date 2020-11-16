package bo.custom.Impl;

import bo.custom.MakeWorkOutDetailsBO;
import dao.DAOFactory;
import dao.custom.EquipmentDAO;
import dao.custom.Impl.EquipmentDAOImpl;
import dao.custom.Impl.ScheduleDAOImpl;
import dao.custom.Impl.ScheduleDetailsDAOImpl;
import dao.custom.ScheduleDAO;
import dao.custom.ScheduleDetailsDAO;
import db.DBConnection;
import dto.*;
import entity.Equipment;
import entity.Schedule;
import entity.ScheduleDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MakeWorkOutDetailsBOImpl implements MakeWorkOutDetailsBO {

    EquipmentDAO equipmentDAO = (EquipmentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EQUIPMENT);
    ScheduleDAO scheduleDAO = (ScheduleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SCHEDULE);
    ScheduleDetailsDAO scheduleDetailsDAO = (ScheduleDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SCHEDULEDETAILS);

    @Override
    public ObservableList<EquipmentDTO> getAllEquipment() throws SQLException, ClassNotFoundException {

        ArrayList<Equipment>equipmentArrayList = equipmentDAO.getAll();
        ObservableList<EquipmentDTO>list = FXCollections.observableArrayList();
        for (Equipment equipment:equipmentArrayList) {

            list.add(new EquipmentDTO(equipment.getEquipmentId()));

        }
        return list;
    }

    @Override
    public ObservableList<ScheduleDTO> getAllSchedule() throws SQLException, ClassNotFoundException {
        ArrayList<Schedule>list = scheduleDAO.getAll();

        ObservableList<ScheduleDTO>scheduleDTOS = FXCollections.observableArrayList();
        for (Schedule schedule:list) {

            scheduleDTOS.add(new ScheduleDTO(schedule.getSchId(),schedule.getSchGoal()));
            System.out.println(scheduleDTOS);
        }
        return scheduleDTOS;
    }

    @Override
    public EquipmentDTO setAllEquipmentsTotxt(String a) throws SQLException, ClassNotFoundException {
        Equipment equipment = equipmentDAO. search(a);
        return new EquipmentDTO(equipment.getEquipmentId(),equipment.getEquipmentName(),equipment.getEquipmentQty(),equipment.getEquipmentCost());
    }

    @Override
    public ScheduleDTO setAllSchudelsTotxt(String a) throws SQLException, ClassNotFoundException {
        Schedule schedule = scheduleDAO.search(a);
        return new ScheduleDTO(schedule.getSchId(),schedule.getSchGoal(),schedule.getSchType(),schedule.getSchLevel(),schedule.getSchDuration(),schedule.getSchPerWeek(),schedule.getSchPerTime());

    }

    @Override
    public String genarateSchLastID() throws SQLException, ClassNotFoundException {
        return scheduleDAO.getLastID();
    }

    @Override
    public boolean createSchedule(ScheduleDTO dto) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        Schedule schedule = new Schedule(dto.getSchId(),dto.getSchGoal(),dto.getSchType(),dto.getSchLevel(), dto.getSchDuration(),dto.getSchPerWeek(),dto.getSchPerTime());

        try {

            boolean isAdded = scheduleDAO.add(schedule);
            System.out.println("bug1");
            if(isAdded){
                System.out.println("bug2");
                for (ScheduleDetailsDTO detailsDTO:dto.getScheduleDetailsList()) {
                    boolean isCreateSch = scheduleDetailsDAO.add(new ScheduleDetails(detailsDTO.getEquId(),detailsDTO.getSchId()));
                    System.out.println("bug3");
                    if (!isCreateSch){
                        connection.rollback();
                        return false;
                    }



                }connection.commit();
                return true;

            }else {
                connection.rollback();
                return false;
            }



        }finally {
            connection.setAutoCommit(true);
        }

    }
}
