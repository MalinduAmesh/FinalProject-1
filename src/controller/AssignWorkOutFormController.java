package controller;

import bo.custom.AssignWorkOutBO;
import bo.custom.Impl.AssignWorkOutBOImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dao.custom.AssignWorkOut;
import dto.AssignWorkOutDTO;
import dto.CustomDTO;
import dto.CustomerDTO;
import dto.ScheduleDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssignWorkOutFormController {

    public JFXComboBox cmbMemIID;
    public JFXComboBox cmbSearchOld;
    public AnchorPane root;
    AssignWorkOutBO assignWorkOutBO = new AssignWorkOutBOImpl();

    public JFXComboBox cmbSchID;
    public JFXTextField txtMemName;
    public JFXTextField txtSchWeek;
    public JFXDatePicker dateIN;
    public JFXDatePicker DateOut;
    public Label lblTotalPln;
    public Label lblAssWorkID;
    public JFXButton btnAdd;
    public JFXButton btnClear;
    @FXML
    private TableView<AssignWorkOutDTO> tblAssignWorkOut;

    @FXML
    private TableColumn<AssignWorkOut,String> colWorkID;

    @FXML
    private TableColumn<AssignWorkOut,String> colMemID;

    @FXML
    private TableColumn<AssignWorkOut,String> colGoal;

    @FXML
    private TableColumn<AssignWorkOut,String> colInDate;

    @FXML
    private TableColumn<AssignWorkOut,String> colEndDate;



    public  void initialize() throws SQLException, ClassNotFoundException {
        genarateAssID();
        setValuesMemTocmb();
        setValuesSchTocmb();
        setValuesToSeachMemcmb();

    }

    private void setValuesToSeachMemcmb() throws SQLException, ClassNotFoundException {
        cmbSearchOld.getItems().add("None");

        ArrayList<CustomerDTO>list = assignWorkOutBO.getAllMemSearchID();
        for (CustomerDTO customDTO:list) {
            cmbSearchOld.getItems().add(customDTO.getCustID());
        }
    }

    public void setDat() {

    }
    private void genarateAssID() throws SQLException, ClassNotFoundException {
        String lastId = assignWorkOutBO.getAssWorkLastID();

        if (lastId!=null) {
            lastId = lastId.split("[A-Z]")[1];
            lastId = "C00" + (Integer.parseInt(lastId) + 1);
            lblAssWorkID.setText(lastId);
        }else {
            lblAssWorkID.setText("C001");
        }

    }

    private void setValuesSchTocmb() throws SQLException, ClassNotFoundException {

        cmbSchID.getItems().add("None");

        ArrayList<ScheduleDTO>list =assignWorkOutBO.getAllSchID();
        for (ScheduleDTO scheduleDTO:list) {
            cmbSchID.getItems().add(scheduleDTO.getSchId());
        }

    }

    private void setValuesMemTocmb() throws SQLException, ClassNotFoundException {
        cmbMemIID.getItems().add("None");

        ArrayList<CustomerDTO>list = assignWorkOutBO.getAllMemID();
        for (CustomerDTO customDTO:list) {
            cmbMemIID.getItems().add(customDTO.getCustID());
        }
    }


    public void cmbMemIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        CustomerDTO customerDTO = assignWorkOutBO.setAllValuesTotxt(cmbMemIID.getSelectionModel().getSelectedItem().toString());
        txtMemName.setText(customerDTO.getCustName());

    }

    public void cmbSchIDOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        ScheduleDTO schedule = assignWorkOutBO.setSchValuesTotxt(cmbSchID.getSelectionModel().getSelectedItem().toString());
        txtSchWeek.setText(schedule.getSchDuration());
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id =lblAssWorkID.getText();
        String memId = cmbMemIID.getValue().toString();
        String schGoal = cmbSchID.getValue().toString();
        String dateIn = dateIN.getValue().toString();
        String dateOut = DateOut.getValue().toString();



        AssignWorkOutDTO assignWorkOutDTO = new AssignWorkOutDTO(id,memId,schGoal,dateIn,dateOut);
        System.out.println("details"+assignWorkOutDTO);
        boolean isAdded = assignWorkOutBO.addAssignWorkOut(assignWorkOutDTO);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Added", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Faild",ButtonType.OK).show();
        }


    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        lblAssWorkID.setText("");
        cmbSchID.setValue("");
        cmbMemIID.setValue("");
        txtMemName.setText("");
        txtSchWeek.setText("");
        dateIN.setValue(LocalDate.parse(""));
        DateOut.setValue(LocalDate.parse(""));
        lblTotalPln.setText("");
    }

    public void DateOutOnAction(ActionEvent actionEvent) throws ParseException {

/*
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        LocalDate dateIn = dateIN.getValue();
        LocalDate dateOut = DateOut.getValue();


        Date date1 = simpleDateFormat.parse(String.valueOf(dateIn));
        Date date2 =simpleDateFormat.parse(String.valueOf(dateOut));
        long sum =(date2.getTime() - date1.getTime());
        String da = String.valueOf(sum);

        System.out.println("Days: " + TimeUnit.DAYS.convert(Long.parseLong(String.valueOf(da)), TimeUnit.MILLISECONDS));
   //    lblTotalPln.setText(String.valueOf(TimeUnit.DAYS.convert(sum,TimeUnit.MILLISECONDS)));
*/

        LocalDate d1=dateIN.getValue();
        LocalDate d2=DateOut.getValue();
        Long date= ChronoUnit.DAYS.between(d1,d2);
        String finalDate=(String.valueOf(date));
        lblTotalPln.setText(String.valueOf(finalDate));
    }

    public void cmbSearchOldOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        tblAssignWorkOut.setItems(loadTables(cmbSearchOld.getSelectionModel().getSelectedItem().toString()));

        colWorkID.setCellValueFactory(new PropertyValueFactory<>("assWorkId"));
        colMemID.setCellValueFactory(new PropertyValueFactory<>("assMemID"));
        colGoal.setCellValueFactory(new PropertyValueFactory<>("assSchID"));
        colInDate.setCellValueFactory(new PropertyValueFactory<>("assInDate"));
        colEndDate.setCellValueFactory(new PropertyValueFactory<>("assOutDate"));
        
    }

    private ObservableList<AssignWorkOutDTO> loadTables(String s) throws SQLException, ClassNotFoundException {
        ArrayList<AssignWorkOutDTO>list = assignWorkOutBO.loadTable(s);
        ObservableList<AssignWorkOutDTO>assignWorkOutDTOS = FXCollections.observableArrayList();
        for (AssignWorkOutDTO dto:list) {
            assignWorkOutDTOS.add(new AssignWorkOutDTO(
                    dto.getAssWorkId(),
                    dto.getAssMemID(),
                    dto.getAssSchID(),
                    dto.getAssInDate(),
                    dto.getAssOutDate()
            ));
        }
        return assignWorkOutDTOS;
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        AnchorPane poot = FXMLLoader.load(this.getClass().getResource("../view/WorkOutForm.fxml"));
        root.getChildren().setAll(poot.getChildren());
    }
}
