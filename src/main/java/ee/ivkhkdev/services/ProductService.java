package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements Service<Product> {
    private final AppHelper<Product> productAppHelper;
    private final List<Product> products; // Список товаров

    public ProductService(AppHelper<Product> productAppHelper) {
        this.productAppHelper = productAppHelper;
        this.products = new ArrayList<>(); // Изначально список пуст
    }

    @Override
    public boolean add() {
        Product product = productAppHelper.create(); // Создание нового продукта через helper
        if (product != null) {
            products.add(product); // Добавляем продукт в список
            return true;
        }
        return false;
    }

    @Override
    public boolean print() {
        if (products.isEmpty()) {
            System.out.println("Список товаров пуст.");
            return false;
        }
        // Печать всех товаров в списке
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
        return products; // Возвращаем текущий список товаров
    }

    @Override
    public List<Product> SortedCustomer() {
        return List.of();
    }
}


