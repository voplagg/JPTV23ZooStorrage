package ee.ivkhkdev.model;

public class Customer {
    private String name;
    private String surname;
    private String phone;
    private String ID;

    // Пустой конструктор
    public Customer() {
    }

    // Конструктор с параметрами
    public Customer(String name, String surname, String phone, String ID) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.ID = ID;
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

    @Override
    public String toString() {
        return "Покупатель: " + name + ", Фамилия: " + surname + ", Телефон: " + phone + ", ID: " + ID;
    }

    public void addSpentPrice(double totalPrice) {
    }

    public double getSpentPrice() {
        return 0;
    }

    public void setBalance(double remainingBalance) {

    }

    public double getBalance() {
        return 0;
    }

    public void setSpentPrice(double updatedSpentAmount) {

    }

    public void addBalance(double amount) {
    }
}



