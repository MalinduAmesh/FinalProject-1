package bo.custom.Impl;

import bo.custom.StockFormBO;
import dao.DAOFactory;
import dao.custom.EquipmentDAO;
import dao.custom.Impl.EquipmentDAOImpl;
import dao.custom.Impl.SuplimentDAOImpl;
import dao.custom.SuplimentDAO;
import dto.EquipmentDTO;
import dto.SuplimentDTO;
import entity.Equipment;
import entity.Supliment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class StockFormBOImpl implements StockFormBO {
    SuplimentDAO suplimentDAO = (SuplimentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPLIMENT);
    EquipmentDAO equipmentDAO = (EquipmentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.EQUIPMENT);
    @Override
    public ObservableList<SuplimentDTO> loadSupliments() throws SQLException, ClassNotFoundException {
        ArrayList<Supliment>list = suplimentDAO.getAll();
        ObservableList<SuplimentDTO>suplimentDTOS = FXCollections.observableArrayList();
        for (Supliment supliment:list) {
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
    public ObservableList<EquipmentDTO> loadAllEquipment() throws SQLException, ClassNotFoundException {
        ArrayList<Equipment>list = equipmentDAO.getAll();
        ObservableList<EquipmentDTO>equipmentDTOS = FXCollections.observableArrayList();
        for (Equipment dto:list) {
            equipmentDTOS.add(new EquipmentDTO(
                    dto.getEquipmentId(),
                    dto.getEquipmentName(),
                    dto.getEquipmentQty(),
                    dto.getEquipmentCost()
            ));

        }
        return equipmentDTOS;
    }
}
