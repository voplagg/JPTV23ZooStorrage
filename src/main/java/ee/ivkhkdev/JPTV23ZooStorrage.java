package ee.ivkhkdev;

import ee.ivkhkdev.helpers.ProductAppHelper;
import ee.ivkhkdev.input.ConsoleInput;
import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.services.CustomerService;
import ee.ivkhkdev.services.ProductService;

import java.util.Scanner;

public class JPTV23ZooStorrage {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        AppHelper<Product> productAppHelper = new ProductAppHelper(input);
        Service<Product> productService = new ProductService(productAppHelper);
        Service<Customer> customerService = new CustomerService();
        App app = new App(input, productService,customerService);
        app.run();
    }
}

