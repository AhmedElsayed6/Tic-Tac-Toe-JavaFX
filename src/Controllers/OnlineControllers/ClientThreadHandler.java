package Controllers.OnlineControllers;

import Controllers.ChangeSceneController;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ClientThreadHandler extends Thread {
    public static String username;

    DataInputStream dis;
    PrintStream ps;
    Socket mySocket;
    public static LinkedBlockingQueue<String> queryQueue = new LinkedBlockingQueue<>();
    public static Map<String, Controllers> controllersMap = new ConcurrentHashMap<>();

    public ClientThreadHandler(String ip ) {
        
      
        try {
            mySocket = new Socket(ip, 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            System.out.print("Can't connect to stream");
        }
        start();
        
        
        ChangeSceneController.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
         synchronized  public void handle(WindowEvent event) {
                
                   ClientThreadHandler.queryQueue.add("setloggedoff," +LoginController.getUsername()+","+LoginController.getUsername());
                   
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ClientThreadHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                    stop();
                    System.exit(0);
            }
        });
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            String sentQuery = "";
            String recievedQuery = null;

            try {
                sentQuery = queryQueue.poll(500, TimeUnit.MILLISECONDS);
                if (sentQuery != null) {
                    querySender(sentQuery);
                }
                if (dis.available() > 0) {
                    recievedQuery = dis.readLine();
                    recievedQueryHandler(recievedQuery);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    void querySender(String query) {
        if (query == null) {
            return;
        }
        ps.println(query);
    }

    void recievedQueryHandler(String query) {
       
        if (query == null) {
            System.out.println(query);
            return;
        }
 
        String[] st = query.split(",");
  
        switch (st[1]) {
            case "loginstatus":
                LoginController lc = (LoginController) controllersMap.get("login");
                if (Boolean.parseBoolean(st[2])) {
                        System.out.println("valid Login");
                    lc.validLogin();
                    lc.setUsername(st[0]);

                } else {
                      System.out.println( "invalid Login");
                    lc.inValidLogin();
                }
                break;
                
                case "signupstatus":
                SignupController sc = (SignupController) controllersMap.get("signup");
                if (Boolean.parseBoolean(st[2])) {
                        System.out.println("valid signup");
                    sc.validSignup();
                    sc.setUsername(st[0]);

                } else {
                     sc.inValidSignup();
                      System.out.println( "invalid signup");
                }
                break;

         
                case "getuserdata":          
                OnlinePageController oc1 = (OnlinePageController) controllersMap.get("online");
                oc1.setUserData(query);
                break;
                
                case "getuserhistory":          
                GameHistoryController ghc = (GameHistoryController) controllersMap.get("history");
                ghc.setHistory(query);
                break;

                case "getavailableplayers":
                    OnlinePageController oc2 = (OnlinePageController) controllersMap.get("online");
                    if(st.length>2){
                        oc2.showAvailablePlayers(st);
                    }
                    break;
                case "playinvite":
                    OnlinePageController oc3 = (OnlinePageController) controllersMap.get("online");
                    oc3.showInvite(query);                  
                    break;
                case "rejectinvite":
                    OnlinePageController oc5 = (OnlinePageController) controllersMap.get("online");
                    oc5.showRejectDialog(query);                  
                    break;
                case "startmatch":
                    OnlinePageController oc4 = (OnlinePageController) controllersMap.get("online");
                    oc4.startGame(query);                  
                    break;
              
                case "playedmove":
                    OnlineGameController ogc = (OnlineGameController) controllersMap.get("game");
                    ogc.recievedPlay(query);                  
                    break;
                case "win":
                    OnlineGameController ogc1 = (OnlineGameController) controllersMap.get("game");
                    ogc1.recievedPlay(query);                  
                    break;
                case "surrender":

        
                     OnlineGameController ogc2 = (OnlineGameController) controllersMap.get("game");
                   ogc2.showSurrDialog();
                    break;
                case "leftgame":

            
                     OnlineGameController ogc3 = (OnlineGameController) controllersMap.get("game");
                    ogc3.showLeaveDialog();
                    break;

              

        }
    }
}
