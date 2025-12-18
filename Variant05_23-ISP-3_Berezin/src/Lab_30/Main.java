package Lab_30;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Сетевые интерфейсы и их адреса:");
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println("\nИнтерфейс: " + ni.getDisplayName());
            Enumeration<InetAddress> addresses = ni.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                System.out.println("  IP: " + addr.getHostAddress() +
                        " (DHCP или статический)");}}
        System.out.println("\nПримечание: DHCP обычно настраивается на уровне ОС,");
        System.out.println("а не в Java-приложении. Java получает уже настроенные интерфейсы.");}}
