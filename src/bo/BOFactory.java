package bo;

import bo.custom.Impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    public BOFactory() {
    }
    public static BOFactory getInstance(){
        if (boFactory==null){
            boFactory= new BOFactory();
        }
        return boFactory;
    }
    public  enum BOTypes{
        ADDEQUIPMENT,ADDSUPLIMENT,ASSIGNWORKOUT,ATTENDANCEINSTRUCTOR,ATTENADNCEMEMBER,INSTRUCTOR,MAINFORM,MAKEWORKOUTDETAILS,MEMGROWING,PAYMENT,PLACEORDER,REGISTER,STOCK,SUPLIMENTORDER,MemForm;


    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case ADDEQUIPMENT:
                return new AddEquipmentBOImpl();
            case ADDSUPLIMENT:
                return new AddSuplimentBOImpl();
            case ASSIGNWORKOUT:
                return new AssignWorkOutBOImpl();
            case ATTENDANCEINSTRUCTOR:
                return new AttendanceInstructorBOImpl();
            case ATTENADNCEMEMBER:
                return new AttendanceMemberBOImpl();
            case INSTRUCTOR:
                return new InstructorBOImpl();
            case MAINFORM:
                return new MainFormBOImpl();
            case MAKEWORKOUTDETAILS:
                return new MakeWorkOutDetailsBOImpl();
            case MEMGROWING:
                return new MemGrowingBOImpl();
            case PAYMENT:
                return new PaymentBoImpl();
            case PLACEORDER:
                return new PlaceOrderBOImpl();
            case REGISTER:
                return new RegisterBOImpl();
            case SUPLIMENTORDER:
                return new SuplimentOrderBOImpl();
            case STOCK:
                return new StockFormBOImpl();
            case MemForm:
                return new MemberFormBOImpl();
            default:
                return null;
        }
    }
}
