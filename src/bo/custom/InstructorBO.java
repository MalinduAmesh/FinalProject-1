package bo.custom;

import bo.SuperBO;
import dto.InstructorDTO;
import entity.Instructor;
import javafx.collections.ObservableList;

public interface InstructorBO extends SuperBO {

    public boolean addInstructor(InstructorDTO a);
    public boolean deleteInstructor(String s);
    public boolean updateInstructor(Instructor a);
    public InstructorDTO searchInstructor(String s);
    public ObservableList<InstructorDTO> getAllInstructor();


}
