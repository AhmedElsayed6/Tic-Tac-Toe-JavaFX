package Views;

import Controllers.ChangeSceneController;
import Controllers.SaveGameController;
import Model.GameBoard;
import Model.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class DialogView {

    Alert dialog;

    public DialogView(Player player1 , Player player2 , GameBoard gb ) {
        
        
     final FlowPane dialogPane;
     final FlowPane buttonPane;
     final Button button;
     final Button button0;
     final Button button1;
     final Label label;

   
        dialogPane = new FlowPane();
        buttonPane = new FlowPane();
        Button menuBtn = new Button("Main Menu");
        Button saveBtn = new Button("Save");
        Button rematchBtn = new Button("Rematch");
        label =new Label("Match Saved !");
          
       label.setOpacity(0);
        dialogPane.getChildren().add(buttonPane);
        dialogPane.getChildren().add(label);
        dialogPane.setAlignment(javafx.geometry.Pos.CENTER);
        dialogPane.setColumnHalignment(javafx.geometry.HPos.CENTER);
        dialogPane.setMaxHeight(150.0);
        dialogPane.setMaxWidth(400.0);
        dialogPane.setMinHeight(150.0);
        dialogPane.setMinWidth(400.0);
        dialogPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        dialogPane.setPrefHeight(150.0);
        dialogPane.setPrefWidth(400.0);

        buttonPane.setAlignment(javafx.geometry.Pos.CENTER);
        buttonPane.setHgap(70.0);
        buttonPane.setMaxHeight(100.0);
        buttonPane.setMaxWidth(400.0);
        buttonPane.setMinHeight(100.0);
        buttonPane.setMinWidth(400.0);
        buttonPane.setPrefHeight(100.0);
        buttonPane.setPrefWidth(400.0);
        buttonPane.setRowValignment(javafx.geometry.VPos.TOP);

      

  

        buttonPane.getChildren().add(menuBtn);
        buttonPane.getChildren().add(saveBtn);
        buttonPane.getChildren().add(rematchBtn);
  

    
        
        
        dialog = new Alert(AlertType.NONE);
        dialog.setTitle("Tic Tac Toe");
        dialog.setHeaderText(null);
        dialog.setContentText(null);

 
        menuBtn.setMinSize(70, 20);
        saveBtn.setMinSize(70, 20);
        rematchBtn.setMinSize(70, 20);
        

        menuBtn.setStyle("-fx-background-color: #1976d2; -fx-background-radius: 50px; -fx-border-color: #ffffff; -fx-border-radius: 50px; -fx-shape: url('Rec.svg');;");
        menuBtn.setTextFill(javafx.scene.paint.Color.WHITE);

        saveBtn.setStyle("-fx-background-color: #1976d2; -fx-background-radius: 50px; -fx-border-color: #ffffff; -fx-border-radius: 50px; -fx-shape: url('Rec.svg');;");
        saveBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        
        rematchBtn.setStyle("-fx-background-color: #1976d2; -fx-background-radius: 50px; -fx-border-color: #ffffff; -fx-border-radius: 50px; -fx-shape: url('Rec.svg');;");
        rematchBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        
        
 
        dialog.initOwner( ChangeSceneController.getStage());
 

        
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
              ChangeSceneController.switchSceneWithStage(new ChosePageClass() );
              dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
              
              dialog.close();
                
            }
        });

        // Add event handler for save button
        saveBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                  label.setOpacity(1);
                SaveGameController.saveMatch(gb);
                System.out.println("Game saved!");
            }
        });

        // Add event handler for rematch button
        rematchBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               ChangeSceneController.switchSceneWithStage(new LocalGameBoardView(player1 , player2 ) );
                 dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
                 dialog.close();
               
               
                System.out.println("Rematch started!");
            }
        });

    

        // Display the dialog
        dialog.showAndWait();
    }
}
