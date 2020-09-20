package bo.custom;

import bo.SuperBO;
import dto.RegisterDTO;
import javafx.collections.ObservableList;

public interface RegisterBO extends SuperBO {

    public boolean addRegister(RegisterDTO a);
    public boolean deleteRegister(String s);
    public boolean updateRegister(RegisterDTO a);
    public RegisterDTO searchRegister(String s);
    public ObservableList<RegisterDTO> getAllRegister();
}
