package Lab_10;

class CardPayment extends OnlinePayment {
    private String cardNumber;

    public CardPayment(double sum, String currency, String cardNumber) {
        super(sum, "Карта", currency);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment() {
        status = "Оплачено картой " + cardNumber;
        System.out.println("Платёж обработан: " + status);
    }
}

class PayPalPayment extends OnlinePayment {
    private String email;

    public PayPalPayment(double sum, String currency, String email) {
        super(sum, "PayPal", currency);
        this.email = email;
    }

    @Override
    public void processPayment() {
        status = "Оплачено через PayPal: " + email;
        System.out.println("Платёж обработан: " + status);
    }
}

public class Main {
    public static void main(String[] args) {

        CardPayment p1 = new CardPayment(1000, "RUB", "1234-5678-9012-3456");
        PayPalPayment p2 = new PayPalPayment(500, "USD", "example@mail.com");

        p1.printInfo();
        p2.printInfo();

        System.out.println("Комиссия p1: " + p1.calculateCommission());
        System.out.println("Комиссия p2: " + p2.calculateCommission());

        p1.processPayment();
        p2.processPayment();

        System.out.println("Всего платежей: " + Payment.getPaymentCount());
    }
}
abstract class OnlinePayment extends Payment {
    protected String currency;

    public OnlinePayment(double sum, String type, String currency) {
        super(sum, type);
        this.currency = currency;
    }

    @Override
    public double calculateCommission() {
        return sum * 0.02; // 2% комиссия по умолчанию
    }

    public abstract void processPayment(); // оставляем для наследников
}
abstract class Payment {
    protected int id;



    protected double sum;
    protected String type;
    protected String status;

    protected static int counter = 0; // подсчёт платежей

    public Payment(double sum, String type) {
        this.sum = sum;
        this.type = type;
        this.status = "Новый";
        counter++;
        this.id = counter;
    }

    public void printInfo() {
        System.out.println("Платёж #" + id + ", сумма: " + sum + ", тип: " + type + ", статус: " + status);
    }

    public static int getPaymentCount() {
        return counter;
    }

    public abstract double calculateCommission(); // абстрактный метод
}
