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
        return CrudUtil.executeUpdate(sql,
                a.getInstructID(),
                a.getInstructName(),
                a.getInstructorNIC(),
                a.getInstructGender(),
                a.getInstructNumber(),
                a.getInstrDOB(),
                a.getInsStatus()
        );
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "Delete from instructor where traId =?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Instructor a) throws SQLException, ClassNotFoundException {
        String sql = "update instructor set traName = ?,nic = ?,tragender = ?,traContact =?,traDOB=?,traStatus=? where traId =?";
        return CrudUtil.executeUpdate(sql,
                a.getInstructName(),
                a.getInstructorNIC(),
                a.getInstructGender(),
                a.getInstructNumber(),
                a.getInstrDOB(),
                a.getInstructID(),
                a.getInsStatus()
        );
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
    public ArrayList<Instructor> getAll() throws SQLException, ClassNotFoundException {
        String sql = "Select * from instructor";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<Instructor>list = new ArrayList<>();
        while (rst.next()){
            list.add(new Instructor(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            ));
        }

        return list;
    }
}
