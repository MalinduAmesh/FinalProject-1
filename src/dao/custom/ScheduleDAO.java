package dao.custom;

import dao.CrudDAO;
import entity.Schedule;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ScheduleDAO extends CrudDAO<Schedule,String> {
    String getLastID() throws SQLException, ClassNotFoundException;

    Schedule getGoalAll(String a) throws SQLException, ClassNotFoundException;
}
