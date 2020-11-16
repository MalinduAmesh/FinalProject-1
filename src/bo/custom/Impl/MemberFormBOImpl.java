package bo.custom.Impl;

import bo.custom.MemberFormBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.Impl.CustomerDAOImpl;
import dto.CustomerDTO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberFormBOImpl implements MemberFormBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public CustomerDTO searchAllMemeName() {
        return null;
    }

    @Override
    public ObservableList<CustomerDTO> loadTables() throws SQLException, ClassNotFoundException {
        ArrayList<Customer>list = customerDAO.getAll();
        System.out.println("BUG1234");
        ObservableList<CustomerDTO>customerDTOS = FXCollections.observableArrayList();
        for (Customer dto:list) {
            customerDTOS.add(new CustomerDTO(
                  dto.getCustID(),
                  dto.getCustName(),
                  dto.getCustContact(),
                  dto.getCustEmail(),
                  dto.getCustContact(),
                  dto.getCustDOB()

            ));
            System.out.println(dto);

        }
        return customerDTOS;
    }
}
