package ee.ivkhkdev;

import Input.InputHelper;

import java.util.Scanner;

public class App {
    private static PetStore store; // Магазин
    private static CustomerManager customerManager;  // Менеджер клиентов
    private static Scanner scanner = new Scanner(System.in);

    public static void run() {
        store = new PetStore();
        customerManager = new CustomerManager();
        addTestProducts();


        while (true) {
            System.out.println("\n--- Главное меню ---");
            System.out.println("1. Выход из программы");
            System.out.println("2. Добавить продукт");
            System.out.println("3. Список продаваемых продуктов");
            System.out.println("4. Добавить покупателя");
            System.out.println("5. Список зарегистрированных покупателей");
            System.out.println("6. Покупка покупателем продукта");
            System.out.println("7. Оборот магазина");
            System.out.println("8. Добавить денег покупателю");
            System.out.println("9. Рейтинг покупателей");
            System.out.println("10. Рейтинг товаров");
            System.out.println("11. Редактировать товар");
            System.out.println("12. Редактировать пользователя");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Выход из программы...");
                    return; // Завершаем программу
                case 2:
                    addProduct();
                    break;
                case 3:
                    listProducts();
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    listCustomers();
                    break;
                case 6:
                    createOrderProcess();
                    break;
                case 7:
                    showStoreTurnover();
                    break;
                case 8:
                    addMoneyToCustomer();
                    break;
                case 9:
                    showCustomerRating();
                    break;
                case 10:
                    showProductSalesRating();
                    break;
                case 11:
                    editProduct();
                    break;
                case 12:
                    editCustomer();
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    private static void createOrderProcess() {
        // Показ товаров в наличии
        System.out.println("\nВот что у нас есть в наличии:");
        store.showProductsWithNumbers(); // Вывод списка продуктов

        // Создаем заказ
        Order order = new Order(null); // Клиент пока не добавлен

        boolean addingProducts = true;
        while (addingProducts) {
            int productNumber = InputHelper.getInt("\nВведите номер товара, который хотите купить (или '0' для завершения): ");
            if (productNumber == 0) {
                addingProducts = false;
            } else {
                Product product = store.findProductByNumber(productNumber);
                if (product != null) {
                    int quantity = InputHelper.getInt("Сколько штук товара \"" + product.getName() + "\" вы хотите добавить? ");

                    // Проверка доступности товара
                    if (quantity > product.getQuantity()) {
                        System.out.println("Извините, доступно только " + product.getQuantity() + " штук(и) товара \"" + product.getName() + "\".");
                    } else {
                        order.addProduct(product, quantity); // Добавление товара в заказ
                    }
                } else {
                    System.out.println("Извините, товара с номером \"" + productNumber + "\" нет в наличии.");
                }
            }
        }

        // Вывод списка купленных товаров
        order.displayPurchasedItems();

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

        // Сохраняем заказ в магазине
        store.addOrder(order);

        // Увеличиваем счётчик покупок у клиента
        customer.incrementPurchases(); // Увеличиваем количество покупок

        System.out.println("\nСпасибо за покупку, " + firstName + "!");
        System.out.println("Ожидайте свой заказ в течение дня.");

    }



    private static void addTestProducts() {
        store.addProduct(new Product("Корм для собак", 10.99, 23));
        store.addProduct(new Product("Корм для кошек", 9.99, 20));
        store.addProduct(new Product("Игрушка для кошек", 5.49, 15));
        store.addProduct(new Product("Игрушка для собак", 3.49, 17));
        store.addProduct(new Product("Корм для рыб", 2.99, 30));
        store.addProduct(new Product("Корм для хомяков", 7.49, 15));
        store.addProduct(new Product("Корм для птиц", 4.79, 11));
    }


    // Добавить продукт
    private static void addProduct() {
        String name = InputHelper.getString("Введите название продукта: ");
        double price = InputHelper.getDouble("Введите цену продукта: ");
        int quantity = InputHelper.getInt("Введите количество продукта: ");
        store.addProduct(new Product(name, price, quantity));
        System.out.println("Продукт добавлен.");
    }

    // Список продаваемых продуктов
    private static void listProducts() {
        System.out.println("\nСписок продуктов:");
        store.showProductsWithNumbers();
    }

    // Добавить покупателя
    private static void addCustomer() {
        String firstName = InputHelper.getString("Введите имя покупателя: ");
        String lastName = InputHelper.getString("Введите фамилию покупателя: ");
        String phone = InputHelper.getString("Введите телефон покупателя: ");
        Customer customer = new Customer(firstName + " " + lastName, phone);
        customerManager.addCustomer(customer);
        store.addCustomer(customer);
        System.out.println("Покупатель добавлен.");
    }

    // Список зарегистрированных покупателей
    private static void listCustomers() {
        System.out.println("\nСписок покупателей:");
        customerManager.showAllCustomers();
    }

    // Оборот магазина
    private static void showStoreTurnover() {
        double turnover = store.calculateTotalTurnover();
        System.out.println("\nОборот магазина: " + turnover + "$");
    }

    // Добавить денег покупателю
    private static void addMoneyToCustomer() {
        String phone = InputHelper.getString("Введите телефон покупателя: ");
        double amount = InputHelper.getDouble("Введите сумму для добавления: ");
        Customer customer = customerManager.findCustomerByPhone(phone);
        if (customer != null) {
            customer.addBalance(amount);
            System.out.println("Деньги добавлены.");
        } else {
            System.out.println("Покупатель не найден.");
        }
    }

    // Рейтинг покупателей по количеству покупок
    private static void showCustomerRating() {
        System.out.println("\nРейтинг покупателей по количеству покупок:");
        customerManager.showCustomerRating();
    }

    // Рейтинг товаров по продаваемости
    private static void showProductSalesRating() {
        System.out.println("\nРейтинг товаров по продаваемости:");
        store.showProductSalesRating();
    }

    // Редактировать товар
    private static void editProduct() {
        int productId = InputHelper.getInt("Введите номер товара для редактирования: ");
        Product product = store.findProductByNumber(productId);
        if (product != null) {
            String newName = InputHelper.getString("Введите новое название товара: ");
            double newPrice = InputHelper.getDouble("Введите новую цену товара: ");
            int newQuantity = InputHelper.getInt("Введите новое количество товара: ");
            product.setName(newName);
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            System.out.println("Товар отредактирован.");
        } else {
            System.out.println("Товар не найден.");
        }
    }

    // Редактировать покупателя
    private static void editCustomer() {
        String phone = InputHelper.getString("Введите телефон покупателя для редактирования: ");
        Customer customer = customerManager.findCustomerByPhone(phone);
        if (customer != null) {
            String newName = InputHelper.getString("Введите новое имя покупателя: ");
            String newPhone = InputHelper.getString("Введите новый телефон покупателя: ");
            customer.setName(newName);
            customer.setPhone(newPhone);
            System.out.println("Покупатель отредактирован.");
        } else {
            System.out.println("Покупатель не найден.");
        }
    }

    // Прочие методы для обработки заказов, работы с клиентами и товарами можно оставить как есть.
}





