package bo.custom.Impl;

import bo.custom.AttendanceInstructorBO;
import dao.custom.Impl.InstAttandanceDAOImpl;
import dao.custom.Impl.InstructorDAOImpl;
import dao.custom.InstAttandanceDAO;
import dao.custom.InstructorDAO;
import dto.InsAttendanceDTO;
import dto.InstructorDTO;
import entity.InsAttendance;
import entity.Instructor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceInstructorBOImpl implements AttendanceInstructorBO {

    InstructorDAO instructorDAO = new InstructorDAOImpl();
    InstAttandanceDAO instAttandanceDAO = new InstAttandanceDAOImpl();

    @Override
    public ObservableList<InstructorDTO> setValues() throws SQLException, ClassNotFoundException {
        ArrayList<Instructor>list = instructorDAO.getAll();
        ObservableList<InstructorDTO>instructorDTOS = FXCollections.observableArrayList();
        for (Instructor instructor:list) {
            instructorDTOS.add(new InstructorDTO(
                    instructor.getInstructID()
            ));

        }
        return instructorDTOS;
    }

    @Override
    public InstructorDTO loadAllvaluesTotxt(String a) throws SQLException, ClassNotFoundException {
        Instructor instructor =instructorDAO.search(a);
        return new InstructorDTO(instructor.getInstructID(),instructor.getInstructName());
    }

    @Override
    public ObservableList<InsAttendanceDTO> setAttValuesTocmb() throws SQLException, ClassNotFoundException {
        ArrayList<InsAttendance>list =instAttandanceDAO.getAll();
        ObservableList<InsAttendanceDTO>insAttendanceDTOS =FXCollections.observableArrayList();
        for (InsAttendance insAttendance:list) {
            insAttendanceDTOS.add(new InsAttendanceDTO(
                    insAttendance.getInsAttID()
            ));

        }
        return insAttendanceDTOS;
    }

    @Override
    public InsAttendanceDTO setValuesTotxt(String a) throws SQLException, ClassNotFoundException {
        InsAttendance insAttendance = instAttandanceDAO.search(a);
        return new InsAttendanceDTO(
                insAttendance.getInsAttID(),
                insAttendance.getInsID(),
                insAttendance.getInsAttInTime(),
                insAttendance.getInsAttInDate());
    }

    @Override
    public String genarateAttID() throws SQLException, ClassNotFoundException {
        return instAttandanceDAO.getLastID();
    }

    @Override
    public boolean markAttendance(InsAttendanceDTO a) throws SQLException, ClassNotFoundException {

        InsAttendance insAttendance = new InsAttendance(a.getInsAttID(),a.getInsID(),a.getInsAttInDate(),
                a.getInsAttInTime(),a.getInsAttOutTime());
               return instAttandanceDAO.add(insAttendance);
    }

    @Override
    public boolean updateAttendance(InsAttendanceDTO a) throws SQLException, ClassNotFoundException {
        InsAttendance insAttendance = new InsAttendance(a.getInsAttID(),a.getInsID(),a.getInsAttInDate(),
                a.getInsAttInTime(),a.getInsAttOutTime());
        return instAttandanceDAO.update(insAttendance);
    }

}
