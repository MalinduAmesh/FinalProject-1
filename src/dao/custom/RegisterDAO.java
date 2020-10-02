package dao.custom;

import dao.CrudDAO;
import entity.Register;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RegisterDAO extends CrudDAO<Register,String> {
    String getLastID() throws SQLException, ClassNotFoundException;

}
