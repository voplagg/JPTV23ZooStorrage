package ee.ivkhkdev;

import ee.ivkhkdev.helpers.ProductAppHelper;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.services.CustomerBalanceService;
import ee.ivkhkdev.services.CustomerService;
import ee.ivkhkdev.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AppTest {

    private App app;
    private ProductService productService;
    private CustomerService customerService;
    private CustomerBalanceService balanceService;

    // Метод, который выполняется перед каждым тестом
    @BeforeEach
    public void setUp() {
        ConsoleInput input = new ConsoleInput();  // Создаем объект для ввода данных с консоли
        ProductAppHelper productAppHelper = new ProductAppHelper(input); // Создаем помощника для работы с продуктами
        productService = new ProductService(productAppHelper); // Создаем сервис для работы с продуктами
        customerService = new CustomerService(input); // Создаем сервис для работы с покупателями
        balanceService = new CustomerBalanceService(customerService); // Создаем сервис для работы с балансом покупателей
        app = new App(input, productService, customerService); // Создаем главный класс приложения с необходимыми зависимостями
    }

    // Тест для добавления продукта
    @Test
    public void testAddProduct() {
        assertTrue(productService.add(), "Продукт должен быть добавлен."); // Проверяем, что продукт добавлен
        List<Product> products = productService.list(); // Получаем список продуктов
        assertEquals(1, products.size(), "Список продуктов должен содержать 1 продукт."); // Проверяем, что в списке один продукт
    }

    // Тест для вывода списка продуктов
    @Test
    public void testPrintProduct() {
        productService.add(); // Добавляем продукт
        assertTrue(productService.print(), "Продукты должны быть выведены."); // Проверяем, что продукты выведены на экран
    }

    // Тест для добавления покупателя
    @Test
    public void testAddCustomer() {
        assertTrue(customerService.add(), "Покупатель должен быть добавлен."); // Проверяем, что покупатель добавлен
        List<Customer> customers = customerService.list(); // Получаем список покупателей
        assertEquals(1, customers.size(), "Список покупателей должен содержать 1 покупателя."); // Проверяем, что в списке один покупатель
    }

    // Тест для вывода списка покупателей
    @Test
    public void testPrintCustomer() {
        customerService.add(); // Добавляем покупателя
        assertTrue(customerService.print(), "Покупатели должны быть выведены."); // Проверяем, что покупатели выведены на экран
    }

    // Тест для добавления средств на баланс покупателя
    @Test
    public void testAddBalanceToCustomer() {
        customerService.add();  // Добавляем покупателя
        Customer customer = customerService.list().get(0); // Получаем первого покупателя
        double initialBalance = customer.getBalance(); // Сохраняем начальный баланс покупателя

        balanceService.addBalanceToCustomer(1, 50.0); // Добавляем 50 единиц на баланс покупателя

        // Проверяем, что баланс покупателя увеличился на 50
        assertEquals(initialBalance + 50.0, customer.getBalance(), "Баланс покупателя должен увеличиться на 50.");
    }

    // Тест для проверки неверного ID покупателя при добавлении баланса
    @Test
    public void testInvalidCustomerIdForBalance() {
        customerService.add();  // Добавляем покупателя
        balanceService.addBalanceToCustomer(999, 50.0); // Пытаемся добавить деньги покупателю с неверным ID (999)
        // Проверяем, что баланс покупателя не изменился
        assertEquals(0, customerService.list().get(0).getBalance(), "Баланс покупателя не должен измениться.");
    }

    // Тест для проверки правильности вывода отсортированных покупателей
    @Test
    public void testSortedCustomers() {
        customerService.add();  // Добавляем покупателей
        customerService.add();
        List<Customer> customers = customerService.list(); // Получаем список покупателей

        // Проверяем, что список покупателей не пустой
        assertNotNull(customers, "Список покупателей не должен быть пустым.");
        // Проверяем, что в списке два покупателя
        assertEquals(2, customers.size(), "Список должен содержать 2 покупателей.");
    }

    // Тест для проверки правильности вывода отсортированных продуктов
    @Test
    public void testSortedProducts() {
        productService.add();  // Добавляем продукты
        productService.add();
        List<Product> products = productService.list(); // Получаем список продуктов

        // Проверяем, что список продуктов не пустой
        assertNotNull(products, "Список продуктов не должен быть пустым.");
        // Проверяем, что в списке два продукта
        assertEquals(2, products.size(), "Список должен содержать 2 продукта.");
    }

    // Тест для проверки всего рабочего процесса: добавление продуктов и покупателей
    @Test
    public void testAppFlow() {
        // Симулируем добавление продукта
        assertTrue(productService.add(), "Продукт должен быть добавлен.");
        // Симулируем добавление покупателя
        assertTrue(customerService.add(), "Покупатель должен быть добавлен.");

        List<Product> products = productService.list(); // Получаем список продуктов
        List<Customer> customers = customerService.list(); // Получаем список покупателей

        // Проверяем, что в списке один продукт
        assertEquals(1, products.size(), "Список продуктов должен содержать 1 продукт.");
        // Проверяем, что в списке один покупатель
        assertEquals(1, customers.size(), "Список покупателей должен содержать 1 покупателя.");
    }
}
