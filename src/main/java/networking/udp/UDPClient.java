package networking.udp;

import java.net.*;
import java.io.*;

public class UDPClient {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket socket = new DatagramSocket();

        // вводим сообщение
        InetAddress address = InetAddress.getByName("localhost");
        System.out.print("Введите сообщение: ");
        String msg = in.readLine();

        // отправляем сообщение
        byte[] data = msg.getBytes();
        DatagramPacket request = new DatagramPacket(data, data.length, address, 12345);
        socket.send(request);

        // получаем ответ
        byte[] buffer = new byte[1024];
        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
        socket.receive(response);
        String time = new String(buffer, 0, response.getLength());

        System.out.println("Server response: " + time);

        socket.close();
    }
}