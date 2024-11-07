package Tests;

import ee.ivkhkdev.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    private Customer customer;

    // Метод, который выполняется перед каждым тестом
    @BeforeEach
    public void setUp() {
        customer = new Customer("Иван Иванов", "1234567890");
    }

    @Test
    public void testCustomerName() {
        // Проверка, что имя клиента совпадает с ожидаемым
        assertEquals("Иван Иванов", customer.getName(), "Имя клиента должно быть 'Иван Иванов'");
    }

    @Test
    public void testCustomerPhone() {
        // Проверка, что телефон клиента совпадает с ожидаемым
        assertEquals("1234567890", customer.getPhone(), "Телефон клиента должен быть '1234567890'");
    }

    @Test
    public void testCustomerToString() {
        // Проверка корректности метода toString()
        String expectedString = "Иван Иванов (1234567890), Баланс: 0.0$, Покупок: 0";
        assertEquals(expectedString, customer.toString(), "Метод toString() должен возвращать корректную строку");
    }

    public void runTests() {
    }
}


