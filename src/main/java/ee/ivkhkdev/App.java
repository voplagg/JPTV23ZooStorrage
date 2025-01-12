package ee.ivkhkdev;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.services.CustomerBalanceService;


import java.util.List;

public class App {
    private final Service<Product> productService;
    private final Input input;
    private final Service<Customer> customerService;



    public App(Input input, Service<Product> productService, Service<Customer> customerService) {
        this.input = input;
        this.productService = productService;
        this.customerService = customerService;
    }

    public void run() {
        boolean repeat = true;
        do {
            System.out.println("\n--- Главное меню ---");
            System.out.println("1. Выход из программы");
            System.out.println("2. Добавить продукт");
            System.out.println("3. Список продаваемых продуктов");
            System.out.println("4. Добавить покупателя");
            System.out.println("5. Список зарегистрированных покупателей");
            System.out.println("6. Добавить денег покупателю");
            System.out.println("7. Рейтинг покупателей");
            System.out.println("8. Рейтинг товаров");
            System.out.println("9. Редактировать товар");
            System.out.println("10. Редактировать пользователя");
            System.out.print("Выберите действие: ");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Выход из программы...");
                    repeat = false; // Завершаем программу
                    break;
                case 2:
                    if (productService.add()) {
                        System.out.println("Продукт успешно добавлен.");
                    } else {
                        System.out.println("Не удалось добавить продукт.");
                    }
                    System.out.println("Список товаров:");
                    productService.print(); // Печать списка товаров после добавления
                    break;
                case 3:
                    if (productService.print()) {
                        System.out.println("-------------------");
                    } else {
                        System.out.println("Продукт напечатать не удалось");
                    }
                    break;
                case 4:
                    if (customerService.add()) {
                        System.out.println("Покупатель успешно добавлен.");
                    } else {
                        System.out.println("Не удалось добавить покупателя.");
                    }
                    break;
                case 5:
                    System.out.println("Список зарегистрированных покупателей:");
                    customerService.list().forEach(customer -> System.out.println(customer));
                    break;
                case 6:
                    System.out.println("Введите ID покупателя:");
                    int customerIdToAddMoney = Integer.parseInt(input.nextLine());  // Ввод ID
                    System.out.println("Введите сумму для добавления:");
                    double amountToAdd = Double.parseDouble(input.nextLine());
                    CustomerBalanceService balanceService = new CustomerBalanceService(customerService);
                    balanceService.addBalanceToCustomer(customerIdToAddMoney, amountToAdd);
                    break;
                case 7:
                    System.out.println("Рейтинг покупателей по потраченной сумме:");
                    List<Customer> sortedCustomers = customerService.SortedCustomer();
                    for (int i = 0; i < sortedCustomers.size(); i++) {
                        Customer customer = sortedCustomers.get(i);
                        System.out.println((i + 1) + ". " + customer.getName() + " - Потрачено: " + customer.getPhone() + "$");
                    }
                    break;
                case 8:
                    System.out.println("Рейтинг товаров:");
                    List<Product> products = productService.list();
                    products.sort((p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity())); // Сортировка по убыванию
                    for (Product product : products) {
                        System.out.println(product.getName() + " - Продано: " + (product.getQuantity() - product.getQuantity()));
                    }
                    break;
                case 9:
                    if (productService.edit()) {
                        System.out.println("Продукт успешно отредактирован.");
                    } else {
                        System.out.println("Не удалось отредактировать продукт.");
                    }
                    break;
                case 10:
                    if (customerService.edit()) {
                        System.out.println("Покупатель успешно отредактирован.");
                    } else {
                        System.out.println("Не удалось отредактировать покупателя.");
                    }
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        } while (repeat);
        System.out.println("До свидания!");


    }
}


