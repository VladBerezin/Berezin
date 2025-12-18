package Lab_26;

import java.io.IOException;
import java.net.Socket;

// Пример демонстрации TCP сокета
public class Main {
    public static void main(String[] args) throws IOException {
        // TCP гарантирует доставку и порядок
        Socket tcpSocket = new Socket("example.com", 80);
        System.out.println("TCP соединение установлено: " + tcpSocket.isConnected());
        tcpSocket.close();}}