package bo.custom;

import bo.SuperBO;
import dto.AttendanceDTO;
import javafx.collections.ObservableList;

public interface MemberAttendnceBO extends SuperBO {

    public boolean addAttendance(AttendanceDTO a);
    public boolean deleteAttendance(String s);
    public boolean updateAttendance(AttendanceDTO a);
    public AttendanceDTO searchAttendance(String a);
    public ObservableList<AttendanceDTO> getAllAttendance();


}
