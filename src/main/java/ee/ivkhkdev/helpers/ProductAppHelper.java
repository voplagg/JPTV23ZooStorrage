package ee.ivkhkdev.helpers;


import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Product;

import java.util.List;

public class ProductAppHelper implements AppHelper<Product> {
    private final Input input;

    public ProductAppHelper(Input input) {
        this.input = input;
    }

    @Override
    public Product create() {
        Product product = new Product();
        System.out.print("Введите имя продукта: ");
        product.setName(input.nextLine());
        
        return product;
    }

    @Override
    public boolean printList(List<Product> entities) {
        return false;
    }

    @Override
    public List<Product> update(List<Product> entitesForModify) {
        return List.of();
    }
}
