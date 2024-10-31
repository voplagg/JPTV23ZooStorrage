package Magazin;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Product> products;
    private double totalAmount;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            this.totalAmount += product.getPrice() * quantity;
            products.add(product);
        } else {
            System.out.println("Недостаточное количество товара: " + product.getName());
        }
    }

    public double getTotalAmount() {
        return totalAmount;
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
        orderDetails.append("Сумма заказа: ").append(totalAmount).append("$");
        return orderDetails.toString();
    }

    public Object getCustomer() {
        return null;
    }
}


