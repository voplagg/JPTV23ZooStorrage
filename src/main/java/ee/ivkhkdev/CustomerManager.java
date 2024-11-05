package ee.ivkhkdev;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer findCustomerByPhone(String phone) {
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone)) {
                return customer;
            }
        }
        return null; // Если не найден
    }

    public void showAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("Нет зарегистрированных покупателей.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // Рейтинг покупателей по количеству покупок
    public void showCustomerRating() {
        customers.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getTotalPurchases(), c1.getTotalPurchases()))
                .forEach(customer -> System.out.println(customer));
    }

    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }

    return null;}

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
        List<Order> orders = new ArrayList<>();
        return orders;
    }
}

