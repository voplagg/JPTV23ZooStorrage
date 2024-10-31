package Magazin;

import java.util.ArrayList;
import java.util.List;

public class PetStore {
    private List<Product> products; // Список продуктов
    protected static List<Customer> customers; // Список клиентов
    protected static List<Order> orders; // Список заказов

    public PetStore() {
        products = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    // Метод для отображения продуктов с их номерами
    public void showProductsWithNumbers() {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - " + product.getPrice() + "$ (В наличии: " + product.getQuantity() + ")");
        }
    }

    // Метод для поиска продукта по номеру
    public Product findProductByNumber(int productNumber) {
        if (productNumber < 1 || productNumber > products.size()) {
            return null; // Если номер вне диапазона, возвращаем null
        }
        return products.get(productNumber - 1); // Возвращаем продукт по индексу
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static List<Order> getOrders() {
        return orders;
    }
}

