package Lab_19;

import java.io.*;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) {
        LinkedList<Transaction> transactions = new LinkedList<>();
        transactions.add(new Transaction("T001", 1000));
        transactions.add(new Transaction("T002", 2000));
        transactions.add(new Transaction("T003", 3000));
        File dir = new File("transactions_data");
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Директория создана: " + dir.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать директорию");
                return;}}
        File file = new File(dir, "transactions.txt");


        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Transaction t : transactions) {
                writer.println(t.toString());}
            System.out.println("Запись в файл выполнена успешно");
            System.out.println("Файл создан: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());}}}
