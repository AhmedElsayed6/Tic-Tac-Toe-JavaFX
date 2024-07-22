package Model;

public class GameBoard {

    Cell[][] gameBoard;
    public String winningLine;
    public int numberPlays;

    
    
    
    public GameBoard() {
        numberPlays = 0;
        winningLine = new String();
        gameBoard = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = new Cell();
            }
        }
    }
    public void playPosition(int x, int y, Player p) {
        gameBoard[x][y].setValue(p.getCoin());
        numberPlays++;
    }
    public boolean checkWin() {
        if (gameBoard[0][0].getValue() == gameBoard[0][1].getValue()
                && gameBoard[0][1].getValue() == gameBoard[0][2].getValue() && gameBoard[0][0].getValue() != 2) {
            winningLine  = "000102";
      
            return true;
        } else if (gameBoard[1][0].getValue() == gameBoard[1][1].getValue()
                && gameBoard[1][1].getValue() == gameBoard[1][2].getValue() && gameBoard[1][0].getValue() != 2) {
                        winningLine  = "101112";
    
            return true;
        } else if (gameBoard[2][0].getValue() == gameBoard[2][1].getValue()
                && gameBoard[2][1].getValue() == gameBoard[2][2].getValue() && gameBoard[2][0].getValue() != 2) {
                        winningLine  = "202122";
   
            return true;
        } else if (gameBoard[0][0].getValue() == gameBoard[1][1].getValue()
                && gameBoard[1][1].getValue() == gameBoard[2][2].getValue() && gameBoard[0][0].getValue() != 2) {
                        winningLine  = "001122";
         
            return true;
        } else if (gameBoard[0][0].getValue() == gameBoard[1][0].getValue()
                && gameBoard[1][0].getValue() == gameBoard[2][0].getValue() && gameBoard[0][0].getValue() != 2) {
                        winningLine  = "001020";
       
            return true;
        } else if (gameBoard[0][1].getValue() == gameBoard[1][1].getValue()
                && gameBoard[1][1].getValue() == gameBoard[2][1].getValue() && gameBoard[0][1].getValue() != 2) {
                        winningLine  = "011121";
 
            return true;
        } else if (gameBoard[0][2].getValue() == gameBoard[1][2].getValue()
                && gameBoard[1][2].getValue() == gameBoard[2][2].getValue() && gameBoard[0][2].getValue() != 2) {
                        winningLine  = "021222";
          
            return true;
        } else if (gameBoard[0][2].getValue() == gameBoard[1][1].getValue()
                && gameBoard[1][1].getValue() == gameBoard[2][0].getValue() && gameBoard[2][0].getValue() != 2) {
                        winningLine  = "021120";
            return true;
        }

        return false;
    }

}
