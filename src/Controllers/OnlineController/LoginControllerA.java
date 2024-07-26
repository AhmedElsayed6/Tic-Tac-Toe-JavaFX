
package Controllers.OnlineController;

import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class LoginControllerA {

    private final Button login;
    protected final ImageView back;
    private final PasswordField passworField;
    private final TextField usernameField;
    private String msg;

    public LoginControllerA(Button login, TextField usernameField, PasswordField passworField, ImageView back) {
        this.login = login;
        this.usernameField = usernameField;
        this.passworField = passworField;
        this.back = back;
        msg = null;
        this.login.setOnMouseClicked((MouseEvent event) -> {
            msg = collectLog();
            login.setDisable(true);
            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(3));
            pause.setOnFinished((e) -> login.setDisable(false));
            pause.play();
        }
        );
    }

    public String getMsg() {
        return msg;
    }

    public String collectLog() {
        return (!usernameField.getText().isEmpty() && !passworField.getText().isEmpty()) ? (usernameField.getText() + "." + passworField.getText()) : null;
    }

}
