package controller;

import bo.custom.Impl.MemGrowingBOImpl;
import bo.custom.MemGrowingBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import dto.MemGrowthDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class MemGrowingFormController {
    public JFXButton btnAdd;
    public JFXButton btnClear;
    public Label lblID;
    public Label lblDate;
    public JFXTextField txtArms;
    public JFXTextField txtThigh;
    public JFXTextField txtWaist;
    public JFXTextField txtHeight;
    public JFXTextField txtWeigth;
    public JFXTextField txtChest;
    public JFXComboBox cmbCusID;

MemGrowingBo memGrowingBo = new MemGrowingBOImpl();

    public void initialize(){
        setValuesTocmb();
    }

    private void setValuesTocmb() {
        ObservableList<CustomerDTO>customerDTOS = null;
        try {
            customerDTOS = memGrowingBo.setValuesTocmb();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (CustomerDTO customerDTO:customerDTOS) {
            cmbCusID.getItems().add(customerDTO.getCustID());

        }

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        String id =lblID.getText();
        String date = lblDate.getText();
        String name =cmbCusID.getValue().toString();
        String weigth = txtWeigth.getText();
        String height =txtHeight.getText();
        String waist = txtWaist.getText();
        String thigh = txtThigh.getText();
        String arms = txtArms.getText();
        String chest =txtChest.getText();

        MemGrowthDTO memGrowthDTO = new MemGrowthDTO(id,date,name,weigth,height,waist,thigh,arms,chest);
        boolean isAdded = memGrowingBo.AddGrowth(memGrowthDTO);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }
}
