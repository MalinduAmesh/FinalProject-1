package dao.custom.Impl;

import dao.CrudDAO;
import dao.CrudUtil;
import dao.custom.ScheduleDAO;
import dao.custom.ScheduleDetailsDAO;
import entity.ScheduleDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScheduleDetailsDAOImpl implements ScheduleDetailsDAO {
    @Override
    public boolean add(ScheduleDetails s) throws SQLException, ClassNotFoundException {
        String sql ="Insert into scheduleDetails Values(?,?)";
        return CrudUtil.executeUpdate(sql,s.getEquId(),s.getSchId());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "Delete from scheduleDetails where equId = ?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(ScheduleDetails s) throws SQLException, ClassNotFoundException {
        String sql = "Update scheduleDetails set schId =? where equId = ?";
        return CrudUtil.executeUpdate(sql,s.getSchId(),s.getEquId());
    }

    @Override
    public ScheduleDetails search(String s) throws SQLException, ClassNotFoundException {
        String sql = "Select * from scheduleDetails where equId = ?";
        ResultSet rst = CrudUtil.executeQuery(sql, s);
        if (rst.next()){
            return  new ScheduleDetails(
                    rst.getString(1),
                    rst.getString(2)
            );
        }
            return null;
    }

    @Override
    public ArrayList<ScheduleDetails> getAll() throws SQLException, ClassNotFoundException {
        String sql = "Select * from scheduleDetails";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<ScheduleDetails>list = new ArrayList<>();
        while (rst.next()){
            list.add(new ScheduleDetails(
                    rst.getString(1),
                    rst.getString(2)
            ));
        }

        return list;
    }
}
