package ee.ivkhkdev.model;

public class Customer {
    private String name; //имя
    private String phone; //телефон
    private double balance; // Баланс покупателя


    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.balance = 0.0; // Изначально баланс 0

    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount; // Добавление денег на баланс
    }





    @Override
    public String toString() { //вывод о покупателе
        return name + " (" + phone + "), Баланс: " + balance;
    }
}