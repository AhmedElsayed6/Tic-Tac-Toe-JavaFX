package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.ImageView;

public class PlayerBarChartController implements Initializable {
    
    @FXML
    private ImageView backPlayerChartView;

    @FXML
    private BarChart<String, Integer> barChartPlayers;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        XYChart.Data<String, Integer> online = new XYChart.Data<>("Online", 10); // change value after server implementation
        XYChart.Data<String, Integer> offline = new XYChart.Data<>("Offline", 20); // change value after server implementation
        XYChart.Data<String, Integer> away = new XYChart.Data<>("Playing", 6); // change value after server implementation

        
        online.nodeProperty().addListener((observable, oldValue, newValue) -> newValue.setStyle("-fx-bar-fill: blue;"));
        offline.nodeProperty().addListener((observable, oldValue, newValue) -> newValue.setStyle("-fx-bar-fill: grey;"));
        away.nodeProperty().addListener((observable, oldValue, newValue) -> newValue.setStyle("-fx-bar-fill: green;"));

        series1.getData().add(online);
        series1.getData().add(offline);
        series1.getData().add(away);

        barChartPlayers.getData().addAll(series1);
        barChartPlayers.setLegendVisible(false);
    }    
}
