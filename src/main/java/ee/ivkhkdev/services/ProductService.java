package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.ProductAppHelper;
import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Product;

import java.util.List;

public class ProductService implements Service {
    private final AppHelper<Product> productAppHelper;

    public ProductService(AppHelper<Product> productAppHelper) {
        this.productAppHelper = productAppHelper;
    }
    @Override
    public boolean add(){
        Product product = productAppHelper.create();

        return false;
    }

    @Override
    public boolean print() {
        return false;
    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public List list() {
        return List.of();
    }
}
