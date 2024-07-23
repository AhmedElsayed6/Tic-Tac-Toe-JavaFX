package Model;

public class GameBoard {

    Cell[][] board;
    public String winningLine;
    public int numberPlays;

    
    
    
    public GameBoard() {
        numberPlays = 0;
        winningLine = new String();
        board = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new Cell();
            }
        }
    }
    public void playPosition(int x, int y, Player p) {
        board[x][y].setValue(p.getCoin());
        board[x][y].setPlayer(p);
        numberPlays++;
    }
    public boolean checkWin() {
        if (board[0][0].getValue() == board[0][1].getValue()
                && board[0][1].getValue() == board[0][2].getValue() && board[0][0].getValue() != 2) {
            winningLine  = "000102";
      
            return true;
        } else if (board[1][0].getValue() == board[1][1].getValue()
                && board[1][1].getValue() == board[1][2].getValue() && board[1][0].getValue() != 2) {
                        winningLine  = "101112";
    
            return true;
        } else if (board[2][0].getValue() == board[2][1].getValue()
                && board[2][1].getValue() == board[2][2].getValue() && board[2][0].getValue() != 2) {
                        winningLine  = "202122";
   
            return true;
        } else if (board[0][0].getValue() == board[1][1].getValue()
                && board[1][1].getValue() == board[2][2].getValue() && board[0][0].getValue() != 2) {
                        winningLine  = "001122";
         
            return true;
        } else if (board[0][0].getValue() == board[1][0].getValue()
                && board[1][0].getValue() == board[2][0].getValue() && board[0][0].getValue() != 2) {
                        winningLine  = "001020";
       
            return true;
        } else if (board[0][1].getValue() == board[1][1].getValue()
                && board[1][1].getValue() == board[2][1].getValue() && board[0][1].getValue() != 2) {
                        winningLine  = "011121";
 
            return true;
        } else if (board[0][2].getValue() == board[1][2].getValue()
                && board[1][2].getValue() == board[2][2].getValue() && board[0][2].getValue() != 2) {
                        winningLine  = "021222";
          
            return true;
        } else if (board[0][2].getValue() == board[1][1].getValue()
                && board[1][1].getValue() == board[2][0].getValue() && board[2][0].getValue() != 2) {
                        winningLine  = "021120";
            return true;
        }

        return false;
    }

}
