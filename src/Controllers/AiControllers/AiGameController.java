/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.AiControllers;

import Controllers.ChangeSceneController;
import Model.GameBoard;
import Model.Player;
import Views.AiViews.AIGameBoardView;
import Views.LocalViews.DialogView;
import Views.AiViews.DrawPageClass;
import Views.AiViews.LosePageClass;
import Views.AiViews.WinPageClass;
import java.util.List;
import java.util.Random;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class AiGameController {

    List<Line> linesList;
    List<Label> labelList;
    List<ImageView> imageViewList;
    GameBoard gb;
    Player player1;//Ai
    Player player2;
    boolean player1Turn = true;
    Player currentPlayer;
    Random rand;
    int def;
    int indexRandom;
    String gameMode;

    public AiGameController(List<ImageView> imageViewList, List<Line> linesList, List<Label> labelList, int def) {
        this.imageViewList = imageViewList;
        this.def = def;
        this.labelList = labelList;
        this.linesList = linesList;
        player1 = new Player(1);
        player2 = new Player(0);
        currentPlayer = player1;
        gb = new GameBoard();
        setScoreBoard();
        setImageViewHandlers();
        rand = new Random();
    }

    public void playAi() {
        if (player1Turn == false && !gb.checkWin() && gb.numberPlays < 9) {
            disableAllImageViews();
            int index = 0;
            switch (def) {
                case 1:
                    index = easyAI();
                    break;
                case 2:
                    index = mediumAI(initializeBoard());
                    break;
                case 3:
                    index = hardAI(initializeBoard(), 0, player1Turn);
                    break;

            }
            int row = index / 3;
            int col = index % 3;
            handleImageViewClick(row, col, index);
            enableAllImageViews();

        }
    }

    public boolean checkWinner(int[] board, Player player) {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6} // Diagonals
        };
        for (int[] condition : winConditions) {
            if (board[condition[0]] == player.getCoin() && board[condition[1]] == player.getCoin() && board[condition[2]] == player.getCoin()) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull(int[] board) {
        for (int spot : board) {
            if (spot == 2) {
                return false;
            }
        }
        return true;
    }

    public int[] initializeBoard() {
        return new int[]{gb.board[0][0].getValue(), gb.board[0][1].getValue(), gb.board[0][2].getValue(), gb.board[1][0].getValue(), gb.board[1][1].getValue(), gb.board[1][2].getValue(), gb.board[2][0].getValue(), gb.board[2][1].getValue(), gb.board[2][2].getValue()};
    }

    private void setImageViewHandlers() {

        for (int i = 0; i < imageViewList.size(); i++) {
            int row = i / 3;
            int col = i % 3;
            int index = i;

            imageViewList.get(i).setOnMouseClicked(event -> {
                handleImageViewClick(row, col, index);
                PauseTransition pauseone = new PauseTransition(javafx.util.Duration.seconds(0.8));
                pauseone.setOnFinished((e) -> playAi());
                pauseone.play();
               
            });

        }
    }

    public int mediumAI(int[] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i] == 2) {
                board[i] = 0;
                if (checkWinner(board, player2)) {
                    board[i] = 2;
                    return i;
                }
                board[i] = 2;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i] == 2) {
                board[i] = 1;
                if (checkWinner(board, player1)) {
                    board[i] = 2;
                    return i;
                }
                board[i] = 2;
            }
        }
        return easyAI();
    }

    private int easyAI() {
        int rowRandom;
        int colRandom;
        int index = 0;
        do {
            rowRandom = rand.nextInt(3);
            colRandom = rand.nextInt(3);
        } while (!gb.checkValidCell(rowRandom, colRandom));
        index = rowRandom * 3 + colRandom;
        return index;
    }

    public int minimax(int[] board, int depth, boolean isMaximizing) {
        if (checkWinner(board, player2)) {
            return 10 - depth;
        }
        if (checkWinner(board, player1)) {
            return depth - 10;
        }
        if (isFull(board)) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == 2) {
                    board[i] = 0;
                    int score = minimax(board, depth + 1, false);
                    board[i] = 2;
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {

            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == 2) {
                    board[i] = 1;
                    int score = minimax(board, depth + 1, true);
                    board[i] = 2;
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }

    public int hardAI(int[] board, int depth, boolean isMaximizing) {
        int bestMove = -1;
        int bestScore = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            if (board[i] == 2) {
                board[i] = 0;
                int score = minimax(board, depth, isMaximizing);
                board[i] = 2;
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }

    private void setScoreBoard() {

        labelList.get(0).setText(String.valueOf(player1.getScore()));
        labelList.get(1).setText(String.valueOf(player2.getScore()));

    }

    private void setCurrentPlayer() {
        if (player1Turn == true) {
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
    }

    private void enableAllImageViews() {
        for (ImageView i : imageViewList) {
            if (i.getImage() == null) {
                i.setDisable(false);
            }
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

    private void handleImageViewClick(int row, int col, int index) {

        Image imageX = new Image("/Images/X.png", true);
        Image imageO = new Image("/Images/O.png", true);
        gb.playPosition(row, col, currentPlayer);
        Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
        Platform.runLater(() -> {
            imageViewList.get(index).setImage(img);
        });
        if (gb.checkWin()) {
            System.out.println(player1Turn);
            drawWinningLine();
            disableAllImageViews();
            currentPlayer.scoreIncrement();
            setScoreBoard();
            if(currentPlayer == player1){
                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(1));
                pause.setOnFinished((e) ->ChangeSceneController.switchSceneWithStage(new WinPageClass(player1 , player2 ,def )));
                pause.play();
            }else{
                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(1));
                pause.setOnFinished((e) ->ChangeSceneController.switchSceneWithStage(new LosePageClass(player1 , player2 ,def )));
                pause.play();
            }
            
           
        } else if (gb.numberPlays == 9) {
            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(1));
            pause.setOnFinished((e) ->ChangeSceneController.switchSceneWithStage(new DrawPageClass(player1 , player2 ,def )));
            pause.play();
        }
        
        player1Turn = !player1Turn;
        setCurrentPlayer();
        imageViewList.get(index).setDisable(true);
    }

}
