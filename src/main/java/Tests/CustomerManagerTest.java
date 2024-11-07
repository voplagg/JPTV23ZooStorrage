package Tests;

import ee.ivkhkdev.Customer;
import ee.ivkhkdev.CustomerManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerManagerTest {

    private CustomerManager customerManager;

    @BeforeEach
    public void setUp() {
        // Инициализация перед каждым тестом
        customerManager = new CustomerManager();
    }

    @Test
    public void testAddCustomer() {
        // Создаем клиента
        Customer customer = new Customer("Иван Иванов", "1234567890");

        // Добавляем клиента в менеджер
        customerManager.addCustomer(customer);

        // Проверяем, что клиент добавлен в список
        assertEquals(1, customerManager.getCustomers().size(), "Размер списка клиентов должен быть 1");

        // Проверяем, что клиент действительно добавлен
        Customer addedCustomer = customerManager.getCustomers().get(0);
        assertEquals("Иван Иванов", addedCustomer.getName(), "Имя клиента должно быть 'Иван Иванов'");
        assertEquals("1234567890", addedCustomer.getPhone(), "Телефон клиента должен быть '1234567890'");
    }

    @Test
    public void testFindCustomerByPhone() {
        // Создаем клиента и добавляем в менеджер
        Customer customer = new Customer("Иван Иванов", "1234567890");
        customerManager.addCustomer(customer);

        // Ищем клиента по телефону
        Customer foundCustomer = customerManager.findCustomerByPhone("1234567890");

        // Проверяем, что клиент найден
        assertNotNull(foundCustomer, "Клиент с таким номером телефона должен быть найден");
        assertEquals("Иван Иванов", foundCustomer.getName(), "Имя найденного клиента должно быть 'Иван Иванов'");
    }

    public void runTests() {
    }
}
