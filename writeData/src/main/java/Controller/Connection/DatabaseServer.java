package Controller.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseServer {

    private static ArrayList<ClientHandler> Clients =new ArrayList<>();

    private static ExecutorService pool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {


            ServerSocket serverSocket =new ServerSocket(8000);
            System.out.println("the server is running ...");
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress()+" the connection is done");
                ClientHandler studentThread = new ClientHandler(socket);
                Clients.add(studentThread);
                pool.execute(studentThread);
            }
    }

}
