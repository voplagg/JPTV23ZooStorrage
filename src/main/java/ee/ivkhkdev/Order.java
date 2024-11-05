package ee.ivkhkdev;

import ee.ivkhkdev.Customer;
import ee.ivkhkdev.Product;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Customer customer;
    private Map<Product, Integer> products;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        if (quantity > 0 && product.getQuantity() >= quantity) {
            products.put(product, quantity);
            product.increaseSoldQuantity(quantity); // Увеличиваем количество проданных товаров
            product.setQuantity(product.getQuantity() - quantity); // Уменьшаем количество товара на складе
        }
    }

    public double getTotalAmount() {
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public void displayPurchasedItems() {
        if (products.isEmpty()) {
            System.out.println("Нет товаров в заказе.");
        } else {
            products.forEach((product, quantity) -> {
                System.out.println(product.getName() + " x" + quantity + " = " + product.getPrice() * quantity + "$");
            });
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}