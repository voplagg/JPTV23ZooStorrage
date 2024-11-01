package Service;

import Magazin.Customer;
import Magazin.Order;
import Magazin.PetStore;
import Magazin.Product;

public class OrderService {
    private PetStore petStore;

    public OrderService(PetStore petStore) {
        this.petStore = petStore;
    }

    public Order createOrder(Customer customer) {
        Order order = new Order(customer);
        petStore.addOrder(order);
        return order;
    }

    public void addProductToOrder(Order order, Product product, int quantity) {
        order.addProduct(product, quantity);
    }

    public String getOrderTotal(Order order) {
        return order.getTotalAmount();
    }

    public void completeOrder(Order order) {
        // Здесь можно добавить логику завершения заказа, например, отправку уведомлений
    }
}

