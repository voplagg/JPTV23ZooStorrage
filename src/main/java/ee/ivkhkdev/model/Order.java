package ee.ivkhkdev.model;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private Customer customer;
    private Product product;
    private LocalDate saleDate;
    private int quantity;

    public Order() {

    }

    public Order(Customer customer, Product product, LocalDate saleDate, int quantity) {
        this.customer = customer;
        this.product = product;
        this.saleDate = saleDate;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity && Objects.equals(customer, order.customer) && Objects.equals(product, order.product) && Objects.equals(saleDate, order.saleDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, product, saleDate, quantity);
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", product=" + product +
                ", saleDate=" + saleDate +
                ", quantity=" + quantity +
                '}';
    }
}
