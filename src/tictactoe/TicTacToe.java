package tictactoe;

import Controllers.OnlineControllers.ClientThreadHandler;
import Views.OnlineViews.LoginPageClass;
import Views.OnlineViews.SignUpPageClass;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        ClientThreadHandler cth = new ClientThreadHandler();
        Parent root = new SignUpPageClass();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
