package bo.custom.Impl;

import bo.custom.MemberAttendnceBO;
import dao.DAOFactory;
import dao.custom.*;
import dao.custom.Impl.*;
import dto.AttendanceDTO;
import dto.CustomerDTO;
import dto.InsAttendanceDTO;
import dto.InstructorDTO;
import entity.Attendance;
import entity.Customer;
import entity.InsAttendance;
import entity.Instructor;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberAttendanceBOImpl implements MemberAttendnceBO {

    AttendaceDAO attendaceDAO = (AttendaceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ATTENDANCE);
    InstAttandanceDAO instAttandanceDAO = (InstAttandanceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INSATTANDANCE);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    InstructorDAO instructorDAO = (InstructorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INSTRUCTOR);

    @Override
    public String getMemLastId() throws SQLException, ClassNotFoundException {
        return attendaceDAO.getLastID();
    }

    @Override
    public String getInsLastID() throws SQLException, ClassNotFoundException {

        return instAttandanceDAO.getLastID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllMemID() throws SQLException, ClassNotFoundException {
        ArrayList<Customer>list =customerDAO.getAll();
        ArrayList<CustomerDTO>customerDTOS = new ArrayList<>();
        for (Customer c:list) {
            customerDTOS.add(new CustomerDTO(
                    c.getCustID()
            ));
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO setAllMemTotxt(String q) throws SQLException, ClassNotFoundException {
        Customer customer = customerDAO.search(q);
        return new CustomerDTO(customer.getCustID(),customer.getCustName());
    }

    @Override
    public InstructorDTO setAllInsTotxt(String a) throws SQLException, ClassNotFoundException {
        Instructor instructor =instructorDAO.search(a);

        return new InstructorDTO(instructor.getInstructID(),instructor.getInstructName());
    }

    @Override
    public ArrayList<InstructorDTO> getAllInsID() throws SQLException, ClassNotFoundException {
        ArrayList<Instructor>list =instructorDAO.getAll();
        ArrayList<InstructorDTO>instructorDTOS = new ArrayList<>();
        for (Instructor a: list) {
            instructorDTOS.add(new InstructorDTO(
                    a.getInstructID(),
                    a.getInstructName()
            ));

        }
        return instructorDTOS;
    }

    @Override
    public boolean addMemAttandance(AttendanceDTO a) throws SQLException, ClassNotFoundException {
        Attendance attendance =new Attendance(a.getAttendID(),a.getCustomerID(),a.getAttendDate());
        return attendaceDAO.add(attendance);
    }

    @Override
    public boolean addInstructor(InsAttendanceDTO a) throws SQLException, ClassNotFoundException {
/*        InsAttendance insAttendance = new InsAttendance(a.getInsAttID(),a.getInsID(),a.getInsAttDate());
        return instAttandanceDAO.add(insAttendance);*/
        return false;
    }


}
