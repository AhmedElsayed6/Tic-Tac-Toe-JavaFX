package Controllers.OnlineControllers;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ClientThreadHandler extends Thread {
    public static String username;

    DataInputStream dis;
    PrintStream ps;
    Socket mySocket;
    public static LinkedBlockingQueue<String> queryQueue = new LinkedBlockingQueue<>();
    public static Map<String, Controllers> controllersMap = new ConcurrentHashMap<>();

    public ClientThreadHandler(String ip) {
        try {
            mySocket = new Socket(ip, 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
        } catch (IOException ex) {
            System.out.print("Can't connect to stream");
        }
        start();
    }

    public void run() {
        while (true) {
            String sentQuery = "";
            String recievedQuery = null;

            try {
                sentQuery = queryQueue.poll(2, TimeUnit.SECONDS);
                if (sentQuery != null) {
                    querySender(sentQuery);
                }

                if (dis.available() > 0) {

                    recievedQuery = dis.readLine();

                    recievedQueryHandler(recievedQuery);
                }

            } catch (Exception ex) {
                System.out.print("An error occured");
            }
        }
    }

    void querySender(String query) {
        if (query == null) {
            return;
        }
        // send to server
        ps.println(query);
    }

    void recievedQueryHandler(String query) {

        if (query == null) {
            System.out.println(query);
            return;
        }

        String[] st = query.split(",");
        System.out.println(query);
        switch (st[1]) {
            case "loginstatus":
                LoginController lc = (LoginController) controllersMap.get("login");
                if (Boolean.parseBoolean(st[2])) {
                        System.out.println("valid");
                    lc.validLogin();
                    username=st[0];
                } else {
                      System.out.println( "invalid");
                    lc.inValidLogin();
                }
                break;
                
                case "signupstatus":
                SignupController sc = (SignupController) controllersMap.get("signup");
                if (Boolean.parseBoolean(st[2])) {
                        System.out.println("valid");
                    sc.validSignup();
                    username=st[0];
                } else {
                     sc.inValidSignup();
                      System.out.println( "invalid");
                }
                break;
                case "getavailableplayers":
                    OnlinePageController oc = (OnlinePageController) controllersMap.get("getavailableplayers");
                    if(st[2]!=null){
                        oc.showAvailablePlayers(st);
                    }
                    break;

        }
    }
}
