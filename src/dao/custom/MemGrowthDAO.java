package dao.custom;

import dao.CrudDAO;
import entity.MemGrowth;

import java.sql.SQLException;

public interface MemGrowthDAO extends CrudDAO<MemGrowth,String> {
    String getLastId() throws SQLException, ClassNotFoundException;
}
