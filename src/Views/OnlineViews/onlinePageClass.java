package Views.OnlineViews;

import Views.GeneralViews.WelcomePageClass;
import Controllers.ChangeSceneController;
import Controllers.OnlineControllers.OnlinePageController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class onlinePageClass extends AnchorPane {

    protected final ImageView backGroundImageView;
    protected final ImageView profilePicture;
    protected final ImageView backImageView;
    protected final Label availablePlayersLabel;
    protected final Button btnRequestJoin;
    protected final ListView listViewAvailable;
    protected final AnchorPane anchorPane;
    protected final Label labelName;
    protected final Label nameField;
    protected final AnchorPane anchorPane0;
    protected final Label labelUsername;
    protected final Label usernameField;
    protected final AnchorPane anchorPane1;
    protected final Label labelScore;
    protected final Label scoreField;
    protected final AnchorPane anchorPane2;
    protected final Label labelGender;
    protected final Label genderField;
    protected final AnchorPane toHistoryPane;
    protected final ImageView imageView2;
    protected final Hyperlink histoyBtn;
    protected final Label label4;
    protected final ImageView imageView3;
    OnlinePageController opc;

    public onlinePageClass() {

        backGroundImageView = new ImageView();
        profilePicture = new ImageView();
        backImageView = new ImageView();
        availablePlayersLabel = new Label();
        btnRequestJoin = new Button();
        listViewAvailable = new ListView();
        anchorPane = new AnchorPane();
        labelName = new Label();
        nameField = new Label();
        anchorPane0 = new AnchorPane();
        labelUsername = new Label();
        usernameField = new Label();
        anchorPane1 = new AnchorPane();
        labelScore = new Label();
        scoreField = new Label();
        anchorPane2 = new AnchorPane();
        labelGender = new Label();
        genderField = new Label();
        toHistoryPane = new AnchorPane();
        imageView2 = new ImageView();
        histoyBtn = new Hyperlink();
        label4 = new Label();
        imageView3 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        backGroundImageView.setFitHeight(800.0);
        backGroundImageView.setFitWidth(700.0);
        backGroundImageView.setLayoutX(-58.0);
        backGroundImageView.setLayoutY(-84.0);
        backGroundImageView.setPickOnBounds(true);
        backGroundImageView.setPreserveRatio(true);
        backGroundImageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        profilePicture.setFitHeight(142.0);
        profilePicture.setFitWidth(200.0);
        profilePicture.setLayoutX(14.0);
        profilePicture.setLayoutY(102.0);
        profilePicture.setPickOnBounds(true);
        profilePicture.setPreserveRatio(true);
        profilePicture.setImage(new Image(getClass().getResource("/Images/male.png").toExternalForm()));

        backImageView.setFitHeight(92.0);
        backImageView.setFitWidth(78.0);
        backImageView.setPickOnBounds(true);
        backImageView.setPreserveRatio(true);
       
        backImageView.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));

        availablePlayersLabel.setAlignment(javafx.geometry.Pos.CENTER);
        availablePlayersLabel.setLayoutX(328.0);
        availablePlayersLabel.setLayoutY(108.0);
        availablePlayersLabel.setPrefHeight(57.0);
        availablePlayersLabel.setPrefWidth(270.0);
        availablePlayersLabel.setStyle("-fx-background-radius: 30;");
        availablePlayersLabel.setText("Available Player");
        availablePlayersLabel.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        availablePlayersLabel.setFont(new Font("Rockwell Bold", 32.0));

        btnRequestJoin.setDefaultButton(true);
        btnRequestJoin.setLayoutX(410.0);
        btnRequestJoin.setLayoutY(610.0);
        btnRequestJoin.setMnemonicParsing(false);
        btnRequestJoin.setPrefHeight(32.0);
        btnRequestJoin.setPrefWidth(106.0);
        btnRequestJoin.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 30; -fx-border-radius: 50; -fx-border-width: 2; -fx-border-color: white;");
        btnRequestJoin.setText("Request Join");
        btnRequestJoin.setTextFill(javafx.scene.paint.Color.WHITE);
        btnRequestJoin.setFont(new Font("Rockwell Italic", 14.0));

        listViewAvailable.setLayoutX(327.0);
        listViewAvailable.setLayoutY(159.0);
        listViewAvailable.setPrefHeight(441.0);
        listViewAvailable.setPrefWidth(259.0);
