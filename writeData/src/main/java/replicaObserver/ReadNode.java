package replicaObserver;

import java.io.IOException;
import java.net.Socket;

class ReadNode  {
private final String host = "localhost";
    public ReadNode(){
    }
    public void connect() throws IOException {
        Socket socket = new Socket(host, 8000);
    }

    public void update() {
        //copy the data from here to the read node
    }
}
