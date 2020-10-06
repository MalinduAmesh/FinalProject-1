package bo.custom.Impl;

import bo.custom.AttendanceMemberBO;
import dao.custom.AttendaceDAO;
import dao.custom.CustomerDAO;
import dao.custom.Impl.AttendanceDAOImpl;
import dao.custom.Impl.CustomerDAOImpl;
import dao.custom.Impl.InstructorDAOImpl;
import dao.custom.InstructorDAO;
import dto.AttendanceDTO;
import dto.CustomerDTO;
import dto.InstructorDTO;
import entity.Attendance;
import entity.Customer;
import entity.Instructor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceMemberBOImpl implements AttendanceMemberBO {

    CustomerDAO customerDAO = new CustomerDAOImpl();
    InstructorDAO instructorDAO = new InstructorDAOImpl();
    AttendaceDAO attendaceDAO = new AttendanceDAOImpl();

    @Override
    public ObservableList<CustomerDTO> setValuesTocmb() throws SQLException, ClassNotFoundException {
        ArrayList<Customer>list = customerDAO.getAll();
        ObservableList<CustomerDTO>customerDTOS = FXCollections.observableArrayList();
        for (Customer customer:list) {
            customerDTOS.add(new CustomerDTO(
                    customer.getCustID()
            ));

        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO setCusValuesTotxt(String a) {
        Customer customer =null;
        CustomerDTO customerDTO =null;
        try {
           customer = customerDAO.search(a);
            customerDTO  =new CustomerDTO(customer.getCustID(), customer.getCustName());

        }catch (NullPointerException e){

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customerDTO;
    }

    @Override
    public ObservableList<InstructorDTO> setInsValuestotxt() throws SQLException, ClassNotFoundException {
        ArrayList<Instructor>list = instructorDAO.searchIns();
        ObservableList<InstructorDTO>instructorDTOS =FXCollections.observableArrayList();
        for (Instructor instructor:list) {
            instructorDTOS.add(new InstructorDTO(
                    instructor.getInstructID()
            ));

        }
        return instructorDTOS;
    }

    @Override
    public InstructorDTO setVlauesTotxt(String a){
        InstructorDTO instructorDTO =null;
        try {
            Instructor instructor = instructorDAO.search(a);
            instructorDTO =new InstructorDTO(instructor.getInstructID(), instructor.getInstructName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NullPointerException e){

        }
        return instructorDTO;
    }

    @Override
    public String getAttLastID() throws SQLException, ClassNotFoundException {
        return attendaceDAO.getLastID();
    }

    @Override
    public boolean addMemAttandance(AttendanceDTO a) throws Exception {
        Attendance attendance = new Attendance(a.getAttendID(),a.getCustomerID(),a.getInstId(),a.getAttendDate(),a.getAttInTime());
        boolean isAdded =attendaceDAO.add(attendance);

        if (isAdded){
            Instructor instructor=new Instructor(a.getInstId());

            instructorDAO.updateStatusOnly(instructor);

        }
        return true;
    }
}
