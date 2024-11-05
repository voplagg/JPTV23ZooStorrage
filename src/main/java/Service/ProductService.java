package Service;


import ee.ivkhkdev.PetStore;
import ee.ivkhkdev.Product;

import java.util.List;

public class ProductService {
    private PetStore petStore;

    public ProductService(PetStore petStore) {
        this.petStore = petStore;
    }

    public void addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        petStore.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return petStore.getProducts(); // Этот метод нужно добавить в PetStore
    }

    public Product findProductByNumber(int productNumber) {
        return petStore.findProductByNumber(productNumber);
    }

    public void showProducts() {
        petStore.showProductsWithNumbers();
    }
}
