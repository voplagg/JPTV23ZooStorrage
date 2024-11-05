package Tests;


import ee.ivkhkdev.PetStore;
import ee.ivkhkdev.Product;

public class PetStoreTest {
    public void runTests() {
        System.out.println("Тестирование класса PetStore");

        PetStore store = new PetStore();
        Product product = new Product("Корм для собак", 10.0, 100);

        store.addProduct(product);
        store.showProductsWithNumbers();
    }
}
