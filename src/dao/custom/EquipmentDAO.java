package dao.custom;

import dao.CrudDAO;
import entity.Equipment;

import java.sql.SQLException;

public interface EquipmentDAO extends CrudDAO<Equipment,String> {

    Equipment searchName(String name) throws SQLException, ClassNotFoundException;
}
