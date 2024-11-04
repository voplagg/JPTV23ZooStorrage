package Tests;

import Magazin.Customer;
import Magazin.Order;
import Magazin.Product;

public class OrderTest {
    public void runTests() {
        System.out.println("Тестирование класса Order");

        Customer customer = new Customer("Иван Иванов", "1234567890");
        Order order = new Order(customer);
        Product product = new Product("Корм для собак", 10.0, 100);

        order.addProduct(product, 2);
        System.out.println("Сумма заказа: " + order.getTotalAmount());
        System.out.println(order);
    }
}

