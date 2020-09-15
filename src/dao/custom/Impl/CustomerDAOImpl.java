package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer s) throws SQLException, ClassNotFoundException {
        String sql ="Insert Into customer Values(?,?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,s.getCustID(),s.getCustName(),s.getCustAddress(),s.getCustContact(),s.getCustDate(),s.getCustGender(),s.getCustEmail(),s.getCustWeigth(),s.getCustHeight());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql ="Delete From customer where cusId =?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Customer s) throws SQLException, ClassNotFoundException {
        String sql ="Update customer set cusName =?,address = ?,contact = ?,dob = ?,gender =?,email =?,weigth = ?,height = ? where cusId =?";
        return CrudUtil.executeUpdate(sql,s.getCustName(),s.getCustAddress(),s.getCustContact(),s.getCustDate(),s.getCustGender(),s.getCustEmail(),s.getCustWeigth(),s.getCustHeight(),s.getCustID());
    }

    @Override
    public Customer search(String s) throws SQLException, ClassNotFoundException {
        String sql ="Select * From customer where cusId =?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)

            );
        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        String sql ="Select * from customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Customer>list = new ArrayList<>();
        while (rst.next()){
            list.add(new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)

            ));
        }
        return list;
    }
}
