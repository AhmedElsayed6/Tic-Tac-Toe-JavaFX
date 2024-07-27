package tictactoe;

import Controllers.OnlineControllers.ClientThreadHandler;
import Views.GeneralViews.WelcomePageClass;
import Views.OnlineViews.IpPageClass;
import Views.OnlineViews.LoginPageClass;
import Views.OnlineViews.SignUpPageClass;
import Views.OnlineViews.onlinePageClass;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new WelcomePageClass();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
