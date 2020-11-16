package bo.custom.Impl;

import bo.custom.MainFormBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.Impl.CustomerDAOImpl;
import dao.custom.Impl.InstructorDAOImpl;
import dao.custom.Impl.PaymentDAOImpl;
import dao.custom.InstructorDAO;
import dao.custom.PaymentDAO;
import dto.CustomDTO;
import entity.CustomEntity;
import javafx.scene.chart.XYChart;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainFormBOImpl implements MainFormBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    InstructorDAO instructorDAO = (InstructorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INSTRUCTOR);
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PAYMENT);
    @Override
    public ArrayList<CustomDTO> lineChart() throws SQLException, ClassNotFoundException {
        ArrayList<CustomEntity> populate = customerDAO.lineChart();
        ArrayList<CustomDTO> customDTOS = new ArrayList<>();
        for (CustomEntity customDTO : populate) {
            customDTOS.add(new CustomDTO(
                    customDTO.getCustID(),
                    customDTO.getInstructID()
            ));

        }
        return customDTOS;
    }

    @Override
    public String getInstructorCount() throws SQLException, ClassNotFoundException {
        return instructorDAO.getCount();
    }

    @Override
    public String getPayCount() throws SQLException, ClassNotFoundException {
        return paymentDAO.getCpunt();
    }

    @Override
    public String getGenarlCount() throws SQLException, ClassNotFoundException {
        return customerDAO.getCountGenaral();

    }
}
/*    @FXML
    private BarChart<String,Integer> barChart;
[14:45, 10/2/2020] Bahashana: chart akta id akak deela skeleton aken aragena aka udinma daganna mchn me aka
        [14:45, 10/2/2020] Bahashana: public ArrayList<CustomChartDTO> barChart() throws Exception {
        ArrayList<CustomChartEntity> populate=chartDAO.chart();

        ArrayList<CustomChartDTO> recList=new ArrayList<>();

        for (CustomChartEntity customChartEntity:populate) {

        recList.add(new CustomChartDTO(customChartEntity.getCheckInDate(),customChartEntity.getChartCount()));

        }
        return recList*/;