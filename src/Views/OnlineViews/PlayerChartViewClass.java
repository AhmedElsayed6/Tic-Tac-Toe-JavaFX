package Views.OnlineViews;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PlayerChartViewClass extends AnchorPane {

    public PlayerChartViewClass() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/PlayerChartView.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
