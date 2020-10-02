package dao.custom;

import dao.SuperDAO;
import entity.CustomEntity;
import entity.Register;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    CustomEntity searchAllRegCus(String a);

}
