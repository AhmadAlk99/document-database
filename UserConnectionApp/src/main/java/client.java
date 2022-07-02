import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String host = "localhost";
            Socket socket = new Socket(host, 8000);

            PrintWriter toServer = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String valid="";
            while (!valid.equals("valid")) {
                System.out.println(in.readLine());
                String UserName = bufferedReader.readLine().trim();
                toServer.println(UserName);

                System.out.println(in.readLine());
                String password = bufferedReader.readLine().trim();
                toServer.println( password);

                valid=in.readLine();
                if(UserName.equals("root")){
                    System.out.println(valid);
                    UserName = bufferedReader.readLine().trim();
                    toServer.println(UserName);

                    System.out.println(in.readLine());
                    password = bufferedReader.readLine().trim();
                    toServer.println( password);
                    valid="valid";
                }
                else if(!valid.equals("valid")) System.out.println(valid);

            }

            int numberOfReads = Integer.parseInt(in.readLine())+0;
            if(numberOfReads>0)
            for (int i = 0; i < numberOfReads; i++) {
                System.out.println(in.readLine());
            }

            while(true) {
                String s = bufferedReader.readLine().trim();
                toServer.println(s);
                if(s.equals("end"))break;
                numberOfReads = Integer.parseInt(in.readLine());
                for (int i = 0; i < numberOfReads; i++) {
                    System.out.println(in.readLine());
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*{"_id": {"type": "integer"},"name": {"type": "string"},"price": {"type": "number","minimum": 0}}*/