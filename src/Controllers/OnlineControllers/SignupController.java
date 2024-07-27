package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import Views.OnlineViews.onlinePageClass;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class SignupController implements Controllers {

    protected final Button btnSignUp;
    protected final Button btnUploadImg;
    protected final PasswordField passworField;
    protected final TextField usernameField;
    protected final TextField firstNameField;
    protected final TextField lastNameField;
    protected final CheckBox checkBoxMale;
    protected final CheckBox checkBoxFemale;
    protected final Text txtUserlength;
    protected final Text txtPasswordlength;
    protected final Text txtLNlength;
    protected final Text txtFNlength;
    ImageView img;
    File personalImage;
    String imageString;
    private String query;

    public SignupController(Button btnUploadImg, Button btnSignUp, PasswordField passworField, TextField usernameField,
            TextField firstNameField, TextField lastNameField, CheckBox checkBoxMale, CheckBox checkBoxFemale,
            Text txtUserlength,Text txtPasswordlength,Text txtFNlength,Text txtLNlength) {

        this.btnSignUp = btnSignUp;
        this.btnUploadImg = btnUploadImg;
        this.passworField = passworField;
        this.usernameField = usernameField;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.checkBoxMale = checkBoxMale;
        this.checkBoxFemale = checkBoxFemale;
        this.txtUserlength = txtUserlength;
        this.txtPasswordlength = txtPasswordlength;
        this.txtFNlength = txtFNlength;
        this.txtLNlength = txtLNlength;
        imageString = null;
        query = null;
        setInputsHandlers();

    }

    private void setInputsHandlers() {
        //HANDLE LAST NAME
        this.lastNameField.setOnKeyReleased((event) -> {
            if (lastNameField.getText().length() > 9) {
                String s;
                s = lastNameField.getText(0, 10);
                lastNameField.clear();
                lastNameField.setText(s);
                lastNameField.positionCaret(10);
                txtLNlength.setOpacity(1);
                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
                pause.setOnFinished((e) -> txtLNlength.setOpacity(0));
                pause.play();

            }

        });
        //HANDLE FIRST NAME
        this.firstNameField.setOnKeyReleased((event) -> {
            if (firstNameField.getText().length() > 9) {
                String s;
                s = firstNameField.getText(0, 10);
                firstNameField.clear();
                firstNameField.setText(s);
                firstNameField.positionCaret(10);
                txtFNlength.setOpacity(1);
                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
                pause.setOnFinished((e) -> txtFNlength.setOpacity(0));
                pause.play();

            }

        });
        //HANDLE USERNAME
        this.usernameField.setOnKeyReleased((event) -> {
            if (usernameField.getText().length() > 9) {
                String s;
                s = usernameField.getText(0, 10);
                usernameField.clear();
                usernameField.setText(s);
                usernameField.positionCaret(10);
                txtUserlength.setOpacity(1);
                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
                pause.setOnFinished((e) -> txtUserlength.setOpacity(0));
                pause.play();

            }

        });
        //HANDLE PASSWORD
        this.passworField.setOnKeyReleased((event) -> {
            if (passworField.getText().length() > 9) {
                String s;
                s = passworField.getText(0, 10);
                passworField.clear();
                passworField.setText(s);
                passworField.positionCaret(10);
                txtPasswordlength.setOpacity(1);
                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
                pause.setOnFinished((e) -> txtPasswordlength.setOpacity(0));
                pause.play();

            }

        });

        this.checkBoxMale.setOnMouseClicked((MouseEvent event) -> {
            if (checkBoxMale.isSelected() && checkBoxFemale.isSelected()) {
                checkBoxFemale.setSelected(false);
            }
        });
        this.checkBoxFemale.setOnMouseClicked((MouseEvent event) -> {
            if (checkBoxMale.isSelected() && checkBoxFemale.isSelected()) {
                checkBoxMale.setSelected(false);
            }
        });

        this.btnSignUp.setOnMouseClicked((MouseEvent event) -> {
            createQuery();

            disableAll(true);
            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
            pause.setOnFinished((e) -> disableAll(false));
            pause.play();
        }
        );
        this.btnUploadImg.setOnMouseClicked((e) -> {

            FileChooser directoryChooser = new FileChooser();
            directoryChooser.setTitle("Select Image");
            File personalImage = directoryChooser.showOpenDialog(ChangeSceneController.getStage());
            Image image = new Image(personalImage.toURI().toString());
            try {
                byte[] imageBytes = Files.readAllBytes(personalImage.toPath());
                imageString = Base64.getEncoder().encodeToString(imageBytes);
            } catch (IOException ex) {
                System.out.println("Exception converting image to string");
            }
        });
    }

    private void createQuery() {
        if (collectSign() != null) {
            query = collectSign();
            ClientThreadHandler.queryQueue.add(query);
            ClientThreadHandler.controllersMap.put("signup", this);
        }
    }
        public void validLogin(){
        Platform.runLater(()->{ChangeSceneController.switchSceneWithStage(new onlinePageClass());});
        
    }

    //signup,username,firstname,lastname,password,(true or false)
    public String collectSign() {
        return !(isEmpty()) ? ("signup," + usernameField.getText() + "," + firstNameField.getText() + "," + lastNameField.getText() + "," + passworField.getText() + "," + isMale() + ",0," + imageString) : null;
    }

    public boolean isEmpty() {
        if (usernameField.getText().isEmpty() || passworField.getText().isEmpty()
                || firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty()
                || !(checkBoxMale.isSelected() || checkBoxFemale.isSelected())) {
            return true;
        } else {
            return false;
        }

    }

    public String isMale() {
        if (checkBoxMale.isSelected()) {
            return "true";
        } else {
            return "false";
        }
    }

    public void disableAll(boolean b) {
        this.btnSignUp.setDisable(b);
        this.passworField.setDisable(b);
        this.usernameField.setDisable(b);
        this.firstNameField.setDisable(b);
        this.lastNameField.setDisable(b);
        this.checkBoxMale.setDisable(b);
        this.checkBoxFemale.setDisable(b);
        this.txtUserlength.setDisable(b);
        this.txtPasswordlength.setDisable(b);
        this.txtFNlength.setDisable(b);
        this.txtLNlength.setDisable(b);
    }

    public void alert(String type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(type);
        alert.show();
    }

}
