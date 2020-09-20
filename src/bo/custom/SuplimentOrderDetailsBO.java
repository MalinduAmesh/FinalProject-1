package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.SuplimentDTO;
import javafx.collections.ObservableList;

public interface SuplimentOrderDetailsBO extends SuperBO {

    public SuplimentDTO searchSupliment(String s);
    public CustomerDTO searchCustomer(String s);
    public ObservableList<SuplimentDTO> getAllSupliments();
    public ObservableList<CustomerDTO> getAllCustomer();
    public boolean purchaseSupliment();

}
