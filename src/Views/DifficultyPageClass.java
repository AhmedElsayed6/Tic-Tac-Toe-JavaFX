package Views;

import Controllers.ChangeSceneController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class DifficultyPageClass extends AnchorPane {

    protected final ImageView btnBackDifficultyView;
    protected final ImageView back;
    protected final AnchorPane anchorPane;
    protected final Button btnDifficultyEasy;
    protected final Button btnDifficultyMedium;
    protected final Button btnDifficultyHard;
    protected final AnchorPane anchorPane0;
    protected final ImageView imageEasy;
    protected final ImageView imageMedium;
    protected final ImageView imageHard;

    public DifficultyPageClass() {

        btnBackDifficultyView = new ImageView();
        back = new ImageView();
        anchorPane = new AnchorPane();
        btnDifficultyEasy = new Button();
        btnDifficultyMedium = new Button();
        btnDifficultyHard = new Button();
        anchorPane0 = new AnchorPane();
        imageEasy = new ImageView();
        imageMedium = new ImageView();
        imageHard = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        btnBackDifficultyView.setFitHeight(768.0);
        btnBackDifficultyView.setFitWidth(637.0);
        btnBackDifficultyView.setLayoutX(-8.0);
        btnBackDifficultyView.setLayoutY(-12.0);
        btnBackDifficultyView.setPickOnBounds(true);
        btnBackDifficultyView.setPreserveRatio(true);
        btnBackDifficultyView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        back.setFitHeight(85.0);
        back.setFitWidth(93.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setOnMouseClicked((MouseEvent event) -> {
            ChangeSceneController.switchScene(new ChosePageClass(),event);
        });
        back.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));
        anchorPane.setPrefHeight(700.0);
        anchorPane.setPrefWidth(300.0);

        btnDifficultyEasy.setLayoutX(89.0);
        btnDifficultyEasy.setLayoutY(107.0);
        btnDifficultyEasy.setMnemonicParsing(false);
        btnDifficultyEasy.setPrefHeight(60.0);
        btnDifficultyEasy.setPrefWidth(195.0);
        btnDifficultyEasy.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-color: white; -fx-border-radius: 50; -fx-border-width: 2;");
        btnDifficultyEasy.setText("Easy");
        btnDifficultyEasy.setTextFill(javafx.scene.paint.Color.WHITE);
        btnDifficultyEasy.setFont(new Font("System Bold", 31.0));
        btnDifficultyEasy.setOnMouseClicked((MouseEvent event) -> {
            //Enter Easy AI
        });

        btnDifficultyMedium.setLayoutX(89.0);
        btnDifficultyMedium.setLayoutY(334.0);
        btnDifficultyMedium.setMnemonicParsing(false);
        btnDifficultyMedium.setPrefHeight(60.0);
        btnDifficultyMedium.setPrefWidth(195.0);
        btnDifficultyMedium.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-color: white; -fx-border-radius: 50; -fx-border-width: 2;");
        btnDifficultyMedium.setText("Medium");
        btnDifficultyMedium.setTextFill(javafx.scene.paint.Color.WHITE);
        btnDifficultyMedium.setFont(new Font("System Bold", 30.0));
        btnDifficultyMedium.setOnMouseClicked((MouseEvent event) -> {
            //Enter Medium AI
        });

        btnDifficultyHard.setLayoutX(89.0);
        btnDifficultyHard.setLayoutY(563.0);
        btnDifficultyHard.setMnemonicParsing(false);
        btnDifficultyHard.setPrefHeight(60.0);
        btnDifficultyHard.setPrefWidth(195.0);
        btnDifficultyHard.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50; -fx-border-color: white; -fx-border-radius: 50; -fx-border-width: 2;");
        btnDifficultyHard.setText("Hard");
        btnDifficultyHard.setTextFill(javafx.scene.paint.Color.WHITE);
        btnDifficultyHard.setFont(new Font("System Bold", 30.0));
        btnDifficultyHard.setOnMouseClicked((MouseEvent event) -> {
            //Enter Medium AI
        });


        anchorPane0.setLayoutX(280.0);
        anchorPane0.setPrefHeight(700.0);
        anchorPane0.setPrefWidth(314.0);

        imageEasy.setFitHeight(137.0);
        imageEasy.setFitWidth(124.0);
        imageEasy.setLayoutX(107.0);
        imageEasy.setLayoutY(76.0);
        imageEasy.setPickOnBounds(true);
        imageEasy.setPreserveRatio(true);
        imageEasy.setImage(new Image(getClass().getResource("/Images/chatbox_12088893.png").toExternalForm()));

        imageMedium.setFitHeight(140.0);
        imageMedium.setFitWidth(134.0);
        imageMedium.setLayoutX(102.0);
        imageMedium.setLayoutY(307.0);
        imageMedium.setPickOnBounds(true);
        imageMedium.setPreserveRatio(true);
        imageMedium.setImage(new Image(getClass().getResource("/Images/meduim.png").toExternalForm()));

        imageHard.setFitHeight(134.0);
        imageHard.setFitWidth(145.0);
        imageHard.setLayoutX(107.0);
        imageHard.setLayoutY(522.0);
        imageHard.setPickOnBounds(true);
        imageHard.setPreserveRatio(true);
        imageHard.setImage(new Image(getClass().getResource("/Images/angry.png").toExternalForm()));

        getChildren().add(btnBackDifficultyView);
        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(btnDifficultyEasy);
        
        anchorPane.getChildren().add(btnDifficultyMedium);
        anchorPane.getChildren().add(btnDifficultyHard);
        getChildren().add(anchorPane);
        anchorPane0.getChildren().add(imageEasy);
        anchorPane0.getChildren().add(imageMedium);
        anchorPane0.getChildren().add(imageHard);
        getChildren().add(anchorPane0);

    }
}
