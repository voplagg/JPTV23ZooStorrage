package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Помечаем класс как Spring сервис
public class CustomerBalanceService {

    private final CustomerService customerService; // Используем CustomerService для работы с клиентами

    // Конструктор для инъекции зависимости
    @Autowired
    public CustomerBalanceService(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Метод для добавления баланса покупателю по его ID
    public void addBalanceToCustomer(int customerId, double amount) {
        // Получаем список покупателей
        List<Customer> customers = customerService.list();

        // Проверяем, что ID покупателя корректен
        if (customerId < 1 || customerId > customers.size()) {
            System.out.println("Неверный ID покупателя.");
            return;
        }

        // Получаем покупателя по введенному ID
        Customer customerToAddMoney = customers.get(customerId - 1); // Индекс в списке начинается с 0, поэтому вычитаем 1

        // Проверяем, что сумма положительная
        if (amount <= 0) {
            System.out.println("Сумма должна быть положительной.");
            return;
        }

        // Добавляем деньги покупателю
        customerToAddMoney.addBalance(amount);

        // Выводим информацию о новом балансе
        System.out.println("К покупателю " + customerToAddMoney.getName() + " добавлено " + amount + " денежных средств.");
        System.out.println("Новый баланс: " + customerToAddMoney.getBalance());
    }
}





