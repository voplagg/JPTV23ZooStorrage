package ee.ivkhkdev;

import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.helpers.ProductAppHelper;
import ee.ivkhkdev.services.CustomerService;
import ee.ivkhkdev.services.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ConsoleInput consoleInput() {
        return new ConsoleInput();
    }

    @Bean
    public ProductAppHelper productAppHelper(ConsoleInput consoleInput) {
        return new ProductAppHelper(consoleInput);
    }

    @Bean
    public ProductService productService(ProductAppHelper productAppHelper) {
        return new ProductService(productAppHelper);
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerService();
    }
}





