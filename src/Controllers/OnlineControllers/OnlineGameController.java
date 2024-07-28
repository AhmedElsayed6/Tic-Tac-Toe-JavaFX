package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import Model.GameBoard;
import Model.Player;
import Views.OnlineViews.OnlineDrawPageClass;
import Views.OnlineViews.OnlineLosePageClass;
import Views.OnlineViews.OnlineWinPageClass;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class OnlineGameController implements Controllers {

    List<Line> linesList;
    List<Label> scoreLabelList;
    List<ImageView> boardImageViews;
    Image player1CoinImage;
    Image player2CoinImage;
    List<Integer> playedCells;
    GameBoard gb;
    Player player1;
    Player player2;
    boolean player1Turn;
    Player currentPlayer;
    String move;

    public OnlineGameController(List<Line> linesList, List<Label> scoreLabelList, List<ImageView> boardImageViews, Player player1, Player player2, boolean player1Turn) {
        this.linesList = linesList;
        this.scoreLabelList = scoreLabelList;
        this.boardImageViews = boardImageViews;
        this.gb = new GameBoard();
        this.player1 = player1;
        this.player2 = player2;
        this.player1Turn = player1Turn;
        this.playedCells = new ArrayList<Integer>();
        ClientThreadHandler.controllersMap.put("game", this);
        initPlayer1();
        initPlayer2();
        setScoreBoard();
        setFirstCurrentPlayer();
        setOnClickHandlers();
    }

    private void initPlayer1() {
        Image imageX = new Image("/Images/X.png", true);
        Image imageO = new Image("/Images/O.png", true);
        player1CoinImage = player1.getCoin() == 1 ? imageX : imageO;
    }

    private void initPlayer2() {
        Image imageX = new Image("/Images/X.png", true);
        Image imageO = new Image("/Images/O.png", true);
        player2CoinImage = player2.getCoin() == 1 ? imageX : imageO;
    }

    private void setScoreBoard() {

        scoreLabelList.get(0).setText(String.valueOf(player1.getScore()));
        scoreLabelList.get(1).setText(String.valueOf(player2.getScore()));

    }

    private void setFirstCurrentPlayer() {
        if (player1Turn == true) {
            currentPlayer = player1;
            enableAllImageViews();
        } else {
            currentPlayer = player2;
            disableAllImageViews();
        }

    }

    private void setCurrentPlayer() {
        // playedmove,ahmed8,abd9,false,index
        ClientThreadHandler.queryQueue.add("playedmove," + player1.getUsername() + "," + player2.getUsername() + "," + player1Turn + "," + move);
        disableAllImageViews();
    }

    private void sendWin() {
        // playedmove,ahmed8,abd9,false,index
        ClientThreadHandler.queryQueue.add("win," + player1.getUsername() + "," + player2.getUsername() + "," + player1Turn + "," + move);
        disableAllImageViews();
    }

    private void showLose() {
        // playedmove,ahmed8,abd9,false,index
        ClientThreadHandler.queryQueue.add("lose," + player1.getUsername() + "," + player2.getUsername() + "," + player1Turn + "," + move);
        disableAllImageViews();
    }

    private void sendDraw() {
        // playedmove,ahmed8,abd9,false,index
        ClientThreadHandler.queryQueue.add("draw," + player1.getUsername() + "," + player2.getUsername() + "," + player1Turn + "," + move);
        disableAllImageViews();
    }

    private void disableAllImageViews() {
        for (ImageView i : boardImageViews) {
            i.setDisable(true);
        }
        Line line;
        line = linesList.get(6);
        line.setEndX(-16.0);
        line.setEndY(-20.0);
        line.setLayoutX(30.0);
        line.setLayoutY(30.0);
        line.setOpacity(1);
        line.setStartX(342.0);
        line.setStartY(418.0);
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(8.0);
        line.setDisable(false);
    }

    private void enableAllImageViews() {
        for (ImageView i : boardImageViews) {
            i.setDisable(false);
        }
        for (int i : playedCells) {
            boardImageViews.get(i).setDisable(true);
        }
        Line line;
        line = linesList.get(6);
        line.setOpacity(0);
        line.setDisable(true);
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

    private void setOnClickHandlers() {
        for (int i = 0; i < boardImageViews.size(); i++) {
            int row = i / 3;
            int col = i % 3;
            int index = i;
            boardImageViews.get(i).setOnMouseClicked(event -> handleImageViewClick(row, col, index));
        }

    }

    private void handleImageViewClick(int row, int col, int index) {
        move = Integer.toString(index);
        playedCells.add(index);
        gb.playPosition(row, col, player1);
        //    SaveGameController.saveMove(row, col , currentPlayer, "Two Players");

        Platform.runLater(() -> {
            boardImageViews.get(index).setImage(player1CoinImage);
        });
        if (gb.checkWin()) {

            drawWinningLine();
            disableAllImageViews();
            currentPlayer.scoreIncrement();
            setScoreBoard();
            System.out.println("Winning");
       //     sendWin();

            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(1));
            pause.setOnFinished((e) -> ChangeSceneController.switchSceneWithStage(new OnlineWinPageClass(player1, player2)));
            pause.play();

//            return;
            //  DialogView dv = new DialogView(player1 , player2  , gb);         
        } else if (gb.numberPlays == 9) {
            sendDraw();

            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(1));
            pause.setOnFinished((e) -> ChangeSceneController.switchSceneWithStage(new OnlineDrawPageClass(player1, player2)));
            pause.play();
        //    return;
            //  DialogView dv = new DialogView(player1 , player2  , gb);  
        }

        player1Turn = !player1Turn; // false 
        setCurrentPlayer();
    }

    private void handleImageViewClickOpponent(int row, int col, int index) {
        gb.playPosition(row, col, player2);
        Platform.runLater(() -> {
            boardImageViews.get(index).setImage(player2CoinImage);
            boardImageViews.get(index).setDisable(true);

        });

    }

    public void recievedPlay(String data) {
        enableAllImageViews();
        String[] move = data.split(",");

        player1Turn = !Boolean.parseBoolean(move[3]);
        setFirstCurrentPlayer();
        int playedMove = Integer.parseInt(move[4]);
        playedCells.add(playedMove);
        int row = playedMove / 3;
        int col = playedMove % 3;
        Platform.runLater(() -> {

            handleImageViewClickOpponent(row, col, playedMove);
            if (gb.checkWin()) {
                drawWinningLine();
                showLose();
                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(1));
                pause.setOnFinished((e) -> ChangeSceneController.switchSceneWithStage(new OnlineLosePageClass(player1, player2)));
                pause.play();
                disableAllImageViews();

            } else if (gb.numberPlays == 9) {
                disableAllImageViews();
                System.out.println("Draw Draw");
            }

        });

        System.out.println(data);
    }

}
