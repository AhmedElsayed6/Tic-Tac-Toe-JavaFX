package Views.OnlineViews;

import Views.GeneralViews.WelcomePageClass;
import Controllers.ChangeSceneController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public class onlinePageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Label label;
    protected final Button btnRequestJoin;
    protected final ListView listViewAvailable;
    protected final AnchorPane anchorPane;
    protected final Label label0;
    protected final Label nameField;
    protected final AnchorPane anchorPane0;
    protected final Label label1;
    protected final Label usernameField;
    protected final AnchorPane anchorPane1;
    protected final Label label2;
    protected final Label scoreField;
    protected final AnchorPane anchorPane2;
    protected final Label label3;
    protected final Label genderField;
    protected final AnchorPane toHistoryPane;
    protected final ImageView imageView2;
    protected final Hyperlink hyperlink;
    protected final Label label4;
    protected final ImageView imageView3;

    public onlinePageClass() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        label = new Label();
        btnRequestJoin = new Button();
        listViewAvailable = new ListView();
        anchorPane = new AnchorPane();
        label0 = new Label();
        nameField = new Label();
        anchorPane0 = new AnchorPane();
        label1 = new Label();
        usernameField = new Label();
        anchorPane1 = new AnchorPane();
        label2 = new Label();
        scoreField = new Label();
        anchorPane2 = new AnchorPane();
        label3 = new Label();
        genderField = new Label();
        toHistoryPane = new AnchorPane();
        imageView2 = new ImageView();
        hyperlink = new Hyperlink();
        label4 = new Label();
        imageView3 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(800.0);
        imageView.setFitWidth(700.0);
        imageView.setLayoutX(-58.0);
        imageView.setLayoutY(-84.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        imageView0.setFitHeight(142.0);
        imageView0.setFitWidth(200.0);
        imageView0.setLayoutX(14.0);
        imageView0.setLayoutY(102.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/Images/male.png").toExternalForm()));

        imageView1.setFitHeight(92.0);
        imageView1.setFitWidth(78.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeSceneController.switchScene(new WelcomePageClass(),event);
            }
        });
        imageView1.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(328.0);
        label.setLayoutY(108.0);
        label.setPrefHeight(57.0);
        label.setPrefWidth(270.0);
        label.setStyle("-fx-background-radius: 30;");
        label.setText("Available Player");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        label.setFont(new Font("Rockwell Bold", 32.0));

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
        FlowPane fp = new FlowPane();
        fp.getChildren().add(new Button("3"));
        fp.getChildren().add(new Label("ahmed"));
        fp.setOrientation(Orientation.HORIZONTAL);
        for (int i=0;i<20;i++){
             listViewAvailable.getItems().add(fp);
        listViewAvailable.getItems().add(new Label("Ahmed"));
        System.out.println(listViewAvailable.getItems().get(0));
        }
       
        
                
        listViewAvailable.setStyle("-fx-background-color: #42a5f5; -fx-background-radius: 10; -fx-border-color: black; -fx-border-radius: 10; -fx-border-width: 2; -fx-background-insets: 5;");

        anchorPane.setLayoutX(4.0);
        anchorPane.setLayoutY(244.0);
        anchorPane.setPrefHeight(78.0);
        anchorPane.setPrefWidth(313.0);
        anchorPane.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 20;");

        label0.setLayoutX(8.0);
        label0.setLayoutY(2.0);
        label0.setPrefHeight(69.0);
        label0.setPrefWidth(85.0);
        label0.setText("Name : ");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#111111"));
        label0.setFont(new Font("Rockwell Bold Italic", 22.0));

        nameField.setLayoutX(95.0);
        nameField.setLayoutY(2.0);
        nameField.setPrefHeight(69.0);
        nameField.setPrefWidth(210.0);
        nameField.setText("filopatir mamdouh");
        nameField.setTextFill(javafx.scene.paint.Color.WHITE);
        nameField.setFont(new Font("Rockwell", 22.0));

        anchorPane0.setLayoutX(4.0);
        anchorPane0.setLayoutY(322.0);
        anchorPane0.setPrefHeight(78.0);
        anchorPane0.setPrefWidth(285.0);
        anchorPane0.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 20;");

        label1.setLayoutX(8.0);
        label1.setLayoutY(3.0);
        label1.setPrefHeight(69.0);
        label1.setPrefWidth(127.0);
        label1.setText("Username :");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#111111"));
        label1.setFont(new Font("Rockwell Bold Italic", 22.0));

        usernameField.setLayoutX(134.0);
        usernameField.setLayoutY(2.0);
        usernameField.setPrefHeight(69.0);
        usernameField.setPrefWidth(106.0);
        usernameField.setText("filopatir mamdouh");
        usernameField.setTextFill(javafx.scene.paint.Color.WHITE);
        usernameField.setFont(new Font("Rockwell", 22.0));

        anchorPane1.setLayoutX(6.0);
        anchorPane1.setLayoutY(478.0);
        anchorPane1.setPrefHeight(78.0);
        anchorPane1.setPrefWidth(228.0);
        anchorPane1.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 20;");

        label2.setLayoutX(8.0);
        label2.setLayoutY(2.0);
        label2.setPrefHeight(69.0);
        label2.setPrefWidth(85.0);
        label2.setText("Name : ");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#111111"));
        label2.setFont(new Font("Rockwell Bold Italic", 22.0));

        scoreField.setLayoutX(95.0);
        scoreField.setLayoutY(2.0);
        scoreField.setPrefHeight(69.0);
        scoreField.setPrefWidth(69.0);
        scoreField.setText("500");
        scoreField.setTextFill(javafx.scene.paint.Color.WHITE);
        scoreField.setFont(new Font("Rockwell", 22.0));

        anchorPane2.setLayoutX(7.0);
        anchorPane2.setLayoutY(400.0);
        anchorPane2.setPrefHeight(78.0);
        anchorPane2.setPrefWidth(216.0);
        anchorPane2.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 20;");

        label3.setLayoutX(8.0);
        label3.setLayoutY(3.0);
        label3.setPrefHeight(69.0);
        label3.setPrefWidth(106.0);
        label3.setText("Gender : ");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#111111"));
        label3.setFont(new Font("Rockwell Bold Italic", 22.0));

        genderField.setLayoutX(114.0);
        genderField.setLayoutY(2.0);
        genderField.setPrefHeight(69.0);
        genderField.setPrefWidth(142.0);
        genderField.setText("Male");
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

        hyperlink.setAlignment(javafx.geometry.Pos.CENTER);
        hyperlink.setLayoutX(33.0);
        hyperlink.setLayoutY(13.0);
        hyperlink.setPrefHeight(43.0);
        hyperlink.setPrefWidth(99.0);
        hyperlink.setText("History");
        hyperlink.setTextFill(javafx.scene.paint.Color.valueOf("#220101"));
        hyperlink.setUnderline(true);
        hyperlink.setFont(new Font("Rockwell Bold Italic", 23.0));

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

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(label);
        getChildren().add(btnRequestJoin);
        getChildren().add(listViewAvailable);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(nameField);
        getChildren().add(anchorPane);
        anchorPane0.getChildren().add(label1);
        anchorPane0.getChildren().add(usernameField);
        getChildren().add(anchorPane0);
        anchorPane1.getChildren().add(label2);
        anchorPane1.getChildren().add(scoreField);
        getChildren().add(anchorPane1);
        anchorPane2.getChildren().add(label3);
        anchorPane2.getChildren().add(genderField);
        getChildren().add(anchorPane2);
        toHistoryPane.getChildren().add(imageView2);
        toHistoryPane.getChildren().add(hyperlink);
        getChildren().add(toHistoryPane);
        getChildren().add(label4);
        getChildren().add(imageView3);

    }
}
