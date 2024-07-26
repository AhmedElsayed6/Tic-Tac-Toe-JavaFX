package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class SignUpController {
 Button signUpButton;
 PasswordField passworField;
 TextField usernameField;
 TextField firstNameField;
 TextField lastNameField;
 ImageView img;
 File personalImage;
 String imageString;
 
    public SignUpController(Button signUpButton, PasswordField passworField, TextField usernameField, TextField firstNameField, TextField lastNameField ,ImageView imageView0 ) {
        this.signUpButton = signUpButton;
        this.passworField = passworField;
        this.usernameField = usernameField;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.img = imageView0;
        ClientThreadHandler cth =new ClientThreadHandler();
        signUpButton.setOnMouseClicked((e)->{
        FileChooser directoryChooser = new FileChooser();
        directoryChooser.setTitle("Select Image");
         File personalImage = directoryChooser.showOpenDialog(ChangeSceneController.getStage());
         Image image = new Image(personalImage.toURI().toString());
      

            try {
                // Read image into byte array
                byte[] imageBytes = Files.readAllBytes(personalImage.toPath());
                 imageString = Base64.getEncoder().encodeToString(imageBytes);
                System.out.println(imageString.length());
            } catch (IOException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            if (personalImage != null) {
               imageView0.setImage(image);
             createQuery();
                System.out.println("Selected directory: " + personalImage.getAbsolutePath());
                // Perform operations on the selected directory
            }
        
        });
        
    }
    
    
    private void createQuery() {

        System.out.println(imageString);
        String query="Signup,ahmed88,ahmed,elsayed,123123123,true,"+imageString ;
        ClientThreadHandler.queryQueue.add(query);
        
        
      
    }
    
    


 
 
    
}
