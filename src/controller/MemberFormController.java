package controller;

import bo.custom.Impl.MemberFormBOImpl;
import bo.custom.MemberForm;
import dto.CustomerDTO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberFormController {


    public Button btnRegister;
    @FXML
    private TableView<CustomerDTO> tblMemebers;

    @FXML
    private TableColumn<CustomerDTO,String> colPhoto;

    @FXML
    private TableColumn<CustomerDTO,String> colMemID;

    @FXML
    private TableColumn<CustomerDTO,String> colMemName;

    @FXML
    private TableColumn<CustomerDTO,String> colNIC;

    @FXML
    private TableColumn<CustomerDTO,String> colContact;

    @FXML
    private TableColumn<CustomerDTO,String> colGender;

    @FXML
    private TableColumn<CustomerDTO,String> colDOB;

    @FXML
    private TableColumn<CustomerDTO,String> colTools;

    MemberForm memberForm = new MemberFormBOImpl();

    public AnchorPane root;



    public void initialize() {

        setValuesTocol();
        setValuesTotxt();



    }
    public void setValuesTocol()  {
        try {
            System.out.println("BUG");
        colMemID.setCellValueFactory(new PropertyValueFactory<>("custID"));
        colMemName.setCellValueFactory(new PropertyValueFactory<>("custName"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("custNic"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("custAddress"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("custContact"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("custDOB"));
            System.out.println("BUG123");

            tblMemebers.setItems(loadAllStudent());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ObservableList<CustomerDTO> loadAllStudent() throws SQLException, ClassNotFoundException {

        ObservableList<CustomerDTO>list = memberForm.loadTables();
        ObservableList<CustomerDTO>customerDTOS = FXCollections.observableArrayList();
        for (CustomerDTO dto:list) {
                customerDTOS.add(new CustomerDTO(
                        dto.getCustID(),
                        dto.getCustName(),
                        dto.getCustNic(),
                        dto.getCustAddress(),
                        dto.getCustContact(),
                        dto.getCustDOB()

                ));
        }

        return customerDTOS;
    }


    private void setValuesTotxt() {

        CustomerDTO customerDTO = memberForm.searchAllMemeName();
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        AnchorPane pane = (AnchorPane) FXMLLoader.load(this.getClass().getResource("../view/RegisterForm.fxml"));
        root.getChildren().setAll(pane.getChildren());
    }
}
