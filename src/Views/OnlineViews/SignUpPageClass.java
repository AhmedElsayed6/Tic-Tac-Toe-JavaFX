package Views.OnlineViews;

import Controllers.OnlineControllers.SignupController;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public  class SignUpPageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final Button btnSignUp;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final PasswordField passworField;
    protected final TextField usernameField;
    protected final Label signUp;
    protected final TextField usernameField1;
    protected final Label label3;
    protected final Label label4;
    protected final TextField usernameField2;
    protected final CheckBox checkBox;
    protected final ImageView imageView0;
    protected final CheckBox checkBox0;
    protected final ImageView imageView1;
    protected final Label label5;
    protected final SignupController SignCon;
    

    public SignUpPageClass() {

        imageView = new ImageView();
        btnSignUp = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        passworField = new PasswordField();
        usernameField = new TextField();
        signUp = new Label();
        usernameField1 = new TextField();
        label3 = new Label();
        label4 = new Label();
        usernameField2 = new TextField();
        checkBox = new CheckBox();
        imageView0 = new ImageView();
        checkBox0 = new CheckBox();
        imageView1 = new ImageView();
        label5 = new Label();
        SignCon = new SignupController(btnSignUp, passworField,usernameField2,  usernameField, usernameField1,checkBox, checkBox0);
        setId("AnchorPane");
        setMaxHeight(700.0);
        setMaxWidth(600.0);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(749.0);
        imageView.setFitWidth(668.0);
        imageView.setLayoutX(-33.0);
        imageView.setLayoutY(-40.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        btnSignUp.setAlignment(javafx.geometry.Pos.CENTER);
        btnSignUp.setLayoutX(248.0);
        btnSignUp.setLayoutY(524.0);
        btnSignUp.setPrefHeight(55.0);
        btnSignUp.setPrefWidth(103.0);
        btnSignUp.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50;");
        btnSignUp.setText("Sign up");
        btnSignUp.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnSignUp.setTextFill(javafx.scene.paint.Color.WHITE);
        btnSignUp.setFont(new Font(18.0));

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        label0.setLayoutX(124.0);
        label0.setLayoutY(230.0);
        label0.setText("First name");
        label0.setFont(new Font(18.0));

        label1.setLayoutX(124.0);
        label1.setLayoutY(368.0);
        label1.setText("Password");
        label1.setFont(new Font(18.0));

        label2.setLayoutX(232.0);
        label2.setLayoutY(616.0);
        label2.setText("Have an account?");

        passworField.setLayoutX(239.0);
        passworField.setLayoutY(361.0);
        passworField.setPrefHeight(39.0);
        passworField.setPrefWidth(220.0);
        passworField.setPromptText("***************");

        usernameField.setLayoutX(238.0);
        usernameField.setLayoutY(225.0);
        usernameField.setPrefHeight(42.0);
        usernameField.setPrefWidth(221.0);
        usernameField.setPromptText("First name");

        signUp.setLayoutX(355.0);
        signUp.setLayoutY(615.0);
        signUp.setText("Login");
        signUp.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        signUp.setTextFill(javafx.scene.paint.Color.valueOf("#340ada"));
        signUp.setUnderline(true);
        signUp.setFont(new Font(14.0));

        usernameField1.setLayoutX(238.0);
        usernameField1.setLayoutY(292.0);
        usernameField1.setPrefHeight(42.0);
        usernameField1.setPrefWidth(221.0);
        usernameField1.setPromptText("Last name");

        label3.setLayoutX(124.0);
        label3.setLayoutY(299.0);
        label3.setText("Last name");
        label3.setFont(new Font(18.0));

        label4.setLayoutX(124.0);
        label4.setLayoutY(166.0);
        label4.setText("Username");
        label4.setFont(new Font(18.0));
        
        usernameField2.setLayoutX(238.0);
        usernameField2.setLayoutY(158.0);
        usernameField2.setPrefHeight(42.0);
        usernameField2.setPrefWidth(221.0);
        usernameField2.setPromptText("User name");

        checkBox.setLayoutX(240.0);
        checkBox.setLayoutY(424.0);
        checkBox.setMnemonicParsing(false);
        checkBox.setFont(new Font(14.0));

        imageView0.setFitHeight(81.0);
        imageView0.setFitWidth(69.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/Images/male.png").toExternalForm()));
        checkBox.setGraphic(imageView0);

        checkBox0.setLayoutX(350.0);
        checkBox0.setLayoutY(426.0);
        checkBox0.setMnemonicParsing(false);
        checkBox0.setFont(new Font(14.0));
        

        imageView1.setFitHeight(69.0);
        imageView1.setFitWidth(69.0);
        imageView1.setImage(new Image(getClass().getResource("/Images/female.png").toExternalForm()));
        checkBox0.setGraphic(imageView1);

        label5.setLayoutX(124.0);
        label5.setLayoutY(434.0);
        label5.setText("Gender  ");
        label5.setFont(new Font(18.0));

        getChildren().add(imageView);
        getChildren().add(btnSignUp);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(passworField);
        getChildren().add(usernameField);
        getChildren().add(signUp);
        getChildren().add(usernameField1);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(usernameField2);
        getChildren().add(checkBox);
        getChildren().add(checkBox0);
        getChildren().add(label5);

    }

}
