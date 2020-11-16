package controller;

import bo.BOFactory;
import bo.custom.AssignWorkOutBO;
import bo.custom.Impl.AssignWorkOutBOImpl;
import com.jfoenix.controls.JFXTextField;
import dto.AssignWorkOutDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;

public class WorkOutFormController {
    public JFXTextField txtSearch;
    public AnchorPane root;
    @FXML
    private TableView<AssignWorkOutDTO> tblWorkOutDetails;

    @FXML
    private TableColumn<AssignWorkOutDTO,String> colMemberName;

    @FXML
    private TableColumn<AssignWorkOutDTO,String> colLevel;

    @FXML
    private TableColumn<AssignWorkOutDTO,String> colGoal;

    @FXML
    private TableColumn<AssignWorkOutDTO,String> colTools;

    AssignWorkOutBO assignWorkOutBO = (AssignWorkOutBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ASSIGNWORKOUT);

    public void initialize() throws SQLException, ClassNotFoundException {
        colMemberName.setCellValueFactory(new PropertyValueFactory<>("assMemID"));
        colLevel.setCellValueFactory(new PropertyValueFactory<>("assSchID"));
        colGoal.setCellValueFactory(new PropertyValueFactory<>("assInDate"));
        colTools.setCellValueFactory(new PropertyValueFactory<>("assOutDate"));
        tblWorkOutDetails.setItems(loadTable());
    }

    private ObservableList loadTable() throws SQLException, ClassNotFoundException {
    ObservableList<AssignWorkOutDTO>assignWorkOutDTOS = assignWorkOutBO.loadTableForm();
    ObservableList<AssignWorkOutDTO>workOutDTOS = FXCollections.observableArrayList();
        for (AssignWorkOutDTO assignWorkOutDTO:assignWorkOutDTOS) {
            workOutDTOS.add(new AssignWorkOutDTO(
                    assignWorkOutDTO.getAssMemID(),
                    assignWorkOutDTO.getAssSchID(),
                    assignWorkOutDTO.getAssInDate(),
                    assignWorkOutDTO.getAssOutDate()
            ));

        }
        return workOutDTOS;
    }

    public void AssignworkoutOnAction(MouseEvent mouseEvent) throws IOException {


    }

    public void btnCreateWorkOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        AnchorPane poot = FXMLLoader.load(this.getClass().getResource("../view/MakeWorkoutDetailsForm.fxml"));
        root.getChildren().setAll(poot.getChildren());
    }

    public void AssignworkoutOnActionn(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("../view/AssignWorkOutForm.fxml"));
        root.getChildren().setAll(pane.getChildren());
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        AnchorPane poot = FXMLLoader.load(this.getClass().getResource("../view/WorkOutForm.fxml"));
        root.getChildren().setAll(poot.getChildren());
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
    }
}
