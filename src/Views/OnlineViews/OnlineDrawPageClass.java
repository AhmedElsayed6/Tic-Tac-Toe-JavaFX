package Views.OnlineViews;

import Views.AiViews.*;
import Views.AiViews.AIGameBoardView;
import Controllers.ChangeSceneController;
import Controllers.OnlineControllers.ClientThreadHandler;
import Model.Player;
import Views.GeneralViews.WelcomePageClass;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
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

public class OnlineDrawPageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView draw;
    protected final Text text;
    protected final Button btnMainMenu;
    protected final Button btnPlayAgain;

    public OnlineDrawPageClass(Player player1, Player player2) {

        imageView = new ImageView();
        draw = new ImageView();
        text = new Text();
        btnMainMenu = new Button();
        btnPlayAgain = new Button();

        setId("AnchorPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(847.0);
        imageView.setFitWidth(672.0);
        imageView.setLayoutX(-36.0);
        imageView.setLayoutY(-17.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        draw.setFitHeight(300.0);
        draw.setFitWidth(400.0);
        draw.setLayoutX(100.0);
        draw.setLayoutY(187.0);
        draw.setImage(new Image(getClass().getResource("/Images/draw.jpg").toExternalForm()));
        
        text.setLayoutX(240.0);
        text.setLayoutY(147.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("DRAW");
        text.setWrappingWidth(120.13671875);
        text.setFont(new Font("System Bold Italic", 36.0));

        btnMainMenu.setLayoutX(336.0);
        btnMainMenu.setLayoutY(535.0);
        btnMainMenu.setMnemonicParsing(false);
        btnMainMenu.setPrefHeight(60.0);
        btnMainMenu.setPrefWidth(164.0);
//        btnMainMenu.setDisable(true);
        btnMainMenu.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-color: white; -fx-border-radius: 50; -fx-border-width: 2;");
        btnMainMenu.setText("Main Menu");
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
//        btnPlayAgain.setDisable(true);
        btnPlayAgain.setFont(new Font("System Bold", 18.0));
        btnPlayAgain.setOnMouseClicked((MouseEvent event) -> {
              ClientThreadHandler.queryQueue.add("playinvite," + player1.getUsername()+","+player2.getUsername());
          //  ChangeSceneController.switchScene(new OnlineGameBoardView(player1 , player2 ),event);
        });
      
        getChildren().add(imageView);
        getChildren().add(draw);
        getChildren().add(text);
        getChildren().add(btnMainMenu);
        getChildren().add(btnPlayAgain);

    }
}
