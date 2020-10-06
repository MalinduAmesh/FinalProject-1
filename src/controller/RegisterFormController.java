package controller;

import bo.custom.Impl.RegisterBOImpl;
import bo.custom.RegisterBO;
import com.jfoenix.controls.*;
import dto.*;
import entity.MemberShip;
import entity.Register;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.stream.events.DTD;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterFormController {

    public JFXTextField txtPacName;
    public JFXComboBox cmbSearch;
    public JFXTextField txtStartDate;
    public JFXTextField txtEndDate;
    public JFXTextField txtInstructorName;
    public JFXComboBox txtRegInstructor;

    RegisterBO registerBO = new RegisterBOImpl();

    public JFXComboBox cmbRegMemberShip;
    public JFXDatePicker dateStartDate;
    public JFXDatePicker dateEndDate;
    public Label lblRegID;
    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerAddress;
    public JFXTextField txtCusContact;
    public JFXTextField txtCusEmail;
    public JFXRadioButton rdoCusMale;
    public JFXRadioButton rdoCusFemale;
    public JFXTextField txtCustomerNIC;
    public Label lblCusID;
    public JFXDatePicker dateDOB;
    public JFXButton btnPaid;
    public JFXRadioButton rdoRegCash;
    public JFXRadioButton rdoRegCard;
    public JFXTextField txtRegTotalFee;
    public JFXTextField txtCusPaidFee;
    public JFXTextField txtCusChange;

    public String paymentType;
    public String sexType;

    @FXML
    private TableView<MemberShipDTO> tblMemberShip;

    @FXML
    private TableColumn<MemberShipDTO,String> colID;

    @FXML
    private TableColumn<MemberShipDTO,String> colName;

    @FXML
    private TableColumn<MemberShipDTO,String> colDuration;

    @FXML
    private TableColumn<MemberShipDTO,String> colFee;

    public void initialize() throws SQLException, ClassNotFoundException {

        genarateCusID();
        genarateRegID();
        setValuesToMemShipcmb();
        setValuesToSearchcmb();
        setValuesToInstructorcmb();


        colID.setCellValueFactory(new PropertyValueFactory<>("memShipid"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("Fee"));
        tblMemberShip.setItems(loadAllPackages());

    }

    private void setValuesToInstructorcmb() throws SQLException, ClassNotFoundException {

        txtRegInstructor.getItems().add("None");

        ArrayList<InstructorDTO>instructorDTOS =registerBO.getAllInstructorID();
        for (InstructorDTO instructorDTO:instructorDTOS) {
            txtRegInstructor.getItems().add(instructorDTO.getInstructID());

        }
    }

    private void setValuesToSearchcmb() throws SQLException, ClassNotFoundException {

        cmbSearch.getItems().add("None");

        ArrayList<RegisterDTO>cusList = registerBO.getAllRegID();

        for (RegisterDTO registerDTO:cusList) {
            cmbSearch.getItems().add(registerDTO.getRegID());
        }



    }

    private ObservableList<MemberShipDTO> loadAllPackages() throws SQLException, ClassNotFoundException {

        ArrayList<MemberShipDTO>list = registerBO.getAllMemShip();
        ObservableList<MemberShipDTO>memShiplist = FXCollections.observableArrayList();
        for (MemberShipDTO dto: list) {
            memShiplist.add(new MemberShipDTO(
                    dto.getMemShipid(),
                    dto.getName(),
                    dto.getDuration(),
                    dto.getFee()
            ));

        }


        return memShiplist;
    }

    private void setValuesToMemShipcmb() throws SQLException, ClassNotFoundException {
        cmbRegMemberShip.getItems().add("None");

        ArrayList<MemberShipDTO> memberShipDTOS = registerBO.getAllMemShip();
        for (MemberShipDTO dto:memberShipDTOS) {
            cmbRegMemberShip.getItems().add(dto.getMemShipid());

        }
    }

    private void genarateRegID() throws SQLException, ClassNotFoundException {

        String lastId = getLastRegID();
        if (lastId != null){

            lastId = lastId.split("[A-Z]")[1];
            lastId ="S00" +(Integer.parseInt(lastId)+1);
            lblRegID.setText(lastId);

        }else {
            lblRegID.setText("S001");
        }


    }

    private void genarateCusID() throws SQLException, ClassNotFoundException {

        String lastId = getLastCustomerCode();

        if (lastId != null) {
            lastId = lastId.split("[A-Z]")[1];
            lastId = "C00" + (Integer.parseInt(lastId) + 1);
            lblCusID.setText(lastId);

        }else {
            lblCusID.setText("C001");
        }

    }

    private String getLastRegID() throws SQLException, ClassNotFoundException {

        return registerBO.getlastRegisterID();
    }


    private String getLastCustomerCode() throws SQLException, ClassNotFoundException {

        return registerBO.getLastCustomerCode();
    }

    public void btnPaidOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {


            CustomerDTO dto = new CustomerDTO();

            dto.setCustID(lblCusID.getText());
            dto.setCustName(txtCustomerName.getText());
            dto.setCustNic(txtCustomerNIC.getText());
            dto.setCustContact(txtCusContact.getText());
            dto.setCustAddress(txtCustomerAddress.getText());
            dto.setCustDOB(dateDOB.getValue().toString());
            dto.setCustEmail(txtCusEmail.getText());
            dto.setCustGender(sexType);

            dto.setRegID(lblRegID.getText());
            dto.setTraID(txtRegInstructor.getSelectionModel().getSelectedItem().toString());
            dto.setCusID(lblCusID.getText());
            dto.setMemShip(cmbRegMemberShip.getSelectionModel().getSelectedItem().toString());
            dto.setRegStartDate(dateStartDate.getValue().toString());
            dto.setRegEndDate(dateEndDate.getValue().toString());
            dto.setRegFeeType(paymentType);
            dto.setRegFee(txtRegTotalFee.getText());


            boolean isAdded = registerBO.registerCustomer(dto);
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
            new Alert(Alert.AlertType.WARNING,"Error Some Text Feilds Uncomplete",ButtonType.OK).show();
        }

    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }
    public void dateStartDateOnAction(ActionEvent actionEvent) {
    }
    public void dateEndDateOnAction(ActionEvent actionEvent) {
    }


    public void cmbRegMemberShipOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        MemberShipDTO memberShipDTO = registerBO.searchMemShip(cmbRegMemberShip.getSelectionModel().getSelectedItem().toString());
        txtPacName.setText(memberShipDTO.getName());
        txtRegTotalFee.setText(memberShipDTO.getFee());
    }
    public void txtRegInstructorOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        InstructorDTO instructorDTO = registerBO.searchAllInstrutors(txtRegInstructor.getSelectionModel().getSelectedItem().toString());
        txtInstructorName.setText(instructorDTO.getInstructName());
    }
    public void rdoCusMaleOnAction(ActionEvent actionEvent) {

        /*rdoCusMale.setSelected(false);
        sexType = "MALE";*/

        boolean isSelected = rdoCusMale.isSelected();
        sexType = "";
        if(isSelected){
            sexType = "Male";

        }


    }

    public void rdoCusFemaleOnAction(ActionEvent actionEvent) {

        rdoCusFemale.setSelected(false);
        sexType = "FEMALE";
    }

    public void rdoRegCashOnAction(ActionEvent actionEvent) {

       boolean isSelected = rdoRegCash.isSelected();
       paymentType ="";
       if(isSelected){
           paymentType ="Cash";
       }else {
           paymentType ="Card";
       }
    }

    public void rdoRegCardOnAction(ActionEvent actionEvent) {

        rdoRegCard.setSelected(false);
        paymentType ="Via CARD";
    }

    public void cmbSearchOnAction(ActionEvent actionEvent) {

        CustomDTO customDTO = registerBO.searchAllCusReg(cmbSearch.getSelectionModel().getSelectedItem().toString());
        txtCustomerName.setText(customDTO.getCustName());
        txtCustomerNIC.setText(customDTO.getCustNic());
        txtCustomerAddress.setText(customDTO.getCustAddress());
        txtCusContact.setText(customDTO.getCustContact());
        txtCusEmail.setText(customDTO.getCustEmail());
        txtRegInstructor.setValue(customDTO.getInstructID());
        txtPacName.setText(customDTO.getName());
        txtStartDate.setText(customDTO.getRegStartDate());
        txtEndDate.setText(customDTO.getRegEndDate());
        txtRegTotalFee.setText(customDTO.getRegFee());

    }
    private void Calculate(){
        double toatal = Double.parseDouble(txtRegTotalFee.getText());
        int paid = Integer.parseInt(txtCusPaidFee.getText());

        double x= (paid-toatal);

        txtCusChange.setText(String.valueOf(x));
    }


    public void txtCusPaidFeeOnAction(ActionEvent actionEvent) {
        Calculate();
    }
}
