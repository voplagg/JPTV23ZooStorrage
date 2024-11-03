package Tests;

public class ProductServiceTest {
    public void runTests() {
        System.out.println("Тестирование класса ProductService");

        PetStore store = new PetStore();
        ProductService productService = new ProductService(store);

        productService.addProduct("Корм для собак", 10.0, 100);
        productService.showProducts();
    }

}
