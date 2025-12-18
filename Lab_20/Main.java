package Lab_20;

import java.io.*;
public class Main {
    public static void main(String[] args) {
        File file = new File("transactions_data/transactions.txt");
        if (!file.exists()) {
            System.out.println("Файл не найден: " + file.getAbsolutePath());
            return;}
        System.out.println("Чтение файла: " + file.getAbsolutePath());
        System.out.println("Размер файла: " + file.length() + " байт");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("Строка " + lineNumber + ": " + line);
                lineNumber++;}



            System.out.println("Чтение файла выполнено. Всего строк: " + (lineNumber - 1));
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());}}}
