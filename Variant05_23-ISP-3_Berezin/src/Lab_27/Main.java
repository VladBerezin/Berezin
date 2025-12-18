package Lab_27;

import java.net.*;
public class Main {
    public static void main(String[] args) throws SocketException {
        // UDP сокет не требует установки соединения
        DatagramSocket udpSocket = new DatagramSocket();
        System.out.println("UDP сокет создан без установки соединения");
        // Отправка датаграммы
        try {
            String message = "Hello UDP";
            byte[] buffer = message.getBytes();
            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 12345);
            udpSocket.send(packet);
            System.out.println("Датаграмма отправлена без гарантий доставки");
        } catch (Exception e) {
            e.printStackTrace();}
        udpSocket.close();}}
