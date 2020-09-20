package bo.custom;

import bo.SuperBO;
import dto.EquipmentDTO;
import javafx.collections.ObservableList;

public interface AddEquipmentBO extends SuperBO {
    public boolean addEqupment(EquipmentDTO a) ;
    public boolean deleteEquipment(String s);
    public boolean updateEquipment(EquipmentDTO a);
    public EquipmentDTO searchEqupment(String s);
    public ObservableList<EquipmentDTO> getAllEqupment();

}
