package network.exception.close;

import java.io.*;
import java.net.Socket;

import static util.MyLogger.log;

public class NormalCloseClient {

    private static boolean isClosed = false;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream is = socket.getInputStream();

        readByInputStream(is, socket);
        readByBufferedReader(is, socket);
        readByDataInputStream(is, socket);

        log("연결 종료: " + socket.isClosed());
    }

    private static void readByInputStream(InputStream is, Socket socket) throws IOException {
        int read = is.read();
        log("read = " + read);
        if (read == -1 && !isClosed) {
            is.close();
            socket.close();
        }
    }

    private static void readByBufferedReader(InputStream is, Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String readString = br.readLine();
        log("readString = " + readString);
        if (readString == null && !isClosed) {
            br.close();
            socket.close();
        }
    }

    private static void readByDataInputStream(InputStream is, Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(is);
        try {
            dis.readUTF();
        } catch (EOFException e) {
            log(e);
        } finally {
            if (!isClosed) {
                dis.close();
                socket.close();
            }
        }
    }
}
