package Magazin;

import ee.ivkhkdev.Product;

import java.util.ArrayList;
import java.util.List;

public class PurchasedItemsList {
    private List<PurchasedItem> purchasedItems; // Список купленных товаров

    // Конструктор класса PurchasedItemsList
    public PurchasedItemsList() {
        purchasedItems = new ArrayList<>();
    } // Инициализация списка купленных товаров

    // Метод для добавления купленного товара
    public void addPurchasedItem(Product product, int quantity) {
        purchasedItems.add(new PurchasedItem(product, quantity)); // Создание нового PurchasedItem и добавление его в список
    }

    // Метод для отображения списка купленных товаров
    public void displayPurchasedItems() {
        System.out.println("Список купленных товаров:"); // Заголовок списка
        for (PurchasedItem item : purchasedItems) { // Перебор всех купленных товаров
            System.out.println(item); // Вывод информации о каждом товаре
        }
    }
}

