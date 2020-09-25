package bo.custom.Impl;

import bo.custom.PlaceOrderBO;
import dao.custom.CustomerDAO;
import dao.custom.Impl.CustomerDAOImpl;
import dao.custom.Impl.OrderDAOImpl;
import dao.custom.Impl.OrderDetailsDAOImpl;
import dao.custom.Impl.SuplimentDAOImpl;
import dao.custom.OrderDetailsDAO;
import dao.custom.OrdersDAO;
import dao.custom.SuplimentDAO;
import db.DBConnection;
import dto.CustomerDTO;
import dto.OrderDetailsDTO;
import dto.OrdersDTO;
import dto.SuplimentDTO;
import entity.Customer;
import entity.OrderDetails;
import entity.Orders;
import entity.Supliment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderBOImpl implements PlaceOrderBO {

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
    public boolean purchaseOrder(OrdersDTO orderDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

       /* Orders o = new Orders();
        o.setOrdersID(orderDTO.getOrdersID());
        o.setOrdersCustomerID(orderDTO.getOrdersCustomerID());
        o.setOrdersDate(orderDTO.getOrdersDate());*/
        Orders orders = new Orders(orderDTO.getOrdersID(), orderDTO.getOrdersDate(),orderDTO.getOrdersCustomerID());
        System.out.println(orders);

        try {
            boolean isAddedOrder = ordersDAO.add(orders);
            System.out.println(isAddedOrder);

            if (isAddedOrder) {
                for (OrderDetailsDTO od : orderDTO.getAllOrderDetails()) {
                    boolean isAddedOrderDetail = orderDetailsDAO.add(new OrderDetails(orderDTO.getOrdersID(), od.getSuplimeID(), od.getOrederDetailQTY(), od.getOrederDetailUnitP()));
                    System.out.println(isAddedOrderDetail);

                    if (!isAddedOrderDetail) {
                        connection.rollback();
                        return false;
                    }
                }
                if (isAddedOrder) {
                    for (SuplimentDTO s : orderDTO.getSuplimentDetailList()) {
                        boolean isUpdatedSupliment = suplimentDAO.update(new Supliment( s.getSuplimId(),s.getSuplimName(), s.getSuplimQTY(), s.getSuplimCost()));
                        System.out.println(isUpdatedSupliment);

                        if (!isUpdatedSupliment) {
                            connection.rollback();
                            return false;
                        }
                    }
                    connection.commit();
                    return true;

                } else {
                    connection.rollback();
                    return false;
                }

            } else {
                connection.rollback();
                return false;
            }
        }catch (SQLException ex){
            connection.rollback();
            ex.printStackTrace();
            return false;
//
        }
        finally {
            connection.setAutoCommit(true);
        }

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
    