package tictactoe;

import Controllers.OnlineControllers.ClientThreadHandler;
import Views.GeneralViews.WelcomePageClass;
<<<<<<< HEAD
=======
import Views.OnlineViews.IpPageClass;
>>>>>>> ef5d7d20d9d31972eb3e40c67c7377c2c27a167e
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
<<<<<<< HEAD
        ClientThreadHandler cth = new ClientThreadHandler();
        Parent root = new onlinePageClass();
=======

    

        Parent root = new WelcomePageClass();
>>>>>>> ef5d7d20d9d31972eb3e40c67c7377c2c27a167e
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
