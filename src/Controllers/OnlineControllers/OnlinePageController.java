/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.OnlineControllers;

import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author hp
 */
public class OnlinePageController {

    protected final Button btnRequestJoin;
    protected final ListView listViewAvailable;
    protected final Label usernameField;
    public OnlinePageController(ListView listViewAvailable, Button btnRequestJoin, Label usernameField) {
        this.usernameField = usernameField;
        this.listViewAvailable = listViewAvailable;
        this.btnRequestJoin = btnRequestJoin;
    }
    
}