package ee.ivkhkdev.model;

import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Customer customer;
    private Product product;
    private Order order;

    @BeforeEach
    void setUp() {
        // Создаем тестовые объекты Customer и Product
        customer = new Customer("Иван", "Иванов", "123456789", "ID123");
        product = new Product("Товар", 100.0, 10);
        order = new Order(customer, product, LocalDate.now(), 2);
    }

    @Test
    void testConstructorAndGetters() {
        // Проверяем правильность работы конструктора и геттеров
        assertEquals(customer, order.getCustomer());
        assertEquals(product, order.getProduct());
        assertEquals(LocalDate.now(), order.getSaleDate());
        assertEquals(2, order.getQuantity());
    }

    @Test
    void testSetters() {
        // Проверяем правильность работы сеттеров
        Customer newCustomer = new Customer("Петр", "Петров", "987654321", "ID456");
        Product newProduct = new Product("Новый товар", 200.0, 5);

        order.setCustomer(newCustomer);
        order.setProduct(newProduct);
        order.setSaleDate(LocalDate.of(2025, 1, 1));
        order.setQuantity(3);

        assertEquals(newCustomer, order.getCustomer());
        assertEquals(newProduct, order.getProduct());
        assertEquals(LocalDate.of(2025, 1, 1), order.getSaleDate());
        assertEquals(3, order.getQuantity());
    }

    @Test
    void testEqualsAndHashCode() {
        // Проверка метода equals()
        Order order1 = new Order(customer, product, LocalDate.now(), 2);
        Order order2 = new Order(customer, product, LocalDate.now(), 2);

        assertEquals(order1, order2); // order1 и order2 должны быть равны
        assertEquals(order1.hashCode(), order2.hashCode()); // hashCode для одинаковых объектов должен быть одинаковым

        // Изменим количество и проверим, что объекты больше не равны
        order2.setQuantity(3);
        assertNotEquals(order1, order2);
    }

    @Test
    void testToString() {
        // Проверка метода toString()
        String expectedString = "Order{" +
                "customer=" + customer +
                ", product=" + product +
                ", saleDate=" + order.getSaleDate() +
                ", quantity=" + 2 +
                '}';

        assertEquals(expectedString, order.toString());
    }

    @Test
    void testDefaultConstructor() {
        // Тестируем пустой конструктор
        Order defaultOrder = new Order();
        assertNull(defaultOrder.getCustomer());
        assertNull(defaultOrder.getProduct());
        assertNull(defaultOrder.getSaleDate());
        assertEquals(0, defaultOrder.getQuantity());
    }
}
