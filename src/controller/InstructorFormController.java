package controller;

import bo.BOFactory;
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
import javafx.scene.paint.Paint;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class InstructorFormController {


    public JFXComboBox cmbStatus;
    InstructorBO instructorBO = (InstructorBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.INSTRUCTOR);

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
        genarteID();
        setValuesTocol();
        setValuesTocmb();


    }

    private void genarteID() throws SQLException, ClassNotFoundException {
        String lastid = instructorBO.getLastId();

        if (lastid!= null){
            lastid = lastid.split("[A-Z]")[1];
            lastid ="D00"+(Integer.parseInt(lastid)+1);
            txtID.setText(lastid);
        }else {
            txtID.setText("D001");
        }
    }

    private void setValuesTocmb() {
        cmbStatus.getItems().add("avalible");

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

        try {

            String id = txtID.getText();
            String name = txtName.getText();
            String nic = txtNic.getText();
            String gender = sexType;
            String cont = txtContact.getText();
            String dob = dateDOB.getValue().toString();
            String status = cmbStatus.getValue().toString();

            InstructorDTO instructorDTO = new InstructorDTO(id, name, nic, gender, cont, dob, status);
            if (Pattern.compile("^[a-z|A-Z]{1,}$").matcher(txtName.getText()).matches()) {
                txtName.setUnFocusColor(Paint.valueOf("blue"));
                if (Pattern.compile("^[0-9]{1,10}$").matcher(txtContact.getText()).matches()) {
                    txtContact.setUnFocusColor(Paint.valueOf("blue"));
                    if (Pattern.compile("^[0-9]{1,12}$").matcher(txtNic.getText()).matches()) {
                        txtNic.setUnFocusColor(Paint.valueOf("blue"));
                        boolean isAdded = instructorBO.addInstructors(instructorDTO);
                        if (isAdded) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK).show();
                        } else {
                            new Alert(Alert.AlertType.WARNING, "Faild", ButtonType.OK).show();
                        }
                    }else {
                        txtNic.setUnFocusColor(Paint.valueOf("red"));
                    }
                }else {
                    txtContact.setUnFocusColor(Paint.valueOf("red"));
                }
            }else {
                txtName.setUnFocusColor(Paint.valueOf("red"));
            }
        }catch (NullPointerException e){
            new Alert(Alert.AlertType.WARNING,"Some text Fields Comes With null Values",ButtonType.OK).show();

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
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK).show();
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
            new Alert(Alert.AlertType.CONFIRMATION,"Updated",ButtonType.OK).show();
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
