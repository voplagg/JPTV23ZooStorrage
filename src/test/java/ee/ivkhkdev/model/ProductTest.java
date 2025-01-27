package ee.ivkhkdev.model;

import ee.ivkhkdev.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        // Инициализация объекта Product перед каждым тестом
        product = new Product("Товар", 100.0, 10);
    }

    @Test
    void testConstructorAndGetters() {
        // Проверяем, что объект был правильно инициализирован
        assertEquals("Товар", product.getName());
        assertEquals(100.0, product.getPrice());
        assertEquals(10, product.getQuantity());
    }

    @Test
    void testSetters() {
        // Проверяем работу сеттеров
        product.setName("Новый товар");
        product.setPrice(200.0);
        product.setQuantity(20);

        assertEquals("Новый товар", product.getName());
        assertEquals(200.0, product.getPrice());
        assertEquals(20, product.getQuantity());
    }

    @Test
    void testToString() {
        // Проверяем корректность метода toString()
        String expectedString = "Продукт: Товар, Цена: 100.0$, Количество: 10";
        assertEquals(expectedString, product.toString());
    }

    @Test
    void testDefaultConstructor() {
        // Проверяем работу пустого конструктора
        Product defaultProduct = new Product();
        defaultProduct.setName("Пустой товар");
        defaultProduct.setPrice(50.0);
        defaultProduct.setQuantity(5);

        assertEquals("Пустой товар", defaultProduct.getName());
        assertEquals(50.0, defaultProduct.getPrice());
        assertEquals(5, defaultProduct.getQuantity());
    }
}
