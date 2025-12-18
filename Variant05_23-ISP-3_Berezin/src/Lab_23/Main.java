package Lab_23;

import java.io.*;
class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private double amount;
    private transient String secretCode = "SECRET123"; // Не будет сериализовано
    public Transaction(String id, double amount) {
        this.id = id;
        this.amount = amount;}
    @Override
    public String toString() {
        return id + ": " + amount + " [секретный код: " + secretCode + "]";}}
public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction("T001", 1000.0);
        System.out.println("Исходный объект: " + transaction);



        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("transaction.ser"))) {
            oos.writeObject(transaction);
            System.out.println("Объект успешно сериализован в файл transaction.ser");
            System.out.println("Размер файла: " + new File("transaction.ser").length() + " байт");
        } catch (IOException e) {
            System.out.println("Ошибка при сериализации: " + e.getMessage());}}}
