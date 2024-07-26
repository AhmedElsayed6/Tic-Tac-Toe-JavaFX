/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.OnlineControllers;

import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
        
        this.usernameField.setOnKeyTyped((event) -> {
            if (usernameField.getText().length() > 5){
                String s;
//               alert("Lengthy Username\nMaximum 6 Character");
                s = usernameField.getText(0,6);
                System.out.println(s);
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
            query = collectSign();
            
            disableAll(true);
            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
            pause.setOnFinished((e) -> disableAll(false));
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
