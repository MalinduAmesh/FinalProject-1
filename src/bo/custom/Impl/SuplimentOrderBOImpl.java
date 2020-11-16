package bo.custom.Impl;

import bo.custom.SuplimentOrderBO;
import dao.DAOFactory;
import dao.custom.Impl.QueryDAOImpl;
import dao.custom.QueryDAO;
import dto.CustomDTO;
import entity.CustomEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class SuplimentOrderBOImpl implements SuplimentOrderBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERYDAO);
    @Override
    public ObservableList<CustomDTO> loadTables() throws SQLException, ClassNotFoundException {
        ArrayList<CustomEntity>list = queryDAO.loadCustomerPayments();
        ObservableList<CustomDTO>customDTOS = FXCollections.observableArrayList();
        for (CustomEntity customEntity:list) {
            customDTOS.add( new CustomDTO(

                    customEntity.getCustID(),
                    customEntity.getSchGoal(),
                    customEntity.getAssWorkId(),
                    customEntity.getAssInDate(),
                    customEntity.getAssOutDate()
            ));
        }
        return customDTOS;
    }

}
