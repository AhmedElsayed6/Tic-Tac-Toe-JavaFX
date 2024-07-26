
package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class SignupController {

    protected final Button btnSignUp;
    protected final Button btnUploadImg;
    protected final PasswordField passworField;
    protected final TextField usernameField;
    protected final TextField firstNameField;
    protected final TextField lastNameField;
    protected final CheckBox checkBoxMale;
    protected final CheckBox checkBoxFemale;
    ImageView img;
    File personalImage;
    String imageString;
    private String query;
    Boolean viewAlertOnce = false;

    public SignupController(Button btnUploadImg , Button btnSignUp, PasswordField passworField, TextField usernameField, TextField firstNameField, TextField lastNameField, CheckBox checkBoxMale, CheckBox checkBoxFemale) {
        this.btnSignUp = btnSignUp;
        this.btnUploadImg = btnUploadImg;
        this.passworField = passworField;
        this.usernameField = usernameField;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.checkBoxMale = checkBoxMale;
        this.checkBoxFemale = checkBoxFemale;
        imageString = null;
        query = null;
        setInputsHandlers();

    }
    private void setInputsHandlers(){
           
            this.usernameField.setOnKeyReleased((event) -> {
            
            if (usernameField.getText().length() > 5 && viewAlertOnce == false ){
               viewAlertOnce = true;
                String s;
               alert("Lengthy Username\nMaximum 6 Character");
                s = usernameField.getText(0,6);
                usernameField.clear();
                usernameField.setText(s);
                usernameField.setFocusTraversable(false);
            }
                
        });
        this.checkBoxMale.setOnMouseClicked((MouseEvent event)-> {
        if (checkBoxMale.isSelected() && checkBoxFemale.isSelected()){
            alert("Insertion Error\nchose one Gender");
            checkBoxMale.setSelected(false);
        }
        });
        
        this.checkBoxFemale.setOnMouseClicked((MouseEvent event)-> {
        if (checkBoxMale.isSelected() && checkBoxFemale.isSelected()){
            alert("Insertion Error\nchose one Gender");
            checkBoxFemale.setSelected(false);
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
        this.btnUploadImg.setOnMouseClicked((e)->{
        
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
        if (collectSign() != null){
           query = collectSign();
           ClientThreadHandler.queryQueue.add(query);
        }
    }
    //signup,username,firstname,lastname,password,(true or false)
    public String collectSign() {
        return !(isEmpty()) ? ("signup," + usernameField.getText() + "," + firstNameField.getText() + "," + lastNameField.getText() +"," + passworField.getText()+"," +isMale()+",0," +imageString  ) : null;
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
        if (checkBoxMale.isSelected()) 
            return "true";
        else
            return "false";
    }
    public void disableAll(boolean b){
        this.btnSignUp.setDisable(b);
        this.passworField.setDisable(b);
        this.usernameField.setDisable(b);
        this.firstNameField.setDisable(b);
        this.lastNameField.setDisable(b);
        this.checkBoxMale.setDisable(b);
        this.checkBoxFemale.setDisable(b);
    }
    public void alert(String type){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText(type);
            alert.show();
    }

}
