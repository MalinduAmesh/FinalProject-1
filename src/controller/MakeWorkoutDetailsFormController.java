package controller;

import animatefx.animation.*;
import bo.custom.Impl.MakeWorkOutDetailsBOImpl;
import bo.custom.MakeWorkOutDetailsBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.custom.EquipmentDAO;
import dao.custom.Impl.EquipmentDAOImpl;
import dao.custom.Impl.ScheduleDAOImpl;
import dao.custom.Impl.ScheduleDetailsDAOImpl;
import dao.custom.ScheduleDAO;
import dao.custom.ScheduleDetailsDAO;
import dto.CustomDTO;
import dto.EquipmentDTO;
import dto.ScheduleDTO;
import dto.ScheduleDetailsDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MakeWorkoutDetailsFormController {

    public AnchorPane root;
    MakeWorkOutDetailsBO makeWorkOutDetailsBO = new MakeWorkOutDetailsBOImpl();


    public JFXTextField txtEquCost;
    public JFXTextField txtEquQty;
    public JFXTextField txtEquName;
    public JFXTextField txtEquID;
    public JFXButton btnAddCart;
    public JFXTextField txtSchType;
    public JFXTextField txtSchWeek;
    public JFXTextField txtschGoal;
    public JFXTextField txtSchTime;
    public JFXTextField txtSchDuration;
    public JFXTextField txtSchLevel;
    public Label lblSchID;
    public JFXButton btnremoveCart;
    public JFXComboBox cmbEquID;
    public JFXButton btnPay;
    public JFXButton btnClear;
    public JFXComboBox cmbSchID;

    @FXML
    private TableView<CustomDTO> tblSchDetails;

    @FXML
    private TableColumn<CustomDTO, String> colID;

    @FXML
    private TableColumn<CustomDTO, String> colEquName;

    @FXML
    private TableColumn<CustomDTO, String> colEquPrice;

    @FXML
    private TableColumn<CustomDTO, String> colSchName;

    public void initialize() throws SQLException, ClassNotFoundException {

        genateSchID();
        setValuesToSchedulecmb();
        setValuesToEquipmentcmb();

        colID.setCellValueFactory(new PropertyValueFactory<>("equipmentId"));
        colEquName.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        colEquPrice.setCellValueFactory(new PropertyValueFactory<>("equipmentCost"));
        colSchName.setCellValueFactory(new PropertyValueFactory<>("schGoal"));




    }

    private void genateSchID() throws SQLException, ClassNotFoundException {

        String lastId = makeWorkOutDetailsBO.genarateSchLastID();

        if(lastId!= null){
            lastId = lastId.split("[A-Z]")[1];
            lastId = "P00" + (Integer.parseInt(lastId)+1);
            lblSchID.setText(lastId);
        }else {
            lblSchID.setText("P001");
        }
    }


    private void setValuesToEquipmentcmb() throws SQLException, ClassNotFoundException {
        cmbEquID.getItems().add("None");

        ObservableList<EquipmentDTO>list = makeWorkOutDetailsBO.getAllEquipment();
        for (EquipmentDTO dto:list) {
            System.out.println(dto.getEquipmentId());
            cmbEquID.getItems().add(dto.getEquipmentId());
        }
    }

    private void setValuesToSchedulecmb() throws SQLException, ClassNotFoundException {
        cmbSchID.getItems().add("None");

        ObservableList<ScheduleDTO>scheduleDTOS = makeWorkOutDetailsBO.getAllSchedule();

        for (ScheduleDTO scheduleDTO:scheduleDTOS) {
            System.out.println(scheduleDTO.getSchId());
            cmbSchID.getItems().add(scheduleDTO.getSchId());

        }

    }

    public void cmbSchIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        ScheduleDTO dto =makeWorkOutDetailsBO.setAllSchudelsTotxt(cmbSchID.getSelectionModel().getSelectedItem().toString());
        lblSchID.setText(dto.getSchId());
        txtschGoal.setText(dto.getSchGoal());
        txtSchType.setText(dto.getSchType());
        txtSchLevel.setText(dto.getSchLevel());
        txtSchDuration.setText(dto.getSchDuration());
        txtSchWeek.setText(dto.getSchPerWeek());
        txtSchTime.setText(dto.getSchPerTime());

    }

    public void cmbEquIDOnActioin(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        EquipmentDTO dto = makeWorkOutDetailsBO.setAllEquipmentsTotxt(cmbEquID.getSelectionModel().getSelectedItem().toString());
        txtEquID.setText(dto.getEquipmentId());
        txtEquName.setText(dto.getEquipmentName());
        txtEquQty.setText(dto.getEquipmentQty()+"");
        txtEquCost.setText(dto.getEquipmentCost()+"");

    }

    public void txtEquIdOnAction(ActionEvent actionEvent) {

    }

    public void btnAddCartOnAction(ActionEvent actionEvent) {
        ArrayList<CustomDTO>customDTOS = new ArrayList<>();
        CustomDTO dto = new CustomDTO(txtEquID.getText(),txtEquName.getText(),Double.parseDouble(txtEquCost.getText()),txtschGoal.getText());

        customDTOS.add(dto);
        tblSchDetails.getItems().add(dto);

    }

    public void btnremoveCartOnAction(ActionEvent actionEvent) {
        tblSchDetails.getItems().remove(tblSchDetails.getSelectionModel().getSelectedItem());
    }

    public void btnPayOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        ScheduleDTO dto = new ScheduleDTO();

        dto.setSchId(lblSchID.getText());
        dto.setSchGoal(txtschGoal.getText());
        dto.setSchType(txtSchType.getText());
        dto.setSchLevel(txtSchLevel.getText());
        dto.setSchDuration(txtSchDuration.getText());
        dto.setSchPerWeek(txtSchWeek.getText());
        dto.setSchPerTime(txtSchTime.getText());

        ObservableList<ScheduleDetailsDTO>list = FXCollections.observableArrayList();
        for (int i = 0; i <tblSchDetails.getItems().size() ; i++) {

            list.add(new ScheduleDetailsDTO(tblSchDetails.getItems().get(i).getEquipmentId(),lblSchID.getText()));


        }
        dto.setScheduleDetailsList(list);

        boolean isAdded = makeWorkOutDetailsBO.createSchedule(dto);

        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
        }



    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }


    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        Parent stage = FXMLLoader.load(this.getClass().getResource("../view/WorkOutForm.fxml"));
        root.getChildren().clear();
        root.getChildren().add(stage);
        new FadeIn(stage).play();
    }
}
