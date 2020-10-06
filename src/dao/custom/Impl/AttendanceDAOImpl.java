package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.AttendaceDAO;
import entity.Attendance;
import entity.Schedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceDAOImpl implements AttendaceDAO {
    @Override
    public boolean add(Attendance a) throws SQLException, ClassNotFoundException {
        String sql = "Insert Into attendance Values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getAttendID(),a.getCustomerID(),a.getInstId(),a.getAttendDate(),a.getAttInTime());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql ="Delete from attendance where attId =?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Attendance a) throws SQLException, ClassNotFoundException {
        String sql ="Update attendance set cusId =?,traId=?,attInDate = ?,attInTime=? where attId = ?";
        return CrudUtil.executeUpdate(sql,a.getCustomerID(),a.getAttendDate(),a.getAttendID());
    }

    @Override
    public Attendance search(String s) throws SQLException, ClassNotFoundException {
        String sql ="Select * From attendance where attId =?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()) {
            return new Attendance(
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
    public ArrayList<Attendance> getAll() throws SQLException, ClassNotFoundException {
        String sql ="Select * From attendance";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Attendance>list =new ArrayList<>();
        while (rst.next()){
            list.add(new Attendance(
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
        String sql ="Select attId from attendance order BY attId desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next() ? rst.getString("attId") :null;
    }
}
