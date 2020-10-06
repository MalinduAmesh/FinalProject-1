package dao.custom.Impl;

import dao.custom.MemGrowthDAO;
import entity.MemGrowth;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemGrowthDAOImpl implements MemGrowthDAO {
    @Override
    public boolean add(MemGrowth memGrowth) throws SQLException, ClassNotFoundException {
        return false;
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
}
