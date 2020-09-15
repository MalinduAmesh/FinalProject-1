package dao.custom.Impl;

import dao.custom.PaymentsDAO;
import entity.Payments;

import java.util.ArrayList;

public class PaymentsDAOImpl implements PaymentsDAO {
    @Override
    public boolean add(Payments payments) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(Payments payments) {
        return false;
    }

    @Override
    public Payments search(String s) {
        return null;
    }

    @Override
    public ArrayList<Payments> getAll() {
        return null;
    }
}
