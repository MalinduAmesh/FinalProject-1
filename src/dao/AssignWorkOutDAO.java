package dao;

import dao.custom.AssignWorkOut;

import java.sql.SQLException;

public interface AssignWorkOutDAO extends CrudDAO<AssignWorkOut,String> {
    String getLastID() throws SQLException, ClassNotFoundException;
}
