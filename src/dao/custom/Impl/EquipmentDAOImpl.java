package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.EquipmentDAO;
import entity.Attendance;
import entity.Equipment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipmentDAOImpl implements EquipmentDAO {
    @Override
    public boolean add(Equipment s) throws SQLException, ClassNotFoundException {
        String sql ="Insert Into equipment Values (?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,s.getEquipmentId(),s.getEquipmentName(),s.getEquipmentImage(),s.getEquipmentQty(),s.getEquipmentCost());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql ="delete from equipment where equId = ?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Equipment a) throws SQLException, ClassNotFoundException {
        String sql ="update equipment set name = ?,image = ?,equQty = ?,equCost = ? where equId =?";
        return CrudUtil.executeUpdate(sql,a.getEquipmentName(),a.getEquipmentImage(),a.getEquipmentQty(),a.getEquipmentQty(),a.getEquipmentId());

    }

    @Override
    public Equipment search(String s) throws SQLException, ClassNotFoundException {
        String sql ="Select * from equipment where equId =?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new Equipment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Equipment> getAll() throws SQLException, ClassNotFoundException {
        String sql ="Select * from equipment";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Equipment>list = new ArrayList<>();
        while (rst.next()){
            list.add(new Equipment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            ));
        }
        return list;
    }
}
