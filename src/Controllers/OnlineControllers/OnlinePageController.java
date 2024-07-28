package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import Model.Player;
import Views.OnlineViews.GameHistoryView;
import Views.OnlineViews.InviteDialog;
import Views.OnlineViews.OnlineGameBoardView;
import Views.OnlineViews.RejectDialog;
import java.io.ByteArrayInputStream;
import java.util.Base64;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OnlinePageController implements Controllers {
    InviteDialog inv;
    ImageView profileImage;
    Label nameLabel , usernameLabel ,  scoreLabel , genderLabel ;
    Button btnRequestGame ;
    ListView availablePlayersListView ;
    Hyperlink histoyHyperLink;
    Image img ;
    public OnlinePageController(ImageView profileImage, Label nameLabel, Label usernameLabel, Label scoreLabel, Label genderLabel, Button btnRequestGame, ListView avaiablePlayersListView, Hyperlink histoyHyperLink) {


        this.profileImage = profileImage;
        this.nameLabel = nameLabel;
        this.usernameLabel = usernameLabel;
        this.scoreLabel = scoreLabel;
        this.genderLabel = genderLabel;
        this.btnRequestGame = btnRequestGame;
        this.availablePlayersListView = avaiablePlayersListView;
        this.histoyHyperLink = histoyHyperLink;
   
    

        ClientThreadHandler.controllersMap.put("online",this);
         getUserDataRequest();
         getAvailablePlayers();
         setHandlers();     
    
     
    }
    private void setHandlers(){
    histoyHyperLink.setOnMouseClicked((e)->{
    ChangeSceneController.switchSceneWithStage(new GameHistoryView() );
    });
    btnRequestGame.setOnMouseClicked((e)->{
    Label opponentLabel =(Label) availablePlayersListView.getSelectionModel().getSelectedItem();
     ClientThreadHandler.queryQueue.add("playinvite," + LoginController.getUsername()+","+opponentLabel.getText());
    
    });
    }
    public void showInvite(String invite){
            System.out.println("got an invite");
            Platform.runLater(()->{ InviteDialog db = new InviteDialog(invite);}); 
    }
    private void getUserDataRequest(){
 
     ClientThreadHandler.queryQueue.add("getuserdata," + LoginController.getUsername());
    }
    public void setUserData(String userData){
     String []data = userData.split(",");
     Platform.runLater(()->{
     usernameLabel.setText(data[0]);
     nameLabel.setText(data[2]+" "+data[3]);
     genderLabel.setText(Boolean.parseBoolean(data[4]) == true ? "Male" : "Female" );
     scoreLabel.setText(data[5]);
     byte [] image = Base64.getDecoder().decode(data[6]) ;
      img = new Image(new ByteArrayInputStream(image));
     profileImage.setImage(img);
     
     });
    }
    private void getAvailablePlayers() {
        String query = "getavailableplayers," + LoginController.getUsername();
        ClientThreadHandler.queryQueue.add(query);
    }
    public void showAvailablePlayers(String[] st) {
         Platform.runLater(() -> {
               availablePlayersListView.getItems().clear();
        for (int i =2 ; i < st.length; i++) {
               availablePlayersListView.getItems().add(new Label(st[i]));
        }
          });
    }
    public void showRejectDialog(String data){
     Platform.runLater(()->{     RejectDialog rd = new RejectDialog(data);});

    }
    public void startGame(String playersData){
        String [] data = playersData.split(",");
      
        Player player1Me = new Player(nameLabel.getText(),usernameLabel.getText(),Integer.valueOf(data[2]) ,Integer.valueOf(scoreLabel.getText()) ,img );

    
         byte [] image = Base64.getDecoder().decode(data[8]) ;
        Image imgg = new Image(new ByteArrayInputStream(image));
        Player player2Opponent = new Player(data[5]+" "+data[6],data[4],Integer.valueOf(data[3]) ,Integer.valueOf(data[7]) ,imgg );
         Platform.runLater(()->{  ChangeSceneController.switchSceneWithStage(new OnlineGameBoardView(player1Me , player2Opponent ));});
        System.out.println(playersData);
    
    }
    

}
