package Magazin;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<>();
    }

    // Метод для добавления нового клиента
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Метод для получения списка всех клиентов
    public List<Customer> getCustomers() {
        return customers;
    }

    // Метод для получения клиента по имени
    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    // Метод для получения всех заказов клиента
    public List<Order> getOrdersByCustomer(Customer customer) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : PetStore.orders) { // Предположим, что заказы хранятся в PetStore
            if (order.getCustomer() != null && order.getCustomer().equals(customer)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }
}
