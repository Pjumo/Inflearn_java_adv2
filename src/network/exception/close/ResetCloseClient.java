package network.exception.close;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static util.MyLogger.log;

public class ResetCloseClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        // client <- server : FIN
        Thread.sleep(1000);

        // client -> server : PUSH[1]
        os.write(1);

        // client <- server : RST
        Thread.sleep(1000);

        try{
            int read = is.read();
            System.out.println("read = " + read);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            os.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}