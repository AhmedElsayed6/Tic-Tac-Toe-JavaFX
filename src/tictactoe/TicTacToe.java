package tictactoe;

import Controllers.OnlineControllers.ClientThreadHandler;
import Views.GeneralViews.WelcomePageClass;
import Views.OnlineViews.GameHistoryView;
import Views.OnlineViews.IpPageClass;
import Views.OnlineViews.LoginPageClass;
import Views.OnlineViews.ReplayGameBoardView;
import Views.OnlineViews.SignUpPageClass;
import Views.OnlineViews.SurDialog;
import Views.OnlineViews.onlinePageClass;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TicTacToe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

    

    //    Parent root = new  WelcomePageClass();


       // Parent root = new ReplayGameBoardView("vv,vvv,1~9~12~2024-07-28-23:37~0.1.1~0.2.0~0.0.1~1.0.0~1.2.1~1.1.0~2.0.1~2.1.0~2.2.1~");

        Parent root = new WelcomePageClass();

        //Parent root = new ReplayGameBoardView("vv,vvv,1~9~12~2024-07-28-23:37~0.1.1~0.2.0~0.0.1~1.0.0~1.2.1~1.1.0~2.0.1~2.1.0~2.2.1~");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
