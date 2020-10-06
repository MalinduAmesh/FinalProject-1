package bo.custom.Impl;

import bo.custom.MemGrowingBo;
import dao.custom.CustomerDAO;
import dao.custom.Impl.CustomerDAOImpl;
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

    CustomerDAO customerDAO = new CustomerDAOImpl();


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
    public boolean AddGrowth(MemGrowthDTO memGrowthDTO) {
        MemGrowth memGrowth =
    }
}
