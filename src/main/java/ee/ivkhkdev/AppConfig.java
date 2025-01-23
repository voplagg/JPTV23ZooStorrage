package ee.ivkhkdev;

import ee.ivkhkdev.helpers.ProductAppHelper;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.services.CustomerService;
import ee.ivkhkdev.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public ConsoleInput consoleInput() {
        return new ConsoleInput(); // Создаем и возвращаем ConsoleInput
    }

    @Bean
    public ProductAppHelper productAppHelper(ConsoleInput input) {
        return new ProductAppHelper(input);  // Передаем зависимость
    }

    @Bean
    public ProductService productService(ProductAppHelper productAppHelper) {
        return new ProductService(productAppHelper, new ArrayList<>());  // Передаем ProductAppHelper и пустой список продуктов
    }

    @Bean
    public CustomerService customerService(ConsoleInput input) {
        return new CustomerService(input);  // Передаем зависимость ConsoleInput в CustomerService
    }
}

