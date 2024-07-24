package Model;

public class GameBoard {

    public Cell[][] gameBoard;
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
    public void printBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(gameBoard[i][j].getValue());
                System.out.print("+");
            }
            System.out.println();
        }
    }
    public boolean checkValidCell(int row, int column){
        if(gameBoard[row][column].getValue()==2){
            return true;
        }
        else{
            return false;
        }
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
public  boolean checkWinner(int[] board, Player player) {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}  // Diagonals
        };
        for (int[] condition : winConditions) {
            if (board[condition[0]] == player.getCoin() && board[condition[1]] == player.getCoin() && board[condition[2]] == player.getCoin()) {
                return true;
            }
        }
        return false;
    }
}
