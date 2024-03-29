package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.CustomEntity;
import entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer s) throws SQLException, ClassNotFoundException {
        String sql ="Insert Into customer Values(?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,s.getCustID(),s.getCustName(),s.getCustNic(),s.getCustAddress(),s.getCustContact(),s.getCustDOB(),s.getCustGender(),s.getCustEmail());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql ="Delete From customer where cusId =?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Customer s) throws SQLException, ClassNotFoundException {
        String sql ="Update customer set cusName =?,nic = ?,address = ?,contact = ?,dob = ?,gender =?,email =? where cusId =?";
        return CrudUtil.executeUpdate(sql,s.getCustName(),s.getCustNic(),s.getCustAddress(),s.getCustContact(),s.getCustDOB(),s.getCustGender(),s.getCustEmail(),s.getCustID());
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
                    rst.getString(8)
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
                    rst.getString(8)
            ));
        }

        return list;
    }

    @Override
    public String getLastID() throws SQLException, ClassNotFoundException {
/*
        String sql = "Select memShipid From memberShip order BY memShipid desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next() ? rst.getString("memShipid") : null;
*/

        String sql ="Select cusId From customer order BY cusId desc LIMIT 1";
        ResultSet rsr = CrudUtil.executeQuery(sql);
        return rsr.next() ? rsr.getString("cusId") : null;
    }
 //   SELECT id, password, COUNT(id) AS count FROM users WHERE email = :email LIMIT 1";
    @Override
    public ArrayList<CustomEntity> lineChart() throws SQLException, ClassNotFoundException {
        String sql = "Select cusId,count(*)as count from customer where email =? LIMIT 1";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        ArrayList<CustomEntity>list = new ArrayList<>();
        while (resultSet.next()){
            list.add(new CustomEntity(
                    resultSet.getString(1),
                    resultSet.getString(2)
            ));
        }
        return list;
    }
}
/*
[14:45, 10/2/2020] Bahashana: public ArrayList<CustomChartEntity> chart() throws Exception {

        String sql="select CheckInDate,count(*)from staffattendance where checkintime<'08:30:57' group by checkindate";
        ResultSet rst=CrudUtil.executeQuery(sql);
        ArrayList<CustomChartEntity> chart=new ArrayList<>();

        while (rst.next()){

        chart.add(new CustomChartEntity(rst.getString(1),rst.getInt(2)));
        }
        return chart;
        }*/
