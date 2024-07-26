package Controllers.OnlineControllers;

import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LoginController {

    PasswordField passwordField;
    TextField usernameField;
    Button loginButton;
    ImageView back;
    String query;
    ClientThreadHandler cth;

    public LoginController(TextField usernameField, PasswordField passwordField, Button loginButton, ImageView back) {
        
        cth = new ClientThreadHandler();
        this.loginButton = loginButton;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.back = back;
        query = null;
        this.loginButton.setOnMouseClicked((MouseEvent event) -> {
             createQuery();
            loginButton.setDisable(true);
            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(3));
            pause.setOnFinished((e) -> loginButton.setDisable(false));
            pause.play();
        }
        );
    }

    private void createQuery() {

        if (collectLog() != null)
            query =collectLog();
        ClientThreadHandler.queryQueue.add(query);

    }
    public String collectLog() {
        return (!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty()) ? ( "login,"+usernameField.getText() + "," + passwordField.getText()) : null;
    }

}
