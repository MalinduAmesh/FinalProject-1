package bo.custom.Impl;

import bo.custom.PlaceOrderBO;
import dao.custom.*;
import dao.custom.Impl.*;
import db.DBConnection;
import dto.*;
import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    SuplimentDAO suplimentDAO = new SuplimentDAOImpl();
    InvoiceDAO invoiceDAO = new InvoiceDAOImpl();
    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    PaymentDAO paymentDAO = new PaymentDAOImpl();


    @Override
    public SuplimentDTO searchSupliment(String s) throws SQLException, ClassNotFoundException {

        Supliment a = suplimentDAO.search(s);
        return new SuplimentDTO(a.getSuplimId(), a.getSuplimName(), a.getSuplimQTY(), a.getSuplimCost());
    }

    @Override
    public CustomerDTO searchCustomer(String s) throws SQLException, ClassNotFoundException {
        Customer a = customerDAO.search(s);
        return new CustomerDTO(a.getCustID(), a.getCustName(), a.getCustContact(), a.getCustEmail());
    }

    @Override
    public boolean purchaseOrder(PaymentDTO pay) throws SQLException, ClassNotFoundException {
    Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        System.out.println("debug1");

    boolean isPaid = paymentDAO.add(new Payment(
            pay.getPayId(),
            pay.getPayType(),
            pay.getPayAmount(),
            pay.getStatus()
    ));
        System.out.println("Check1");
        System.out.println(pay);
        try {

        if (isPaid) {
            boolean isAdded =false;
            for (InvoiceDTO dto : pay.getInvoiceDTOS()) {
                Invoice invoice = new Invoice(
                        dto.getInoId(),
                        dto.getInoDate(),
                        dto.getInoCus(),
                        dto.getInoPayId()
                );
                System.out.println("Gib Check :"+pay.getInvoiceDTOS());
                isAdded = invoiceDAO.add(invoice);

                System.out.println("Check2");
                System.out.println(dto);

                if (!isAdded) {
                    connection.rollback();
                    return false;

                }
                //System.out.println("Check22");

            }       //System.out.println("Check222");
            if (isAdded) {
                System.out.println("Check33"+pay.getOrderDetailsDTOS());
                boolean isAddedOrderDetail = false;
                for (OrderDetailsDTO dto1 : pay.getOrderDetailsDTOS()) {
                    OrderDetails orderDetails = new OrderDetails(
                            dto1.getOrderDetailID(),
                            dto1.getSuplimeID(),
                            dto1.getOrederDetailQTY(),
                            dto1.getOrederDetailUnitP()
                    );

                    isAddedOrderDetail = orderDetailsDAO.add(orderDetails);

                    System.out.println("Check3");
                    System.out.println(dto1);

                    if (!isAddedOrderDetail) {
                        connection.rollback();
                        return false;
                    }
                }
                if (isAddedOrderDetail) {
                    for (SuplimentDTO sup : pay.getSuplimentDTOS()) {
                        boolean isUpdateSuplimet = suplimentDAO.update(new Supliment(
                                sup.getSuplimId(),
                                sup.getSuplimName(),
                                sup.getSuplimQTY(),
                                sup.getSuplimCost()
                        ));
                        System.out.println("Check4");
                        System.out.println(sup);

                        if (!isUpdateSuplimet) {
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
        } else {
            connection.rollback();
            return false;
        }
    }catch (SQLException e){
        e.printStackTrace();
        return false;
    }finally {
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
        for (Supliment supliment : list) {
            suplimentDTOS.add(new SuplimentDTO(
                    supliment.getSuplimId(),
                    supliment.getSuplimName(),
                    supliment.getSuplimQTY(),
                    supliment.getSuplimCost()
            ));


        }
        return suplimentDTOS;
    }

    @Override
    public String getLastPayID() throws SQLException, ClassNotFoundException {
        return invoiceDAO.getLastOrderID();
    }

    @Override
    public String genaratePayID() throws SQLException, ClassNotFoundException {
        return paymentDAO.getLastID();
    }
}
  /*   /Invoice invoice = new Invoice(
                invoiceDTO.getInoId(),
                invoiceDTO.getInoDate(),
                invoiceDTO.getInoCus(),
                invoiceDTO.getInoPayId());

        System.out.println(invoice);
        boolean isAddedOrder = invoiceDAO.add(invoice);
        try {
            System.out.println("debug2");
            if (isAddedOrder) {
                for (OrderDetailsDTO od : invoiceDTO.getOrderDetailsDTOS()) {

                   boolean isAddedOrderDetail = orderDetailsDAO.add(new OrderDetails(
                                    od.getOrderDetailID(),
                                    od.getSuplimeID(),
                                    od.getOrederDetailQTY(),
                                    od.getOrederDetailUnitP()
                   ));
                    System.out.println(isAddedOrderDetail);

                   // boolean isAddedOrderDetail = orderDetailsDAO.add(orderDetails);

                    if (!isAddedOrderDetail) {
                        connection.rollback();
                        return false;
                    }
                    System.out.println("debug3");
                }
                if (isAddedOrder) {
                    for (SuplimentDTO s : invoiceDTO.getSuplimentDTOS()) {
                        boolean isUpdatedSupliment = suplimentDAO.update(new Supliment(

                                s.getSuplimId(),
                                s.getSuplimName(),
                                s.getSuplimQTY(),
                                s.getSuplimCost()));

                        System.out.println(isUpdatedSupliment);

                        if (!isUpdatedSupliment) {
                            connection.rollback();
                            return false;
                        }
                    }if (isAddedOrder){
                        for (PaymentDTO paymentDTO :invoiceDTO.getPaymentDTOS()){
                            boolean isPaid = paymentDAO.add(new Payment(
                                    paymentDTO.getPayId(),
                                    paymentDTO.getPayType(),
                                    paymentDTO.getPayAmount(),
                                    paymentDTO.getStatus()
                            ));
                            System.out.println(isPaid);
                            if (!isPaid){
                                connection.rollback();
                                return false;
                            }
                        }
                        connection.commit();
                        return true;
                    }else {
                        connection.rollback();
                        return false;
                    }

                } else {
                    connection.rollback();
                    return false;
                }

            } else {
                connection.rollback();
                return false;
            }
        } catch (SQLException ex) {
            connection.rollback();
            ex.printStackTrace();
            return false;
//
         } finally {
            connection.setAutoCommit(true);
        }
*/