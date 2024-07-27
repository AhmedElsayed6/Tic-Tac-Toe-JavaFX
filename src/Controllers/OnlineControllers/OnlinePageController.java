
package Controllers.OnlineControllers;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;


public class OnlinePageController implements Controllers {

    public OnlinePageController(ImageView profileImage, Label nameLabel, Label usernameLabel, Label scoreLabel, Label genderLabel, Button btnRequestGame, ListView avaiablePlayersListView, Hyperlink histoyHyperLink) {
        this.profileImage = profileImage;
        this.nameLabel = nameLabel;
        this.usernameLabel = usernameLabel;
        this.scoreLabel = scoreLabel;
        this.genderLabel = genderLabel;
        this.btnRequestGame = btnRequestGame;
        this.avaiablePlayersListView = avaiablePlayersListView;
        this.histoyHyperLink = histoyHyperLink;
    }
    ImageView profileImage;
    Label nameLabel , usernameLabel ,  scoreLabel , genderLabel ;
    Button btnRequestGame ;
    ListView avaiablePlayersListView ;
    Hyperlink histoyHyperLink;
}
