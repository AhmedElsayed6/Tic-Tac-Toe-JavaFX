package tictactoe;

import Model.ReplaySystem;
import Model.Player;
import Views.*;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
     
        Parent root = new ReplaySystemView();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
