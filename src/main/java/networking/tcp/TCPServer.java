package networking.tcp;

import java.net.*;
import java.io.*;
import java.util.Date;

public class TCPServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(12345);

        while (true) {

            // ждем подключения
            Socket client = server.accept();
            System.out.println("New client connected");

            // получаем данные
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String msg = in.readLine();

            // отправляем ответ
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println(new Date());

            System.out.println(new Date() + ": " + msg);

            client.close();
        }
    }
}