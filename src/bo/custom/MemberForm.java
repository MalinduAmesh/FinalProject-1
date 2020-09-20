package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;

public interface MemberForm extends SuperBO {

    public CustomerDTO searchCustomer(String s);
    public ObservableList<CustomerDTO> getAllCustomer();
}
