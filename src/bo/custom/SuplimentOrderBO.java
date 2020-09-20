package bo.custom;

import bo.SuperBO;
import dto.SuplimentDTO;
import javafx.collections.ObservableList;

public interface SuplimentOrderBO extends SuperBO {

    public SuplimentDTO searchSuplimentOrder(String s);
    public ObservableList<SuplimentDTO> getAllSupliments();

}
