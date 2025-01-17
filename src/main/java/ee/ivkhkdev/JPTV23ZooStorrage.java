package ee.ivkhkdev;

import ee.ivkhkdev.ProductDAO;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.services.CustomerService;
import ee.ivkhkdev.services.ProductService;

public class JPTV23ZooStorrage {
    public static void main(String[] args) {
        Input input = new ConsoleInput();

        // Создаём DAO для работы с продуктами
        ProductDAO productDAO = new ProductDAO();

        // Используем DAO для создания сервиса для работы с продуктами
        Service<Product> productService = new ProductService(productDAO);

        // Сервис для работы с покупателями (можно оставить как есть)
        Service<Customer> customerService = new CustomerService(input);

        // Создаём и запускаем приложение
        App app = new App(input, productService, customerService);
        app.run();
    }
}
