package controller;

import bo.custom.AddEquipmentBO;
import bo.custom.Impl.AddEquipmentBOImpl;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.EquipmentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class EquipmentFormController {
    public JFXTextField txtTotalQty;
    public JFXTextField txtNowQty;
    public JFXTextField txtAvalQTY;
    public JFXTextField txtEquName;
    public JFXComboBox txtEquID;
    public Label lblImage;
    public JFXTextField txtID;

    @FXML
    private TableView<EquipmentDTO> tblEqupment;

    @FXML
    private TableColumn<EquipmentDTO, String> colID;

    @FXML
    private TableColumn<EquipmentDTO, String> colName;

    @FXML
    private TableColumn<EquipmentDTO, String> colQty;

    @FXML
    private TableColumn<EquipmentDTO, String> colOneItem;


    AddEquipmentBO addEquipmentBO = new AddEquipmentBOImpl();
    public void initialize() throws SQLException, ClassNotFoundException {

        colID.setCellValueFactory(new PropertyValueFactory<>("equipmentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("equipmentQty"));
        colOneItem.setCellValueFactory(new PropertyValueFactory<>("equipmentCost"));

        tblEqupment.setItems(loadAllTables());

    }

    private ObservableList<EquipmentDTO> loadAllTables() throws SQLException, ClassNotFoundException {
        ObservableList<EquipmentDTO> list = addEquipmentBO.getAllEqupment();
        ObservableList<EquipmentDTO> equipmentDTOS = FXCollections.observableArrayList();

        for (EquipmentDTO dto: list) {

            equipmentDTOS.add(
                    new EquipmentDTO(
                            dto.getEquipmentId(),
                            dto.getEquipmentName(),
                            dto.getEquipmentQty(),
                            dto.getEquipmentCost()
                    )
            );

        }

        return equipmentDTOS;
    }

    public void btnAddOnAction(MouseEvent mouseEvent) {




    }

    public void btnclearOnAction(MouseEvent mouseEvent) {



    }
}
