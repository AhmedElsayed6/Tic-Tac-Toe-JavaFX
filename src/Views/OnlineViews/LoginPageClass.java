package Views.OnlineViews;

import Controllers.OnlineControllers.LoginController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoginPageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView backImage;
    protected final Button btnLogin;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final PasswordField passworField;
    protected final TextField usernameField;
    protected final Label signUp;
    protected final Text txtLength;
    protected final Text txtNotFound;
    LoginController loginController;
    public LoginPageClass() {

        imageView = new ImageView();
        backImage = new ImageView();
        btnLogin = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        passworField = new PasswordField();
        usernameField = new TextField();
        signUp = new Label();
        txtLength = new Text();
        txtNotFound = new Text();
        loginController = new LoginController(usernameField,passworField,btnLogin,backImage);

        setId("AnchorPane");
        setMaxHeight(700.0);
        setMaxWidth(600.0);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(700.0);
        imageView.setFitWidth(600.0);
        imageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        backImage.setFitHeight(74.0);
        backImage.setFitWidth(80.0);
        backImage.setPickOnBounds(true);
        backImage.setPreserveRatio(true);
        backImage.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));

        btnLogin.setAlignment(javafx.geometry.Pos.CENTER);
        btnLogin.setLayoutX(248.0);
        btnLogin.setLayoutY(474.0);
        btnLogin.setPrefHeight(55.0);
        btnLogin.setPrefWidth(103.0);
        btnLogin.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50;");
        btnLogin.setText("Login");
        btnLogin.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnLogin.setTextFill(javafx.scene.paint.Color.WHITE);
        btnLogin.setFont(new Font("Rockwell", 18.0));

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        label0.setLayoutX(105.0);
        label0.setLayoutY(266.0);
        label0.setText("Username");
        label0.setFont(new Font("Rockwell Bold", 18.0));

        label1.setLayoutX(107.0);
        label1.setLayoutY(377.0);
        label1.setText("Password");
        label1.setFont(new Font("Rockwell", 18.0));

        label2.setLayoutX(222.0);
        label2.setLayoutY(566.0);
        label2.setText("Not a member?");
        label2.setFont(new Font("Rockwell", 15.0));

        passworField.setFocusTraversable(false);
        passworField.setLayoutX(228.0);
        passworField.setLayoutY(371.0);
        passworField.setPrefHeight(39.0);
        passworField.setPrefWidth(212.0);
        passworField.setPromptText("***************");

        usernameField.setFocusTraversable(false);
        usernameField.setLayoutX(227.0);
        usernameField.setLayoutY(260.0);
        usernameField.setPrefHeight(39.0);
        usernameField.setPrefWidth(212.0);
        usernameField.setPromptText("Username");

        signUp.setLayoutX(332.0);
        signUp.setLayoutY(567.0);
        signUp.setText("Sign Up");
        signUp.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        signUp.setTextFill(javafx.scene.paint.Color.valueOf("#340ada"));
        signUp.setUnderline(true);
        signUp.setFont(new Font("Rockwell", 14.0));

        txtLength.setFill(javafx.scene.paint.Color.RED);
        txtLength.setLayoutX(227.0);
        txtLength.setLayoutY(335.0);
        txtLength.setOpacity(0.0);
        txtLength.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtLength.setStrokeWidth(0.0);
        txtLength.setText("Maximum 10 Character");

        txtNotFound.setFill(javafx.scene.paint.Color.RED);
        txtNotFound.setLayoutX(228.0);
        txtNotFound.setLayoutY(449.0);
        txtNotFound.setOpacity(0.0);
        txtNotFound.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtNotFound.setStrokeWidth(0.0);
        txtNotFound.setText("Wrong Username Or Password");

        getChildren().add(imageView);
        getChildren().add(backImage);
        getChildren().add(btnLogin);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(passworField);
        getChildren().add(usernameField);
        getChildren().add(signUp);
        getChildren().add(txtLength);
        getChildren().add(txtNotFound);

    }

    

}
