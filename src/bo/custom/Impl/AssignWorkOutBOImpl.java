package bo.custom.Impl;

import bo.custom.AssignWorkOutBO;
import dao.AssignWorkOutDAO;
import dao.DAOFactory;
import dao.custom.AssignWorkOut;
import dao.custom.CustomerDAO;
import dao.custom.Impl.AssignWorkOutDAOImpl;
import dao.custom.Impl.CustomerDAOImpl;
import dao.custom.Impl.ScheduleDAOImpl;
import dao.custom.ScheduleDAO;
import dto.AssignWorkOutDTO;
import dto.CustomDTO;
import dto.CustomerDTO;
import dto.ScheduleDTO;
import entity.CustomEntity;
import entity.Customer;
import entity.Schedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class AssignWorkOutBOImpl implements AssignWorkOutBO {

    AssignWorkOutDAO assignWorkOutDAO = (AssignWorkOutDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ASSIGNWORK);
    CustomerDAO customerDAO = new CustomerDAOImpl();
    ScheduleDAO scheduleDAO = new ScheduleDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllMemID() throws SQLException, ClassNotFoundException {
        ArrayList<Customer>list = customerDAO.getAll();
        ArrayList<CustomerDTO>customerDTOS = new ArrayList<>();
        for (Customer customer:list) {
            customerDTOS.add(new CustomerDTO(
                    customer.getCustID()
            ));

        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO setAllValuesTotxt(String a) throws SQLException, ClassNotFoundException {
        Customer customer = customerDAO.search(a);
        return new CustomerDTO(customer.getCustID(),customer.getCustName());

    }

    @Override
    public ArrayList<ScheduleDTO> getAllSchID() throws SQLException, ClassNotFoundException {
        ArrayList<Schedule>list = scheduleDAO.getAll();
        ArrayList<ScheduleDTO> scheduleDTOS =new ArrayList<>();
        for (Schedule schedule:list) {
            scheduleDTOS.add(new ScheduleDTO(
                    schedule.getSchGoal()
            ));

        }
        return scheduleDTOS;
    }

    @Override
    public ScheduleDTO setSchValuesTotxt(String a) throws SQLException, ClassNotFoundException {
        Schedule schedule = scheduleDAO.getGoalAll(a);
        return new  ScheduleDTO(schedule.getSchGoal(),schedule.getSchDuration());
    }

    @Override
    public String getAssWorkLastID() throws SQLException, ClassNotFoundException {
        return assignWorkOutDAO.getLastID();
    }

    @Override
    public boolean addAssignWorkOut(AssignWorkOutDTO a) throws SQLException, ClassNotFoundException {
        AssignWorkOut assignWorkOutDTO = new AssignWorkOut(a.getAssWorkId(),a.getAssMemID(),a.getAssSchID(),a.getAssInDate(),a.getAssOutDate());
        return assignWorkOutDAO.add(assignWorkOutDTO);

    }

    @Override
    public ArrayList<AssignWorkOutDTO> loadTable(String s) throws SQLException, ClassNotFoundException {
        ArrayList<AssignWorkOut>list = assignWorkOutDAO.search(s);
        ObservableList<AssignWorkOutDTO>assignWorkOutDTOS = FXCollections.observableArrayList();
        for (AssignWorkOut dto:list) {
            assignWorkOutDTOS.add(new AssignWorkOutDTO(
                    dto.getAssWorkId(),
                    dto.getAssMemID(),
                    dto.getAssSchID(),
                    dto.getAssInDate(),
                    dto.getAssOutDate()
            ));
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllMemSearchID() throws SQLException, ClassNotFoundException {
        ArrayList<Customer>list = customerDAO.getAll();
        ArrayList<CustomerDTO>customerDTOS = new ArrayList<>();
        for (Customer customer:list) {
            customerDTOS.add(new CustomerDTO(
                    customer.getCustID()
            ));
        }
        return customerDTOS;
    }

    @Override
    public ObservableList<AssignWorkOutDTO> loadTableForm() throws SQLException, ClassNotFoundException {
        ArrayList<AssignWorkOut>list = assignWorkOutDAO.getAll();
        ObservableList<AssignWorkOutDTO>assignWorkOutDTOS=FXCollections.observableArrayList();
        for (AssignWorkOut assignWorkOut:list) {
            assignWorkOutDTOS.add(new AssignWorkOutDTO(
                    assignWorkOut.getAssMemID(),
                    assignWorkOut.getAssSchID(),
                    assignWorkOut.getAssInDate(),
                    assignWorkOut.getAssOutDate()
            ));

        }
        return assignWorkOutDTOS;
    }


    public ArrayList<AssignWorkOutDTO> loadTable() throws SQLException, ClassNotFoundException {
        ArrayList<AssignWorkOut>list = assignWorkOutDAO.getAll();
        ObservableList<AssignWorkOutDTO>assignWorkOutDTOS = FXCollections.observableArrayList();
        for (AssignWorkOut dto:list) {
            assignWorkOutDTOS.add(new AssignWorkOutDTO(
                    dto.getAssWorkId(),
                    dto.getAssMemID(),
                    dto.getAssSchID(),
                    dto.getAssInDate(),
                    dto.getAssOutDate()
            ));
        }
        return null;
    }
}
