
package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import Views.OnlineViews.GameHistoryView;
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
    ImageView profileImage;
    Label nameLabel , usernameLabel ,  scoreLabel , genderLabel ;
    Button btnRequestGame ;
    ListView avaiablePlayersListView ;
    Hyperlink histoyHyperLink;
    
    public OnlinePageController(ImageView profileImage, Label nameLabel, Label usernameLabel, Label scoreLabel, Label genderLabel, Button btnRequestGame, ListView avaiablePlayersListView, Hyperlink histoyHyperLink) {
        this.profileImage = profileImage;
        this.nameLabel = nameLabel;
        this.usernameLabel = usernameLabel;
        this.scoreLabel = scoreLabel;
        this.genderLabel = genderLabel;
        this.btnRequestGame = btnRequestGame;
        this.avaiablePlayersListView = avaiablePlayersListView;
        this.histoyHyperLink = histoyHyperLink;
        ClientThreadHandler.controllersMap.put("online",this);
         getUserDataRequest();
         setHandlers();
    }
    private void setHandlers(){
    histoyHyperLink.setOnMouseClicked((e)->{
    ChangeSceneController.switchSceneWithStage(new GameHistoryView() );
    });
    
    
    }
    private void getUserDataRequest(){
 
   ClientThreadHandler.queryQueue.add("getuserdata," + LoginController.getUsername());
    }
    public void setUserData(String userData){
     System.out.println("Recieced " + userData);
     String []data = userData.split(",");
     Platform.runLater(()->{
     usernameLabel.setText(data[0]);
     nameLabel.setText(data[2]+" "+data[3]);
     genderLabel.setText(Boolean.parseBoolean(data[4]) == true ? "Male" : "Female" );
     scoreLabel.setText(data[5]);
     byte [] image = Base64.getDecoder().decode(data[6]) ;
     Image im = new Image(new ByteArrayInputStream(image));
     profileImage.setImage(im);
     
     });
  //  String []data = userData.split(",");
    
    }
    
 
    
    
    
}
