package dao.custom;

import dao.CrudDAO;
import entity.Instructor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InstructorDAO extends CrudDAO<Instructor,String> {
    Instructor searchIns(String a) throws SQLException, ClassNotFoundException;

    ArrayList<Instructor> searchIns() throws SQLException, ClassNotFoundException;

    public boolean updateStatusOnly(Instructor id) throws  Exception;

    String getCount() throws SQLException, ClassNotFoundException;

    String getLastId() throws SQLException, ClassNotFoundException;
}
