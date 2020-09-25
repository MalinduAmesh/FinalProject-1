package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.OrderDetailsDAO;
import entity.OrderDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean add(OrderDetails a) throws SQLException, ClassNotFoundException {
        String sql = "Insert Into orderDetail Values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getOrderDetailID(),a.getSuplimeID(),a.getOrederDetailQTY(),a.getOrederDetailUnitP());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql ="delete from orderDetail where ordId";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(OrderDetails a) throws SQLException, ClassNotFoundException {
        String sql = "Update orderDetail set supId = ?,qty = ?,unitPrice =? where ordId =?";
        return CrudUtil.executeUpdate(sql,a.getSuplimeID(),a.getOrederDetailQTY(),a.getOrederDetailUnitP(),a.getOrderDetailID());

    }

    @Override
    public OrderDetails search(String s) throws SQLException, ClassNotFoundException {
        String sql =" Select * From orderDetail where ordId =?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new OrderDetails(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {

        String sql = "Select * From orderDetail";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<OrderDetails>list = new ArrayList<>();
        while (rst.next()){
            list.add(new OrderDetails(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4)
            ));
        }
        return list;
    }
}
