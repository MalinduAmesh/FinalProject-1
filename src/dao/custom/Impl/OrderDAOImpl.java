package dao.custom.Impl;

import dao.custom.OrdersDAO;
import entity.Orders;

import java.util.ArrayList;

public class OrderDAOImpl implements OrdersDAO {
    @Override
    public boolean add(Orders orders) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(Orders orders) {
        return false;
    }

    @Override
    public Orders search(String s) {
        return null;
    }

    @Override
    public ArrayList<Orders> getAll() {
        return null;
    }
}
