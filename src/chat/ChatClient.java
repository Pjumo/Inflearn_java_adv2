package chat;

import chat.util.RegexUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static chat.util.Command.JOIN;

public class ChatClient {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userCommand;
        while (RegexUtil.getCommand(userCommand = scanner.nextLine()) != JOIN) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
        try (Socket socket = new Socket("localhost", PORT);
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
