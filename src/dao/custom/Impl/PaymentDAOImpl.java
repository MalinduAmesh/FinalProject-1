package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.PaymentDAO;
import entity.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean add(Payment a) throws SQLException, ClassNotFoundException {
        String sql ="Insert Into payments Values(?,?,?,?)";
       return CrudUtil.executeUpdate(sql,a.getPayId(),a.getPayType(),a.getPayAmount(),a.getStatus());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String  sql ="Delete from payments where payId";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Payment a) throws SQLException, ClassNotFoundException {
        String sql ="Update payments set paytype =?,payAmount = ?,status = ? where payId =?";
        return CrudUtil.executeUpdate(sql,a.getPayType(),a.getPayAmount(),a.getStatus(),a.getPayId());
    }

    @Override
    public Payment search(String s) throws SQLException, ClassNotFoundException {

        String sql = "Select * from payments where payId = ?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new Payment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {

        String sql ="Select * from payments";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Payment>list = new ArrayList<>();

        while (rst.next()){
            list.add(new Payment(
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
        String sql ="Select payId from payments order BY payId desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next()?rst.getString("payId"):null;
    }
}
