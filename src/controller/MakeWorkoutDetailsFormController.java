package controller;

import animatefx.animation.*;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;

public class MakeWorkoutDetailsFormController {

    EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
    ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
    ScheduleDetailsDAO scheduleDetailsDAO = new ScheduleDetailsDAOImpl();

    public JFXTextField txtScheduleId;
    public JFXTextField txtSchType;
    public JFXTextField txtSchWeek;
    public JFXTextField txtSchGoal;
    public JFXTextField txtSchTime;
    public JFXTextField txtSchDuration;
    public JFXTextField txtSchLevel;
    public JFXTextField txtEquId;
    public JFXTextField txtEquCost;
    public JFXTextField txtEquQty;
    public JFXTextField txtEquName;
    public JFXButton btnAdd;
    public JFXButton btnAddCart;
    public JFXButton btnClear;
    public JFXTextField txtSchID;
    public JFXTextField txtschGoal;
    public JFXButton btnremoveCart;
    public JFXComboBox cmbSupID;

    @FXML
    private TableView<CustomDTO> tblSchDetails;

    @FXML
    private TableColumn<CustomDTO, String> colID;

    @FXML
    private TableColumn<CustomDTO, String> colEquName;

    @FXML
    private TableColumn<CustomDTO, String> colSchName;

    @FXML
    private TableColumn<CustomDTO, String> colSchGoal;


    public void TempAddOnAction(MouseEvent mouseEvent) {
    }

    public void ClearOnAction(MouseEvent mouseEvent) {
    }

    public void AddCartOnAction(MouseEvent mouseEvent) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
    }

    public void btnAddOnEntered(MouseEvent mouseEvent) {

        /*new JackInTheBox(btnAdd).setSpeed(1.0).play();*/
    }

    public void btnAddCartOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnremoveCartOnAction(ActionEvent actionEvent) {
    }

    public void txtEquIdOnAction(ActionEvent actionEvent) {



    }

    public void cmbSupIDOnAction(ActionEvent actionEvent) {
    }

    public void btnPayOnAction(ActionEvent actionEvent) {
    }
}
