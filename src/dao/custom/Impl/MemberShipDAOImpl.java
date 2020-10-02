package dao.custom.Impl;

import dao.CrudDAO;
import dao.CrudUtil;
import dao.custom.MemberShipDAO;
import entity.MemberShip;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberShipDAOImpl implements MemberShipDAO {
    @Override
    public boolean add(MemberShip a) throws SQLException, ClassNotFoundException {
        String sql =" Insert Into memberShip Values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getMemShipid(),a.getName(),a.getDuration(),a.getFee());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "Delete from memberShip where memShipid = ?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(MemberShip s) throws SQLException, ClassNotFoundException {
        String sql ="Update memberShip set name =? , duration = ?,fee = ? where memShipid= ?";
        return CrudUtil.executeUpdate(sql,s.getName(),s.getDuration(),s.getFee(),s.getMemShipid());
    }

    @Override
    public MemberShip search(String s) throws SQLException, ClassNotFoundException {
        String sql = "Select * from memberShip where memShipid = ?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new MemberShip(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<MemberShip> getAll() throws SQLException, ClassNotFoundException {
        String sql ="Select * from memberShip";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<MemberShip>list = new ArrayList<>();
        while (rst.next()){
            list.add(new MemberShip(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ));
        }
        return list;
    }

    @Override
    public String getLastID() throws SQLException, ClassNotFoundException {

        String sql = "Select memShipid From memberShip order BY memShipid desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next() ? rst.getString("memShipid") : null;

    }
}
