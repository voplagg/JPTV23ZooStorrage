package ee.ivkhkdev.services;

import ee.ivkhkdev.ProductDAO;
import ee.ivkhkdev.helpers.ProductAppHelper;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.interfaces.Service;

import java.util.List;

public class ProductService implements Service<Product> {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public boolean add() {
        // Пример добавления продукта
        Product product = new Product("Laptop", 1000.0, 10); // Создаём новый продукт
        productDAO.saveProduct(product);  // Сохраняем в базе данных
        return true;
    }

    @Override
    public boolean print() {
        List<Product> products = productDAO.getAllProducts(); // Получаем все продукты из базы данных
        if (products.isEmpty()) {
            System.out.println("Список товаров пуст.");
            return false;
        }
        // Печать всех товаров
        products.forEach(System.out::println);
        return true;
    }

    @Override
    public boolean edit() {
        // Логика редактирования товара
        return false;
    }

    @Override
    public boolean remove() {
        // Логика удаления товара
        return false;
    }

    @Override
    public List<Product> list() {
        return productDAO.getAllProducts();
    }

    @Override
    public List<Product> SortedCustomer() {
        return List.of();
    }
}




