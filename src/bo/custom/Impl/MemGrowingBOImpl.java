package bo.custom.Impl;

import bo.custom.MemGrowingBo;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.Impl.CustomerDAOImpl;
import dao.custom.Impl.MemGrowthDAOImpl;
import dao.custom.MemGrowthDAO;
import dto.CustomerDTO;
import dto.MemGrowthDTO;
import entity.Customer;
import entity.MemGrowth;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class MemGrowingBOImpl implements MemGrowingBo {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    MemGrowthDAO memGrowthDAO = (MemGrowthDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEMGROWTH);

    @Override
    public ObservableList<CustomerDTO> setValuesTocmb() throws SQLException, ClassNotFoundException {
        ArrayList<Customer>list = customerDAO.getAll();
        ObservableList<CustomerDTO>customerDTOS = FXCollections.observableArrayList();
        for (Customer customer: list) {
            customerDTOS.add(new CustomerDTO(
                    customer.getCustID()
            ));
        }
        return customerDTOS;
    }

    @Override
    public boolean AddGrowth(MemGrowthDTO a) throws SQLException, ClassNotFoundException {
        MemGrowth memGrowth = new MemGrowth(a.getGrID(),a.getGrCusId(),a.getGrdate(),a.getWeigth(),a.getHeight(),a.getWaist(),a.getThigh(),a.getArms(),a.getChest());
        return memGrowthDAO.add(memGrowth);
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        return memGrowthDAO.getLastId();
    }
}
