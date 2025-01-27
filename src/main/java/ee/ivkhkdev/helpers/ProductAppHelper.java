package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

        System.out.print("Введите цену продукта: ");
        product.setPrice(Double.parseDouble(input.nextLine()));

        System.out.print("Введите количество товара: ");
        product.setQuantity(Integer.parseInt(input.nextLine()));

        return product;
    }

    @Override
    public boolean printList(List<Product> entities) {
        if (entities.isEmpty()) {
            System.out.println("Список пуст.");
            return false;
        }

        entities.forEach(System.out::println);
        return true;
    }

    @Override
    public List<Product> update(List<Product> entitesForModify) {
        // Логика обновления списка товаров
        return entitesForModify;
    }
}
