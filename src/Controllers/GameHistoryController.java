/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.OnlineControllers.ClientThreadHandler;
import Controllers.OnlineControllers.LoginController;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author hp
 */
public class GameHistoryController {
    ListView listViewHistory;
    public GameHistoryController(  ListView listViewHistory){
        this.listViewHistory=listViewHistory;
        getPlayerHistory();
    }

    private void getPlayerHistory() {
       String query = "getuserhistory," + LoginController.getUsername();
        ClientThreadHandler.queryQueue.add(query);
    }
   
    
}
