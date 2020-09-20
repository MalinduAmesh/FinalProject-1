package bo.custom.Impl;

import bo.custom.AddSuplimentBo;
import dao.custom.Impl.SuplimentDAOImpl;
import dao.custom.SuplimentDAO;
import dto.SuplimentDTO;
import entity.Supliment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddSuplimentBOImpl implements AddSuplimentBo {

    SuplimentDAO suplimentDAO = new SuplimentDAOImpl();

    @Override
    public boolean addSupliment(SuplimentDTO a) throws SQLException, ClassNotFoundException {
        Supliment supliment = new Supliment(a.getSuplimId(),a.getSuplimName(),a.getSuplimQTY(),a.getSuplimCost());
        return suplimentDAO.add(supliment);
    }

    @Override
    public boolean deleteSupliment(String s) throws SQLException, ClassNotFoundException {
        return suplimentDAO.delete(s);

    }

    @Override
    public boolean updateSupliment(SuplimentDTO a) throws SQLException, ClassNotFoundException {

        Supliment supliment = new Supliment(a.getSuplimName(),a.getSuplimQTY(),a.getSuplimCost());
        return suplimentDAO.update(supliment);
    }

    @Override
    public SuplimentDTO searchSupliment(String s) throws SQLException, ClassNotFoundException {

        Supliment a =suplimentDAO.search(s);
        return new SuplimentDTO(a.getSuplimId(),a.getSuplimName(),a.getSuplimQTY(),a.getSuplimCost());

    }

    @Override
    public ObservableList<SuplimentDTO> getAllSupliment() throws SQLException, ClassNotFoundException {
        ArrayList<Supliment>list = suplimentDAO.getAll();
        ObservableList<SuplimentDTO> suplimentDTOS = FXCollections.observableArrayList();
        for (Supliment supliment:list) {
            suplimentDTOS.add(new SuplimentDTO(supliment.getSuplimId(),supliment.getSuplimName(),supliment.getSuplimQTY(),supliment.getSuplimCost()));


        }
        return suplimentDTOS;
    }


}
