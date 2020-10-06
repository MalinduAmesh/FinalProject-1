package bo.custom.Impl;

import bo.custom.RegisterBO;
import dao.custom.*;
import dao.custom.Impl.*;
import db.DBConnection;
import dto.*;
import entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterBOImpl implements RegisterBO {

    RegisterDAO registerDAO = new RegisterDAOImpl();
    MemberShipDAO memberShipDAO = new MemberShipDAOImpl();
    CustomerDAO customerDAO = new CustomerDAOImpl();
    QueryDAO queryDAO = new QueryDAOImpl();
    InstructorDAO instructorDAO = new InstructorDAOImpl();

    @Override
    public String getLastCustomerCode() throws SQLException, ClassNotFoundException {

        return customerDAO.getLastID();
    }

    @Override
    public String getlastRegisterID() throws SQLException, ClassNotFoundException {
        return registerDAO.getLastID();
    }

    @Override
    public ArrayList<MemberShipDTO> getAllMemShip() throws SQLException, ClassNotFoundException {
        ArrayList<MemberShip> memberShip = memberShipDAO.getAll();
        ArrayList<MemberShipDTO> list = new ArrayList<>();

        for (MemberShip dto : memberShip) {
            list.add(new MemberShipDTO(dto.getMemShipid(), dto.getName(), dto.getDuration(), dto.getFee()));

        }
        return list;
    }
    @Override
    public ArrayList<InstructorDTO> getAllInstructorID() throws SQLException, ClassNotFoundException {
        ArrayList<Instructor>instructors =instructorDAO.getAll();
        ArrayList<InstructorDTO>instructorDTOS = new ArrayList<>();

        for (Instructor instructorDTO:instructors) {
            instructorDTOS.add(new InstructorDTO(instructorDTO.getInstructID(),instructorDTO.getInstructName(),instructorDTO.getInstructorNIC(),instructorDTO.getInstructGender(),instructorDTO.getInstructNumber(),instructorDTO.getInstrDOB(),instructorDTO.getInsStatus()));


        }
        return instructorDTOS;
    }

    @Override
    public InstructorDTO searchAllInstrutors(String a) throws SQLException, ClassNotFoundException {
        Instructor instructor= instructorDAO.search(a);
        return new InstructorDTO(instructor.getInstructID(),instructor.getInstructName());
    }

    @Override
    public MemberShipDTO searchMemShip(String a) throws SQLException, ClassNotFoundException {
        MemberShip memberShip = memberShipDAO.search(a);
        return new MemberShipDTO(memberShip.getMemShipid(), memberShip.getName(),memberShip.getFee());
    }

    @Override
    public CustomDTO searchAllCusReg(String a) {
        CustomEntity c = queryDAO.searchAllRegCus(a);
        return new CustomDTO(
                c.getCustID(), c.getCustName(), c.getCustNic(), c.getCustAddress(), c.getCustContact(), c.getCustDOB(), c.getCustGender(), c.getCustEmail(), c.getRegID(), c.getInstructID(), c.getMemShip(), c.getMemShipid(), c.getRegStartDate(), c.getRegEndDate(), c.getRegFeeType(), c.getRegFee());
      /*  ent.getCustID(),
                ent.getCustName(),
                ent.getCustNic(),
                ent.getCustAddress(),
                ent.getCustContact(),
                ent.getCustDOB(),
                ent.getCustGender(),
                ent.getCustEmail(),
                ent.getRegInsId(),
                ent.getRegInsId(),
                ent.getCustID(),
                ent.getReMmemShip(),
                ent.getRegStartDate(),
                ent.getRegEndDate(),
                ent.getRegFeeType(),
                ent.getRegFee()*/
    }

    @Override
    public ArrayList<RegisterDTO> getAllRegID() throws SQLException, ClassNotFoundException {
        ArrayList<Register> registers = registerDAO.getAll();
        ArrayList<RegisterDTO> registerDTOS = new ArrayList<>();

        for (Register ent : registers) {
            registerDTOS.add(new RegisterDTO(
                    ent.getRegID()
            ));
        }
        return registerDTOS;
    }

    @Override
    public boolean registerCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        Customer customer = new Customer(dto.getCustID(), dto.getCustName(), dto.getCustNic(), dto.getCustAddress(), dto.getCustContact(), dto.getCustDOB(), dto.getCustGender(), dto.getCustEmail());

        try {
            boolean isAddedCustomer = customerDAO.add(customer);
            System.out.println("Bug 1");
            if (isAddedCustomer) {
                System.out.println("Bug 2");
                Register register = new Register(dto.getRegID(),dto.getTraID(),dto.getCusID(), dto.getMemShip(),dto.getRegStartDate(),dto.getRegEndDate(),dto.getRegFeeType(),dto.getRegFee());

                boolean isRegistered = registerDAO.add(register);

                    if (!isRegistered) {
                        System.out.println("Bug 4");
                        connection.rollback();
                        return false;
                    }
                connection.commit();
                connection.setAutoCommit(true);
                return true;

            } else {
                connection.rollback();
                return false;
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }

        finally {
            connection.setAutoCommit(true);
        }
        
    }



}
