package dao.custom;

import dao.CrudDAO;
import entity.CustomEntity;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    String getLastID() throws SQLException, ClassNotFoundException;

    ArrayList<CustomEntity> lineChart() throws SQLException, ClassNotFoundException;
}
