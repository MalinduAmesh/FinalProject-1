package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.RegisterDAO;
import entity.Register;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public boolean add(Register a) throws SQLException, ClassNotFoundException {
        String sql ="Insert Into register Values(?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getRegID(),a.getTraID(),a.getCusID(),a.getMemShip(),a.getRegStartDate(),a.getRegEndDate(),a.getRegFeeType(),a.getRegFee());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "Delete from register where regId ";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Register a) throws SQLException, ClassNotFoundException {
        String sql = "Update register set traId=?,cusId=?,memShip=?,startDate=?,endDate=?,regFeeType=?,regFee=? where regId =?";
        return CrudUtil.executeUpdate(sql,a.getTraID(),a.getCusID(),a.getMemShip(),a.getRegStartDate(),a.getRegEndDate(),a.getRegFeeType(),a.getRegFee(),a.getRegID());

    }

    @Override
    public Register search(String s) throws SQLException, ClassNotFoundException {
        String sql ="Select From register where regId =?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new Register(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Register> getAll() throws SQLException, ClassNotFoundException {
        String sql ="Select * from register";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Register>list = new ArrayList<>();

        while (rst.next()){
            list.add(new Register(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            ));
        }
        return list;
    }

    @Override
    public String getLastID() throws SQLException, ClassNotFoundException {

        String sql = "Select regId from register order BY regId desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next() ? rst.getString("regId") : null;


    }

}
