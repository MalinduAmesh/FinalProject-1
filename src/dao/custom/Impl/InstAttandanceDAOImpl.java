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
        String sql ="Insert Into insAttendance Values(?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getInsAttID(),a.getInsID(),a.getInsAttDate());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql ="delete from insAttendance where attId=?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(InsAttendance a) throws SQLException, ClassNotFoundException {
        String sql = "update insAttendance  set traId=?,attDate=? where attId=? ";
        return CrudUtil.executeUpdate(a.getInsID(),a.getInsAttDate(),a.getInsAttID());
    }

    @Override
    public InsAttendance search(String s) throws SQLException, ClassNotFoundException {
        String sql = "Select * from insAttendance where attId =?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if(rst.next()){
            return new InsAttendance(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );

        }

        return null;
    }

    @Override
    public ArrayList<InsAttendance> getAll() throws SQLException, ClassNotFoundException {
        String sql ="Select * from insAttendance";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<InsAttendance>list = new ArrayList<>();
        while (rst.next()){
            list.add(new InsAttendance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            ));

        }
        return list;
    }

    @Override
    public String getLastID() throws SQLException, ClassNotFoundException {
        String sql ="Select attId from insAttendance order BY attId desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next()?rst.getString("attId"):null;
    }
}
