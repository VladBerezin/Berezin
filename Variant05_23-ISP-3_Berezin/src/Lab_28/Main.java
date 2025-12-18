package Lab_28;

import java.net.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/get");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        System.out.println("HTTP запрос:");
        System.out.println("Метод: " + conn.getRequestMethod());
        System.out.println("Код ответа: " + conn.getResponseCode());
        System.out.println("Сообщение: " + conn.getResponseMessage());
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        System.out.println("\nТело ответа:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);}
        reader.close();}}