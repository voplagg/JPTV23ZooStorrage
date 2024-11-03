package Magazin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Product> products; // Список товаров
    private List<Integer> quantities; // Список количеств товаров
    private BigDecimal totalAmount;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>(); // Инициализация списка количеств
        this.totalAmount = BigDecimal.ZERO; // Инициализация суммы заказа
    }

    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            BigDecimal productTotal = BigDecimal.valueOf(product.getPrice()).multiply(BigDecimal.valueOf(quantity));
            totalAmount = totalAmount.add(productTotal).setScale(2, RoundingMode.HALF_UP); // Округление до сотых

            // Добавляем продукт и количество в соответствующие списки
            products.add(product);
            quantities.add(quantity);
        } else {
            System.out.println("Недостаточное количество товара: " + product.getName());
        }
    }

    public String getTotalAmount() {
        return totalAmount.setScale(2, RoundingMode.HALF_UP).toString(); // Возвращаем сумму как строку с двумя знаками
    }

    public void displayPurchasedItems() {
        System.out.println("Купленные товары:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            int quantity = quantities.get(i);
            System.out.println(product.getName() + " (Количество: " + quantity + ")");
        }
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}






