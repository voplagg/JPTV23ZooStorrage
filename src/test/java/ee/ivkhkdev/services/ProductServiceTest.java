package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    private ProductService productService;
    private AppHelper<Product> mockProductAppHelper;

    @BeforeEach
    void setUp() {
        // Мокаем зависимость AppHelper
        mockProductAppHelper = Mockito.mock(AppHelper.class);

        // Инициализация ProductService с замокированным AppHelper
        productService = new ProductService(mockProductAppHelper);
    }

    @Test
    void testAddProduct_Success() {
        // Создаем фиктивный продукт
        Product mockProduct = new Product("Product1", 100.0, 1);

        // Устанавливаем мок для метода create() из AppHelper
        Mockito.when(mockProductAppHelper.create()).thenReturn(mockProduct);

        // Проверяем, что продукт добавляется успешно
        assertTrue(productService.add());

        // Проверяем, что в списке товаров есть добавленный продукт
        List<Product> products = productService.list();
        assertEquals(1, products.size());
        assertEquals(mockProduct, products.get(0));
    }

    @Test
    void testAddProduct_Failure() {
        // Устанавливаем мок, чтобы метод create() возвращал null
        Mockito.when(mockProductAppHelper.create()).thenReturn(null);

        // Проверяем, что при неудачном создании продукта метод add возвращает false
        assertFalse(productService.add());

        // Проверяем, что список товаров остается пустым
        List<Product> products = productService.list();
        assertTrue(products.isEmpty());
    }

    @Test
    void testPrint_EmptyList() {
        // Проверяем, что метод print возвращает false, если список товаров пуст
        assertFalse(productService.print());
    }

    @Test
    void testPrint_NotEmptyList() {
        // Создаем фиктивный продукт
        Product mockProduct = new Product("Product1", 100.0, 1);

        // Устанавливаем мок для метода create() из AppHelper
        Mockito.when(mockProductAppHelper.create()).thenReturn(mockProduct);

        // Добавляем продукт в сервис
        productService.add();

        // Проверяем, что метод print выводит товары и возвращает true
        assertTrue(productService.print());
    }
}

