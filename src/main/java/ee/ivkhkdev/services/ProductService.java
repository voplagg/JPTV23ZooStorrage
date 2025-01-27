package ee.ivkhkdev.services;
import ee.ivkhkdev.helpers.ProductAppHelper;
import ee.ivkhkdev.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductAppHelper productAppHelper;
    private final List<Product> productList;

    public ProductService(ProductAppHelper productAppHelper) {
        this.productAppHelper = productAppHelper;
        this.productList = new ArrayList<>(); // Если это новый список продуктов
    }

    public boolean add() {
        // Логика добавления продукта
        Product newProduct = productAppHelper.create();
        productList.add(newProduct);
        return true;
    }

    public boolean print() {
        return productAppHelper.printList(productList);
    }

    public boolean edit() {
        return false;
    }

    public boolean remove() {
        return false;
    }

    public List<Product> list() {
        return productList;
    }

    public List<Product> SortedCustomer() {
        return List.of();
    }
}




