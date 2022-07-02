package Connection;

import Dao.ReadDao;
import Dao.ReadDaoImp;

import java.io.*;

import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket ClientSocket;
    PrintWriter out;
    BufferedReader in;

    public ClientHandler(Socket ClientSocket) throws IOException {

        this.ClientSocket = ClientSocket;
        in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
        out = new PrintWriter(ClientSocket.getOutputStream(), true);

    }

    @Override
    public void run() {

        try {
            ReadDao data= new ReadDaoImp();
            String[] readFromData;
            out.println("2");
            out.println("> to read document from specific database write 1");
            out.println("> to read indexed document from specific database write 2");

            while (true) {
                String[] read = in.readLine().trim().split(" ");
                switch (read[0]){
                    case "1":
                        out.println("1");
                        out.println("> example how to read:read from dataBaseName documentName");
                        readFromData = in.readLine().trim().split(" ");
                        data.readDocument(readFromData,out);
                        break;
                    case "2":
                        out.println("1");
                        out.println("> example how to read:read from dataBaseName documentName");
                        readFromData = in.readLine().trim().split(" ");
                        data.readIndexedDocument(readFromData,out);
                        break;

                    default:
                        out.println("1");
                        out.println("> sorry not valid input try again");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}