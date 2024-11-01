package ee.ivkhkdev;

import Helpers.CustomerHelper;
import Helpers.OrderHelper;
import Helpers.ProductHelper;
import Magazin.Customer;
import Magazin.Order;
import Magazin.PetStore;
import Magazin.Product;
import Magazin.CustomerManager;

import java.util.Scanner;

public class App {
    private static PetStore store;
    private static CustomerManager customerManager;
    private static CustomerHelper customerHelper;
    private static ProductHelper productHelper;
    private static OrderHelper orderHelper;
    private static Scanner scanner = new Scanner(System.in);

    // Запуск приложения
    public static void run() {
        store = new PetStore();
        customerManager = new CustomerManager();
        customerHelper = new CustomerHelper(customerManager);
        productHelper = new ProductHelper(store);
        orderHelper = new OrderHelper(store);

        addTestProducts(); // Добавляем тестовые товары

        System.out.println("Добро пожаловать в наш зоомагазин!");

        // Показ товаров и начало заказа
        createOrderProcess();

        // Закрываем сканер после завершения
        scanner.close();
    }

    // Метод для добавления тестовых товаров
    private static void addTestProducts() {
        productHelper.addProduct("Корм для собак", 10.99, 23);
        productHelper.addProduct("Корм для кошек", 9.99, 20);
        productHelper.addProduct("Игрушка для кошек", 5.49, 15);
        productHelper.addProduct("Игрушка для собак", 3.49, 17);
        productHelper.addProduct("Корм для рыб", 2.99, 30);
        productHelper.addProduct("Корм для хомяков", 7.49, 15);
        productHelper.addProduct("Корм для птиц", 4.79, 11);
    }

    private static void createOrderProcess() {
        // Показ товаров в наличии
        System.out.println("\nВот что у нас есть в наличии:");
        productHelper.displayProducts();

        // Создаем заказ
        Order order = orderHelper.createOrder(null); // Клиент пока не добавлен

        // Добавляем товары в заказ
        boolean addingProducts = true;
        while (addingProducts) {
            System.out.print("\nВведите номер товара, который хотите купить (или '0' для завершения): ");
            int productNumber = Integer.parseInt(scanner.nextLine());
            if (productNumber == 0) {
                addingProducts = false;
            } else {
                Product product = productHelper.findProductByNumber(productNumber);
                if (product != null) {
                    System.out.print("Сколько штук товара \"" + product.getName() + "\" вы хотите добавить? ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    // Проверка доступности товара
                    if (quantity > product.getQuantity()) {
                        System.out.println("Извините, доступно только " + product.getQuantity() + " штук(и) товара \"" + product.getName() + "\".");
                    } else {
                        orderHelper.addProductToOrder(order, product, quantity);
                    }
                } else {
                    System.out.println("Извините, товара с номером \"" + productNumber + "\" нет в наличии.");
                }
            }
        }

        // Вывод суммы заказа
        double totalAmount = orderHelper.calculateTotal(order);
        System.out.println("\nСумма вашего заказа: " + totalAmount + "$");

        // Запрос данных клиента
        System.out.print("\nВведите ваше имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите вашу фамилию: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите ваш номер телефона: ");
        String phone = scanner.nextLine();
        System.out.print("Введите ваш номер карты: ");
        String cardNumber = scanner.nextLine(); // Добавлен ввод номера карты

        Customer customer = new Customer(firstName + " " + lastName, phone);
        customerHelper.addCustomer(customer.getName(), customer.getPhone());

        order.setCustomer(customer); // Устанавливаем клиента в заказ

        // Сохраняем заказ
        orderHelper.saveOrder(order);

        System.out.println("\nСпасибо за покупку, " + firstName + "!");
        System.out.println("Ожидайте свой заказ в течение дня.");
    }
}


