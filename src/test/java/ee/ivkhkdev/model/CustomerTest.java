package ee.ivkhkdev.model;

import ee.ivkhkdev.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        // Создаем объект Customer перед каждым тестом
        customer = new Customer("Иван", "Иванов", "123456789", "ID123");
    }

    @Test
    void testConstructorAndGetters() {
        // Проверяем правильность работы конструктора и геттеров
        assertEquals("Иван", customer.getName());
        assertEquals("Иванов", customer.getSurname());
        assertEquals("123456789", customer.getPhone());
        assertEquals("ID123", customer.getID());
        assertEquals(0.0, customer.getBalance());
        assertEquals(0.0, customer.getSpentPrice());
    }

    @Test
    void testSetters() {
        // Проверяем правильность работы сеттеров
        customer.setName("Петр");
        customer.setSurname("Петров");
        customer.setPhone("987654321");
        customer.setID("ID456");

        assertEquals("Петр", customer.getName());
        assertEquals("Петров", customer.getSurname());
        assertEquals("987654321", customer.getPhone());
        assertEquals("ID456", customer.getID());
    }

    @Test
    void testAddBalance() {
        // Проверяем метод добавления баланса
        customer.addBalance(100.0);
        assertEquals(100.0, customer.getBalance(), 0.01); // Проверяем, что баланс увеличился на 100

        customer.addBalance(50.0);
        assertEquals(150.0, customer.getBalance(), 0.01); // Проверяем, что баланс увеличился на 50
    }

    @Test
    void testAddSpentPrice() {
        // Проверяем метод добавления потраченной суммы
        customer.addSpentPrice(30.0);
        assertEquals(30.0, customer.getSpentPrice(), 0.01); // Проверяем, что потраченная сумма увеличилась на 30

        customer.addSpentPrice(20.0);
        assertEquals(50.0, customer.getSpentPrice(), 0.01); // Проверяем, что потраченная сумма увеличилась на 20
    }

    @Test
    void testSetBalance() {
        // Проверяем метод обновления баланса
        customer.setBalance(200.0);
        assertEquals(200.0, customer.getBalance(), 0.01); // Проверяем, что баланс обновился на 200

        customer.setBalance(0.0);
        assertEquals(0.0, customer.getBalance(), 0.01); // Проверяем, что баланс обновился на 0
    }

    @Test
    void testSetSpentPrice() {
        // Проверяем метод обновления потраченной суммы
        customer.setSpentPrice(150.0);
        assertEquals(150.0, customer.getSpentPrice(), 0.01); // Проверяем, что потраченная сумма обновилась на 150

        customer.setSpentPrice(0.0);
        assertEquals(0.0, customer.getSpentPrice(), 0.01); // Проверяем, что потраченная сумма обновилась на 0
    }

    @Test
    void testToString() {
        // Проверяем метод toString()
        String expectedString = "Покупатель: Иван, Фамилия: Иванов, Телефон: 123456789, ID: ID123, Баланс: 0.0, Потраченная сумма: 0.0";
        assertEquals(expectedString, customer.toString());
    }

    @Test
    void testAddBalanceWithNegativeAmount() {
        // Проверяем, что добавление отрицательной суммы не изменяет баланс
        customer.addBalance(-50.0);
        assertEquals(0.0, customer.getBalance(), 0.01); // Баланс должен остаться 0
    }

    @Test
    void testAddSpentPriceWithNegativeAmount() {
        // Проверяем, что добавление отрицательной суммы не изменяет потраченную сумму
        customer.addSpentPrice(-30.0);
        assertEquals(0.0, customer.getSpentPrice(), 0.01); // Потраченная сумма должна остаться 0
    }

    @Test
    void testSetBalanceWithNegativeAmount() {
        // Проверяем, что установка отрицательного баланса не изменяет его
        customer.setBalance(-50.0);
        assertEquals(0.0, customer.getBalance(), 0.01); // Баланс должен остаться 0
    }

    @Test
    void testSetSpentPriceWithNegativeAmount() {
        // Проверяем, что установка отрицательной потраченной суммы не изменяет ее
        customer.setSpentPrice(-30.0);
        assertEquals(0.0, customer.getSpentPrice(), 0.01); // Потраченная сумма должна остаться 0
    }
}
