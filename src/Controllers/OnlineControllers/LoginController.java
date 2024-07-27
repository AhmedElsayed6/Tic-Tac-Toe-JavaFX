package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import Views.OnlineViews.onlinePageClass;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LoginController  implements Controllers {

    PasswordField passwordField;
    TextField usernameField;
    Button loginButton;
    ImageView back;
    String query;
    ClientThreadHandler cth;
    Text txtLength;
    Text txtPassLength;
    Text invalidText;

    public static String getUsername() {
        return username;
    }
    private static String username;
    
    public static void setUsername(String username) {
        LoginController.username = username;
    }
    

    public LoginController(TextField usernameField, PasswordField passwordField, Button loginButton,
            ImageView back, Text txtLength, Text txtPassLength , Text invalidText) {

     
        this.loginButton = loginButton;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.back = back;
        this.txtLength = txtLength;
        this.txtPassLength = txtPassLength;
        this.invalidText = invalidText;
        query = null;
        this.usernameField.setOnKeyReleased((event) -> {
            if (usernameField.getText().length() > 9) {
                String s;
                s = usernameField.getText(0, 10);
                usernameField.clear();
                usernameField.setText(s);
                usernameField.positionCaret(10);
                txtLength.setOpacity(1);
                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
                pause.setOnFinished((e) -> txtLength.setOpacity(0));
                pause.play();

            }

        });
        this.passwordField.setOnKeyReleased((event) -> {
            if (passwordField.getText().length() > 9) {
                String s;
                s = passwordField.getText(0, 10);
                passwordField.clear();
                passwordField.setText(s);
                passwordField.positionCaret(10);
                txtPassLength.setOpacity(1);
                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(5));
                pause.setOnFinished((e) -> txtPassLength.setOpacity(0));
                pause.play();

            }

        });

        this.loginButton.setOnMouseClicked((MouseEvent event) -> {
            createQuery();
            loginButton.setDisable(true);
            usernameField.setDisable(true);
            passwordField.setDisable(true);
            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(3));
            pause.setOnFinished((e) -> {
                loginButton.setDisable(false);
                usernameField.setDisable(false);
                passwordField.setDisable(false);
            });
            pause.play();
        }
        );
    }

    private void createQuery() {

        if (collectLog() != null){
            query =collectLog();
            ClientThreadHandler.queryQueue.add(query);
            ClientThreadHandler.controllersMap.put("login", this);
        }


    }
    
    public void validLogin(){
       
        Platform.runLater(()->{ChangeSceneController.switchSceneWithStage(new onlinePageClass());});
        
    }
    public void inValidLogin(){
         Platform.runLater(()->{  invalidText.setOpacity(1);
            PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(3));
            pause.setOnFinished((e) -> {
               invalidText.setOpacity(0);
            });});
          
    }
    
    public String collectLog() {
        return (!usernameField.getText().isEmpty() && !passwordField.getText().isEmpty()) ? ("login," + usernameField.getText() + "," + passwordField.getText()) : null;
    }

}
