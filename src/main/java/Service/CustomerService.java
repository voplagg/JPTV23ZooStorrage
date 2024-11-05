package Service;


import ee.ivkhkdev.Customer;
import ee.ivkhkdev.CustomerManager;
import ee.ivkhkdev.Order;
import ee.ivkhkdev.PetStore;

import java.util.List;

public class CustomerService {
    private CustomerManager customerManager;  // Менеджер клиентов

    // Конструктор класса CustomerService
    public CustomerService(CustomerManager customerManager) {
        this.customerManager = customerManager; // Инициализация менеджера клиентов
    }

    // Метод для добавления нового клиента
    public void addCustomer(String name, String phone) {
        Customer customer = new Customer(name, phone); // Создание нового клиента
        customerManager.addCustomer(customer); // Добавление клиента в CustomerManager
        PetStore.addCustomer(customer); // Добавление клиента в PetStore
    }

    // Метод для получения списка всех клиентов
    public List<Customer> getAllCustomers() {
        return customerManager.getCustomers(); // Возврат списка клиентов
    }

    // Метод для поиска клиента по имени
    public Customer findCustomerByName(String name) {
        return customerManager.getCustomerByName(name); // Возврат клиента по имени
    }

    // Метод для получения всех заказов клиента
    public List<Order> getOrdersByCustomer(Customer customer) {
        return customerManager.getOrdersByCustomer(customer); // Возврат списка заказов клиента
    }
}

