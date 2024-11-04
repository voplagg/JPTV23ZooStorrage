package Magazin;

public class Product {
    private String name; // Название продукта
    private double price; // Цена продукта
    private int quantity; // Количество на складе
    private double discount; // скидка в процентах

    // Конструктор класса Product
    public Product(String name, double price, int quantity) {
        this.name = name; // Инициализация названия продукта
        this.price = price; // Инициализация цены продукта
        this.quantity = quantity; // Инициализация количества продукта
        this.discount = 0.0; // По умолчанию скидка 0%
    }

    // Метод для получения названия продукта
    public String getName() {
        return name;
    } // Возврат названия продукта

    // Метод для получения цены продукта с учётом скидки
    public double getPrice() {
        return price * (1 - discount / 100); // Цена с учетом скидки
    }

    // Метод для получения количества продукта
    public int getQuantity() {
        return quantity;
    } // Возврат количества продукта

    // Метод для установки количества продукта
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } // Установка нового количества продукта

    // Метод для установки скидки
    public void setDiscount(double discount) {
        this.discount = discount;
    } // Установка новой скидки

    // Переопределение метода toString для отображения информации о продукте
    @Override
    public String toString() {
        return name + " - " + getPrice() + "$ в наличии: " + quantity;
    } // Форматированный вывод информации о продукте
}

