package Views.OnlineViews;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerChartViewClass extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView backPlayerChartView;
    protected final CategoryAxis xAxis;
    protected final NumberAxis yAxis;
    protected final BarChart barChartPlayers;
    protected final Text text;

    public PlayerChartViewClass() {

        imageView = new ImageView();
        backPlayerChartView = new ImageView();
        xAxis = new CategoryAxis();
        yAxis = new NumberAxis();
        barChartPlayers = new BarChart(xAxis, yAxis);
        text = new Text();

        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(836.0);
        imageView.setFitWidth(846.0);
        imageView.setLayoutX(-75.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        backPlayerChartView.setFitHeight(116.0);
        backPlayerChartView.setFitWidth(79.0);
        backPlayerChartView.setPickOnBounds(true);
        backPlayerChartView.setPreserveRatio(true);
        backPlayerChartView.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));

        xAxis.setLabel("Player Status");
        xAxis.setSide(javafx.geometry.Side.BOTTOM);

        yAxis.setLabel("Number OF Players");
        yAxis.setSide(javafx.geometry.Side.LEFT);
        barChartPlayers.setLayoutX(6.0);
        barChartPlayers.setLayoutY(150.0);
        barChartPlayers.setPrefHeight(451.0);
        barChartPlayers.setPrefWidth(574.0);

        text.setLayoutX(103.0);
        text.setLayoutY(116.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Players Bar Chart");
        text.setFont(new Font("System Bold Italic", 48.0));
         XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Data Series 1");
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
//barChartPlayers.getChildrenUnmodifiable().add(new Label("Ahmed"));
        getChildren().add(imageView);
        getChildren().add(backPlayerChartView);
        getChildren().add(barChartPlayers);
        getChildren().add(text);

    }
}
