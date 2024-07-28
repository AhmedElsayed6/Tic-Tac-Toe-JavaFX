package Model;

import javafx.scene.image.Image;

public class Player {

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", username=" + username + ", coin=" + coin + ", score=" + score + ", profilePicture=" + profilePicture + '}';
    }
private String name,username;
private int coin ; 
private int score;
private Image profilePicture;
    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }



    public void scoreIncrement(){
    score++;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public Player(int coin){
        this.coin = coin;
        this.score =0;
    }
    
    //online
    public Player(String name, String username , int coin , int score ,Image profilePicture ) {
        this.score = score;
        this.name = name;
        this.username = username;
        this.coin = coin;
        this.profilePicture = profilePicture;
    }

    //Ai
    public Player(String name, int coin , int score ) {
        this.score = score;
        this.name = name;
        this.username = null;

    }
    
        public Player(String name, int coin ) {
        this.score = 0;
        this.name = name;
        this.username = null;

        this.coin = coin;
    }

    
    





    
}
