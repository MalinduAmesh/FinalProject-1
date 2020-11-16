package controller;

import bo.BOFactory;
import bo.custom.AttendanceInstructorBO;
import bo.custom.Impl.AttendanceInstructorBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import dto.InsAttendanceDTO;
import dto.InstructorDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AttendanceInstructorFormController {
    public JFXComboBox cmbInsID;
    public JFXTextField txtInsName;
    public JFXTimePicker txtINTime;
    public JFXTimePicker txtOverTime;
    public JFXTextField txtDate;
    public Label lblAttID;
    public JFXComboBox cmbSearchINOUT;
    public JFXButton btnAdd;
    public JFXButton btnUpdateAdd;
    public JFXButton btnClear;
    public Label lblInTime;
    public Label lblDate;
    public JFXComboBox cmbInstrutor;

    AttendanceInstructorBO attendanceInstructorBO = (AttendanceInstructorBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ATTENDANCEINSTRUCTOR);


    public void initialize(){
        genarateAttID();
        setInsAttValuesTocmb();
        setInOutValuesTocmb();
        setInsValuesTocmb();
        setDate();
        setTime();
    }

    private void genarateAttID() {
        String lastid = null;
        try {
            lastid = attendanceInstructorBO.genarateAttID();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (lastid!=null){
            lastid =lastid.split("[A-Z]")[1];
            lastid ="P00"+(Integer.parseInt(lastid)+1);
            lblAttID.setText(lastid);
        }else {
            lblAttID.setText("P001");
        }
    }

    private void setInsAttValuesTocmb() {
        ObservableList<InsAttendanceDTO>insAttendanceDTOS = null;
        try {
            insAttendanceDTOS = attendanceInstructorBO.setAttValuesTocmb();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (InsAttendanceDTO insAttendanceDTO:insAttendanceDTOS) {
            cmbInstrutor.getItems().add(insAttendanceDTO.getInsAttID());

        }
    }

    private void setInOutValuesTocmb() {
        cmbSearchINOUT.getItems().add("In");
        cmbSearchINOUT.getItems().add("out");
    }

    private void setInsValuesTocmb() {
        ObservableList<InstructorDTO>list= null;
        try {
            list = attendanceInstructorBO.setValues();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (InstructorDTO instructorDTO:list) {
            cmbInsID.getItems().add(instructorDTO.getInstructID());

        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            String id = lblAttID.getText();
            String insID = cmbInsID.getValue().toString();
            String inTime = lblInTime.getText();
            String date = lblDate.getText();
            String outTime = "0";

            InsAttendanceDTO insAttendanceDTO = new InsAttendanceDTO(id, insID, inTime, date, outTime);
            boolean isAdded = attendanceInstructorBO.markAttendance(insAttendanceDTO);
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Added", ButtonType.OK).show();

            } else {
                new Alert(Alert.AlertType.WARNING, "Faild", ButtonType.OK).show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            new Alert(Alert.AlertType.WARNING,"Some TextField Values comes with null values",ButtonType.OK).show();
        }


    }

    public void cmbSearchINOUTOnAction(ActionEvent actionEvent) {

        int index = cmbSearchINOUT.getSelectionModel().getSelectedIndex();
        if (index==0){
            txtOverTime.setDisable(true);
            cmbInstrutor.setDisable(true);
        }else {
            txtOverTime.setDisable(false);
            cmbInstrutor.setDisable(false);
        }



    }

    public void btnUpdateAddOnAction(ActionEvent actionEvent) {
        String id = lblAttID.getText();
        String insID =cmbInsID.getValue().toString();
        String inTime =lblInTime.getText();
        String date =lblDate.getText();
        String outTime = txtOverTime.getValue().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));

        InsAttendanceDTO insAttendanceDTO = new InsAttendanceDTO(id,insID,inTime,date,outTime);
        System.out.println("check1"+insAttendanceDTO);
        boolean isUpdated = false;
        try {
            isUpdated = attendanceInstructorBO.updateAttendance(insAttendanceDTO);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"Added",ButtonType.OK).show();
           // boolean is = new InstructorDTO();
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Faild",ButtonType.OK).show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void cmbInsIDOnAction(ActionEvent actionEvent) {

        InstructorDTO instructorDTO = null;
        try {
            instructorDTO = attendanceInstructorBO.loadAllvaluesTotxt(cmbInsID.getSelectionModel().getSelectedItem().toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        txtInsName.setText(instructorDTO.getInstructName());

    }
    private void setDate(){
        String date = LocalDate.now().toString();
        lblDate.setText(date);
    }
    private void setTime(){
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        lblInTime.setText(time);
    }

    public void cmbInstrutorOnAction(ActionEvent actionEvent) {
        InsAttendanceDTO insAttendanceDTO = null;
        try {
            insAttendanceDTO = attendanceInstructorBO.setValuesTotxt(cmbInstrutor.getSelectionModel().getSelectedItem().toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cmbInsID.setValue(insAttendanceDTO.getInsID());
        lblInTime.setText(insAttendanceDTO.getInsAttInTime());
        lblDate.setText(insAttendanceDTO.getInsAttInDate());
        lblAttID.setText(insAttendanceDTO.getInsAttID());
        txtInsName.setDisable(true);
    }
}
