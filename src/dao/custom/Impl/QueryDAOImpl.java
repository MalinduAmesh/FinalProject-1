package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.QueryDAO;
import entity.CustomEntity;
import entity.Register;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public CustomEntity searchAllRegCus(String a) {
        return null;
    }

    @Override
    public ArrayList<CustomEntity> loadCustomerPayments() throws SQLException, ClassNotFoundException {
        String sql ="select i.inoId,c.cusName,p.status,i.date,p.payAmount from customer c,invoice i, payments p where (c.cusId=i.cusId && i.payId=p.payId)";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ArrayList<CustomEntity>list = new ArrayList<>();

        while (rst.next()){
            list.add(new CustomEntity(
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
