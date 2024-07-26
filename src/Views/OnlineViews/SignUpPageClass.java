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
import javafx.scene.text.Text;

public class SignUpPageClass extends AnchorPane {

    protected final ImageView imageView;
    protected final Button btnSignup;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final PasswordField passworField;
    protected final TextField fNameField;
    protected final Label toLogin;
    protected final TextField lNameField;
    protected final Label label3;
    protected final Label label4;
    protected final TextField usernameField;
    protected final CheckBox checkBoxFeMale;
    protected final ImageView imageView0;
    protected final Label label5;



    protected final CheckBox checkBoxMale;
    protected final ImageView imageView1;
    protected final Label label6;
    protected final Button btnUploadImage;
    protected final Text txtUserlength;
    protected final Text txtGender;
    protected final Text txtPasswordlength;
    protected final Text txtLNlength;
    protected final Text txtFNlength;
    SignupController signupController;

    public SignUpPageClass() {

        imageView = new ImageView();
        btnSignup = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        passworField = new PasswordField();
        fNameField = new TextField();
        toLogin = new Label();
        lNameField = new TextField();
        label3 = new Label();
        label4 = new Label();
        usernameField = new TextField();
        checkBoxFeMale = new CheckBox();
        imageView0 = new ImageView();
        label5 = new Label();

  

        checkBoxMale = new CheckBox();
        imageView1 = new ImageView();
        label6 = new Label();
        btnUploadImage = new Button();
        txtUserlength = new Text();
        txtGender = new Text();
        txtPasswordlength = new Text();
        txtLNlength = new Text();
        txtFNlength = new Text();
        signupController = new SignupController(btnUploadImage , btnSignup, passworField,usernameField,  fNameField, lNameField,checkBoxMale, checkBoxFeMale);

        setId("AnchorPane");
        setMaxHeight(700.0);
        setMaxWidth(600.0);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(600.0);


        imageView.setFitHeight(789.0);
        imageView.setFitWidth(706.0);
        imageView.setLayoutX(-72.0);
        imageView.setLayoutY(-61.0);
        imageView.setImage(new Image(getClass().getResource("/Images/BackGround.png").toExternalForm()));

        btnSignup.setAlignment(javafx.geometry.Pos.CENTER);
        btnSignup.setLayoutX(248.0);
        btnSignup.setLayoutY(583.0);
        btnSignup.setPrefHeight(55.0);
        btnSignup.setPrefWidth(103.0);
        btnSignup.setStyle("-fx-background-color: #3f51b5; -fx-background-radius: 50;");
        btnSignup.setText("Sign up");
        btnSignup.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btnSignup.setTextFill(javafx.scene.paint.Color.WHITE);
        btnSignup.setFont(new Font("Rockwell", 18.0));

        label.setLayoutX(126);
        label.setLayoutY(120);
        label.setMinHeight(16);
        label.setMinWidth(69);

        label0.setLayoutX(109.0);
        label0.setLayoutY(201.0);
        label0.setText("First name");
        label0.setFont(new Font("Rockwell", 18.0));

        label1.setLayoutX(109.0);
        label1.setLayoutY(361.0);
        label1.setText("Password");
        label1.setFont(new Font("Rockwell", 18.0));

        label2.setLayoutX(205.0);
        label2.setLayoutY(647.0);
        label2.setText("Have an account?");
        label2.setFont(new Font("Rockwell", 18.0));

        passworField.setFocusTraversable(false);
        passworField.setLayoutX(224.0);
        passworField.setLayoutY(354.0);
        passworField.setPrefHeight(39.0);
        passworField.setPrefWidth(220.0);
        passworField.setPromptText("***************");

        fNameField.setFocusTraversable(false);
        fNameField.setLayoutX(223.0);
        fNameField.setLayoutY(196.0);
        fNameField.setPrefHeight(42.0);
        fNameField.setPrefWidth(221.0);
        fNameField.setPromptText("First name");

        toLogin.setLayoutX(357.0);
        toLogin.setLayoutY(646.0);
        toLogin.setText("Login");
        toLogin.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        toLogin.setTextFill(javafx.scene.paint.Color.valueOf("#340ada"));
        toLogin.setUnderline(true);
        toLogin.setFont(new Font("Rockwell", 18.0));

        lNameField.setFocusTraversable(false);
        lNameField.setLayoutX(223.0);
        lNameField.setLayoutY(275.0);
        lNameField.setPrefHeight(42.0);
        lNameField.setPrefWidth(221.0);
        lNameField.setPromptText("Last name");

        label3.setLayoutX(109.0);
        label3.setLayoutY(282.0);
        label3.setText("Last name");
        label3.setFont(new Font("Rockwell", 18.0));

        label4.setLayoutX(109.0);
        label4.setLayoutY(122.0);
        label4.setText("Username");
        label4.setFont(new Font("Rockwell", 18.0));

        usernameField.setFocusTraversable(false);
        usernameField.setLayoutX(223.0);
        usernameField.setLayoutY(114.0);
        usernameField.setPrefHeight(42.0);
        usernameField.setPrefWidth(221.0);
        usernameField.setPromptText("User name");

        checkBoxFeMale.setLayoutX(344.0);
        checkBoxFeMale.setLayoutY(420.0);
        checkBoxFeMale.setMnemonicParsing(false);
        checkBoxFeMale.setFont(new Font(14.0));

        imageView0.setFitHeight(69.0);
        imageView0.setFitWidth(69.0);
        imageView0.setImage(new Image(getClass().getResource("/Images/female.png").toExternalForm()));
        checkBoxFeMale.setGraphic(imageView0);

        label5.setLayoutX(109.0);
        label5.setLayoutY(437.0);
        label5.setText("Gender  ");
        label5.setFont(new Font("Rockwell", 18.0));

        checkBoxMale.setLayoutX(223.0);
        checkBoxMale.setLayoutY(420.0);
        checkBoxMale.setMnemonicParsing(false);
        checkBoxMale.setFont(new Font(14.0));

        imageView1.setFitHeight(69.0);
        imageView1.setFitWidth(69.0);

        imageView1.setImage(new Image(getClass().getResource("/Images/male.png").toExternalForm()));
        checkBoxMale.setGraphic(imageView1);


        label6.setLayoutX(109.0);
        label6.setLayoutY(508.0);
        label6.setText("Image");
        label6.setFont(new Font("Rockwell", 18.0));

        btnUploadImage.setLayoutX(221.0);
        btnUploadImage.setLayoutY(504.0);
        btnUploadImage.setMnemonicParsing(false);
        btnUploadImage.setText("Upload Image");

        txtUserlength.setFill(javafx.scene.paint.Color.RED);
        txtUserlength.setLayoutX(224.0);
        txtUserlength.setLayoutY(182.0);
        txtUserlength.setOpacity(0.0);
        txtUserlength.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtUserlength.setStrokeWidth(0.0);
        txtUserlength.setText("Maximum 10 character");

        txtGender.setFill(javafx.scene.paint.Color.RED);
        txtGender.setLayoutX(221.0);
        txtGender.setLayoutY(495.0);
        txtGender.setOpacity(0.0);
        txtGender.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtGender.setStrokeWidth(0.0);
        txtGender.setText("Choose One Gender");

        txtPasswordlength.setFill(javafx.scene.paint.Color.RED);
        txtPasswordlength.setLayoutX(224.0);
        txtPasswordlength.setLayoutY(415.0);
        txtPasswordlength.setOpacity(0.0);
        txtPasswordlength.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtPasswordlength.setStrokeWidth(0.0);
        txtPasswordlength.setText("Maximum 10 character");

        txtLNlength.setFill(javafx.scene.paint.Color.RED);
        txtLNlength.setLayoutX(221.0);
        txtLNlength.setLayoutY(339.0);
        txtLNlength.setOpacity(0.0);
        txtLNlength.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtLNlength.setStrokeWidth(0.0);
        txtLNlength.setText("Maximum 10 character");

        txtFNlength.setFill(javafx.scene.paint.Color.RED);
        txtFNlength.setLayoutX(221.0);
        txtFNlength.setLayoutY(263.0);
        txtFNlength.setOpacity(0.0);
        txtFNlength.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtFNlength.setStrokeWidth(0.0);
        txtFNlength.setText("Maximum 10 character");

        getChildren().add(imageView);
        getChildren().add(btnSignup);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(passworField);
        getChildren().add(fNameField);
        getChildren().add(toLogin);
        getChildren().add(lNameField);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(usernameField);
        getChildren().add(checkBoxFeMale);
        getChildren().add(label5);
        getChildren().add(checkBoxMale);
        getChildren().add(label6);
        getChildren().add(btnUploadImage);
        getChildren().add(txtUserlength);
        getChildren().add(txtGender);
        getChildren().add(txtPasswordlength);
        getChildren().add(txtLNlength);
        getChildren().add(txtFNlength);

    }

}
