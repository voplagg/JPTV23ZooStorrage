package Tests;

import ee.ivkhkdev.Customer;
import ee.ivkhkdev.CustomerManager;
import Service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    private CustomerManager manager;
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        manager = new CustomerManager();
        customerService = new CustomerService(manager);
    }

    @Test
    public void testAddCustomer() {
        // Добавляем клиента
        customerService.addCustomer("Иван Иванов", "1234567890");

        // Проверяем, что клиент добавлен
        assertEquals(1, customerService.getAllCustomers().size(), "Размер списка клиентов должен быть 1");

        // Проверяем, что данные клиента корректны
        Customer addedCustomer = customerService.getAllCustomers().get(0);
        assertEquals("Иван Иванов", addedCustomer.getName(), "Имя клиента должно быть 'Иван Иванов'");
        assertEquals("1234567890", addedCustomer.getPhone(), "Телефон клиента должен быть '1234567890'");
    }

    @Test
    public void testAddMultipleCustomers() {
        // Добавляем нескольких клиентов
        customerService.addCustomer("Иван Иванов", "1234567890");
        customerService.addCustomer("Петр Петров", "0987654321");

        // Проверяем, что количество клиентов теперь 2
        assertEquals(2, customerService.getAllCustomers().size(), "Размер списка клиентов должен быть 2");
    }

    public void runTests() {
    }
}


