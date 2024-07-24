package Views;

import Controllers.ChangeSceneController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ChosePageClass extends AnchorPane {

    protected final ImageView iconQuestionMark;
    protected final ImageView back;
    protected final ImageView imageView;
    protected final Button btnVSComputer;
    protected final Button btnLocalCoop;
    protected final Button btnOnline;
    protected final Text iconVersion;

    public ChosePageClass() {

        iconQuestionMark = new ImageView();
        back = new ImageView();
        imageView = new ImageView();
        btnVSComputer = new Button();
        btnLocalCoop = new Button();
        btnOnline = new Button();
        iconVersion = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        iconQuestionMark.setFitHeight(749.0);
        iconQuestionMark.setFitWidth(668.0);
        iconQuestionMark.setLayoutX(-33.0);
        iconQuestionMark.setLayoutY(-40.0);
        iconQuestionMark.setPickOnBounds(true);
        iconQuestionMark.setPreserveRatio(true);
        iconQuestionMark.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        back.setFitHeight(80.0);
        back.setFitWidth(100.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setOnMouseClicked((MouseEvent event) -> {
            ChangeSceneController.switchScene(new WelcomePageClass(),event);
        });
        back.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));

        imageView.setFitHeight(332.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutY(87.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Images/.png").toExternalForm()));

        btnVSComputer.setLayoutX(30.0);
        btnVSComputer.setLayoutY(552.0);
        btnVSComputer.setMnemonicParsing(false);
        btnVSComputer.setPrefHeight(60.0);
        btnVSComputer.setPrefWidth(164.0);
        btnVSComputer.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-color: white; -fx-border-radius: 50; -fx-border-width: 2;");
        btnVSComputer.setText("VS Computer");
        btnVSComputer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeSceneController.switchScene(new DifficultyPageClass(),event);
            }
        });
        
        btnVSComputer.setTextFill(javafx.scene.paint.Color.WHITE);
        btnVSComputer.setFont(new Font("System Bold", 18.0));

        btnLocalCoop.setLayoutX(213.0);
        btnLocalCoop.setLayoutY(552.0);
        btnLocalCoop.setMnemonicParsing(false);
        btnLocalCoop.setPrefHeight(60.0);
        btnLocalCoop.setPrefWidth(164.0);
        btnLocalCoop.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-color: white; -fx-border-radius: 50; -fx-border-width: 2;");
        btnLocalCoop.setText("Local Co-op");
        btnLocalCoop.setOnMouseClicked((MouseEvent event) -> {
            ChangeSceneController.switchScene(new ChooseXOPageClass(),event);
        });
        btnLocalCoop.setTextFill(javafx.scene.paint.Color.WHITE);
        btnLocalCoop.setFont(new Font("System Bold", 18.0));

        btnOnline.setLayoutX(412.0);
        btnOnline.setLayoutY(552.0);
        btnOnline.setMnemonicParsing(false);
        btnOnline.setPrefHeight(60.0);
        btnOnline.setPrefWidth(169.0);
        btnOnline.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-color: white; -fx-border-radius: 50; -fx-border-width: 2;");
        btnOnline.setText("Online");
        btnOnline.setOnMouseClicked((MouseEvent event) -> {
            ChangeSceneController.switchScene(new LoginPageClass(),event);
        });
        btnOnline.setTextFill(javafx.scene.paint.Color.WHITE);
        btnOnline.setFont(new Font("System Bold", 18.0));

        iconVersion.setLayoutX(540.0);
        iconVersion.setLayoutY(695.0);
        iconVersion.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        iconVersion.setStrokeWidth(0.0);
        iconVersion.setText("v1.0");
        iconVersion.setWrappingWidth(40.287109375);
        iconVersion.setFont(new Font(18.0));

        getChildren().add(iconQuestionMark);
        getChildren().add(back);
        getChildren().add(imageView);
        getChildren().add(btnVSComputer);
        getChildren().add(btnLocalCoop);
        getChildren().add(btnOnline);
        getChildren().add(iconVersion);

    }
    
}
