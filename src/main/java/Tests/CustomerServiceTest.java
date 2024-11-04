package Tests;

import Magazin.CustomerManager;
import Magazin.PetStore;
import Service.CustomerService;

public class CustomerServiceTest {
    public void runTests() {
        System.out.println("Тестирование класса CustomerService");

        PetStore store = new PetStore();
        CustomerManager manager = new CustomerManager();
        CustomerService customerService = new CustomerService(manager);

        customerService.addCustomer("Иван Иванов", "1234567890");
        assertEquals(1, customerService.getAllCustomers().size());
    }

    private void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            System.out.println("Ошибка: ожидалось " + expected + ", но получено " + actual);
        } else {
            System.out.println("Тест пройден: " + expected);
        }
    }
}

