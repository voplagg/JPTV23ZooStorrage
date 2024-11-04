package Helpers;

import Magazin.PetStore;
import Magazin.Product;

public class ProductHelper {
    private PetStore store; // Экземпляр магазина

    // Конструктор класса
    public ProductHelper(PetStore store) {
        this.store = store; // Инициализация магазина
    }

    // Метод для добавления продукта
    public void addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price, quantity); // Создание нового продукта
        store.addProduct(product); // Добавление продукта в магазин
    }

    // Метод для отображения продуктов
    public void displayProducts() {
        store.showProductsWithNumbers(); // Вывод списка продуктов с номерами
    }
    // Метод для поиска продукта по номеру
    public Product findProductByNumber(int productNumber) {
        return store.findProductByNumber(productNumber); // Возврат продукта по номеру
    }
}

