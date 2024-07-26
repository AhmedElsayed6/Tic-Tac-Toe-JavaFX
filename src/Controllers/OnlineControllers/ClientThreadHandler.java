package Controllers.OnlineControllers;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ClientThreadHandler extends Thread {

    DataInputStream dis;
    PrintStream ps;
    Socket mySocket;
    public static LinkedBlockingQueue<String> queryQueue = new LinkedBlockingQueue<>();

    public ClientThreadHandler() {
        try {
            mySocket = new Socket("127.0.0.1", 5005);
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

        StringTokenizer st = new StringTokenizer(query, ",");
        String q = st.nextToken();

        switch (q) {
            case "loginstatus":
                System.out.println("Signup");

                break;

        }
    }
}
