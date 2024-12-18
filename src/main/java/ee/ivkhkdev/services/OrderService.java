package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.interfaces.Service;

import java.util.List;
import java.util.Scanner;

public class OrderService {

    private final Service<Customer> customerService;
    private final Service<Product> productService;

    // Конструктор, принимающий сервисы для покупателей и продуктов
    public OrderService(Service<Customer> customerService, Service<Product> productService) {
        this.customerService = customerService;
        this.productService = productService;
    }

    // Метод для создания заказа
    public void createOrder() {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для ввода с клавиатуры

        // Получаем всех покупателей
        List<Customer> customers = customerService.list();
        if (customers.isEmpty()) {
            System.out.println("Нет покупателей.");
            return;
        }

        // Покупатель выбирает из списка
        System.out.println("Выберите покупателя:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName());
        }
        int customerIndex = scanner.nextInt() - 1; // Чтение ввода и уменьшение на 1
        if (customerIndex < 0 || customerIndex >= customers.size()) {
            System.out.println("Неверный выбор покупателя.");
            return;
        }
        Customer customer = customers.get(customerIndex);

        // Получаем все продукты
        List<Product> products = productService.list();
        if (products.isEmpty()) {
            System.out.println("Нет продуктов.");
            return;
        }

        // Покупатель выбирает продукт
        System.out.println("Выберите продукт:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName() + " - Цена: " + products.get(i).getPrice());
        }
        int productIndex = scanner.nextInt() - 1; // Чтение ввода и уменьшение на 1
        if (productIndex < 0 || productIndex >= products.size()) {
            System.out.println("Неверный выбор продукта.");
            return;
        }
        Product product = products.get(productIndex);

        // Спрашиваем количество продукта
        System.out.print("Введите количество: ");
        int quantity = scanner.nextInt();
        if (quantity <= 0) {
            System.out.println("Количество должно быть больше 0.");
            return;
        }

        // Проверка на наличие достаточного количества товара на складе
        if (quantity > product.getQuantity()) {
            System.out.println("Недостаточное количество продукта на складе.");
            return;
        }

        // Рассчитываем общую цену
        double totalPrice = product.getPrice() * quantity;

        // Проверяем, есть ли у покупателя достаточно средств
        if (customer.getBalance() >= totalPrice) {
            // Прямое списание средств
            double remainingBalance = customer.getBalance() - totalPrice;
            customer.setBalance(remainingBalance); // Обновляем баланс покупателя

            // Добавляем сумму в потраченную сумму
            double updatedSpentAmount = customer.getSpentPrice() + totalPrice;
            customer.setSpentPrice(updatedSpentAmount); // Обновляем потраченную сумму

            // Обновляем количество товара на складе
            product.setQuantity(product.getQuantity() - quantity);

            // Выводим информацию о покупке
            System.out.println("Покупка успешна! Товар: " + product.getName() + ", Количество: " + quantity +
                    ", Общая сумма: " + totalPrice + "$. Баланс покупателя: " + customer.getBalance());
        } else {
            System.out.println("Недостаточно средств на балансе.");
        }
    }

    // Метод для расчёта оборота магазина
    public double calculateStoreTurnover() {
        double totalTurnover = 0.0;

        // Получаем всех покупателей
        List<Customer> customers = customerService.list();

        // Суммируем потраченные деньги всех покупателей
        for (Customer customer : customers) {
            totalTurnover += customer.getSpentPrice();
        }

        return totalTurnover;
    }
}

