package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.InstAttandanceDAO;
import entity.InsAttendance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstAttandanceDAOImpl implements InstAttandanceDAO {
    @Override
    public boolean add(InsAttendance a) throws SQLException, ClassNotFoundException {
        String sql ="Insert Into attendanceInstructor Values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getInsAttID(),a.getInsID(),a.getInsAttInDate(),a.getInsAttInTime(),a.getInsAttOutTime());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql ="delete from attendanceInstructor where insAttId=?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(InsAttendance a) throws SQLException, ClassNotFoundException {
        String sql = "update attendanceInstructor  set traId=?,insAttInDate=?,insAttInTime=?,insAttOutTime=? where insAttId=? ";

        return CrudUtil.executeUpdate(sql,a.getInsID(),a.getInsAttInDate(),a.getInsAttInTime(),a.getInsAttOutTime(),a.getInsAttID());
    }

    @Override
    public InsAttendance search(String s) throws SQLException, ClassNotFoundException {
        String sql = "Select * from attendanceInstructor where insAttId =?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if(rst.next()){
            return new InsAttendance(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );

        }

        return null;
    }

    @Override
    public ArrayList<InsAttendance> getAll() throws SQLException, ClassNotFoundException {
        String sql ="Select * from attendanceInstructor";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<InsAttendance>list = new ArrayList<>();
        while (rst.next()){
            list.add(new InsAttendance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            ));

        }
        return list;
    }

    @Override
    public String getLastID() throws SQLException, ClassNotFoundException {
        String sql ="Select insAttId from attendanceInstructor order BY insAttId desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next()?rst.getString("insAttId"):null;
    }
}
