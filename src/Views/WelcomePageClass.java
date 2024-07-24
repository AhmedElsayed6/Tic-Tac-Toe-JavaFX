package Views;

import Controllers.ChangeSceneController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class WelcomePageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final Button btnLocalCoop;
    protected final Text iconVersion;

    public WelcomePageClass() {

        imageView = new ImageView();
        btnLocalCoop = new Button();
        iconVersion = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(800.0);
        imageView.setFitWidth(700.0);
        imageView.setLayoutX(-1.0);
        imageView.setLayoutY(-8.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Images/homeBackground.png").toExternalForm()));

        btnLocalCoop.setLayoutX(192.0);
        btnLocalCoop.setLayoutY(556.0);
        btnLocalCoop.setMnemonicParsing(false);
        btnLocalCoop.setPrefHeight(60.0);
        btnLocalCoop.setPrefWidth(236.0);
        btnLocalCoop.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-color: white; -fx-border-radius: 50; -fx-border-width: 2;");
        btnLocalCoop.setText("New Game");
        btnLocalCoop.setOnMouseClicked((MouseEvent event) -> {
            ChangeSceneController.switchScene(new ChosePageClass(),event);
        });
        btnLocalCoop.setTextFill(javafx.scene.paint.Color.WHITE);
        btnLocalCoop.setFont(new Font("System Bold", 18.0));

        iconVersion.setLayoutX(555.0);
        iconVersion.setLayoutY(693.0);
        iconVersion.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        iconVersion.setStrokeWidth(0.0);
        iconVersion.setText("v1.0");
        iconVersion.setWrappingWidth(40.287109375);
        iconVersion.setFont(new Font(18.0));

        getChildren().add(imageView);
        getChildren().add(btnLocalCoop);
        getChildren().add(iconVersion);

    }
}
