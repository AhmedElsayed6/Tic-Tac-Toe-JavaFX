package Controllers.OnlineControllers;

import Model.GameBoard;
import Model.Player;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SaveGameController {

     String move;
     String gamesHistory;
    Player player1;
    Player player2;
    
    public SaveGameController(Player player1, Player player2){
    this.player1 = player1;
    this.player2 = player2;
    
    
        gamesHistory="";
        move = "";
    
    }
    

    
    public void saveMove(int x, int y, Player p) {
            
            move += (String.valueOf(x)) + (".") + (String.valueOf(y)) + "." + (String.valueOf(p.getCoin())) + "~";
    }
    public void saveMatch(GameBoard game) {
        String numberOfPlays = String.valueOf(game.numberPlays);
         String winningLine = game.winningLine;
              LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
        String formattedTime = now.format(formatter);
        // save,u1,u2,nplays~winning~date~winningline
        String matchSaveQuery = "save,"+player1.getUsername()+","+player2.getUsername()+","+numberOfPlays+"~"+winningLine+"~"+formattedTime+"~"+move;
        ClientThreadHandler.queryQueue.add(matchSaveQuery);
    }
    public  void declineSave(){
    move="";
    }


}
