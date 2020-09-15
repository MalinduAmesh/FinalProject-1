package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.InstructorDAO;
import entity.Instructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorDAOImpl implements InstructorDAO {
    @Override
    public boolean add(Instructor a) throws SQLException, ClassNotFoundException {
        String sql = "Insert Into instructor values(?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,a.getInstructID(),a.getInstructName(),a.getInstructGender(),a.getInstructNumber(),a.getInstructJoinDate(),a.getInstructCost(),a.getInstructPayMonth());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "Delete from instructor where traId =?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Instructor a) throws SQLException, ClassNotFoundException {
        String sql = "update instructor set traName = ?,tragender = ?,traNum = ?,traJoinDate =?,traCost =?,traPayMonth =? where traId =?";
        return CrudUtil.executeUpdate(sql,a.getInstructName(),a.getInstructGender(),a.getInstructNumber(),a.getInstructJoinDate(),a.getInstructCost(),a.getInstructPayMonth(),a.getInstructID());
    }

    @Override
    public Instructor search(String s) throws SQLException, ClassNotFoundException {
        String sql = "Select * from instructor where traId =?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return new Instructor(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            );
        }
        return null;
    }

    @Override
    public ArrayList<Instructor> getAll() {
        return null;
    }
}
