package ee.ivkhkdev;

import java.util.ArrayList;
import java.util.List;

public class PetStore {
    private List<Product> products;
    private static List<Customer> customers;
    private List<Order> orders;

    public PetStore() {
        products = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProductByNumber(int number) {
        if (number < 1 || number > products.size()) {
            return null;
        }
        return products.get(number - 1); // Индексация с 1
    }

    public void showProductsWithNumbers() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    // Оборот магазина
    public double calculateTotalTurnover() {
        return orders.stream().mapToDouble(Order::getTotalAmount).sum();
    }

    // Рейтинг товаров
    public void showProductSalesRating() {
        products.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getSoldQuantity(), p1.getSoldQuantity()))
                .forEach(product -> System.out.println(product));
    }

    public List<Product> getProducts() {
        return products;
    }
}