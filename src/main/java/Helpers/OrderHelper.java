package Helpers;


import Magazin.Customer;
import Magazin.Order;
import Magazin.PetStore;
import Magazin.Product;

public class OrderHelper {
    private PetStore store;

    public OrderHelper(PetStore store) {
        this.store = store;
    }

    public Order createOrder(Customer customer) {
        return new Order(customer);
    }

    public void addProductToOrder(Order order, Product product, int quantity) {
        order.addProduct(product, quantity);
    }

    public double calculateTotal(Order order) {
        return order.getTotalAmount();
    }

    public void saveOrder(Order order) {
        store.addOrder(order);
    }
}
