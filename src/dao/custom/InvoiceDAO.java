package dao.custom;

import dao.CrudDAO;
import entity.Invoice;

import java.sql.SQLException;

public interface InvoiceDAO extends CrudDAO<Invoice,String> {
    String getLastOrderID() throws SQLException, ClassNotFoundException;
}
