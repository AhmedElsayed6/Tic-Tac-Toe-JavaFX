/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.OnlineController;

import Controllers.ChangeSceneController;
import Views.GeneralViews.ChosePageClass;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class LoginController {

    private final Button login;
    protected final ImageView back;
    private final PasswordField passworField;
    private final TextField usernameField;
    private String msg;

    public LoginController(Button login, TextField usernameField, PasswordField passworField, ImageView back) {
        this.login = login;
        this.usernameField = usernameField;
        this.passworField = passworField;
        this.back = back;
        msg = null;
        this.login.setOnMouseClicked((MouseEvent event) -> {
            msg = collectLog();
            login.setDisable(true);
            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
            pause.setOnFinished((e) -> login.setDisable(false));
            pause.play();
         
        }
        );
    }

    public String getMsg() {
        return msg;
    }

    public String collectLog() {
        return (!isEmpty()) ? ("login,"+usernameField.getText() + "," + passworField.getText()) : null;
    }
    public boolean isEmpty() {
        if (usernameField.getText().isEmpty() || passworField.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
