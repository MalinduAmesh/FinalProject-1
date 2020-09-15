package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.ScheduleDAO;
import entity.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public boolean add(Schedule a) throws SQLException, ClassNotFoundException {
        String sql = "Insert Into schedule Values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getSchedulID(),a.getSchedulName(),a.getEquipID(),a.getSchedulAddTime(),a.getSchedulDuration());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "Delete from schedule where schId;";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Schedule a) throws SQLException, ClassNotFoundException {
        String sql = "Update schedule set schName =?,equId =?,schAddTime = ?,schAddMon =? where schId =?";
        return CrudUtil.executeUpdate(sql,a.getSchedulName(),a.getEquipID(),a.getSchedulAddTime(),a.getSchedulDuration(),a.getSchedulID());

    }

    @Override
    public Schedule search(String s) throws SQLException, ClassNotFoundException {
        String sql ="Select * from schedule where schId=?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new Schedule(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }

        return null;
    }

    @Override
    public ArrayList<Schedule> getAll() throws SQLException, ClassNotFoundException {
        String sql ="Select * from schedule";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Schedule>list = new ArrayList<>();

        while (rst.next()){
            list.add(new Schedule(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            ));
        }
        return list;
    }
}
