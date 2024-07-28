package Views.OnlineViews;

import Views.GeneralViews.ChosePageClass;
import Controllers.ChangeSceneController;
import Model.GameBoard;
import Model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class DialogView {

    Alert dialog;

    public DialogView(Player player1, Player player2, GameBoard gb) {

        final BorderPane dialogPane;
    
        dialogPane = new BorderPane();
     
        Button menuBtn = new Button("Accept");
 
        Button rematchBtn = new Button("Reject");
   
       Label middleLabel = new Label("Player: User2 hase invited you to a game.");
middleLabel.setStyle("-fx-font-size: 16;");

        HBox buttonsBox = new HBox(20);
        buttonsBox.getChildren().addAll(menuBtn, rematchBtn);
        buttonsBox.setAlignment(javafx.geometry.Pos.CENTER);

        dialogPane.setCenter(middleLabel);
        dialogPane.setBottom(buttonsBox);

        dialog = new Alert(AlertType.NONE);
        dialog.setTitle("Tic Tac Toe");
        dialog.setHeaderText(null);
        dialog.setContentText(null);

        menuBtn.setMinSize(70, 20);
 
        rematchBtn.setMinSize(70, 20);

        menuBtn.setStyle("-fx-background-color: #1976d2; -fx-background-radius: 50px; -fx-border-color: #ffffff; -fx-border-radius: 50px; -fx-shape: url('Rec.svg');;");
        menuBtn.setTextFill(javafx.scene.paint.Color.WHITE);


        rematchBtn.setStyle("-fx-background-color: #1976d2; -fx-background-radius: 50px; -fx-border-color: #ffffff; -fx-border-radius: 50px; -fx-shape: url('Rec.svg');;");
        rematchBtn.setTextFill(javafx.scene.paint.Color.WHITE);

        dialog.initOwner(ChangeSceneController.getStage());

        Image backgroundImage = new Image("/Images/BackGround.png");
        BackgroundSize backgroundSize = new BackgroundSize(400, 200, true, true, true, true);
        BackgroundImage bgImage = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        dialog.getDialogPane().setBackground(new Background(bgImage));
        dialog.getDialogPane().setMinSize(400, 150);
        dialog.getDialogPane().setContent(dialogPane);

        // Add event handler for exit button
        menuBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
                dialog.close();

            }
        });

   
        // Add event handler for rematch button
        rematchBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
                dialog.close();

            }
        });

        // Display the dialog
        dialog.showAndWait();
    }
}