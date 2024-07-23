package Model;

public class Cell {

    int value;
     Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
  

    public Cell() {
        value = 2;
        player = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int input) {
        value = input;
    }

}
