package ee.ivkhkdev;

import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.services.CustomerService;
import ee.ivkhkdev.services.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JPTV23ZooStorrage {
    public static void main(String[] args) {
        // Создаём контекст Spring для инъекции зависимостей
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Получаем необходимые сервисы из Spring контекста
        ProductService productService = context.getBean(ProductService.class);
        Service<Customer> customerService = context.getBean(CustomerService.class);
        Input input = context.getBean(ConsoleInput.class);

        // Создаём и запускаем приложение
        App app = new App(input, (Service<Product>) productService, customerService);
        app.run();
    }
}
