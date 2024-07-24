
package Controllers;

import Model.Player;
import Views.LocalGameBoardView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LocalGameInitController {
    private ImageView imgX , imgO;
    private Player player1;
    private Player player2;
    
    public LocalGameInitController(ImageView imgX , ImageView imgO) {
        this.imgX = imgX;
          this.imgO = imgO;
          initGame();
    }
    private void initGame(){
        imgX.setOnMouseClicked((MouseEvent event) -> {
            player1 = new Player(1);
            player2 = new Player(0);
            ChangeSceneController.switchScene(new LocalGameBoardView(player1 , player2 ),event);
        });
        imgO.setOnMouseClicked((MouseEvent event) -> {
            player1 = new Player(0);
            player2 = new Player(1);
            ChangeSceneController.switchScene(new LocalGameBoardView(player1 , player2),event);
        });
        
    
    }

    
    
    
}
