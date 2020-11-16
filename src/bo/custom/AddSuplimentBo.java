package bo.custom;

import bo.SuperBO;
import dto.SuplimentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddSuplimentBo extends SuperBO {

    public boolean addSupliment(SuplimentDTO a) throws SQLException, ClassNotFoundException;
    public  boolean deleteSupliment(String s) throws SQLException, ClassNotFoundException;
    public boolean updateSupliment(SuplimentDTO a) throws SQLException, ClassNotFoundException;
    public SuplimentDTO searchSupliment(String s) throws SQLException, ClassNotFoundException;
    public ObservableList<SuplimentDTO> getAllSupliment() throws SQLException, ClassNotFoundException;


    String getLastId() throws SQLException, ClassNotFoundException;
}
