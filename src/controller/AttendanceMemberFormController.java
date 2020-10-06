package controller;

import bo.custom.AttendanceMemberBO;
import bo.custom.Impl.AttendanceMemberBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.AttendanceDTO;
import dto.CustomerDTO;
import dto.InstructorDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AttendanceMemberFormController {

    public Label lblMemAttID;
    public JFXTextField txtMemName;
    public JFXComboBox cmbMemID;
    public JFXComboBox cmbInsID;
    public JFXTextField txtInsName;
    public Label lblAutoDate;
    public Label lblAutoTime;
    public TableView tblInstructor;
    public TableColumn colInsID;
    public TableColumn colInsName;
    public TableColumn colStartTime;
    public TableColumn colEndTime;
    public JFXTextField txtInsSearchPart;
    public JFXButton btnAdd;
    public JFXButton btnClear;

    AttendanceMemberBO attendanceMemberBO = new AttendanceMemberBOImpl();

    public void initialize() throws SQLException, ClassNotFoundException {
        setCusValuesTocmb();
        setInsValuesTocmb();
        genarateAttID();
        setDate();
        setTime();

    }

    private void genarateAttID() {
        try {
        String lastid = attendanceMemberBO.getAttLastID();

            if (lastid!= null){
                lastid = lastid.split("[A-Z]")[1];
                lastid = "A00" +(Integer.parseInt(lastid)+1);
                lblMemAttID.setText(lastid);

            }else {
                lblMemAttID.setText("A001");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void setInsValuesTocmb() {
        ObservableList<InstructorDTO>instructorDTOS = null;
        try {
            instructorDTOS = attendanceMemberBO.setInsValuestotxt();
            for (InstructorDTO instructorDTO:instructorDTOS) {
                cmbInsID.getItems().add(instructorDTO.getInstructID());

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void setCusValuesTocmb()  {
        ObservableList<CustomerDTO>list = null;
        try {
            list = attendanceMemberBO.setValuesTocmb();
            for (CustomerDTO customerDTO:list) {
                cmbMemID.getItems().add(customerDTO.getCustID());

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void txtInsSearchPart(ActionEvent actionEvent) {

    }

    public void cmbMemIDOnAction(ActionEvent actionEvent){
        try {
            CustomerDTO customerDTO = attendanceMemberBO.setCusValuesTotxt(cmbMemID.getSelectionModel().getSelectedItem().toString());
            txtMemName.setText(customerDTO.getCustName());
        }catch (NullPointerException e){

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void cmbInsIDOnAction(ActionEvent actionEvent) {

        InstructorDTO instructorDTO = null;
        try {
            instructorDTO = attendanceMemberBO.setVlauesTotxt(cmbInsID.getSelectionModel().getSelectedItem().toString());
            txtInsName.setText(instructorDTO.getInstructID());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NullPointerException e){

        }

    }
    public  void setDate(){
        String date =LocalDate.now().toString();
        lblAutoDate.setText(date);
    }
    public void setTime(){
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
        lblAutoTime.setText(time);
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws Exception {
        String id = lblMemAttID.getText();
        String memId = cmbMemID.getValue().toString();
        String insId = cmbInsID.getValue().toString();
        String date = lblAutoDate.getText();
        String time = lblAutoTime.getText();

        AttendanceDTO attendanceDTO = new AttendanceDTO(id,memId,insId,date,time);

        boolean isAdded =attendanceMemberBO.addMemAttandance(attendanceDTO);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
        }
    }

    public void btnClearOnAction(ActionEvent actionEvent) {

        try {
        txtInsName.setText("");
        txtMemName.setText("");
        cmbInsID.setValue("");
        cmbMemID.setValue("");
    }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
