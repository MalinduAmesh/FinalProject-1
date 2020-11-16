package dao;

import db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrudUtil {

    private static PreparedStatement getPreparedStatement(String sql,Object...params) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i <params.length ; i++) {
            pstm.setObject((i+1),params[i]);

        }
        return pstm;
    }
    public static boolean executeUpdate(String sql,Object...params) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = getPreparedStatement(sql, params);
        return pstm.executeUpdate() >0;
    }
    public static ResultSet executeQuery(String sql,Object...params) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = getPreparedStatement(sql, params);
        return pstm.executeQuery();
    }
    ArrayList a = new ArrayList();
}
