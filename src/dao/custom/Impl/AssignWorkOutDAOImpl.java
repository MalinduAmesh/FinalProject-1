package dao.custom.Impl;

import dao.AssignWorkOutDAO;
import dao.CrudUtil;
import dao.custom.AssignWorkOut;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssignWorkOutDAOImpl implements AssignWorkOutDAO {
    @Override
    public boolean add(AssignWorkOut s) throws SQLException, ClassNotFoundException {
        String sql ="Insert Into assignWorkout Values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,s.getAssWorkId(),s.getAssMemID(),s.getAssSchID(),s.getAssInDate(),s.getAssOutDate());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql ="Delete from assignWorkout where assWorkId = ? ";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(AssignWorkOut s) throws SQLException, ClassNotFoundException {
        String sql = "upadate assWorkId set memId =?,schId =?,assInDate=?,assOutDate=? where assWorkId=?";
        return CrudUtil.executeUpdate(sql,s.getAssWorkId(),s.getAssMemID(),s.getAssSchID(),s.getAssInDate(),s.getAssOutDate());

    }

    @Override
    public AssignWorkOut search(String s) throws SQLException, ClassNotFoundException {
        String sql ="Select * from assWorkId where assWorkId";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new AssignWorkOut(
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
    public ArrayList<AssignWorkOut> getAll() throws SQLException, ClassNotFoundException {
        String sql ="select * from assignWorkout";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<AssignWorkOut>list = new ArrayList<>();
         while (rst.next()){
             list.add(new AssignWorkOut(
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
        String sql ="select assWorkId from assignWorkout order BY assWorkId desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next()?rst.getString("assWorkId"):null;
    }
}
