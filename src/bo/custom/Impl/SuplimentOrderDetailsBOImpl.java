package bo.custom.Impl;

import bo.custom.SuplimentOrderBO;
import bo.custom.SuplimentOrderDetailsBO;
import dao.custom.CustomerDAO;
import dao.custom.Impl.CustomerDAOImpl;
import dao.custom.Impl.OrderDAOImpl;
import dao.custom.Impl.OrderDetailsDAOImpl;
import dao.custom.Impl.SuplimentDAOImpl;
import dao.custom.OrderDetailsDAO;
import dao.custom.OrdersDAO;
import dao.custom.SuplimentDAO;
import dto.CustomerDTO;
import dto.OrdersDTO;
import dto.SuplimentDTO;
import entity.Customer;
import entity.Supliment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuplimentOrderDetailsBOImpl implements SuplimentOrderDetailsBO {

    SuplimentDAO suplimentDAO = new SuplimentDAOImpl();
    OrdersDAO ordersDAO = new OrderDAOImpl();
    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();


    @Override
    public SuplimentDTO searchSupliment(String s) throws SQLException, ClassNotFoundException {

        Supliment a = suplimentDAO.search(s);
        return new SuplimentDTO(a.getSuplimId(), a.getSuplimName(), a.getSuplimQTY(), a.getSuplimCost());
    }

    @Override
    public CustomerDTO searchCustomer(String s) throws SQLException, ClassNotFoundException {
        Customer a = customerDAO.search(s);
        return new CustomerDTO(a.getCustID(), a.getCustName());
    }

    @Override
    public boolean purchaseSupliment(OrdersDTO dto) {

        return false;
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        return suplimentDAO.getLastOrderID();
    }

    @Override
    public ObservableList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> list = customerDAO.getAll();
        ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList();
        for (Customer customer : list) {
            customerDTOS.add(new CustomerDTO(
                    customer.getCustID(),
                    customer.getCustName(),
                    customer.getCustNic(),
                    customer.getCustAddress(),
                    customer.getCustContact(),
                    customer.getCustDOB(),
                    customer.getCustGender(),
                    customer.getCustEmail()
            ));
        }
        return customerDTOS;
    }

    @Override
    public ObservableList<SuplimentDTO> getAllSupliment() throws SQLException, ClassNotFoundException {
        ArrayList<Supliment> list = suplimentDAO.getAll();
        ObservableList<SuplimentDTO> suplimentDTOS = FXCollections.observableArrayList();
        for (Supliment supliment: list) {
            suplimentDTOS.add(new SuplimentDTO(
                    supliment.getSuplimId(),
                    supliment.getSuplimName(),
                    supliment.getSuplimQTY(),
                    supliment.getSuplimCost()
            ));

            
        }
        return suplimentDTOS;
    }
}
    