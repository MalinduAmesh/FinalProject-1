package dao.custom.Impl;

import com.sun.org.apache.bcel.internal.generic.Select;
import dao.CrudDAO;
import dao.CrudUtil;
import dao.custom.ScheduleDAO;
import entity.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleDAOImpl implements ScheduleDAO {
    @Override
    public boolean add(Schedule a) throws SQLException, ClassNotFoundException {
        String sql = "Insert Into schedule Values(?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getSchId(),a.getSchGoal(),a.getSchType(),a.getSchLevel(),a.getSchDuration(),a.getSchPerWeek(),a.getSchPerTime());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "Delete from schedule where schId;";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Schedule a) throws SQLException, ClassNotFoundException {
        String sql = "Update schedule set schGoal=?,schType = ?,schLevel =?,schDuration = ?,schPerWeek = ?,schPerTime =? where schId =?";
        return CrudUtil.executeUpdate(sql,a.getSchGoal(),a.getSchType(),a.getSchLevel(),a.getSchDuration(),a.getSchPerWeek(),a.getSchPerTime(),a.getSchId());

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
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)

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
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            ));
        }
        System.out.println(list);
        return list;
    }

    @Override
    public String getLastID() throws SQLException, ClassNotFoundException {
       String sql = "Select schId from schedule order BY schId desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next() ? rst.getString("schId") :null;
    }

    @Override
    public Schedule getGoalAll(String a) throws SQLException, ClassNotFoundException {
        String sql ="Select * from schedule where schGoal = ?";
        ResultSet rst = CrudUtil.executeQuery(sql,a);
            if (rst.next()){
                return new Schedule(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7)
                );
        }
        return null;
    }

}

