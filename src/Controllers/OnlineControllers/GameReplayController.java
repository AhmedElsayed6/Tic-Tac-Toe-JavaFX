package Controllers.OnlineControllers;

import Model.GameBoard;
import Model.Player;
import java.util.ArrayList;
//import Model.ReplaySystem;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class GameReplayController extends Thread {

    List<Line> linesList;
    List<Label> labelList;
    List<ImageView> imageViewList;
    GameBoard gb;
    Player player1;
    Player player2;
    String match;
    boolean player1Turn;
    Player currentPlayer;
    int numberOfPlays;
    String winningLine;
    List<String> movesList;
    int row;
    int col;
    int index;
    Image imageX;
    Image imageO;

    int currentIteration;
    boolean check;
    volatile Timeline timeline;

    public GameReplayController(List<ImageView> imageViewList, List<Line> linesList, List<Label> labelList, String match) {
        this.imageViewList = imageViewList;
        this.labelList = labelList;
        this.linesList = linesList;
        gb = new GameBoard();
        setImageViewHandlers();
        InitMatch(match);
        setCurrentPlayer();
        disableAllImageViews();
        setImageViewHandlers();
        currentIteration = 0;
        check = true;
        timeline = null;
        start();
    }

    
    
 
    private void InitMatch(String match) {
        System.out.println(match);
        String[] matchData = match.split(",");
        String[] roundsData = matchData[2].split("~");
        // public Player(String name, int coin , int score ) {
        int player1Coin = Integer.valueOf(roundsData[0]);
        int player2Coin = player1Coin == 0 ? 1 : 0;
        player1 = new Player(matchData[0], player1Coin);
        player2 = new Player(matchData[1], player2Coin);
        String matchDate = roundsData[3];
        winningLine = roundsData[2];
        System.out.println(winningLine);
        numberOfPlays = Integer.valueOf(roundsData[1]);
        movesList = new ArrayList<>();
        for (int i = 0; i < numberOfPlays; i++) {
            movesList.add(roundsData[4 + i]);
        }
        //  "vv,vvv,1~5~001020~2024-07-28-20:10~0.0.1~0.2.0~1.0.1~1.2.0~2.0.1~"        
        player1Turn = Integer.valueOf(roundsData[4].split("[.]")[2]) == player1Coin ? true : false;

    }

    private void setCurrentPlayer() {

        if (player1Turn == true) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
    }

    private void disableAllImageViews() {
        for (ImageView i : imageViewList) {
            i.setDisable(true);
        }
    }

    private void drawWinningLine() {
        Line line;
        switch (gb.winningLine) {
            case "000102":
                line = linesList.get(0);
                line.setEndX(387.0);
                line.setEndY(72.0);
                line.setOpacity(1);
                line.setStartX(9.0);
                line.setStartY(72.0);
                line.setStrokeWidth(15.0);
                break;
            case "101112":
                line = linesList.get(1);
                line.setEndX(375.0);
                line.setEndY(214.0);
                line.setLayoutX(10.0);
                line.setLayoutY(10.0);
                line.setOpacity(1);
                line.setStartX(-1.0);
                line.setStartY(215.0);
                line.setStrokeWidth(15.0);
                break;
            case "202122":
                line = linesList.get(2);
                line.setEndX(365.0);
                line.setEndY(363.0);
                line.setLayoutX(20.0);
                line.setLayoutY(20.0);
                line.setOpacity(1);
                line.setStartX(-11.0);
                line.setStartY(363.0);
                line.setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin.ROUND);
                line.setStrokeWidth(15.0);
                break;

            case "001020":
                line = linesList.get(3);
                line.setEndX(62.0);
                line.setEndY(7.0);
                line.setOpacity(1);
                line.setStartX(62.0);
                line.setStartY(445.0);
                line.setStrokeWidth(15.0);
                break;
            case "011121":
                line = linesList.get(4);
                line.setEndX(174.0);
                line.setEndY(3.0);
                line.setLayoutX(10.0);
                line.setLayoutY(10.0);
                line.setOpacity(1);
                line.setStartX(174.0);
                line.setStartY(441.0);
                line.setStrokeWidth(15.0);
                break;
            case "021222":
                line = linesList.get(5);
                line.setEndX(299.0);
                line.setEndY(-10.0);
                line.setLayoutX(20.0);
                line.setLayoutY(20.0);
                line.setOpacity(1);
                line.setStartX(299.0);
                line.setStartY(436.0);
                line.setStrokeWidth(15.0);
                break;
            case "001122":
                line = linesList.get(6);
                line.setEndX(-16.0);
                line.setEndY(-20.0);
                line.setLayoutX(30.0);
                line.setLayoutY(30.0);
                line.setOpacity(1);
                line.setStartX(342.0);
                line.setStartY(418.0);
                line.setStrokeWidth(15.0);
                break;
            case "021120":
                line = linesList.get(7);
                line.setEndX(342.0);
                line.setEndY(-40.0);
                line.setLayoutX(40.0);
                line.setLayoutY(40.0);
                line.setOpacity(1);
                line.setStartX(-20.0);
                line.setStartY(390.0);
                line.setStrokeWidth(15.0);
                break;

        }

    }
   private void drawWinningLinePresistant(String lineString) {
        Line line;
        switch (lineString) {
            case "000102":
                line = linesList.get(0);
                line.setEndX(387.0);
                line.setEndY(72.0);
                line.setOpacity(1);
                line.setStartX(9.0);
                line.setStartY(72.0);
                line.setStrokeWidth(15.0);
                break;
            case "101112":
                line = linesList.get(1);
                line.setEndX(375.0);
                line.setEndY(214.0);
                line.setLayoutX(10.0);
                line.setLayoutY(10.0);
                line.setOpacity(1);
                line.setStartX(-1.0);
                line.setStartY(215.0);
                line.setStrokeWidth(15.0);
                break;
            case "202122":
                line = linesList.get(2);
                line.setEndX(365.0);
                line.setEndY(363.0);
                line.setLayoutX(20.0);
                line.setLayoutY(20.0);
                line.setOpacity(1);
                line.setStartX(-11.0);
                line.setStartY(363.0);
                line.setStrokeLineJoin(javafx.scene.shape.StrokeLineJoin.ROUND);
                line.setStrokeWidth(15.0);
                break;

            case "001020":
                line = linesList.get(3);
                line.setEndX(62.0);
                line.setEndY(7.0);
                line.setOpacity(1);
                line.setStartX(62.0);
                line.setStartY(445.0);
                line.setStrokeWidth(15.0);
                break;
            case "011121":
                line = linesList.get(4);
                line.setEndX(174.0);
                line.setEndY(3.0);
                line.setLayoutX(10.0);
                line.setLayoutY(10.0);
                line.setOpacity(1);
                line.setStartX(174.0);
                line.setStartY(441.0);
                line.setStrokeWidth(15.0);
                break;
            case "021222":
                line = linesList.get(5);
                line.setEndX(299.0);
                line.setEndY(-10.0);
                line.setLayoutX(20.0);
                line.setLayoutY(20.0);
                line.setOpacity(1);
                line.setStartX(299.0);
                line.setStartY(436.0);
                line.setStrokeWidth(15.0);
                break;
            case "001122":
                line = linesList.get(6);
                line.setEndX(-16.0);
                line.setEndY(-20.0);
                line.setLayoutX(30.0);
                line.setLayoutY(30.0);
                line.setOpacity(1);
                line.setStartX(342.0);
                line.setStartY(418.0);
                line.setStrokeWidth(15.0);
                break;
            case "021120":
                line = linesList.get(7);
                line.setEndX(342.0);
                line.setEndY(-40.0);
                line.setLayoutX(40.0);
                line.setLayoutY(40.0);
                line.setOpacity(1);
                line.setStartX(-20.0);
                line.setStartY(390.0);
                line.setStrokeWidth(15.0);
                break;

        }

    }

    public void drawPlay(int row, int col, int index) {
        imageX = new Image("/Images/X.png", true);
        imageO = new Image("/Images/O.png", true);
        gb.playPosition(row, col, currentPlayer);
        Platform.runLater(() -> {
            System.out.println("Player1 Turn: " + player1Turn);
            if (player1Turn) {

                imageViewList.get(index).setImage(player1.getCoin() == 0 ? imageO : imageX);
            } else {

                imageViewList.get(index).setImage(player2.getCoin() == 0 ? imageO : imageX);
            }
            player1Turn = !player1Turn;
        });
      
            System.out.println("HIIII");
            Platform.runLater(()->{drawWinningLine();} );
            disableAllImageViews();
       if (gb.numberPlays == 9) {

        }

        setCurrentPlayer();
    }

    
    
    
       public void run() {
      for(int i = 0 ; i< numberOfPlays ; i++ ){
            try {
              Thread.sleep(1000);
          } catch (InterruptedException ex) {
              Logger.getLogger(GameReplayController.class.getName()).log(Level.SEVERE, null, ex);
          }
                    String move = movesList.get(i);
            String[] locations = move.split("[.]");
                
                int row = Integer.parseInt(locations[0]);
                int col = Integer.parseInt(locations[1]);
                int index = row * 3 + col;
                drawPlay(row, col, index);
                currentIteration++;
                if(i == numberOfPlays-1 )
               drawWinningLinePresistant(winningLine);
        
 
      }
    }
    private void setImageViewHandlers() {

//      currentIteration = 0; // Ensure currentIteration is reset if necessary
//
//    timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
//        if (currentIteration < numberOfPlays) {
//         
//
//            try {
//                int row = Integer.parseInt(locations[0]);
//                int col = Integer.parseInt(locations[1]);
//                int index = row * 3 + col;
//                drawPlay(row, col, index);
//                currentIteration++;
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//                // Handle error (e.g., log it, notify the user, etc.)
//            }
//        } else {
//            if (timeline != null) {
//                timeline.stop();
//            }
//            // Perform any additional cleanup if needed
//        }
//        timeline.setDelay(Duration.seconds(1));
//    }));
//
//    timeline.setCycleCount(numberOfPlays); // Number of iterations
//     // Ensure initial delay
//    timeline.play();;
//    
//    }

}
}