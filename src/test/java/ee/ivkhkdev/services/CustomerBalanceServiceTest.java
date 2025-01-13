package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.interfaces.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerBalanceServiceTest {

    @Mock
    private Service<Customer> customerServiceMock;

    @InjectMocks
    private CustomerBalanceService customerBalanceService;

    private List<Customer> customers;

    @BeforeEach
    void setUp() {
        customers = new ArrayList<>();
        customers.add(new Customer("John", "Doe", "1234567890", "1"));
        customers.add(new Customer("Jane", "Smith", "0987654321", "2"));
    }

    @Test
    void testAddBalanceToCustomer_Success() {
        // Мокаем поведение метода list() для возврата списка покупателей
        when(customerServiceMock.list()).thenReturn(customers);

        // Выполняем добавление средств покупателю с ID 1
        customerBalanceService.addBalanceToCustomer(1, 100.0);

        // Проверяем, что баланс покупателя был обновлен
        assertEquals(100.0, customers.get(0).getBalance(), "Баланс покупателя должен быть обновлен.");
    }

    @Test
    void testAddBalanceToCustomer_InvalidId() {
        // Мокаем поведение метода list() для возврата списка покупателей
        when(customerServiceMock.list()).thenReturn(customers);

        // Проверяем на неверный ID (например, ID больше чем количество покупателей)
        customerBalanceService.addBalanceToCustomer(3, 100.0);

        // Проверяем, что покупатель не был найден, и выводится сообщение об ошибке
        // В данном случае мы проверяем, что не был обновлен баланс
        assertEquals(0.0, customers.get(0).getBalance(), "Баланс покупателя не должен измениться.");
    }

    @Test
    void testAddBalanceToCustomer_NegativeAmount() {
        // Мокаем поведение метода list() для возврата списка покупателей
        when(customerServiceMock.list()).thenReturn(customers);

        // Проверяем на отрицательную сумму
        customerBalanceService.addBalanceToCustomer(1, -50.0);

        // Проверяем, что баланс покупателя не изменился
        assertEquals(0.0, customers.get(0).getBalance(), "Баланс покупателя не должен измениться.");
    }

    @Test
    void testAddBalanceToCustomer_ZeroAmount() {
        // Мокаем поведение метода list() для возврата списка покупателей
        when(customerServiceMock.list()).thenReturn(customers);

        // Проверяем на сумму 0
        customerBalanceService.addBalanceToCustomer(1, 0.0);

        // Проверяем, что баланс покупателя не изменился
        assertEquals(0.0, customers.get(0).getBalance(), "Баланс покупателя не должен измениться.");
    }
}
