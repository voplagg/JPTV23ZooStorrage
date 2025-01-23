package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.ProductAppHelper;
import ee.ivkhkdev.model.Product;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.interfaces.Input;

import java.util.List;

public class ProductService implements Service<Product> {
    private final ProductAppHelper productAppHelper;
    private final List<Product> productList; // Assume product list is handled in memory or fetched from database

    public ProductService(ProductAppHelper productAppHelper, List<Product> productList) {
        this.productAppHelper = productAppHelper;
        this.productList = productList;
    }

    @Override
    public boolean add() {
        // Using the ProductAppHelper to create a new product
        Product newProduct = productAppHelper.create(); // Collects product data from the user input
        productList.add(newProduct); // Adds the new product to the product list or database
        return true;
    }

    @Override
    public boolean print() {
        return productAppHelper.printList(productList); // Prints the list using the helper
    }

    @Override
    public boolean edit() {
        // You can implement logic to update a product, using productAppHelper or other methods
        // The implementation would depend on the actual requirements (e.g., selecting a product to modify)
        return false;
    }

    @Override
    public boolean remove() {
        // Implement the logic to remove a product (e.g., by selecting a product to delete)
        return false;
    }

    @Override
    public List<Product> list() {
        return productList; // Returns the list of products
    }

    @Override
    public List<Product> SortedCustomer() {
        // Sorting logic can be implemented here if needed
        return List.of(); // Placeholder
    }
}


