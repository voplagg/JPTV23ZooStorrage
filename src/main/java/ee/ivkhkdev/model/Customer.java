package ee.ivkhkdev.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity // Аннотация для указания на сущность в JPA
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация ID при вставке
    private Long id; // Идентификатор клиента в базе данных

    private String name; // Имя клиента
    private String surname; // Фамилия клиента
    private String phone; // Телефон клиента
    private String customerId; // Внешний идентификатор клиента (может быть использован, например, для уникального номера)

    private double balance; // Баланс клиента
    private double spentPrice; // Потраченная сумма

    // Пустой конструктор для JPA
    public Customer() {
    }

    // Конструктор с параметрами для удобства создания объектов
    public Customer(String name, String surname, String phone, String customerId) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.customerId = customerId;
        this.balance = 0.0; // Инициализация баланса 0
        this.spentPrice = 0.0; // Инициализация потраченной суммы 0
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    // Метод для отображения информации о клиенте
    @Override
    public String toString() {
        return "Покупатель: " + name + ", Фамилия: " + surname + ", Телефон: " + phone + ", ID: " + customerId + ", Баланс: " + balance + ", Потраченная сумма: " + spentPrice;
    }

    // Метод для увеличения баланса клиента
    public void addBalance(double amount) {
        if (amount > 0) {
            this.balance += amount; // Увеличиваем баланс на указанную сумму
        }
    }

    // Метод для получения текущего баланса
    public double getBalance() {
        return balance;
    }

    // Метод для увеличения потраченной суммы
    public void addSpentPrice(double totalPrice) {
        if (totalPrice > 0) {
            this.spentPrice += totalPrice; // Увеличиваем потраченную сумму
        }
    }

    // Геттер для потраченной суммы
    public double getSpentPrice() {
        return spentPrice;
    }

    // Метод для обновления потраченной суммы
    public void setSpentPrice(double updatedSpentAmount) {
        if (updatedSpentAmount >= 0) {
            this.spentPrice = updatedSpentAmount; // Обновляем потраченную сумму
        }
    }

    // Метод для обновления баланса
    public void setBalance(double updatedBalance) {
        if (updatedBalance >= 0) {
            this.balance = updatedBalance; // Обновляем баланс
        }
    }
}




