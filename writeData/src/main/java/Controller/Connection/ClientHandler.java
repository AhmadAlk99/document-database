package Controller.Connection;

import Doa.DaoImp.*;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    PrintWriter out;
    BufferedReader in;

    public ClientHandler(Socket ClientSocket) throws IOException {
        in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
        out = new PrintWriter(ClientSocket.getOutputStream(), true);

    }

    @Override
    public void run() {

        try {
            UserValidatedImp user;
            DefaultAdminImp defaultAdmin;
            AdminImp admin;

            while (true) {
                out.println("please enter your UserName:");
                String userName = in.readLine().trim();

                out.println("please enter your password:");
                String password = in.readLine().trim();

                user = new UserValidatedImp(userName,password);

                if (user.isValid()) {
                    out.println("valid");
                    admin = new AdminImp(userName);
                    user = new UserValidatedImp(userName,password);
                    break;
                }
                else if(user.isDefaultAdmin()){
                    out.println("please enter your new UserName:");
                    userName = in.readLine().trim();

                    out.println("please enter your new password:");
                    password = in.readLine().trim();
                    defaultAdmin = new DefaultAdminImp(userName,password);
                    defaultAdmin.createAdmin();
                    user = new UserValidatedImp(userName,password);
                    admin = new AdminImp(userName);
                    break;
                }
                else
                    out.println("insert a valid user");
            }

            if(!user.isAdmin()){out.println("0");while (true){}}

            out.println("6");
            out.println("welcome to database");
            out.println("1-add/remove database");
            out.println("2-add/remove schema");
            out.println("3-add/remove document");
            out.println("4-add/remove users");
            out.println("5-add/remove index");

            handelRequest handel=new handelRequest(admin);
            while (true) {
                String s = in.readLine().trim();
                System.out.println(s);
                String[] reader;
                out.println("1");
                switch (s) {
                    case "1":
                        out.println("type add/remove databaseName");
                        reader= in.readLine().trim().split(" ");
                        out.println("1");
                        if(handel.handelDataBase(reader)){
                            out.println("done");
                        }
                        else {
                            out.println("try again");
                        }
                        break;
                    case "2":
                        out.println("type add/remove databaseName schemaName");
                        reader= in.readLine().trim().split(" ");
                        out.println("1");
                        if(handel.handelSchema(reader)){
                            out.println("done");
                        }
                        else {
                            out.println("try again");
                        }
                        break;
                    case "3":
                        out.println("type add databaseName schemaName");
                        reader= in.readLine().trim().split(" ");
                        out.println("1");
                        out.println("type schemaJson");
                        String Json= in.readLine().trim();
                        out.println("1");
                        if(handel.handelSchemaJson(reader,Json)){
                            out.println("done");
                        }
                        else {
                            out.println("try again");
                        }
                        break;
                    case "4":
                        out.println("type add/remove databaseName schemaName");
                        reader= in.readLine().trim().split(" ");
                        out.println("1");
                        out.println("type document");
                        String document= in.readLine().trim();
                        out.println("1");
                        if(handel.handelDocument(reader,document)){
                            out.println("done");
                        }
                        else {
                            out.println("try again");
                        }
                        break;
                    case "5":
                        out.println("type add/remove databaseName schemaName index");
                        reader= in.readLine().trim().split(" ");
                        out.println("1");
                        if(handel.handelIndex(reader)){
                            out.println("done");
                        }
                        else {
                            out.println("try again");
                        }
                        break;
                    default:
                        out.println("invalid number");

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