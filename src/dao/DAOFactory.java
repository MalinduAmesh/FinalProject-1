package dao;

import dao.custom.Impl.*;
import org.omg.CORBA.PUBLIC_MEMBER;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public DAOFactory() {
    }
    public static DAOFactory getInstance(){
        if (daoFactory ==null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes{
        ATTENDANCE,CUSTOMER,EQUIPMENT,INSATTANDANCE,INSTRUCTOR,INVOICE,MEMBERSHIP,MEMGROWTH,ORDERDETAILS,PAYMENT,QUERYDAO,REGISTER,SCHEDULE,SCHEDULEDETAILS,SUPLIMENT,ASSIGNWORK;

    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case ATTENDANCE:
                return new AttendanceDAOImpl();
            case CUSTOMER:
                return  new CustomerDAOImpl();
            case EQUIPMENT:
                return new EquipmentDAOImpl();
            case INSATTANDANCE:
                return new InstAttandanceDAOImpl();
            case INSTRUCTOR:
                return new InstructorDAOImpl();
            case INVOICE:
                return new InvoiceDAOImpl();
            case MEMBERSHIP:
                return new MemberShipDAOImpl();
            case MEMGROWTH:
                return new MemGrowthDAOImpl();
            case ORDERDETAILS:
                return new OrderDetailsDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
            case REGISTER:
                return new RegisterDAOImpl();
            case SCHEDULE:
                return new ScheduleDAOImpl();
            case SCHEDULEDETAILS:
                return new ScheduleDetailsDAOImpl();
            case SUPLIMENT:
                return new SuplimentDAOImpl();
            case ASSIGNWORK:
                return new AssignWorkOutDAOImpl();
            default:
                return null;
        }
    }
}
