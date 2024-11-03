package Tests;

public class CustomerManagerTest {
    public void runTests() {
        System.out.println("Тестирование класса CustomerManager");

        CustomerManager customerManager = new CustomerManager();
        Customer customer = new Customer("Иван Иванов", "1234567890");

        customerManager.addCustomer(customer);
        assertEquals(1, customerManager.getCustomers().size());
        System.out.println(customerManager.getCustomers());
    }

    private void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            System.out.println("Ошибка: ожидалось " + expected + ", но получено " + actual);
        } else {
            System.out.println("Тест пройден: " + expected);
        }
    }
}

