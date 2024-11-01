package Helpers;

import Magazin.PetStore;
import Magazin.Product;

public class ProductHelper {
    private PetStore store;

    public ProductHelper(PetStore store) {
        this.store = store;
    }

    public void addProduct(String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        store.addProduct(product);
    }

    public void displayProducts() {
        store.showProductsWithNumbers();
    }

    public Product findProductByNumber(int productNumber) {
        return store.findProductByNumber(productNumber);
    }
}

