package controller;

import bo.BOFactory;
import bo.custom.Impl.SuplimentOrderBOImpl;
import bo.custom.SuplimentOrderBO;
import dto.CustomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class SuplimentOrderFormController {
    public AnchorPane root;
    @FXML
    private TableView<CustomDTO> tblOrders;

    @FXML
    private TableColumn<CustomDTO,String> colOrderId;

    @FXML
    private TableColumn<CustomDTO,String> colOrdCusName;

    @FXML
    private TableColumn<CustomDTO,String> colSuplimentName;

    @FXML
    private TableColumn<CustomDTO,String> colOrdDate;

    @FXML
    private TableColumn<CustomDTO,String> colSuplimentTotal;

    SuplimentOrderBO suplimentOrderBO = (SuplimentOrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPLIMENTORDER);

    public void initialize() throws SQLException, ClassNotFoundException {
        setCusValues();
        loadTable();
    }

    private void setCusValues() throws SQLException, ClassNotFoundException {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        colOrdCusName.setCellValueFactory(new PropertyValueFactory<>("schGoal"));
        colSuplimentName.setCellValueFactory(new PropertyValueFactory<>("assWorkId"));
        colOrdDate.setCellValueFactory(new PropertyValueFactory<>("assInDate"));
        colSuplimentTotal.setCellValueFactory(new PropertyValueFactory<>("assOutDate"));
        tblOrders.setItems(loadTable());
    }

    private ObservableList<CustomDTO> loadTable() throws SQLException, ClassNotFoundException {
        ObservableList<CustomDTO>customDTOS =suplimentOrderBO.loadTables();
        ObservableList<CustomDTO>dtos = FXCollections.observableArrayList();
        for (CustomDTO customDTO:customDTOS) {
            dtos.add(new CustomDTO(

                    customDTO.getCustID(),
                    customDTO.getSchGoal(),
                    customDTO.getAssWorkId(),
                    customDTO.getAssInDate(),
                    customDTO.getAssOutDate()
            ));

        }
        return customDTOS;
    }

    public void sellOnAction(MouseEvent mouseEvent) throws IOException {

        root.getChildren().clear();
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("../view/SuplimentOrderDetailsForm.fxml"));
        root.getChildren().setAll(anchorPane.getChildren());
    }
}
