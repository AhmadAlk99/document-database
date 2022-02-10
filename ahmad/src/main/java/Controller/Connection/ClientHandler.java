package Controller.Connection;

import Doa.DaoImp.*;

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
            UserValidatedImp user;
            DefaultAdminImp defaultAdmin;

            while (true) {

                out.println("please enter your UserName:");
                String userName = in.readLine().trim();

                out.println("please enter your password:");
                String password = in.readLine().trim();

                user = new UserValidatedImp(userName,password);

                if (user.isValid()) {
                    break;
                }
                else if(user.isDefaultAdmin()){
                    defaultAdmin = new DefaultAdminImp(userName,password);
                    defaultAdmin.createAdmin();
                }
                else
                    out.println("insert a valid user");
            }

            out.println("welcome to database");

            out.println("1-add/remove database");
            out.println("2-add/remove schema");
            out.println("3-add/remove document");
            out.println("4-add/remove users");
            out.println("5-add/remove index");
            out.println("6-add/remove index");

            while (true) {
                String[] read = in.readLine().trim().split(" ");
                switch (read[0]){

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