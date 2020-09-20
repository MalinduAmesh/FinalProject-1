package bo.custom;

import bo.SuperBO;
import dto.ScheduleDTO;
import javafx.collections.ObservableList;

public interface MakeWorkOutDetailsBO extends SuperBO {

    public boolean addMakeWorkOut(ScheduleDTO s);
    public boolean deleteWorkOut(String s);
    public boolean updateWorkOut(ScheduleDTO a);
    public ScheduleDTO searchWorkOut(String s);
    public ObservableList<ScheduleDTO> getAllWorkout();

}
