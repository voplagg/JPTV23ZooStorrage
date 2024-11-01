package Magazin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Product> products;
    private BigDecimal totalAmount;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalAmount = BigDecimal.ZERO; // Инициализация суммы заказа
    }

    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            BigDecimal productTotal = BigDecimal.valueOf(product.getPrice()).multiply(BigDecimal.valueOf(quantity));
            totalAmount = totalAmount.add(productTotal).setScale(2, RoundingMode.HALF_UP); // Округление до сотых
            products.add(product);
        } else {
            System.out.println("Недостаточное количество товара: " + product.getName());
        }
    }

    public String getTotalAmount() {
        return totalAmount.setScale(2, RoundingMode.HALF_UP).toString(); // Возвращаем сумму как строку с двумя знаками
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Заказ от " + customer.getName() + "\n");
        for (Product product : products) {
            orderDetails.append(product.getName()).append(" - ").append(product.getPrice()).append("$\n");
        }
        orderDetails.append("Сумма заказа: ").append(getTotalAmount()).append("$");
        return orderDetails.toString();
    }

    public Customer getCustomer() {
        return customer;
    }
}



