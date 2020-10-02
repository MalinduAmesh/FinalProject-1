package bo.custom;

import bo.SuperBO;
import dto.InstructorDTO;
import entity.Instructor;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InstructorBO extends SuperBO {


    ArrayList<InstructorDTO> setValuesToTable() throws SQLException, ClassNotFoundException;

    boolean addInstructors(InstructorDTO instructorDTO) throws SQLException, ClassNotFoundException;


    boolean updateInstructor(InstructorDTO instructorDTO) throws SQLException, ClassNotFoundException;

    boolean deleteInstructor(InstructorDTO instructorDTO) throws SQLException, ClassNotFoundException;
}
