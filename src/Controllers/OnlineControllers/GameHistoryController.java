package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import Views.OnlineViews.onlinePageClass;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.util.Callback;

public class GameHistoryController implements Controllers {

    ImageView backArrow;
    ListView listViewHistory;

    public GameHistoryController(ListView listViewHistory, ImageView backArrow) {
        this.listViewHistory = listViewHistory;
        this.backArrow = backArrow;
        getHistory();
    }

    private void getHistory() {
        ClientThreadHandler.queryQueue.add("gethistory," + LoginController.getUsername());
        ClientThreadHandler.controllersMap.put("history", this);
    }


    public void setHistory(String history) {
        backArrow.setOnMouseClicked((MouseEvent event) -> {
            ChangeSceneController.switchScene(new onlinePageClass(),event);
        });
        System.out.println("TEST: " + history);
        String[] historyarray = history.split(",");
        if (historyarray[2] != null) {
            System.out.println(historyarray[2]);

            for (int i = 2; i < historyarray.length; i++) {
                String[] historyiNFO = historyarray[i].split("~");
                FlowPane flowPaneForListRow = new FlowPane();
                Label infoGameHistoryLable = new Label();
                String[] vsPlayer = historyiNFO[0].split("_");
                infoGameHistoryLable.setText("Vs:\t" + vsPlayer[0]+"\t"+historyiNFO[2].substring(0,10)+" "+historyiNFO[2].substring(11)+"\t\t\t");
                Button viewGameButton = new Button();
                flowPaneForListRow.setLayoutX(90.0);
                flowPaneForListRow.setLayoutY(224.0);
                flowPaneForListRow.setPrefHeight(38.0);
                flowPaneForListRow.setPrefWidth(453.0);
                infoGameHistoryLable.setFont(new Font(18.0));
                viewGameButton.setMnemonicParsing(false);
                viewGameButton.setPrefHeight(29.0);
                viewGameButton.setPrefWidth(77.0);
                viewGameButton.setStyle("-fx-background-color: #3f51b5; -fx-border-width: 2;");
                viewGameButton.setText("View Game");
                viewGameButton.setTextFill(javafx.scene.paint.Color.WHITE);
                FlowPane.setMargin(infoGameHistoryLable, new Insets(0.0, 0.0, 0.0, 10.0));
                FlowPane.setMargin(viewGameButton, new Insets(0.0, 0.0, 0.0, 25.0));
                flowPaneForListRow.setPadding(new Insets(5.0, 0.0, 0.0, 0.0));
                flowPaneForListRow.getChildren().add(infoGameHistoryLable);
                flowPaneForListRow.getChildren().add(viewGameButton);

                // Add the items to the list view
                listViewHistory.getItems().add(flowPaneForListRow);
                viewGameButton.setOnAction(( event) -> {
                    System.out.println("dasdas");
        });
            }
        }

    }
}
