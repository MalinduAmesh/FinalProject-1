package dao.custom;

import dao.CrudDAO;
import entity.InsAttendance;

import java.sql.SQLException;

public interface InstAttandanceDAO extends CrudDAO<InsAttendance,String> {
    String getLastID() throws SQLException, ClassNotFoundException;
}
