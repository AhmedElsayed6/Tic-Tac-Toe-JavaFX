package Views.LocalViews;

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
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;

public class DialogView {

    Alert dialog;

    public DialogView(Player player1, Player player2, GameBoard gb) {

        final FlowPane dialogPane;
    
        dialogPane = new FlowPane();
     
        Button menuBtn = new Button("Main Menu");
 
        Button rematchBtn = new Button("Rematch");
   

        dialogPane.setAlignment(javafx.geometry.Pos.CENTER);
        dialogPane.setHgap(70.0);
        dialogPane.setMaxHeight(100.0);
        dialogPane.setMaxWidth(400.0);
        dialogPane.setMinHeight(100.0);
        dialogPane.setMinWidth(400.0);
        dialogPane.setPrefHeight(100.0);
        dialogPane.setPrefWidth(400.0);
        dialogPane.setRowValignment(javafx.geometry.VPos.TOP);

        dialogPane.getChildren().add(menuBtn);
  
        dialogPane.getChildren().add(rematchBtn);

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
                ChangeSceneController.switchSceneWithStage(new ChosePageClass());
                dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

                dialog.close();

            }
        });

   
        // Add event handler for rematch button
        rematchBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChangeSceneController.switchSceneWithStage(new LocalGameBoardView(player1, player2));
                dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
                dialog.close();

                System.out.println("Rematch started!");
            }
        });

        // Display the dialog
        dialog.showAndWait();
    }
}
