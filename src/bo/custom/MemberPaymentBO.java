package bo.custom;

import bo.SuperBO;
import dto.PaymentsDTO;
import javafx.collections.ObservableList;

public interface MemberPaymentBO extends SuperBO {

    public boolean addPayments(PaymentsDTO a);
    public boolean deletePayments(String s);
    public boolean updatePayments(PaymentsDTO a);
    public PaymentsDTO searchPayments();
    public ObservableList<PaymentsDTO> getAllPayments();


}
