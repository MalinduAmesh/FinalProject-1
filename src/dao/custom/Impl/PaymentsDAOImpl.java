package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.PaymentsDAO;
import entity.Payments;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentsDAOImpl implements PaymentsDAO {
    @Override
    public boolean add(Payments a) throws SQLException, ClassNotFoundException {
        String sql ="Insert Into payments Values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getPayID(),a.getCustomerId(),a.getPayType(),a.getPayAmount(),a.getPayStatus());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String  sql ="Delete from payments where payId";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Payments a) throws SQLException, ClassNotFoundException {

        String sql ="Update payments set cusId =?,payType = ?,payAmount = ?,payStatus = ? where payId =?";
        return CrudUtil.executeUpdate(sql,a.getCustomerId(),a.getPayType(),a.getPayAmount(),a.getPayStatus(),a.getPayID());

    }

    @Override
    public Payments search(String s) throws SQLException, ClassNotFoundException {

        String sql = "Select * from payments where payId = ?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new Payments(
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
    public ArrayList<Payments> getAll() throws SQLException, ClassNotFoundException {

        String sql ="Select * from payments";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Payments>list = new ArrayList<>();

        while (rst.next()){
            list.add(new Payments(
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
