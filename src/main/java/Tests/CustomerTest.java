package Tests;

import Magazin.Customer;

public class CustomerTest {
    public void runTests() {
        System.out.println("Тестирование класса Customer");

        Customer customer = new Customer("Иван Иванов", "1234567890");
        assertEquals("Иван Иванов", customer.getName());
        assertEquals("1234567890", customer.getPhone());
        System.out.println(customer);
    }

    private void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            System.out.println("Ошибка: ожидалось " + expected + ", но получено " + actual);
        } else {
            System.out.println("Тест пройден: " + expected);
        }
    }
}

