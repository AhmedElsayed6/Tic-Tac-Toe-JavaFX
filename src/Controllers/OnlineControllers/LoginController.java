package Controllers.OnlineControllers;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
        PasswordField passwordField;
        TextField usernameField;
        Button loginButton;
        
  public  LoginController(TextField usernameField,PasswordField passwordField , Button loginButton){
            this.usernameField=usernameField;
            this.passwordField=passwordField;
            this.loginButton=loginButton;
            loginButton.setOnMouseClicked(event ->loginHandler());
        }
  private void loginHandler(){
   
      String username = usernameField.getText();
      String password = passwordField.getText();
      String query = "Login,"+username+","+password;
      
      
  }

}
