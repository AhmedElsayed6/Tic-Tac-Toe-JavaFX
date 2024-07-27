package Controllers.OnlineControllers;

import Views.OnlineViews.DialogView;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class OnlinePageController implements Controllers {

    ImageView profileImage;
    Label nameLabel, usernameLabel, scoreLabel, genderLabel;
    Button btnRequestGame;
    ListView avaiablePlayersListView;
    Hyperlink histoyHyperLink;

    public OnlinePageController(boolean queryCreated,ImageView profileImage, Label nameLabel, Label usernameLabel, Label scoreLabel, Label genderLabel, Button btnRequestGame, ListView avaiablePlayersListView, Hyperlink histoyHyperLink) {
        this.profileImage = profileImage;
        this.nameLabel = nameLabel;
        this.usernameLabel = usernameLabel;
        this.scoreLabel = scoreLabel;
        this.genderLabel = genderLabel;
        this.btnRequestGame = btnRequestGame;
        this.avaiablePlayersListView = avaiablePlayersListView;
        this.histoyHyperLink = histoyHyperLink;
            createQuery();
         this.btnRequestGame.setOnAction((event) -> { 
              new DialogView(null, null, null);
         });
    }
   

    private void createQuery() {
        String query = "getavailableplayers," + ClientThreadHandler.username;
        ClientThreadHandler.queryQueue.add(query);
        ClientThreadHandler.controllersMap.put("getavailableplayers", this);
    }

    void showAvailablePlayers(String[] st) {
         Platform.runLater(() -> {
               avaiablePlayersListView.getItems().clear();
        for (int i =2 ; i < st.length; i++) {
            System.out.println(st[i]);
               avaiablePlayersListView.getItems().add(new Label(st[i]));
        }
          });
    }
    

}
