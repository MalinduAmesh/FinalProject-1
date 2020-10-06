package bo.custom;

import bo.SuperBO;
import dto.ScheduleDTO;
import javafx.collections.ObservableList;

public interface MakeWorkOutBO extends SuperBO {

    public boolean seaarchWorkOut(String s);
    public ObservableList<ScheduleDTO> getAllMakeWorkOut();

}
