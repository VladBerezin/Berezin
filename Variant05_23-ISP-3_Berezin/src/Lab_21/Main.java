package Lab_21;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, NullPointerException {
        Scanner scanner = new Scanner(System.in);
        // 1. Обработка деления на ноль
        try {
            System.out.print("Введите два числа для деления: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int result = a / b;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль!");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введите целые числа!");
            scanner.nextLine(); // Очистка буфера}
            // 2. Обработка выхода за границы массива
            int[] array = {1, 2, 3, 4, 5};


            System.out.print("Введите индекс элемента (0-4): ");
            int index = scanner.nextInt();
            System.out.println("Элемент: " + array[index]);
            // 3. Обработка null-указателя
            String text = null;
            System.out.println("Длина строки: " + text.length());
            scanner.close();
            System.out.println("Программа завершена");}}}