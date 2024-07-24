package Views;

import Controllers.ChangeSceneController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class IpPageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView back;
    protected final Text text;
    protected final TextField ipField;
    protected final Button btnEnterIp;

    public IpPageClass() {

        imageView = new ImageView();
        back = new ImageView();
        text = new Text();
        ipField = new TextField();
        btnEnterIp = new Button();

        setId("AnchorPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(600.0);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(600.0);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(744.0);
        imageView.setFitWidth(705.0);
        imageView.setLayoutX(-25.0);
        imageView.setLayoutY(-35.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Images/BackGround.png").toExternalForm()));

        back.setFitHeight(70.0);
        back.setFitWidth(98.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeSceneController.switchScene(new LoginPageClass(),event);
            }
        });
        back.setImage(new Image(getClass().getResource("Images/backArrow.png").toExternalForm()));

        text.setLayoutX(54.0);
        text.setLayoutY(342.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Enter IP :");
        text.setWrappingWidth(156.6708984375);
        text.setFont(new Font(35.0));

        ipField.setFocusTraversable(false);
        ipField.setLayoutX(244.0);
        ipField.setLayoutY(304.0);
        ipField.setPrefHeight(47.0);
        ipField.setPrefWidth(200.0);
        ipField.setPromptText("256.256.256.256");
        ipField.setFont(new Font(23.0));

        btnEnterIp.setLayoutX(244.0);
        btnEnterIp.setLayoutY(455.0);
        btnEnterIp.setMnemonicParsing(false);
        btnEnterIp.setPrefHeight(47.0);
        btnEnterIp.setPrefWidth(113.0);
        btnEnterIp.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-radius: 50; -fx-border-width: 2; -fx-border-color: white;");
        btnEnterIp.setText("Join");
        btnEnterIp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeSceneController.switchScene(new onlinePageClass(),event);
            }
        });
        btnEnterIp.setTextFill(javafx.scene.paint.Color.WHITE);

        getChildren().add(imageView);
        getChildren().add(back);
        getChildren().add(text);
        getChildren().add(ipField);
        getChildren().add(btnEnterIp);

    }
}
