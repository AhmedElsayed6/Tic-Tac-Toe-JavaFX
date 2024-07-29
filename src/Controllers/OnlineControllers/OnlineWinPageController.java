/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import Views.GeneralViews.WelcomePageClass;
import Views.OnlineViews.OnlineGameBoardView;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author hp
 */
public class OnlineWinPageController {
Button btnMainMenu;
Button btnPlayAgain;
    public OnlineWinPageController(Button btnMainMenu, Button btnPlayAgain) {
        this.btnMainMenu=btnMainMenu;
        this.btnPlayAgain=btnPlayAgain;
        btnMainMenu.setOnMouseClicked((MouseEvent event) -> {
            ChangeSceneController.switchScene(new WelcomePageClass(),event);
        });
        btnPlayAgain.setOnMouseClicked((MouseEvent event) -> {
            ChangeSceneController.switchScene(new OnlineGameBoardView(player1 , player2  ),event);
        });
        PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(3));
        pause.setOnFinished((e) ->{
                                btnPlayAgain.setDisable(false);
                                btnMainMenu.setDisable(false);
                                    });
        pause.play();
    }
    
}
