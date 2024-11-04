package Magazin;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers; // Список клиентов

    // Конструктор класса
    public CustomerManager() {
        customers = new ArrayList<>();
    } // Инициализация списка клиентов

    // Метод для добавления нового клиента
    public void addCustomer(Customer customer) {
        customers.add(customer);
    } // Добавление клиента в список

    // Метод для получения списка всех клиентов
    public List<Customer> getCustomers() {
        return customers;
    } // Возврат списка клиентов

    // Метод для получения клиента по имени
    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) { // Перебор всех клиентов
            if (customer.getName().equalsIgnoreCase(name)) { // Сравнение имени без учёта регистра
                return customer; // Возврат найденного клиента
            }
        }
        return null; // Возврат null, если клиент не найден
    }

    // Метод для получения всех заказов клиента
    public List<Order> getOrdersByCustomer(Customer customer) {  // Список заказов клиента
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : PetStore.orders) { // Предположим, что заказы хранятся в PetStore
            if (order.getCustomer() != null && order.getCustomer().equals(customer)) {
                customerOrders.add(order); // Добавление заказа в список, если он принадлежит клиенту
            }
        }
        return customerOrders; // Возврат списка заказов клиента
    }
}
