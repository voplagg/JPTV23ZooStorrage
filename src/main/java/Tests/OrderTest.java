package Tests;

import ee.ivkhkdev.Customer;
import ee.ivkhkdev.Order;
import ee.ivkhkdev.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Customer customer;
    private Order order;
    private Product product;

    // Метод, который выполняется перед каждым тестом для подготовки объектов
    @BeforeEach
    public void setUp() {
        customer = new Customer("Иван Иванов", "1234567890");
        order = new Order(customer);
        product = new Product("Корм для собак", 10.0, 100);
    }

    @Test
    public void testAddProductToOrder() {
        // Добавляем продукт в заказ
        order.addProduct(product, 2);

        // Проверяем, что количество продукта в заказе увеличилось
        assertEquals(2, order.getProducts().get(product), "Количество продукта в заказе должно быть 2");

        // Проверяем, что сумма заказа правильная
        double expectedAmount = product.getPrice() * 2;
        assertEquals(expectedAmount, order.getTotalAmount(), "Сумма заказа должна быть корректной");
    }

    @Test
    public void testOrderTotalAmount() {
        // Добавляем продукт в заказ
        order.addProduct(product, 2);

        // Проверяем общую сумму
        double expectedAmount = product.getPrice() * 2;
        assertEquals(expectedAmount, order.getTotalAmount(), "Сумма заказа должна быть " + expectedAmount);
    }

    @Test
    public void testOrderToString() {
        // Добавляем продукт в заказ
        order.addProduct(product, 2);

        // Проверка корректности метода toString()
        String expectedToString = "Заказ от Иван Иванов (1234567890), Продукты: [Корм для собак x2], Общая сумма: 20.0$";
        assertEquals(expectedToString, order.toString(), "Метод toString() должен вернуть корректное строковое представление");
    }

    public void runTests() {
    }
}


