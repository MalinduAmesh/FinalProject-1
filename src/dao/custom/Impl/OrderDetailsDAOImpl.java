package dao.custom.Impl;

import dao.custom.OrderDetailsDAO;
import entity.OrderDetails;

import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean add(OrderDetails orderDetails) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(OrderDetails orderDetails) {
        return false;
    }

    @Override
    public OrderDetails search(String s) {
        return null;
    }

    @Override
    public ArrayList<OrderDetails> getAll() {
        return null;
    }
}
