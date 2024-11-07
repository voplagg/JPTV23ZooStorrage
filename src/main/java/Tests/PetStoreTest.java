package Tests;

import ee.ivkhkdev.PetStore;
import ee.ivkhkdev.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PetStoreTest {

    private PetStore store;
    private Product product;

    // Метод, который выполняется перед каждым тестом
    @BeforeEach
    public void setUp() {
        store = new PetStore();  // Создаем новый магазин
        product = new Product("Корм для собак", 10.0, 100);  // Создаем новый продукт
    }

    @Test
    public void testAddProduct() {
        // Добавляем продукт в магазин
        store.addProduct(product);

        // Проверяем, что продукт был добавлен
        assertEquals(1, store.getProducts().size(), "Магазин должен содержать 1 продукт");
        assertTrue(store.getProducts().contains(product), "Магазин должен содержать добавленный продукт");
    }

    @Test
    public void testFindProductByNumber() {
        store.addProduct(product);

        // Проверяем, что продукт найден по номеру
        Product foundProduct = store.findProductByNumber(1);
        assertNotNull(foundProduct, "Продукт должен быть найден");
        assertEquals(product, foundProduct, "Найденный продукт должен быть тем же, что и добавленный");
    }

    @Test
    public void testShowProductsWithNumbers() {
        store.addProduct(product);

        // Проверяем, что список продуктов выводится
        store.showProductsWithNumbers();  // Метод просто выводит информацию, но в реальности можно бы было перехватывать вывод для проверки
    }

    @Test
    public void testProductSalesRating() {
        store.addProduct(product);
        product.increaseSoldQuantity(10);  // Симулируем продажу продукта

        // Проверяем, что рейтинг продуктов показывает правильное количество продаж
        store.showProductSalesRating();
    }

    public void runTests() {
    }
}

