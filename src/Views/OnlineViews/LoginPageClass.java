package Views.OnlineViews;
import Views.GeneralViews.ChosePageClass;
import Controllers.ChangeSceneController;
import Controllers.OnlineController.LoginController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class LoginPageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView back;
    protected final Button loginButton;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final PasswordField passworField;
    protected final TextField usernameField;
    protected final Label signUp;
    LoginController logCon;
    public LoginPageClass() {
        
        imageView = new ImageView();
        back = new ImageView();
        loginButton = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        
        back.setFitHeight(80.0);
        back.setFitWidth(100.0);
        back.setPickOnBounds(true);
        back.setPreserveRatio(true);
        back.setImage(new Image(getClass().getResource("/Images/backArrow.png").toExternalForm()));
        
        passworField = new PasswordField();
        usernameField = new TextField();
        signUp = new Label();
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

        loginButton.setAlignment(javafx.geometry.Pos.CENTER);
        loginButton.setLayoutX(248.0);
        loginButton.setLayoutY(474.0);
        loginButton.setPrefHeight(55.0);
        loginButton.setPrefWidth(103.0);
        loginButton.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50;");
        loginButton.setText("Login");
        
        loginButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        loginButton.setTextFill(javafx.scene.paint.Color.WHITE);
        loginButton.setFont(new Font(18.0));

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        label0.setLayoutX(105.0);
        label0.setLayoutY(266.0);
        label0.setText("Username");
        label0.setFont(new Font(18.0));

        label1.setLayoutX(107.0);
        label1.setLayoutY(349.0);
        label1.setText("Password");
        label1.setFont(new Font(18.0));

        label2.setLayoutX(222.0);
        label2.setLayoutY(566.0);
        label2.setText("Not a member?");

        passworField.setLayoutX(228.0);
        passworField.setLayoutY(343.0);
        passworField.setPrefHeight(39.0);
        passworField.setPrefWidth(212.0);
        passworField.setPromptText("***************");
        passworField.setFocusTraversable(false);

        usernameField.setLayoutX(227.0);
        usernameField.setLayoutY(260.0);
        usernameField.setPrefHeight(39.0);
        usernameField.setPrefWidth(212.0);
        usernameField.setPromptText("Username");
        usernameField.setFocusTraversable(false);

        signUp.setLayoutX(330.0);
        signUp.setLayoutY(565.0);
        signUp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeSceneController.switchScene(new SignUpPageClass(),event);
            }
        });
        signUp.setText("Sign Up");
        signUp.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        signUp.setTextFill(javafx.scene.paint.Color.valueOf("#340ada"));
        signUp.setUnderline(true);
        signUp.setFont(new Font(14.0));
        
        
        
        getChildren().add(imageView);
        getChildren().add(back);
        getChildren().add(loginButton);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(passworField);
        getChildren().add(usernameField);
        getChildren().add(signUp);
        
        
    }          
}
