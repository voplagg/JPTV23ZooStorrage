package ee.ivkhkdev;

import Input.InputHelper;
import Magazin.Customer;
import Magazin.Order;
import Magazin.PetStore;
import Magazin.CustomerManager;
import Magazin.Product;

public class App {
    private static PetStore store; // Магазин
    private static CustomerManager customerManager;  // Менеджер клиентов

    // Запуск приложения
    public static void run() {
        store = new PetStore(); // Создание экземпляра магазина
        customerManager = new CustomerManager(); // Создание менеджера клиентов
        addTestProducts(); // Добавление тестовых продуктов

        System.out.println("Добро пожаловать в наш зоомагазин!");

        // Показ товаров и начало заказа
        createOrderProcess(); // Запуск процесса создания заказа
    }

    // Метод для добавления тестовых товаров
    private static void addTestProducts() {
        store.addProduct(new Product("Корм для собак", 10.99, 23));
        store.addProduct(new Product("Корм для кошек", 9.99, 20));
        store.addProduct(new Product("Игрушка для кошек", 5.49, 15));
        store.addProduct(new Product("Игрушка для собак", 3.49, 17));
        store.addProduct(new Product("Корм для рыб", 2.99, 30));
        store.addProduct(new Product("Корм для хомяков", 7.49, 15));
        store.addProduct(new Product("Корм для птиц", 4.79, 11));
    }

    private static void createOrderProcess() {
        // Показ товаров в наличии
        System.out.println("\nВот что у нас есть в наличии:");
        store.showProductsWithNumbers(); // Вывод списка продуктов

        // Создаем заказ
        Order order = new Order(null); // Клиент пока не добавлен

        // Добавляем товары в заказ
        boolean addingProducts = true; // Флаг для добавления продуктов
        while (addingProducts) {
            int productNumber = InputHelper.getInt("\nВведите номер товара, который хотите купить (или '0' для завершения): ");
            if (productNumber == 0) {
                addingProducts = false; // Завершение добавления
            } else {
                Product product = store.findProductByNumber(productNumber); // Поиск продукта
                if (product != null) {
                    int quantity = InputHelper.getInt("Сколько штук товара \"" + product.getName() + "\" вы хотите добавить? ");

                    // Проверка доступности товара
                    if (quantity > product.getQuantity()) {
                        System.out.println("Извините, доступно только " + product.getQuantity() + " штук(и) товара \"" + product.getName() + "\".");
                    } else {
                        order.addProduct(product, quantity); // Добавление продукта в заказ
                    }
                } else {
                    System.out.println("Извините, товара с номером \"" + productNumber + "\" нет в наличии.");
                }
            }
        }

        // Вывод списка купленных товаров
        order.displayPurchasedItems(); // Отображение купленных товаров

        // Вывод суммы заказа
        System.out.println("\nСумма вашего заказа: " + order.getTotalAmount() + "$");

        // Ввод данных клиента
        String firstName = InputHelper.getString("\nВведите ваше имя: ");
        String lastName = InputHelper.getString("Введите вашу фамилию: ");
        String phone = InputHelper.getString("Введите ваш номер телефона: ");
        String cart = InputHelper.getString("Введите ваш номер карты: ");

        // Создаем клиента и добавляем его в менеджер клиентов
        Customer customer = new Customer(firstName + " " + lastName, phone);
        customerManager.addCustomer(customer); // Добавляем клиента в CustomerManager
        store.addCustomer(customer); // Добавляем клиента в PetStore
        order.setCustomer(customer); // Установка клиента для заказа

        // Сохраняем заказ
        store.addOrder(order);

        System.out.println("\nСпасибо за покупку, " + firstName + "!");
        System.out.println("Ожидайте свой заказ в течение дня.");
    }
}




