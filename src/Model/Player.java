package Model;
public class Player {
private String name,username,gender,password;


private int coin ; 
private int score;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    
    public Player(String name, String username, String gender, String password , int coin , int score ) {
        this.score = score;
        this.name = name;
        this.username = username;
        this.gender = gender;
        this.password = password;
        this.coin = coin;
    }

    //Ai
    public Player(String name, int coin , int score ) {
        this.score = score;
        this.name = name;
        this.username = null;
        this.gender = null;
        this.password = null;
        this.coin = coin;
    }

    
    





    
}
