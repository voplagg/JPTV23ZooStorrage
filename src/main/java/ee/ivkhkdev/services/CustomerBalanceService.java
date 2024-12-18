package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.interfaces.Service;

import java.util.List;

public class CustomerBalanceService {
    private final Service<Customer> customerService;

    public CustomerBalanceService(Service<Customer> customerService) {
        this.customerService = customerService;
    }
    public void addBalanceToCustomer(int customerId, double amount) {
        // Получаем список покупателей
        List<Customer> customers = customerService.list();
        // Проверяем, что ID покупателя корректен
        if (customerId < 1 || customerId > customers.size()) {
            System.out.println("Неверный ID покупателя.");
            return;
        }
        // Получаем покупателя по введенному ID
        Customer customerToAddMoney = customers.get(customerId - 1);  // Индекс в списке начинается с 0, поэтому вычитаем 1
        // Проверяем, что сумма положительная
        if (amount <= 0) {
            System.out.println("Сумма должна быть положительной.");
            return;
        }
        // Добавляем деньги покупателю
        customerToAddMoney.addBalance(amount);
        System.out.println("К покупателю " + customerToAddMoney.getName() + " добавлено " + amount + " денежных средств.");
        System.out.println("Новый баланс: " + customerToAddMoney.getBalance());
    }
}