//        FlowPane fp = new FlowPane();
//        fp.getChildren().add(new Button("3"));
//        fp.getChildren().add(new Label("ahmed"));
//        fp.setOrientation(Orientation.HORIZONTAL);
//        for (int i=0;i<20;i++){
//             listViewAvailable.getItems().add(fp);
//        listViewAvailable.getItems().add(new Label("Ahmed"));
//        System.out.println(listViewAvailable.getItems().get(0));
//        }
//       
        
                
        listViewAvailable.setStyle("-fx-background-color: #42a5f5; -fx-background-radius: 10; -fx-border-color: black; -fx-border-radius: 10; -fx-border-width: 2; -fx-background-insets: 5;");

        anchorPane.setLayoutX(4.0);
        anchorPane.setLayoutY(244.0);
        anchorPane.setPrefHeight(78.0);
        anchorPane.setPrefWidth(313.0);
        anchorPane.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 20;");

        labelName.setLayoutX(8.0);
        labelName.setLayoutY(2.0);
        labelName.setPrefHeight(69.0);
        labelName.setPrefWidth(85.0);
        labelName.setText("Name : ");
        labelName.setTextFill(javafx.scene.paint.Color.valueOf("#111111"));
        labelName.setFont(new Font("Rockwell Bold Italic", 22.0));

        nameField.setLayoutX(95.0);
        nameField.setLayoutY(2.0);
        nameField.setPrefHeight(69.0);
        nameField.setPrefWidth(210.0);
        nameField.setText("");
        nameField.setTextFill(javafx.scene.paint.Color.WHITE);
        nameField.setFont(new Font("Rockwell", 22.0));
   
        anchorPane0.setLayoutX(4.0);
        anchorPane0.setLayoutY(322.0);
        anchorPane0.setPrefHeight(78.0);
        anchorPane0.setPrefWidth(285.0);
        anchorPane0.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 20;");

        labelUsername.setLayoutX(8.0);
        labelUsername.setLayoutY(3.0);
        labelUsername.setPrefHeight(69.0);
        labelUsername.setPrefWidth(127.0);
        labelUsername.setText("Username :");
        labelUsername.setTextFill(javafx.scene.paint.Color.valueOf("#111111"));
        labelUsername.setFont(new Font("Rockwell Bold Italic", 22.0));
 
        usernameField.setLayoutX(134.0);
        usernameField.setLayoutY(2.0);
        usernameField.setPrefHeight(69.0);
        usernameField.setPrefWidth(106.0);
        usernameField.setText("");
        usernameField.setTextFill(javafx.scene.paint.Color.WHITE);
        usernameField.setFont(new Font("Rockwell", 22.0));
 
        anchorPane1.setLayoutX(6.0);
        anchorPane1.setLayoutY(478.0);
        anchorPane1.setPrefHeight(78.0);
        anchorPane1.setPrefWidth(228.0);
        anchorPane1.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 20;");

        labelScore.setLayoutX(8.0);
        labelScore.setLayoutY(2.0);
        labelScore.setPrefHeight(69.0);
        labelScore.setPrefWidth(85.0);
        labelScore.setText("Score : ");
        labelScore.setTextFill(javafx.scene.paint.Color.valueOf("#111111"));
        labelScore.setFont(new Font("Rockwell Bold Italic", 22.0));

        scoreField.setLayoutX(95.0);
        scoreField.setLayoutY(2.0);
        scoreField.setPrefHeight(69.0);
        scoreField.setPrefWidth(69.0);
        scoreField.setText("");
        scoreField.setTextFill(javafx.scene.paint.Color.WHITE);
        scoreField.setFont(new Font("Rockwell", 22.0));
   
        anchorPane2.setLayoutX(7.0);
        anchorPane2.setLayoutY(400.0);
        anchorPane2.setPrefHeight(78.0);
        anchorPane2.setPrefWidth(216.0);
        anchorPane2.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 20;");

        labelGender.setLayoutX(8.0);
        labelGender.setLayoutY(3.0);
        labelGender.setPrefHeight(69.0);
        labelGender.setPrefWidth(106.0);
        labelGender.setText("Gender : ");
        labelGender.setTextFill(javafx.scene.paint.Color.valueOf("#111111"));
        labelGender.setFont(new Font("Rockwell Bold Italic", 22.0));

        genderField.setLayoutX(114.0);
        genderField.setLayoutY(2.0);
        genderField.setPrefHeight(69.0);
        genderField.setPrefWidth(142.0);
        genderField.setText("");
        genderField.setTextFill(javafx.scene.paint.Color.WHITE);
        genderField.setFont(new Font("Rockwell", 22.0));
 
        toHistoryPane.setLayoutX(7.0);
        toHistoryPane.setLayoutY(644.0);
        toHistoryPane.setPrefHeight(39.0);
        toHistoryPane.setPrefWidth(132.0);

        imageView2.setFitHeight(49.0);
        imageView2.setFitWidth(43.0);
        imageView2.setLayoutY(13.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("/Images/male.png").toExternalForm()));

        histoyBtn.setAlignment(javafx.geometry.Pos.CENTER);
        histoyBtn.setLayoutX(33.0);
        histoyBtn.setLayoutY(13.0);
        histoyBtn.setPrefHeight(43.0);
        histoyBtn.setPrefWidth(99.0);
        histoyBtn.setText("History");
        histoyBtn.setTextFill(javafx.scene.paint.Color.valueOf("#220101"));
        histoyBtn.setUnderline(true);
        histoyBtn.setFont(new Font("Rockwell Bold Italic", 23.0));


        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label4.setLayoutX(125.0);
        label4.setLayoutY(13.0);
        label4.setPrefHeight(61.0);
        label4.setPrefWidth(313.0);
        label4.setStyle("-fx-background-radius: 50;");
        label4.setText("Online Mode");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#e0f7fa"));
        label4.setFont(new Font("Rockwell", 51.0));

        imageView3.setFitHeight(69.0);
        imageView3.setFitWidth(142.0);
        imageView3.setLayoutX(450.0);
        imageView3.setLayoutY(11.0);
        imageView3.setPickOnBounds(true);
        imageView3.setImage(new Image(getClass().getResource("/Images/together.png").toExternalForm()));

        getChildren().add(backGroundImageView);
        getChildren().add(profilePicture);
        getChildren().add(backImageView);
        getChildren().add(availablePlayersLabel);
        getChildren().add(btnRequestJoin);
        getChildren().add(listViewAvailable);
        anchorPane.getChildren().add(labelName);
        anchorPane.getChildren().add(nameField);
        getChildren().add(anchorPane);
        anchorPane0.getChildren().add(labelUsername);
        anchorPane0.getChildren().add(usernameField);
        getChildren().add(anchorPane0);
        anchorPane1.getChildren().add(labelScore);
        anchorPane1.getChildren().add(scoreField);
        getChildren().add(anchorPane1);
        anchorPane2.getChildren().add(labelGender);
        anchorPane2.getChildren().add(genderField);
        getChildren().add(anchorPane2);
        toHistoryPane.getChildren().add(imageView2);
        toHistoryPane.getChildren().add(histoyBtn);
        getChildren().add(toHistoryPane);
        getChildren().add(label4);
        getChildren().add(imageView3);
        opc = new OnlinePageController (profilePicture , nameField ,usernameField, scoreField , genderField
                ,btnRequestJoin , listViewAvailable , histoyBtn , backImageView);

    }
}
