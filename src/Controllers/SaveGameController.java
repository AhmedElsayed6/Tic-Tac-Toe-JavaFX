package Controllers;

import Model.GameBoard;
import Model.Player;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SaveGameController {

    static String move;
    static List<String> gamesHistory;
    static String gameMode;

    static {
        gamesHistory = new ArrayList<>();
        move = "";
        gameMode = "LocalTwoPlayers";
    }

    public static void saveMove(int x, int y, Player p, String gameMode) {
        if (gameMode == "LocalTwoPlayers") {
            move += (String.valueOf(x)) + (".") + (String.valueOf(y)) + "." + (String.valueOf(p.getCoin())) + "~";
        } else if (gameMode == "VS AI");
       

    }

    public static void saveMatch(GameBoard game) {
        String numberOfPlays = String.valueOf(game.numberPlays);
        String winningLine = game.winningLine;

        String copy = move; 
        String move = "";
        move += numberOfPlays; // 5.202122.0.0.1~1.1.0~2.0.1~
        move += (".");
        move += winningLine;
        move += (".");
        move += (copy);

        gamesHistory.add(move);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String formattedTime = now.format(formatter);
        String directoryPath = "D:\\Programs\\NetBeansProjects\\TicTacToe2\\Tic-Tac-Toe-JavaFX\\src\\local_matches";

        System.out.println(formattedTime);
        File file = new File(directoryPath, gameMode + "_" + formattedTime + ".txt");
        try {
            FileOutputStream fis = new FileOutputStream(file);

            fis.write(move.getBytes());

            fis.close();
        } catch (Exception n) {
            System.out.println("File not found");
        }

    }
    public static void declineSave(){
    move="";
    }
    
    

}
