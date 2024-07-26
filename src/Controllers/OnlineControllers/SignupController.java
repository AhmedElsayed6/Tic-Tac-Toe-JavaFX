/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import Views.GeneralViews.ChosePageClass;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SignupController {

    protected final Button btnSignUp;
    protected final PasswordField passworField;
    protected final TextField usernameField;
    protected final TextField firstNameField;
    protected final TextField lastNameField;
    protected final CheckBox checkBoxMale;
    protected final CheckBox checkBoxFemale;
    private String query;

    public SignupController(Button btnSignUp, PasswordField passworField, TextField usernameField, TextField firstNameField, TextField lastNameField, CheckBox checkBoxMale, CheckBox checkBoxFemale) {
        this.btnSignUp = btnSignUp;
        this.passworField = passworField;
        this.usernameField = usernameField;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.checkBoxMale = checkBoxMale;
        this.checkBoxFemale = checkBoxFemale;
        query = null;
        this.btnSignUp.setOnMouseClicked((MouseEvent event) -> {
            query = collectSign();
            
            btnSignUp.setDisable(true);
            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
            pause.setOnFinished((e) -> btnSignUp.setDisable(false));
            pause.play();
        }
        );
    }
    private void createQuery() {
        if (collectSign() != null)
            query = "signup,"+collectSign();
        System.out.println(query);
    }
    //signup,username,firstname,lastname,password,(true or false)
    public String collectSign() {
        return !(isEmpty()) ? ("signup," + usernameField.getText() + "," + firstNameField.getText() + "," + lastNameField.getText() + "," + passworField.getText() + "," +isMale()) : null;
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

}
