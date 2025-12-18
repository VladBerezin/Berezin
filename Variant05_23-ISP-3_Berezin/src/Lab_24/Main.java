package Lab_24;

import Lab_19.Transaction;

import java.io.*;
public class Main {
    public static <Transaction> void main(String[] args) {
        System.out.println("Десериализация объекта из файла transaction.ser");
        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("transaction.ser"))) {
            Transaction restoredTransaction = (Transaction) ois.readObject();
            System.out.println("Объект успешно восстановлен:");
            System.out.println("Восстановленный объект: " + restoredTransaction);


            // Проверка transient поля
            System.out.println("Примечание: transient поле 'secretCode' не сохранилось при сериализации");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден: " + e.getMessage());}
        System.out.println("\nАнализ результата:");
        System.out.println("1. Объект восстановлен без вызова конструктора");
        System.out.println("2. transient-поля инициализируются значениями по умолчанию");
        System.out.println("3. Состояние объекта (id, amount) сохранено");}}
