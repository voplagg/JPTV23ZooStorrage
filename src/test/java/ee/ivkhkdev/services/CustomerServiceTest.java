package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.interfaces.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CustomerServiceTest {

    private CustomerService customerService;
    private Input mockInput;

    @BeforeEach
    void setUp() {
        // Мокаем интерфейс Input
        mockInput = Mockito.mock(Input.class);

        // Инициализируем CustomerService с моком Input
        customerService = new CustomerService(mockInput);
    }

    @Test
    void testAddCustomer_Success() {
        // Мокаем поведение метода nextLine() для ввода данных
        Mockito.when(mockInput.nextLine()).thenReturn("John", "Doe", "1234567890", "1");

        // Добавляем покупателя
        assertTrue(customerService.add());

        // Получаем список покупателей и проверяем его
        List<Customer> customers = customerService.list();
        assertEquals(1, customers.size());

        // Проверяем, что данные покупателя совпадают с введенными
        Customer customer = customers.get(0);
        assertEquals("John", customer.getName());
        assertEquals("Doe", customer.getSurname());
        assertEquals("1234567890", customer.getPhone());
        assertEquals("1", customer.getID());
    }

    @Test
    void testAddCustomer_Failure() {
        // Мокаем поведение метода nextLine() для ввода данных
        Mockito.when(mockInput.nextLine()).thenReturn(null, null, null, null);

        // Попытка добавить покупателя с некорректными данными
        assertFalse(customerService.add());

        // Проверяем, что список остается пустым
        List<Customer> customers = customerService.list();
        assertTrue(customers.isEmpty());
    }

    @Test
    void testPrint_EmptyList() {
        // Проверяем, что метод print() выводит сообщение о пустом списке
        assertTrue(customerService.print());
    }

    @Test
    void testPrint_NotEmptyList() {
        // Мокаем поведение метода nextLine() для ввода данных
        Mockito.when(mockInput.nextLine()).thenReturn("John", "Doe", "1234567890", "1");

        // Добавляем покупателя
        customerService.add();

        // Проверяем, что метод print() выводит покупателей
        assertTrue(customerService.print());
    }

    @Test
    void testList() {
        // Мокаем поведение метода nextLine() для ввода данных
        Mockito.when(mockInput.nextLine()).thenReturn("John", "Doe", "1234567890", "1");

        // Добавляем покупателя
        customerService.add();

        // Получаем список покупателей и проверяем его
        List<Customer> customers = customerService.list();
        assertEquals(1, customers.size());

        // Проверяем, что покупатель добавлен в список
        assertEquals("John", customers.get(0).getName());
    }
}
