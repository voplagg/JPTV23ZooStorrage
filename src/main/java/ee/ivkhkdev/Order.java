package ee.ivkhkdev;

import ee.ivkhkdev.Customer;
import ee.ivkhkdev.Product;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Customer customer; // Клиент, который сделал заказ
    private Map<Product, Integer> products; // Товары и их количество в заказе

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new HashMap<>(); //Конструктор создаёт новый объект Order для указанного клиента и инициализирует пустую коллекцию товаров. Это означает, что при создании
        //заказа необходимо передать клиента, а список продуктов будет пустым, пока не добавятся товары.
    }

    public void addProduct(Product product, int quantity) { //Метод добавляет продукт в заказ с указанным количеством. Он проверяет:
        //что количество больше 0,
        //что в магазине есть достаточное количество товара.
        if (quantity > 0 && product.getQuantity() >= quantity) {
            products.put(product, quantity);
            product.increaseSoldQuantity(quantity); // Увеличиваем количество проданных товаров
            product.setQuantity(product.getQuantity() - quantity); // Уменьшаем количество товара на складе
        }
    }

    public double getTotalAmount() { //Этот метод вычисляет общую сумму заказа.
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public void displayPurchasedItems() { //Этот метод выводит информацию о товарах в заказе
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
    }//Эти методы позволяют получить и установить клиента для данного заказа.

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public <T> ClassValue<T> getProducts() {
    }
}