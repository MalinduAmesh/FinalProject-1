package bo.custom.Impl;

import bo.custom.PaymentBo;
import dao.custom.CustomerDAO;
import dao.custom.Impl.CustomerDAOImpl;
import dao.custom.Impl.PaymentDAOImpl;
import dao.custom.PaymentDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentBoImpl implements PaymentBo {
    PaymentDAO paymentDAO = new PaymentDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public String getLastPayID() throws SQLException, ClassNotFoundException {
        return paymentDAO.getLastID();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomerID() throws SQLException, ClassNotFoundException {
        ArrayList<Customer>list = customerDAO.getAll();
        ArrayList<CustomerDTO>customerDTOS = new ArrayList<>();
        for (Customer customer:list) {
            customerDTOS.add(new CustomerDTO(
                    customer.getCustID(),
                    customer.getCustName()
            ));

        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO setAllMemVAluesTotxt(String a) throws SQLException, ClassNotFoundException {
        Customer customer = customerDAO.search(a);
        return new CustomerDTO(customer.getCustID(),customer.getCustName());
    }
}
