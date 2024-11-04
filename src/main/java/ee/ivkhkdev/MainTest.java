package ee.ivkhkdev;

import Tests.*;

public class MainTest {
    public static void main(String[] args) {
        new CustomerTest().runTests();
        new ProductTest().runTests();
        new OrderTest().runTests();
        new PetStoreTest().runTests();
        new CustomerManagerTest().runTests();
        new CustomerServiceTest().runTests();
        new OrderServiceTest().runTests();

    }
}
