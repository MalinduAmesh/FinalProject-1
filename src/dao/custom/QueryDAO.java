package dao.custom;

import dao.SuperDAO;
import dto.CustomDTO;
import entity.CustomEntity;
import entity.Register;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    CustomEntity searchAllRegCus(String a);

    ArrayList<CustomEntity> loadCustomerPayments() throws SQLException, ClassNotFoundException;
}
