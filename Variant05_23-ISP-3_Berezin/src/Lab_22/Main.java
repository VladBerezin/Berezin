package Lab_22;

import Lab_19.Transaction;

class InvalidTransactionException extends Exception {
    private double amount;
    public InvalidTransactionException(double amount, String message) {
        super(message);
        this.amount = amount;}
    public double getAmount() {
        return amount;}
    @Override
    public String getMessage() {
        return super.getMessage() + " (сумма: " + amount + ")";}}
class TransactionValidator {
    public static void validateTransaction(double amount) throws InvalidTransactionException {
        if (amount <= 0) {
            throw new InvalidTransactionException(amount, "Сумма транзакции должна быть положительной");}



        if (amount > 1000000) {
            throw new InvalidTransactionException(amount, "Сумма транзакции превышает лимит");}
        if (amount % 1 != 0) {
            throw new InvalidTransactionException(amount, "Сумма должна быть целым числом");}}}
public class Main {
    public static void main(String[] args) {
        double[] testAmounts = {-100, 1500000, 1000.5, 5000};
        for (double amount : testAmounts) {
            System.out.println("\nПроверка суммы: " + amount);
            try {
                TransactionValidator.validateTransaction(amount);
                System.out.println("Транзакция валидна");
                Transaction t = new Transaction("T" + System.currentTimeMillis(), amount);
                System.out.println("Создана: " + t);
            } catch (InvalidTransactionException e) {
                System.out.println("Ошибка: " + e.getMessage());}}}}
