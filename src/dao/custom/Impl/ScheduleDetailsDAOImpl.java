package dao.custom.Impl;

import dao.CrudDAO;
import dao.CrudUtil;
import dao.custom.ScheduleDetailsDAO;
import entity.ScheduleDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleDetailsDAOImpl implements ScheduleDetailsDAO {
    @Override
    public boolean add(ScheduleDetails scheduleDetails) throws SQLException, ClassNotFoundException {
        String sql ="Insert Into scheduleDetails Values(?,?)";
        return CrudUtil.executeUpdate(sql,scheduleDetails.getEquId(),scheduleDetails.getSchId());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ScheduleDetails scheduleDetails) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ScheduleDetails search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<ScheduleDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
