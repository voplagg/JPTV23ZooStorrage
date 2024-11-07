package Tests;

import ee.ivkhkdev.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product product;

    // Метод, который выполняется перед каждым тестом
    @BeforeEach
    public void setUp() {
        product = new Product("Корм для собак", 10.0, 100);  // Инициализация перед каждым тестом
    }

    @Test
    public void testGetName() {
        assertEquals("Корм для собак", product.getName(), "Название продукта должно быть 'Корм для собак'");
    }

    @Test
    public void testGetPrice() {
        assertEquals(10.0, product.getPrice(), 0.01, "Цена продукта должна быть 10.0");
    }

    @Test
    public void testSetDiscount() {
        // Применяем скидку
        product.setDiscount(20);

        // Проверяем, что цена изменилась на 20% меньше
        assertEquals(8.0, product.getPrice(), 0.01, "Цена продукта после скидки должна быть 8.0");
    }

    @Test
    public void testProductToString() {
        // Проверяем корректность метода toString
        String expected = "Продукт: Корм для собак, Цена: 10.0$, Количество: 100, Продано: 0";
        assertEquals(expected, product.toString(), "Метод toString() должен возвращать корректную строку");
    }

    public void runTests() {
    }
}

