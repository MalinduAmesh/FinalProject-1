package controller;

import bo.custom.Impl.MainFormBOImpl;
import bo.custom.MainFormBO;
import dto.CustomDTO;
import entity.CustomEntity;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainFormController {

    public Label txtTotalEarnings;
    public Label txtTotalGoldMembers;
    public Label txtTotalInstructors;
    public Label txtTotalGenarlMembers;
    public LineChart lineChartName;
    public Label txtGoldMem;
    public Label txtGenarlMem;

    MainFormBO mainFormBO = new MainFormBOImpl();


    @FXML
    private LineChart<String, Integer> lineChart;


    public void initialize(){
        setMonthlyCount();
    }

    private void setMonthlyCount() {
    }
}

