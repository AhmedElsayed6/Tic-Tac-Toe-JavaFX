/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ChangeSceneController {
    private static  Stage stage;
    private static Scene scene;
    private static Parent root;
        
    // CHANGE SCENE TO Chose
    public static void switchScene(Parent newRoot,MouseEvent e) {
        root = newRoot;
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
    } 
    
}
