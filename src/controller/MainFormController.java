package controller;

import bo.BOFactory;
import bo.custom.Impl.MainFormBOImpl;
import bo.custom.MainFormBO;
import com.jfoenix.controls.JFXButton;
import com.mongodb.DB;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainFormController {

    public Label txtTotalEarnings;
    public Label txtTotalGoldMembers;
    public Label txtTotalInstructors;
    public Label txtTotalGenarlMembers;
    public Label txtGenarlMem;



    @FXML
    private BarChart<String,Integer> barchartID;

    @FXML
    private JFXButton btnLoadChart;


    MainFormBO mainFormBO = (MainFormBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MAINFORM);


    public void initialize() throws SQLException, ClassNotFoundException {

        txtTotalInstructors.setText(mainFormBO.getInstructorCount());
        txtTotalEarnings.setText(mainFormBO.getPayCount());
        txtGenarlMem.setText(mainFormBO.getGenarlCount());

    }



    public void btnLoadChartOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


    }
    public void Db() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/GymSystem","root","1563");

    }
}

