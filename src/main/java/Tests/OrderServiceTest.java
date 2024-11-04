package Tests;

import Magazin.Customer;
import Magazin.Order;
import Magazin.PetStore;
import Magazin.Product;
import Service.OrderService;

public class OrderServiceTest {
    public void runTests() {
        System.out.println("Тестирование класса OrderService");

        PetStore store = new PetStore();
        OrderService orderService = new OrderService(store);
        Customer customer = new Customer("Иван Иванов", "1234567890");

        Order order = orderService.createOrder(customer);
        Product product = new Product("Корм для собак", 10.0, 100);

        orderService.addProductToOrder(order, product, 2);
        System.out.println("Сумма заказа: " + orderService.getOrderTotal(order));
    }
}
