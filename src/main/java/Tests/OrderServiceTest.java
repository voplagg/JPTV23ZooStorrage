package Tests;

import Service.OrderService;
import ee.ivkhkdev.Customer;
import ee.ivkhkdev.Order;
import ee.ivkhkdev.PetStore;
import ee.ivkhkdev.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    private PetStore store;
    private OrderService orderService;
    private Customer customer;
    private Order order;
    private Product product;

    // Метод для подготовки объектов перед каждым тестом
    @BeforeEach
    public void setUp() {
        store = new PetStore();
        orderService = new OrderService(store);
        customer = new Customer("Иван Иванов", "1234567890");

        // Создаем заказ
        order = orderService.createOrder(customer);

        // Создаем продукт
        product = new Product("Корм для собак", 10.0, 100);
    }

    @Test
    public void testCreateOrder() {
        // Проверяем, что заказ был успешно создан
        assertNotNull(order, "Заказ не должен быть null");
        assertEquals(customer, order.getCustomer(), "Клиент заказа должен быть 'Иван Иванов'");
    }

    @Test
    public void testAddProductToOrder() {

    }

    @Test
    public void testOrderTotalWithMultipleProducts() {
        // Добавляем несколько продуктов в заказ
        Product product2 = new Product("Корм для кошек", 5.0, 50);
        orderService.addProductToOrder(order, product, 2);
        orderService.addProductToOrder(order, product2, 3);

        // Проверяем, что сумма заказа была правильно рассчитана
        double expectedTotal = (product.getPrice() * 2) + (product2.getPrice() * 3);
        assertEquals(expectedTotal, orderService.getOrderTotal(order), "Сумма заказа должна быть корректной");
    }

    public void runTests() {
    }
}

