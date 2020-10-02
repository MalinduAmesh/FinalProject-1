package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.InvoiceDAO;
import entity.Invoice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDAOImpl implements InvoiceDAO {

    @Override
    public boolean add(Invoice a) throws SQLException, ClassNotFoundException {
        String sql = "Insert Into invoice Values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getInoId(),a.getInoDate(),a.getInoCus(),a.getInoPayId());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
         String sql ="Delete From invoice where inoId = ?";
         return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Invoice a) throws SQLException, ClassNotFoundException {
        String sql = "Update invoice set date =? ,cusId =?,payId=? where inoId = ?";
        return CrudUtil.executeUpdate(sql,a.getInoDate(),a.getInoCus(),a.getInoPayId(),a.getInoId());
    }


    @Override
    public Invoice search(String s) throws SQLException, ClassNotFoundException {
        String sql = "Select * invoice where inoId =?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new Invoice(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Invoice> getAll() throws SQLException, ClassNotFoundException {
        String sql ="Select * from invoice";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Invoice>list = new ArrayList<>();

        while (rst.next()){
            list.add(new Invoice(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            ));
        }
        return list;
    }

    @Override
    public String getLastOrderID() throws SQLException, ClassNotFoundException {
        String sql ="select inoId from invoice order BY inoId desc LIMIT 1";
        ResultSet rst = CrudUtil.executeQuery(sql);
        System.out.println(rst);
        return rst.next()?rst.getString("inoId"):null;
    }
}