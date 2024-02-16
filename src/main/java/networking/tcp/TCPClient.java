package networking.tcp;

import java.net.*;
import java.io.*;

public class TCPClient {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 12345);

        // отправляем данные
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите сообщение: ");
        String msg = in.readLine();
        out.println(msg);

        // получаем ответ
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String time = input.readLine();

        System.out.println("Server response: " + time);

        socket.close();
    }
}