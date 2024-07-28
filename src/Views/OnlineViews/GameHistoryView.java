

package Views.OnlineViews;

import Controllers.ChangeSceneController;
import Controllers.OnlineControllers.GameHistoryController;
import Views.GeneralViews.WelcomePageClass;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class GameHistoryView extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView backArrow;
    protected final Label historyLable;
    protected final ListView listViewHistory;
//    protected final FlowPane flowPaneForListRow;
//    protected final Label infoGameHistoryLable;
//    protected final Button viewGameButton;
    protected final GameHistoryController ghc;
    

    public GameHistoryView() {

        imageView = new ImageView();
        backArrow = new ImageView();
        historyLable = new Label();
        listViewHistory = new ListView();
//        flowPaneForListRow = new FlowPane();
//        infoGameHistoryLable = new Label();
//        viewGameButton = new Button();

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
        imageView.setLayoutY(-34.0);
        imageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        backArrow.setFitHeight(79.0);
        backArrow.setFitWidth(106.0);
        backArrow.setPickOnBounds(true);
        backArrow.setPreserveRatio(true);
        backArrow.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));

        historyLable.setLayoutX(202.0);
        historyLable.setLayoutY(61.0);
        historyLable.setText("History");
        historyLable.setFont(new Font("System Italic", 64.0));

        listViewHistory.setFocusTraversable(false);
        listViewHistory.setLayoutX(90.0);
        listViewHistory.setLayoutY(212.0);
        listViewHistory.setPrefHeight(432.0);
        listViewHistory.setPrefWidth(453.0);

//        flowPaneForListRow.setLayoutX(90.0);
//        flowPaneForListRow.setLayoutY(224.0);
//        flowPaneForListRow.setPrefHeight(38.0);
//        flowPaneForListRow.setPrefWidth(453.0);

//        infoGameHistoryLable.setText("LocalTwoPlayers_2024-07-24-14-23-06t");
//        infoGameHistoryLable.setFont(new Font(18.0));
//        FlowPane.setMargin(infoGameHistoryLable, new Insets(0.0, 0.0, 0.0, 10.0));

//        viewGameButton.setMnemonicParsing(false);
//        viewGameButton.setPrefHeight(29.0);
//        viewGameButton.setPrefWidth(77.0);
//        viewGameButton.setStyle("-fx-background-color: #3f51b5; -fx-border-width: 2;");
//        viewGameButton.setText("View Game");
//        viewGameButton.setTextFill(javafx.scene.paint.Color.WHITE);
//        FlowPane.setMargin(viewGameButton, new Insets(0.0, 0.0, 0.0, 25.0));
//        flowPaneForListRow.setPadding(new Insets(5.0, 0.0, 0.0, 0.0));
//        flowPaneForListRow.getChildren().add(infoGameHistoryLable);
//        flowPaneForListRow.getChildren().add(viewGameButton);
//   listViewHistory.getItems().add(flowPaneForListRow);
        getChildren().add(imageView);
        getChildren().add(backArrow);
        getChildren().add(historyLable);
        getChildren().add(listViewHistory);
        
         ghc = new GameHistoryController(listViewHistory ,backArrow);
    }
}

   