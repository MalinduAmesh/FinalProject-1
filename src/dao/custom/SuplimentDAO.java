package dao.custom;

import dao.CrudDAO;
import entity.Supliment;

import java.sql.SQLException;

public interface SuplimentDAO extends CrudDAO<Supliment,String> {
    public String getLastOrderID() throws SQLException, ClassNotFoundException;
}
