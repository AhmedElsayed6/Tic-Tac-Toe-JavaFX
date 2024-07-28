package Views.OnlineViews;

import Controllers.OnlineControllers.GameHistoryController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class GameHistoryView extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final ScrollPane scrollPane;
    protected final FlowPane flowPane;
    protected final Label label0;
    protected final Label label1;
    protected final Line line;
    protected final Button button;
    GameHistoryController ghc;
    public GameHistoryView() {

        imageView = new ImageView();
        label = new Label();
        scrollPane = new ScrollPane();
        flowPane = new FlowPane();
        label0 = new Label();
        label1 = new Label();
        line = new Line();
        button = new Button();
        ghc = new GameHistoryController();
        setId("AnchorPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(744.0);
        imageView.setFitWidth(621.0);
        imageView.setLayoutX(-8.0);
        imageView.setLayoutY(-29.0);
        imageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        label.setLayoutX(202.0);
        label.setLayoutY(61.0);
        label.setText("Histroy");
        label.setFont(new Font("System Italic", 64.0));

        scrollPane.setLayoutX(80.0);
        scrollPane.setLayoutY(183.0);
        scrollPane.setPrefHeight(339.0);
        scrollPane.setPrefWidth(453.0);

        flowPane.setPrefHeight(38.0);
        flowPane.setPrefWidth(449.0);

        label0.setText("Game Name");
        label0.setFont(new Font(24.0));
        FlowPane.setMargin(label0, new Insets(0.0, 50.0, 0.0, 10.0));

        label1.setText("Date");
        label1.setFont(new Font(24.0));
        FlowPane.setMargin(label1, new Insets(0.0, 0.0, 0.0, 70.0));
        scrollPane.setContent(flowPane);

        line.setEndX(532.0);
        line.setEndY(223.0);
        line.setStartX(80.0);
        line.setStartY(223.0);

        button.setLayoutX(277.0);
        button.setLayoutY(586.0);
        button.setMnemonicParsing(false);
        button.setText("View Game");

        getChildren().add(imageView);
        getChildren().add(label);
        flowPane.getChildren().add(label0);
        flowPane.getChildren().add(label1);
        getChildren().add(scrollPane);
        getChildren().add(line);
        getChildren().add(button);

    }
}
