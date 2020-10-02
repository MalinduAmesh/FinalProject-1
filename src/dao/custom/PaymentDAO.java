package dao.custom;

import dao.CrudDAO;
import entity.Payment;

import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<Payment,String> {
    String getLastID() throws SQLException, ClassNotFoundException;
}
