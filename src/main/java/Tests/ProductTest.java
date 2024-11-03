package Tests;

public class ProductTest {
    public void runTests() {
        System.out.println("Тестирование класса Product");

        Product product = new Product("Корм для собак", 10.0, 100);
        assertEquals("Корм для собак", product.getName());
        assertEquals(10.0, product.getPrice(), 0.01);

        product.setDiscount(20);
        assertEquals(8.0, product.getPrice(), 0.01);

        System.out.println(product);
    }

    private void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            System.out.println("Ошибка: ожидалось " + expected + ", но получено " + actual);
        } else {
            System.out.println("Тест пройден: " + expected);
        }
    }

    private void assertEquals(double expected, double actual, double delta) {
        if (Math.abs(expected - actual) > delta) {
            System.out.println("Ошибка: ожидалось " + expected + ", но получено " + actual);
        } else {
            System.out.println("Тест пройден: " + expected);
        }
    }
}
