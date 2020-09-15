package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.OrdersDAO;
import entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrdersDAO {
    @Override
    public boolean add(Orders a) throws SQLException, ClassNotFoundException {
        String sql = "Insert Into orders Values(?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getOrdersID(),a.getOrdersDate(),a.getOrdersCustomerID());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
         String sql ="Delete From orders where ordId = ?";
         return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Orders a) throws SQLException, ClassNotFoundException {
        String sql = "Update orders set date =? ,cusId =? where ordId = ?";
        return CrudUtil.executeUpdate(sql,a.getOrdersDate(),a.getOrdersCustomerID(),a.getOrdersID());

    }

    @Override
    public Orders search(String s) throws SQLException, ClassNotFoundException {
        String sql = "Select * orders where ordId =?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new Orders(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Orders> getAll() throws SQLException, ClassNotFoundException {
        String sql ="Select * from orders";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Orders>list = new ArrayList<>();

        while (rst.next()){
            list.add(new Orders(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            ));
        }
        return list;
    }
}
