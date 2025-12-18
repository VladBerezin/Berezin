package Lab_18;

import Lab_19.Transaction;

import java.util.ArrayList;
class TransactionContainer<T> {
    private ArrayList<T> items;
    public TransactionContainer() {
        items = new ArrayList<>();}
    public TransactionContainer(T initialItem) {
        this();
        items.add(initialItem);}
    public void addItem(T item) {
        items.add(item);}
    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);}
        return null;}


    public void displayAll() {
        System.out.println("Все элементы (" + items.size() + "):");
        for (T item : items) {
            System.out.println("  " + item);}}
    public int getCount() {
        return items.size();}}
class Repository<T extends Transaction> {
    private T item;
    public Repository(T item) {
        this.item = item;}
    public T getItem() {
        return item;}
    public void processItem() {
        System.out.println("Обработка: " + item);}}
public class Main {
    public static void main(String[] args) {
        Transaction t1 = new Transaction("T001", 1000);
        Transaction t2 = new Transaction("T002", 2000);
        TransactionContainer<Transaction> container = new TransactionContainer<>(t1);
        container.addItem(t2);
        container.addItem(new Transaction("T003", 3000));
        container.displayAll();
        System.out.println("Элемент 1: " + container.getItem(0));
        System.out.println("Элемент 2: " + container.getItem(1));
        System.out.println("Всего элементов: " + container.getCount());        Repository<Transaction> repo = new Repository<>(t1);
        repo.processItem();}}