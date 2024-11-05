package Helpers;


import ee.ivkhkdev.Customer;
import ee.ivkhkdev.CustomerManager;

public class CustomerHelper {
    private CustomerManager customerManager; // Менеджер клиентов, который будет использоваться в классе

    // Конструктор класса
    public CustomerHelper(CustomerManager customerManager) {
        this.customerManager = customerManager; // Инициализация менеджера клиентов
    }

    // Метод для добавления клиента
    public void addCustomer(String name, String phone) {
        Customer customer = new Customer(name, phone); // Создание нового клиента
        customerManager.addCustomer(customer); // Добавление клиента в менеджер
    }

    // Метод для поиска клиента по имени
    public Customer findCustomerByName(String name) {
        return customerManager.getCustomerByName(name); // Возврат клиента, найденного по имени
    }
}

