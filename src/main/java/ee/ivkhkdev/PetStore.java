package ee.ivkhkdev;

import java.util.ArrayList;
import java.util.List;

public class PetStore {
    private List<Product> products; //список продуктов
    private static List<Customer> customers; //список клиентов
    private List<Order> orders; //список заказов

    public PetStore() { //конструтор инициализирует пустые списки
        products = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product); //Этот метод добавляет продукт в список продуктов магазина.
    }

    public Product findProductByNumber(int number) {
        if (number < 1 || number > products.size()) { //Метод ищет продукт по номеру. Номера продуктов начинаются с 1
            return null;
        }
        return products.get(number - 1); // Индексация с 1
    }

    public void showProductsWithNumbers() { //Этот метод выводит все продукты в магазине с их номерами (индексация с 1).
        // Он перебирает все элементы списка products и выводит их в виде: номер продукта и его строковое представление.
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    public static void addCustomer(Customer customer) { //Этот метод добавляет клиента в список customers
        customers.add(customer);
    }

    public void addOrder(Order order) {
        orders.add(order);
    } //Метод добавляет заказ в список заказов.

    // Оборот магазина
    public double calculateTotalTurnover() {
        return orders.stream().mapToDouble(Order::getTotalAmount).sum();
    } //Этот метод вычисляет общий оборот магазина, суммируя общие суммы всех заказов.

    // Рейтинг товаров
    public void showProductSalesRating() {
        products.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getSoldQuantity(), p1.getSoldQuantity()))
                .forEach(product -> System.out.println(product)); //Этот метод выводит список продуктов, отсортированных по количеству проданных единиц (от большего к меньшему).
    }

    public List<Product> getProducts() {
        return products; //Этот метод возвращает список всех продуктов магазина.
    }
}