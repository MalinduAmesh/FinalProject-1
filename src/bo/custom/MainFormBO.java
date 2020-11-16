package bo.custom;

import bo.SuperBO;
import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MainFormBO extends SuperBO {

    ArrayList<CustomDTO> lineChart() throws SQLException, ClassNotFoundException;

    String getInstructorCount() throws SQLException, ClassNotFoundException;

    String getPayCount() throws SQLException, ClassNotFoundException;

    String getGenarlCount() throws SQLException, ClassNotFoundException;
}
