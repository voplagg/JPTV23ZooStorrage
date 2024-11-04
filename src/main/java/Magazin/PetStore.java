package Magazin;

import java.util.ArrayList;
import java.util.List;

public class PetStore {
    private List<Product> products; // Список продуктов
    protected static List<Customer> customers; // Список клиентов
    protected static List<Order> orders; // Список заказов

    public PetStore() {
        products = new ArrayList<>(); // Инициализация списка продуктов
        customers = new ArrayList<>(); // Инициализация списка клиентов
        orders = new ArrayList<>();// Инициализация списка заказов
    }

    // Метод для добавления продукта в магазин
    public void addProduct(Product product) {
        products.add(product); // Добавление продукта в список
    }

    // Метод для отображения продуктов с их номерами
    public void showProductsWithNumbers() {
        for (int i = 0; i < products.size(); i++) { // Перебор всех продуктов
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - " + product.getPrice() + "$ (В наличии: " + product.getQuantity() + ")"); // Вывод информации о продукте
        }
    }

    // Метод для поиска продукта по номеру
    public Product findProductByNumber(int productNumber) {
        if (productNumber < 1 || productNumber > products.size()) { // Проверка на допустимый номер
            return null; // Если номер вне диапазона, возвращаем null
        }
        return products.get(productNumber - 1); // Возвращаем продукт по индексу
    }

    // Метод для добавления клиента
    public static void addCustomer(Customer customer) {
        customers.add(customer); // Добавление клиента в список
    }

    // Метод для добавления заказа
    public static void addOrder(Order order) {
        orders.add(order); // Добавление заказа в список
    }

    // Метод для получения списка всех заказов
    public static List<Order> getOrders() {
        return orders; // Возврат списка заказов
    }

    // Метод для получения всех продуктов
    public List<Product> getProducts() {
        return null; // Этот метод не реализован и всегда возвращает null
    }
}
