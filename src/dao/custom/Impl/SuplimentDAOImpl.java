package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.SuplimentDAO;
import entity.Supliment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SuplimentDAOImpl implements SuplimentDAO {
    @Override
    public boolean add(Supliment a) throws SQLException, ClassNotFoundException {
        String sql = "Insert Into supliment VALUES(?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getSuplimId(),a.getSuplimName(),a.getSuplimQTY(),a.getSuplimCost());

    }
 /*   name | supQty | supCost*/
    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "delete from supliment where supId =?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Supliment a) throws SQLException, ClassNotFoundException {

        String sql = "Update supliment set supQty =?,supCost =? where name =?";
        return CrudUtil.executeUpdate(sql,a.getSuplimQTY(),a.getSuplimCost(),a.getSuplimName());


    }

    @Override
    public Supliment search(String s) throws SQLException, ClassNotFoundException {
        String sql = "Select * from supliment where supId =?";
        ResultSet rst = CrudUtil.executeQuery(sql,s);

        if (rst.next()){
            return new Supliment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Supliment> getAll() throws SQLException, ClassNotFoundException {
        String sql = "Select * from supliment";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Supliment>list = new ArrayList<>();

        while (rst.next()){
            list.add(new Supliment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4)
            ));
        }
        return list;
    }


    @Override
    public String getLastOrderID() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM orders ORDER BY ordId DESC LIMIT 3";
        ResultSet rst = CrudUtil.executeQuery(sql);
        return rst.next() ? rst.getString("ordId"):null;
    }
}
