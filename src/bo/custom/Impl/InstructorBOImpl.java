package bo.custom.Impl;

import bo.custom.InstructorBO;
import dao.custom.Impl.InstructorDAOImpl;
import dao.custom.InstructorDAO;
import dto.InstructorDTO;
import entity.Instructor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorBOImpl implements InstructorBO {

    InstructorDAO instructorDAO = new InstructorDAOImpl();

    @Override
    public ArrayList<InstructorDTO> setValuesToTable() throws SQLException, ClassNotFoundException {
        ArrayList<Instructor>list = instructorDAO.getAll();
        ArrayList<InstructorDTO>instructorDTOS = new ArrayList<>();
        for (Instructor instructor:list) {
            instructorDTOS.add(new InstructorDTO(
                    instructor.getInstructID(),
                    instructor.getInstructName(),
                    instructor.getInstructGender(),
                    instructor.getInstructNumber(),
                    instructor.getInstrDOB()
            ));
            
        }
        return instructorDTOS;
    }

    @Override
    public boolean addInstructors(InstructorDTO t) throws SQLException, ClassNotFoundException {
        Instructor instructor = new Instructor(t.getInstructID(),t.getInstructName(),t.getInstructorNIC(),t.getInstructGender(),t.getInstructNumber(),t.getInstrDOB(),t.getInsStatus());
        return instructorDAO.add(instructor);
    }

    @Override
    public boolean updateInstructor(InstructorDTO a) throws SQLException, ClassNotFoundException {
        Instructor instructor = new Instructor(a.getInstructID(),a.getInstructName(),a.getInstructorNIC(),a.getInstructGender(),a.getInstructNumber(),a.getInstrDOB(),a.getInsStatus());
        return instructorDAO.update(instructor);
    }

    @Override
    public boolean deleteInstructor(InstructorDTO a) throws SQLException, ClassNotFoundException {
        Instructor instructor = new Instructor(a.getInstructID(),a.getInstructName(),a.getInstructorNIC(),a.getInstructGender(),a.getInstructNumber(),a.getInstrDOB(),a.getInsStatus());
        return instructorDAO.delete(a.getInstructID());
    }
}
