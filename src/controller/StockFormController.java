package controller;

import animatefx.animation.FadeIn;
import bo.BOFactory;
import bo.custom.Impl.StockFormBOImpl;
import bo.custom.StockFormBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import dto.EquipmentDTO;
import dto.SuplimentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class StockFormController {
    public JFXButton btnEqupment;
    public JFXButton btnProducts;
    public ImageView btnSearch;
    public JFXButton btnBack;
    public AnchorPane root;
    @FXML
    private TableView<EquipmentDTO> tblEquipment;

    @FXML
    private TableColumn<EquipmentDTO,String> colEquID;

    @FXML
    private TableColumn<EquipmentDTO,String> colEquName;

    @FXML
    private TableColumn<EquipmentDTO,String> colEquQty;

    @FXML
    private TableColumn<EquipmentDTO,String> colEquCost;

    @FXML
    private TableView<SuplimentDTO> tblSupliment;

    @FXML
    private TableColumn<SuplimentDTO,String> colSupID;

    @FXML
    private TableColumn<SuplimentDTO,String> colSupName;

    @FXML
    private TableColumn<SuplimentDTO,String> colSupQty;

    @FXML
    private TableColumn<SuplimentDTO,String> colSupCost;

    StockFormBO stockFormBO = (StockFormBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STOCK);

    public void initialize() throws SQLException, ClassNotFoundException {
        setSupliment();
        setEquipment();
    }

    private void setEquipment() throws SQLException, ClassNotFoundException {
        colEquID.setCellValueFactory(new PropertyValueFactory<>("equipmentId"));
        colEquName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        colEquQty.setCellValueFactory(new PropertyValueFactory<>("equipmentQty"));
        colEquCost.setCellValueFactory(new PropertyValueFactory<>("equipmentCost"));
        tblEquipment.setItems(laodAllEquipment());
    }

    private ObservableList<EquipmentDTO> laodAllEquipment() throws SQLException, ClassNotFoundException {
        ObservableList<EquipmentDTO>list = stockFormBO.loadAllEquipment();
        ObservableList<EquipmentDTO>equipmentDTOS = FXCollections.observableArrayList();
        for (EquipmentDTO dto :list) {
            equipmentDTOS.add(new EquipmentDTO(
                    dto.getEquipmentId(),
                    dto.getEquipmentName(),
                    dto.getEquipmentQty(),
                    dto.getEquipmentCost()
            ));

        }
        return list;
    }

    private void setSupliment() throws SQLException, ClassNotFoundException {
        colSupID.setCellValueFactory(new PropertyValueFactory<>("suplimId"));
        colSupName.setCellValueFactory(new PropertyValueFactory<>("suplimName"));
        colSupQty.setCellValueFactory(new PropertyValueFactory<>("suplimQTY"));
        colSupCost.setCellValueFactory(new PropertyValueFactory<>("suplimCost"));
        tblSupliment.setItems(loadSupliment());


    }

    private ObservableList<SuplimentDTO> loadSupliment() throws SQLException, ClassNotFoundException {
        ObservableList<SuplimentDTO>suplimentDTOS =stockFormBO.loadSupliments();
        ObservableList<SuplimentDTO>dtos = FXCollections.observableArrayList();
        for (SuplimentDTO suplimentDTO:suplimentDTOS) {
            dtos.add(new SuplimentDTO(
                    suplimentDTO.getSuplimId(),
                    suplimentDTO.getSuplimName(),
                    suplimentDTO.getSuplimQTY(),
                    suplimentDTO.getSuplimCost()
            ));

        }
        return suplimentDTOS;
    }

    public void btnEqupmentOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/AddEquipmentForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();

    }

    public void btnProductsOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/AddSuplimentForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();
    }

    public void btnSearchOnAction(MouseEvent mouseEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/StockForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }
}
