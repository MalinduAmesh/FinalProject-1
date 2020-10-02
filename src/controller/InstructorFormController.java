package controller;

import bo.custom.Impl.InstructorBOImpl;
import bo.custom.InstructorBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.InstructorDTO;
import entity.Instructor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorFormController {


    public JFXComboBox cmbStatus;
    InstructorBO instructorBO =new InstructorBOImpl();

    public JFXTextField txtNic;
    public JFXTextField txtID;
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXDatePicker dateDOB;
    public RadioButton rdoMale;
    public RadioButton rdoFemale;
    public JFXTextField txtAddress;
    public JFXButton btnAdd;
    public JFXButton btnClear;
    public JFXButton btnRemove;
    public JFXButton btnUpdate;

    private String sexType;
    private String sexType1;

    @FXML
    private TableView<InstructorDTO> tblInstructor;

    @FXML
    private TableColumn<InstructorDTO, String> colID;

    @FXML
    private TableColumn<InstructorDTO, String> colName;

    @FXML
    private TableColumn<InstructorDTO, String> colGender;

    @FXML
    private TableColumn<InstructorDTO, String> colContact;

    @FXML
    private TableColumn<InstructorDTO, String> colDOB;


    public void initialize() throws SQLException, ClassNotFoundException {

        setValuesTocol();
        setValuesTocmb();


    }

    private void setValuesTocmb() {
        cmbStatus.getItems().add("Specialist");

    }

    private void setValuesTocol() throws SQLException, ClassNotFoundException {
        colID.setCellValueFactory(new PropertyValueFactory<>("instructID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("instructName"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("instructGender"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("instructNumber"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("instrDOB"));
        tblInstructor.setItems(loadAllInstructor());

    }

    private ObservableList<InstructorDTO> loadAllInstructor() throws SQLException, ClassNotFoundException {
        ArrayList<InstructorDTO>list = instructorBO.setValuesToTable();
        ObservableList<InstructorDTO>instructorDTOS = FXCollections.observableArrayList();
        for (InstructorDTO instructorDTO:list) {
            instructorDTOS.add(new InstructorDTO(
                    instructorDTO.getInstructID(),
                    instructorDTO.getInstructName(),
                    instructorDTO.getInstructGender(),
                    instructorDTO.getInstructNumber(),
                    instructorDTO.getInstrDOB()
            ));

        }
        return instructorDTOS;
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String id =txtID.getText();
        String  name =txtName.getText();
        String nic = txtNic.getText();
        String gender = sexType;
        String cont =txtContact.getText();
        String dob = dateDOB.getValue().toString();
        String status = cmbStatus.getValue().toString();

        InstructorDTO instructorDTO = new InstructorDTO(id,name,nic,gender,cont,dob,status);
        boolean isAdded = instructorBO.addInstructors(instructorDTO);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
        }

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        try {

            txtContact.setText("");
            txtID.setText("");
            txtName.setText("");
            txtNic.setText("");
            txtAddress.setText("");
            rdoFemale.setText("");
            rdoMale.setText("");
            cmbStatus.setValue("");
        }catch (NullPointerException ex){

        }
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //tblInstructor.getItems().remove(tblInstructor.getSelectionModel().getSelectedItem());
        String id =txtID.getText();
        String  name =txtName.getText();
        String nic = txtNic.getText();
        String gender = sexType;
        String cont =txtContact.getText();
        String dob = dateDOB.getValue().toString();
        String status = cmbStatus.getValue().toString();

        InstructorDTO instructorDTO = new InstructorDTO(id,name,nic,gender,cont,dob,status);
        boolean isDeleted = instructorBO.deleteInstructor(instructorDTO);
        if (isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"added",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id =txtID.getText();
        String  name =txtName.getText();
        String nic = txtNic.getText();
        String gender = sexType;
        String cont =txtContact.getText();
        String dob = dateDOB.getValue().toString();
        String status =cmbStatus.getValue().toString();

        InstructorDTO instructorDTO = new InstructorDTO(id,name,nic,gender,cont,dob,status);
        boolean isUpdated = instructorBO.updateInstructor(instructorDTO);
        if (isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"Addedd",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
        }
    }

    public void rdoMaleOnAction(ActionEvent actionEvent) {
        rdoFemale.isSelected();
    }

    public void rdoFemaleOnAction(ActionEvent actionEvent) {
    boolean isSelected = rdoFemale.isSelected();
    if (isSelected){
        rdoFemale.setSelected(true);
        sexType1 = "Female";
    }else {
        rdoFemale.setSelected(false);
    }
    }

    public void cmbStatusOnAction(ActionEvent actionEvent) {

    }
}
