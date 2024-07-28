package Views.OnlineViews;

import Views.AiViews.*;
import Views.AiViews.AIGameBoardView;
import Controllers.ChangeSceneController;

import Controllers.OnlineControllers.ClientThreadHandler;

import Model.Player;
import Views.GeneralViews.WelcomePageClass;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class OnlineLosePageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final MediaView mediaView;
    protected final Text text;
    protected final Button btnMainMenu;
    protected final Button btnPlayAgain;

    public OnlineLosePageClass(Player player1, Player player2) {

        imageView = new ImageView();
        mediaView = new MediaView();
        text = new Text();
        btnMainMenu = new Button();
        btnPlayAgain = new Button();

        setId("AnchorPane");
        setMaxHeight(700.0);
        setMaxWidth(600.0);
        setMinHeight(700.0);
        setMinWidth(600.0);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(830.0);
        imageView.setFitWidth(705.0);
        imageView.setLayoutX(-55.0);
        imageView.setLayoutY(-63.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        mediaView.setFitHeight(300.0);
        mediaView.setFitWidth(400.0);
        mediaView.setLayoutX(100.0);
        mediaView.setLayoutY(181.0);

        String MEDIA_URL = "file:///" + System.getProperty("user.dir").replace("\\", "/") + "/src/Images/lose.mp4";

        MediaPlayer mp = new MediaPlayer( new Media(MEDIA_URL));
        mediaView.setMediaPlayer(mp);
        mp.play();

        text.setLayoutX(211.0);
        text.setLayoutY(155.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("YOU LOSE");
        text.setWrappingWidth(178.13671875);
        text.setFont(new Font("System Bold Italic", 36.0));

        btnMainMenu.setLayoutX(336.0);
        btnMainMenu.setLayoutY(535.0);
        btnMainMenu.setMnemonicParsing(false);
        btnMainMenu.setPrefHeight(60.0);
        btnMainMenu.setPrefWidth(164.0);
        btnMainMenu.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-color: white; -fx-border-radius: 50; -fx-border-width: 2;");
        btnMainMenu.setText("Main Menu");
        btnMainMenu.setDisable(true);
        btnMainMenu.setOnMouseClicked((MouseEvent event) -> {
            ChangeSceneController.switchScene(new WelcomePageClass(),event);
        });
        btnMainMenu.setTextFill(javafx.scene.paint.Color.WHITE);
        btnMainMenu.setFont(new Font("System Bold", 18.0));

        btnPlayAgain.setLayoutX(100.0);
        btnPlayAgain.setLayoutY(535.0);
        btnPlayAgain.setMnemonicParsing(false);
        btnPlayAgain.setPrefHeight(60.0);
        btnPlayAgain.setPrefWidth(164.0);
        btnPlayAgain.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-color: white; -fx-border-radius: 50; -fx-border-width: 2;");
        btnPlayAgain.setText("Play Again");
        btnPlayAgain.setTextFill(javafx.scene.paint.Color.WHITE);
        btnPlayAgain.setFont(new Font("System Bold", 18.0));
        btnPlayAgain.setDisable(true);
        btnPlayAgain.setOnMouseClicked((MouseEvent event) -> {

              ClientThreadHandler.queryQueue.add("playinvite," + player1.getUsername()+","+player2.getUsername());
          //  ChangeSceneController.switchScene(new OnlineGameBoardView(player1 , player2  ),event);

        });
        PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(3));
        pause.setOnFinished((e) -> {
                                    btnPlayAgain.setDisable(false);
                                    btnMainMenu.setDisable(false);});
        pause.play();
        getChildren().add(imageView);
        getChildren().add(mediaView);
        getChildren().add(text);
        getChildren().add(btnMainMenu);
        getChildren().add(btnPlayAgain);

    }
}
