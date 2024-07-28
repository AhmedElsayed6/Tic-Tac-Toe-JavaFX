package Controllers;

import Views.OnlineViews.onlinePageClass;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ChangeSceneController {
    private static  Stage stage;

    public static Stage getStage() {
        return stage;
    }


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

        public static void switchSceneWithStage(Parent newRoot) {
        root = newRoot;
        Scene newScene = new Scene(root);
        stage.setScene(newScene);
        stage.show();
    } 


}
