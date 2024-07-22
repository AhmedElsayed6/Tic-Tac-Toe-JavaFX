package Controllers;
/// controller for each mode 

import Model.GameBoard;
import Model.Player;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class GameController {

    List<VBox> vboxList;
    List<Line> linesList;
    List<Label> labelList;
    List<ImageView> imageViewList;
    GameBoard gb;
    Player player1;
    Player player2;
    boolean player1Turn = true;
    Player currentPlayer;
    
    public GameController(List<VBox> vboxList, List<Line> linesList , List<Label> labelList) {
        imageViewList = new ArrayList<>();
        this.linesList = linesList;
        this.labelList = labelList;
        this.vboxList = vboxList;
        player1 = new Player(1);
        player2 = new Player(0);
        currentPlayer = player1;
        gb = new GameBoard();
        setScoreBoard();
        gridHandler();

    }
    
    private void setScoreBoard(){
    
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
                line.setEndY(-27.0);
                line.setLayoutX(40.0);
                line.setLayoutY(40.0);
                line.setOpacity(1);
                line.setStartX(-20.0);
                line.setStartY(408.0);
                line.setStrokeWidth(15.0);
                break;

        }

    }

    private void gridHandler() {
        Image imageX = new Image("/Images/X.png", true);
        Image imageO = new Image("/Images/O.png", true);
        ImageView imgView0 = (ImageView) vboxList.get(0).getChildren().iterator().next();
        ImageView imgView1 = (ImageView) vboxList.get(1).getChildren().iterator().next();
        ImageView imgView2 = (ImageView) vboxList.get(2).getChildren().iterator().next();
        ImageView imgView3 = (ImageView) vboxList.get(3).getChildren().iterator().next();
        ImageView imgView4 = (ImageView) vboxList.get(4).getChildren().iterator().next();
        ImageView imgView5 = (ImageView) vboxList.get(5).getChildren().iterator().next();
        ImageView imgView6 = (ImageView) vboxList.get(6).getChildren().iterator().next();
        ImageView imgView7 = (ImageView) vboxList.get(7).getChildren().iterator().next();
        ImageView imgView8 = (ImageView) vboxList.get(8).getChildren().iterator().next();
        imageViewList.add(imgView0);
        imageViewList.add(imgView3);
        imageViewList.add(imgView6);
        imageViewList.add(imgView1);
        imageViewList.add(imgView4);
        imageViewList.add(imgView7);
        imageViewList.add(imgView2);
        imageViewList.add(imgView5);
        imageViewList.add(imgView8);

        imgView0.setOnMouseClicked(event -> {
            gb.playPosition(0, 0, currentPlayer);
            Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
            System.out.println("0 0");
            imgView0.setImage(img);
            if (gb.checkWin()) {
                drawWinningLine();
                disableAllImageViews();
                currentPlayer.scoreIncrement();
                setScoreBoard();
                
                System.out.println(currentPlayer.getCoin() + " Wins");
                //Platform.exit();
            } else if (gb.numberPlays == 9) {
                System.out.println("Draw");
            }
            player1Turn = !player1Turn;
            setCurrentPlayer();
            imgView0.setDisable(true);

        });
        imgView1.setOnMouseClicked(event -> {

            gb.playPosition(0, 1, currentPlayer);
            Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
            System.out.println("0 1");
            Platform.runLater(() -> {

                imgView1.setImage(img);
            });
            if (gb.checkWin()) {
                drawWinningLine();
                disableAllImageViews();
                   currentPlayer.scoreIncrement();
                     setScoreBoard();
                System.out.println(currentPlayer.getCoin() + " Wins");
                // Platform.exit();
            } else if (gb.numberPlays == 9) {
                System.out.println("Draw");
            }
            player1Turn = !player1Turn;
            setCurrentPlayer();
            imgView1.setDisable(true);

        });
        imgView2.setOnMouseClicked(event -> {

            gb.playPosition(0, 2, currentPlayer);
            Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
            System.out.println("0 2");
            Platform.runLater(() -> {
                imgView2.setImage(img);
            });
            if (gb.checkWin()) {
                drawWinningLine();
                disableAllImageViews();
                   currentPlayer.scoreIncrement();
                     setScoreBoard();
                System.out.println(currentPlayer.getCoin() + " Wins");
                //Platform.exit();
            } else if (gb.numberPlays == 9) {
                System.out.println("Draw");
            }
            player1Turn = !player1Turn;
            setCurrentPlayer();
            imgView2.setDisable(true);

        });
        imgView3.setOnMouseClicked(event -> {

            gb.playPosition(1, 0, currentPlayer);
            System.out.println("1 0");

            Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
            Platform.runLater(() -> {
                imgView3.setImage(img);
            });
            if (gb.checkWin()) {
                drawWinningLine();
                disableAllImageViews();
                
                   currentPlayer.scoreIncrement();
                     setScoreBoard();
                System.out.println(currentPlayer.getCoin() + " Wins");
                //Platform.exit();
            } else if (gb.numberPlays == 9) {
                System.out.println("Draw");
            }
            player1Turn = !player1Turn;
            setCurrentPlayer();
            imgView3.setDisable(true);

        });
        imgView4.setOnMouseClicked(event -> {

            gb.playPosition(1, 1, currentPlayer);
            System.out.println("1 1");
            Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
            Platform.runLater(() -> {
                imgView4.setImage(img);
            });
            if (gb.checkWin()) {
                drawWinningLine();
                disableAllImageViews();
                   currentPlayer.scoreIncrement();
                     setScoreBoard();
                System.out.println(currentPlayer.getCoin() + " Wins");
                // Platform.exit();
            } else if (gb.numberPlays == 9) {
                System.out.println("Draw");
            }
            player1Turn = !player1Turn;
            setCurrentPlayer();
            imgView4.setDisable(true);

        });
        imgView5.setOnMouseClicked(event -> {

            gb.playPosition(1, 2, currentPlayer);
            System.out.println("1 2");
            Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
            Platform.runLater(() -> {
                imgView5.setImage(img);
            });
            if (gb.checkWin()) {
                drawWinningLine();
                disableAllImageViews();
                   currentPlayer.scoreIncrement();
                     setScoreBoard();
                System.out.println(currentPlayer.getCoin() + " Wins");
                //Platform.exit();
            } else if (gb.numberPlays == 9) {
                System.out.println("Draw");
            }
            player1Turn = !player1Turn;
            setCurrentPlayer();
            imgView5.setDisable(true);

        });
        imgView6.setOnMouseClicked(event -> {

            gb.playPosition(2, 0, currentPlayer);
            System.out.println("2 0");
            Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
            Platform.runLater(() -> {
                imgView6.setImage(img);
            });
            if (gb.checkWin()) {
                drawWinningLine();
                disableAllImageViews();
                   currentPlayer.scoreIncrement();
                     setScoreBoard();
                System.out.println(currentPlayer.getCoin() + " Wins");
                // Platform.exit();
            } else if (gb.numberPlays == 9) {
                System.out.println("Draw");
            }
            player1Turn = !player1Turn;
            setCurrentPlayer();
            imgView6.setDisable(true);

        });
        imgView7.setOnMouseClicked(event -> {

            gb.playPosition(2, 1, currentPlayer);
            Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
            System.out.println("2 1 ");
            Platform.runLater(() -> {
                imgView7.setImage(img);
            });
            if (gb.checkWin()) {
                drawWinningLine();
                disableAllImageViews();
                   currentPlayer.scoreIncrement();
                     setScoreBoard();
                System.out.println(currentPlayer.getCoin() + " Wins");
                // Platform.exit();
            } else if (gb.numberPlays == 9) {
                System.out.println("Draw");
            }
            player1Turn = !player1Turn;
            setCurrentPlayer();
            imgView7.setDisable(true);

        });
        imgView8.setOnMouseClicked(event -> {

            gb.playPosition(2, 2, currentPlayer);
            System.out.println("2 2");
            Image img = currentPlayer.getCoin() == 1 ? imageX : imageO;
            Platform.runLater(() -> {
                imgView8.setImage(img);
            });
            if (gb.checkWin()) {
                drawWinningLine();
                disableAllImageViews();
                   currentPlayer.scoreIncrement();
                     setScoreBoard();
                System.out.println(currentPlayer.getCoin() + " Wins");
                //  Platform.exit();
            } else if (gb.numberPlays == 9) {
                System.out.println("Draw");
            }
            player1Turn = !player1Turn;
            setCurrentPlayer();
            imgView8.setDisable(true);

        });
    }

}
