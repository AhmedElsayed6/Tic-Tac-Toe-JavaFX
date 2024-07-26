package Controllers.OnlineControllers;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ClientThreadHandler {

    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;

    public ClientThreadHandler() {
        try {
            mySocket = new Socket("127.0.0.1", 5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
            ps.println("Server can you hear me ?");
            String replyMsg = dis.readLine();
            System.out.println(replyMsg);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                dis.close();
                mySocket.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

//    public void closeServerConnection() {
//        try {
//            ps.close();
//            dis.close();
//            mySocket.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    public void setquery(String query) {
        ps.println(query);
    }
}
