package Controllers;
/// controller for each mode 

import Model.GameBoard;
import Model.Player;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;


public class GameController {

    List<Line> linesList;
    List<Label> labelList;
    List<ImageView> imageViewList;
    GameBoard gb;
    Player player1;
    Player player2;
    boolean player1Turn = true;
    Player currentPlayer;
    AiControler ai;
    public GameController(List<ImageView> imageViewList, List<Line> linesList, List<Label> labelList) {
        this.imageViewList = imageViewList;
        this.labelList = labelList;
        this.linesList = linesList;
        player1 = new Player(1);
        player2 = new Player(0);
        currentPlayer = player1;
        ai=new AiControler(imageViewList, linesList, labelList);
        gb = new GameBoard();
        setScoreBoard();
        setImageViewHandlers();

    }

    public void setScoreBoard() {

        labelList.get(0).setText(String.valueOf(player1.getScore()));
        labelList.get(1).setText(String.valueOf(player2.getScore()));

    }

    public void setCurrentPlayer() {
        if (player1Turn == true) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
    }

    public void disableAllImageViews() {
        for (ImageView i : imageViewList) {
            i.setDisable(true);
        }
    }
    
    public void enableAllImageViews() {
        for (ImageView i : imageViewList) {
            if(i.getImage()==null)
            i.setDisable(false);
        }
    }

    public void drawWinningLine() {
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

    public void handleImageViewClick(int row, int col, int index) {
        Image imageX = new Image("/Images/X.png", true);
        Image imageO = new Image("/Images/O.png", true);
        gb.playPosition(row, col, currentPlayer);
        Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
        Platform.runLater(() -> {
            imageViewList.get(index).setImage(img);
        });
        if (gb.checkWin()) {
            drawWinningLine();
            disableAllImageViews();
            currentPlayer.scoreIncrement();
            setScoreBoard();
        } else if (gb.numberPlays == 9) {
            System.out.println("Draw");
        }
        player1Turn = !player1Turn;
        setCurrentPlayer();
        imageViewList.get(index).setDisable(true);
    }

    public void setImageViewHandlers() {
        for (int i = 0; i < imageViewList.size(); i++) {
            int row = i / 3;
            int col = i % 3;
            int index = i;
            //System.out.println(i+" "+col+" "+row);
            imageViewList.get(i).setOnMouseClicked(event -> {
                 System.out.println(gb.checkValidCell(row, col));
                handleImageViewClick(row, col, index);
                 System.out.println(gb.checkValidCell(row, col));
                  ai.playAi();
            });
        }

    }

}
