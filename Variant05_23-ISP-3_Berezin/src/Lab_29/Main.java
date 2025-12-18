package Lab_29;

import java.net.InetAddress;
public class Main {
    public static void main(String[] args) throws Exception {
        String hostname = "google.com";
        System.out.println("DNS разрешение для: " + hostname);
        InetAddress[] addresses = InetAddress.getAllByName(hostname);
        for (InetAddress addr : addresses) {
            System.out.println("IP адрес: " + addr.getHostAddress());
            System.out.println("Обратное разрешение: " + addr.getHostName());}
        // Локальный кэш DNS
        System.out.println("\nЛокальный хост:");
        System.out.println("IP: " + InetAddress.getLocalHost().getHostAddress());
        System.out.println("Имя: " + InetAddress.getLocalHost().getHostName());}}


