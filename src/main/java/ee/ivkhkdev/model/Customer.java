package ee.ivkhkdev.model;

public class Customer {
    private String name;
    private String surname;
    private String phone;
    private String ID;
    private double balance;  // Поле для хранения баланса покупателя
    private double spentPrice;  // Поле для хранения потраченной суммы

    // Пустой конструктор
    public Customer() {
    }

    // Конструктор с параметрами
    public Customer(String name, String surname, String phone, String ID) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.ID = ID;
        this.balance = 0.0; // Инициализация с нулевым балансом
        this.spentPrice = 0.0; // Инициализация с нулевым расходом
    }

    // Геттеры и сеттеры для всех полей
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    // Метод toString для отображения информации о покупателе
    @Override
    public String toString() {
        return "Покупатель: " + name + ", Фамилия: " + surname + ", Телефон: " + phone + ", ID: " + ID + ", Баланс: " + balance + ", Потраченная сумма: " + spentPrice;
    }

    // Метод для добавления баланса
    public void addBalance(double amount) {
        if (amount > 0) {
            this.balance += amount; // Увеличиваем баланс покупателя
        }
    }

    // Геттер для баланса
    public double getBalance() {
        return balance;
    }

    // Метод для добавления потраченной суммы
    public void addSpentPrice(double totalPrice) {
        if (totalPrice > 0) {
            this.spentPrice += totalPrice; // Увеличиваем потраченную сумму
        }
    }

    // Геттер для потраченной суммы
    public double getSpentPrice() {
        return spentPrice;
    }

    // Метод для изменения потраченной суммы
    public void setSpentPrice(double updatedSpentAmount) {
        if (updatedSpentAmount >= 0) {
            this.spentPrice = updatedSpentAmount; // Обновляем потраченную сумму
        }
    }

    // Метод для изменения баланса (например, при списании средств)
    public void setBalance(double updatedBalance) {
        if (updatedBalance >= 0) {
            this.balance = updatedBalance; // Обновляем баланс
        }
    }
}



