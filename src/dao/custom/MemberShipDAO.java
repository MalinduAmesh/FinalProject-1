package dao.custom;

import dao.CrudDAO;
import entity.MemberShip;

import java.sql.SQLException;

public interface MemberShipDAO extends CrudDAO<MemberShip,String> {
    String getLastID() throws SQLException, ClassNotFoundException;
}
