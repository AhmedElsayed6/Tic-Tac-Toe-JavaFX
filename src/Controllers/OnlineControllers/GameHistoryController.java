package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import Views.OnlineViews.ReplayGameBoardView;
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

/*: f,getuserhistory,
    ff_1~7~001020~2024-07-28-23:29~0.0.1~0.2.0~1.0.1~1.2.0~0.1.1~1.1.0~2.0.1~,
    ff_0~8~001020~2024-07-28-23:30~0.2.1~0.0.0~1.2.1~1.0.0~0.1.1~1.1.0~2.1.1~2.0.0~,
    ff_0~8~011121~2024-07-28-23:30~2.0.1~1.1.0~0.2.1~0.0.0~2.2.1~0.1.0~1.0.1~2.1.0~,
    ff_0~9~021222~2024-07-28-23:31~0.2.1~0.0.0~1.2.1~1.0.0~0.1.1~1.1.0~2.0.1~2.1.0~2.2.1~,
    ff_1~9~001020~2024-07-28-23:32~0.0.1~0.2.0~1.0.1~1.2.0~0.1.1~1.1.0~2.2.1~2.1.0~2.0.1~,
    ff_1~8~021120~2024-07-28-23:32~0.0.1~0.2.0~1.0.1~1.2.0~0.1.1~1.1.0~2.1.1~2.0.0~,
    ff_1~9~~2024-07-28-23:33~1.1.1~0.2.0~0.1.1~0.0.0~2.2.1~1.0.0~2.0.1~2.1.0~1.2.1~,
    ff_1~9~021222~2024-07-28-23:36~0.0.1~1.1.0~0.2.1~0.1.0~2.1.1~1.0.0~1.2.1~2.0.0~2.2.1~,
    ff_1~7~001020~2024-07-28-23:29~0.0.1~0.2.0~1.0.1~1.2.0~0.1.1~1.1.0~2.0.1~*/
     //  "vv,vvv,1~5~001020~2024-07-28-20:10~0.0.1~0.2.0~1.0.1~1.2.0~2.0.1~"    
    public void setHistory(String history) {
        backArrow.setOnMouseClicked((MouseEvent event) -> {
            ChangeSceneController.switchScene(new onlinePageClass(),event);
        });
       // System.out.println("TEST: " + history);
        String[] historyarray = history.split(",");
        if (historyarray.length>2 ) {
            //zz_
            //0~5~021222~2024-07-29-00:25~0.2.1~0.0.0~1.2.1~1.0.0~2.2.1~
            System.out.println(historyarray[2]);
       
            for (int i = 2; i < historyarray.length; i++) {
                String[] historyData = historyarray[i].split("_"); 
                // historyData[0] // enemy username
                // match info
          
                String[] historyInfo = historyarray[i].split("~");
                // historyInfo[3] // time
                FlowPane flowPaneForListRow = new FlowPane();
                Label infoGameHistoryLable = new Label();
                String[] vsPlayer = historyInfo[0].split("_");
                infoGameHistoryLable.setText("Enemy: " + historyData[0]+" Date: " + historyInfo[3] );
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
                viewGameButton.setText("View");
                viewGameButton.setTextFill(javafx.scene.paint.Color.WHITE);
                FlowPane.setMargin(infoGameHistoryLable, new Insets(0.0, 0.0, 0.0, 10.0));
                FlowPane.setMargin(viewGameButton, new Insets(0.0, 0.0, 0.0, 25.0));
                flowPaneForListRow.setPadding(new Insets(5.0, 0.0, 0.0, 0.0));
                flowPaneForListRow.setHgap(40);
                flowPaneForListRow.getChildren().add(infoGameHistoryLable);
                flowPaneForListRow.getChildren().add(viewGameButton);
                // Add the items to the list view
                listViewHistory.getItems().add(flowPaneForListRow);
                viewGameButton.setOnAction(( event) -> {
                           String match = "";
                 match+= historyarray[0]+","+historyData[0] +","+ historyData[1];
                    System.out.println("matchchchch:: "+ match);
                   ChangeSceneController.switchSceneWithStage(new ReplayGameBoardView(match));
        });
            }
        }

    }
}
