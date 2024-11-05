package Magazin;

import ee.ivkhkdev.Product;

public class PurchasedItem {
    private Product product; // Продукт
    private int quantity; // Количество продукта

    // Конструктор класса PurchasedItem
    public PurchasedItem(Product product, int quantity) {
        this.product = product; // Инициализация продукта
        this.quantity = quantity; // Инициализация количества
    }

    // Метод для получения продукта
    public Product getProduct() {
        return product;
    } // Возврат продукта

    // Метод для получения количества
    public int getQuantity() {
        return quantity;
    } // Возврат количества

    // Переопределение метода toString для отображения информации о купленном товаре
    @Override
    public String toString() {
        return product.getName() + " (Количество: " + quantity + ")";
    } // Форматированный вывод информации о товаре
}
