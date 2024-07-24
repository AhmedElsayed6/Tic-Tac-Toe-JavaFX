
package Controllers;

import Model.Player;
import Views.LocalGameBoardView;
import javafx.animation.PauseTransition;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LocalGameInitController {
    Text timer;
    Text three;
    Text two;
    Text one;
    private ImageView imgX , imgO;
    private Player player1;
    private Player player2;
    PauseTransition pause;
    PauseTransition pauseone;
    PauseTransition pausetwo;
//    PauseTransition pausethree;
    
    public LocalGameInitController(ImageView imgX , ImageView imgO, Text timer, Text three, Text two,Text one) {
        this.imgX = imgX;
        this.imgO = imgO;
        this.timer = timer;
        this.three = three;
        this.two = two;
        this.one = one;
        initGame();
    }
    private void initGame(){
        imgX.setOnMouseClicked((MouseEvent event) -> {
            player1 = new Player(1);
            player2 = new Player(0);
            timerControler(player1,player2,event);
        });
        imgO.setOnMouseClicked((MouseEvent event) -> {
            player1 = new Player(0);
            player2 = new Player(1);
            timerControler(player1,player2,event);
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
        {ChangeSceneController.switchScene(new LocalGameBoardView(playerone , playertwo ),event);}
                                );
        pausetwo.play();
        
        
        
        
        
       
//        
//        
        
        
    }

    
    
    
}
