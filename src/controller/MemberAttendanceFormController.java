package controller;

import bo.custom.Impl.MemberAttendanceBOImpl;
import bo.custom.MemberAttendnceBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.*;
import entity.Attendance;
import entity.InsAttendance;
import entity.Instructor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberAttendanceFormController {

    public Label lblMemAttID;
    public Label lblInstAttID;
    MemberAttendnceBO memberAttendnceBO =new MemberAttendanceBOImpl();

    public JFXTextField txtMemberName;
    public JFXComboBox cmbmemID;
    public JFXTextField txtMemSearch;
    public JFXTextField txtMemberDate;
    public JFXTextField txtInstructorName;
    public JFXComboBox cmbInsID;
    public JFXTextField txtInsSearch;
    public JFXTextField txtInstrDate;
    public JFXButton btnmemberAdd;
    public JFXButton clearMember;
    public JFXButton addInstruct;
    public JFXButton clearInstructor;

    @FXML
    private TableView<Attendance> tblMemberAttendance;

    @FXML
    private TableColumn<Attendance,String> colMemberID;

    @FXML
    private TableColumn<Attendance,String> colMemberName;

    @FXML
    private TableColumn<Attendance,String> colMemberDate;

    @FXML
    private TableView<InsAttendance> tblInstructor;

    @FXML
    private TableColumn<InsAttendance,String> colInstrucorID;

    @FXML
    private TableColumn<InsAttendance,String> colInstrucName;

    @FXML
    private TableColumn<InsAttendance,String> colInstruDate;


    public void initialize() throws SQLException, ClassNotFoundException {

        genarateInsAttID();
        setValuesToMemcmb();
        setValuesToInscmb();
        setDate();


    }

    private void setDate() {
        String date = LocalDate.now().toString();
        txtMemberDate.setText(date);
        txtInstrDate.setText(date);
    }

    private void setValuesToInscmb() throws SQLException, ClassNotFoundException {
        cmbInsID.getItems().add("None");

        ArrayList<InstructorDTO>list = memberAttendnceBO.getAllInsID();
        for (InstructorDTO instructorDTO:list) {
            cmbInsID.getItems().add(instructorDTO.getInstructID());

        }

    }

    public void cmbInsIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        InstructorDTO instructorDTO = memberAttendnceBO.setAllInsTotxt(cmbInsID.getSelectionModel().getSelectedItem().toString());
        lblInstAttID.setText(instructorDTO.getInstructID());
        txtInstructorName.setText(instructorDTO.getInstructName());
    }
    private void setValuesToMemcmb() throws SQLException, ClassNotFoundException {
        cmbmemID.getItems().add("None");

        ArrayList<CustomerDTO>customerDTOS = memberAttendnceBO.getAllMemID();
        for (CustomerDTO customerDTO:customerDTOS) {
            cmbmemID.getItems().add(customerDTO.getCustID()
            );
        }

    }
    public void cmbmemIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        CustomerDTO customerDTO = memberAttendnceBO.setAllMemTotxt(cmbmemID.getSelectionModel().getSelectedItem().toString());
         txtMemberName.setText(customerDTO.getCustName());
    }

    private void genarateInsAttID() throws SQLException, ClassNotFoundException {

        String lastId= memberAttendnceBO.getInsLastID();

        if (lastId != null){
            lastId =lastId.split("[A-Z]")[1];
            lastId = "P00"+(Integer.parseInt(lastId)+1);
            lblInstAttID.setText(lastId);
        }else {
            lblInstAttID.setText("P001");
        }
    }

    private void genarateMemAttID() throws SQLException, ClassNotFoundException {
        String lastId = memberAttendnceBO.getMemLastId();

        if (lastId!=null){
            lastId= lastId.split("[A-Z]")[1];
            lastId = "C00"+(Integer.parseInt(lastId)+1);
            lblMemAttID.setText(lastId);
        }else {
            lblMemAttID.setText("C001");
        }

    }



    public void txtMemSearchOnAction(ActionEvent actionEvent) {
    }


    public void txtInsSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnmemberAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id =lblMemAttID.getText();
        String memId = cmbmemID.getValue().toString();
        String date = txtMemberDate.getText();

        AttendanceDTO attendanceDTO = new AttendanceDTO(id,memId,date);
        boolean isAdded = memberAttendnceBO.addMemAttandance(attendanceDTO);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"faild",ButtonType.OK).show();
        }
    }

    public void clearMemberOnAction(ActionEvent actionEvent) {
    }

    public void InstructorAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
/*        String id = lblInstAttID.getText();
        String insId =cmbInsID.getValue().toString();
        String date = txtInstrDate.getText();

     *//*   InsAttendanceDTO insAttendanceDTO = new InsAttendanceDTO(id,insId,date);*//*
        boolean isAdded = memberAttendnceBO.addInstructor(insAttendanceDTO);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Added",ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
        }*/
    }

    public void clearInstructorOnAction(ActionEvent actionEvent) {
    }
}
