package dao.custom;

import dao.CrudDAO;
import entity.Attendance;

import java.sql.SQLException;

public interface AttendaceDAO extends CrudDAO<Attendance,String> {
    String getLastID() throws SQLException, ClassNotFoundException;
}
