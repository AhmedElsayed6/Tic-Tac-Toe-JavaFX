
package Controllers;

import Model.Player;
import Views.AIGameBoardView;
import javafx.animation.PauseTransition;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class AIGameInitController {
    int def;
    Text timer;
    Text three;
    Text two;
    Text one;
    private ImageView imgX , imgO , btn;
    private Player player1;
    private Player player2;
    PauseTransition pause;
    PauseTransition pauseone;
    PauseTransition pausetwo;
//    PauseTransition pausethree;
    
    public AIGameInitController(ImageView imgX , ImageView imgO, Text timer, Text three, Text two,Text one, int def , ImageView btn) {
        this.imgX = imgX;
        this.imgO = imgO;
        this.timer = timer;
        this.three = three;
        this.two = two;
        this.one = one;
        this.def = def;
        this.btn = btn;
        initGame();
    }
    private void initGame(){
        imgX.setOnMouseClicked((MouseEvent event) -> {
            player1 = new Player(1);
            player2 = new Player(0);
            timerControler(player1,player2,event);
          btn.setDisable(true);
            imgO.setDisable(true);
        });
        imgO.setOnMouseClicked((MouseEvent event) -> {
            player1 = new Player(0);
            player2 = new Player(1);
            timerControler(player1,player2,event);
            btn.setDisable(true);
            imgX.setDisable(true);
        });
    }
    private void timerControler(Player playerone , Player playertwo,MouseEvent event){
        timer.setOpacity(1);
        
        three.setOpacity(1);
        
        pause = new PauseTransition(javafx.util.Duration.seconds(1));
        pause.setOnFinished((e) ->{three.setOpacity(0);
                                    two.setOpacity(1);
        });
        pause.play();
        
        pauseone = new PauseTransition(javafx.util.Duration.seconds(2));
        pauseone.setOnFinished((e) ->{two.setOpacity(0);
                                   one.setOpacity(1);});
        pauseone.play();
        
        pausetwo = new PauseTransition(javafx.util.Duration.seconds(3));
        pausetwo.setOnFinished((e) -> 
        {ChangeSceneController.switchSceneWithStage(new AIGameBoardView (playerone , playertwo , def ));}
                                );
        pausetwo.play();     
        
    }

}
