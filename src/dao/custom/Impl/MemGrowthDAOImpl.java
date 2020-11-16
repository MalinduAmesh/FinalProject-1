package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.MemGrowthDAO;
import entity.MemGrowth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemGrowthDAOImpl implements MemGrowthDAO {
    @Override
    public boolean add(MemGrowth s) throws SQLException, ClassNotFoundException {
        String sql ="Insert Into growth Values(?,?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,s.getGrID(),s.getGrdate(),s.getGrCusId(),s.getWeigth(),s.getHeight(),s.getWaist(),s.getThigh(),s.getArms(),s.getChest());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(MemGrowth memGrowth) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public MemGrowth search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<MemGrowth> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        String sql ="Select grId from growth order by grId desc LIMIT 1";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        return resultSet.next()?resultSet.getString("grId"):null;
    }
}
