package networking.udp;

import java.net.*;
import java.io.*;
import java.util.Date;

public class UDPServer {

    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(12345);

        while (true) {

            // получаем данные
            byte[] buffer = new byte[1024];
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);

            // обрабатываем данные
            String msg = new String(buffer, 0, request.getLength());
            System.out.println(new Date() + ": " + msg + " from " + request.getAddress().getHostAddress());

            // отправляем ответ
            byte[] time = (new Date().toString()).getBytes();
            DatagramPacket response = new DatagramPacket(time, time.length, request.getAddress(), request.getPort());
            socket.send(response);

            socket.close();

        }

    }
}