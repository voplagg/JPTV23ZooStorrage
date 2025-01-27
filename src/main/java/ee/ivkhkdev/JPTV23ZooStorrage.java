package ee.ivkhkdev;

import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.services.CustomerService;
import ee.ivkhkdev.services.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JPTV23ZooStorrage {
    public static void main(String[] args) {
        // Создаем контекст Spring для инъекции зависимостей
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Получаем необходимые сервисы из Spring контекста
        ProductService productService = context.getBean(ProductService.class); // Получаем сервис для продуктов
        CustomerService customerService = context.getBean(CustomerService.class); // Получаем сервис для клиентов
        ConsoleInput input = context.getBean(ConsoleInput.class); // Получаем input для взаимодействия с пользователем

        // Создаем и запускаем приложение
        App app = new App(input, productService, customerService);
        app.run();
    }
}
