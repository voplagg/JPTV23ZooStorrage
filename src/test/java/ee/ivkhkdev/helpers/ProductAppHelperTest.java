package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Product;

import java.util.List;

public class ProductAppHelperTest implements AppHelper<Product> {
    private final Input input;

    public ProductAppHelperTest(Input input) {
        this.input = input;
    }

    @Override
    public Product create() {
        Product product = new Product();

        // Ввод имени продукта
        System.out.print("Введите имя продукта: ");
        product.setName(input.nextLine());

        // Ввод цены с обработкой ошибок
        while (true) {
            try {
                System.out.print("Введите цену продукта: ");
                product.setPrice(Double.parseDouble(input.nextLine()));
                break; // Выход из цикла, если ввод корректен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Пожалуйста, введите корректную цену.");
            }
        }

        // Ввод количества с обработкой ошибок
        while (true) {
            try {
                System.out.print("Введите количество товара: ");
                product.setQuantity(Integer.parseInt(input.nextLine()));
                break; // Выход из цикла, если ввод корректен
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Пожалуйста, введите корректное количество.");
            }
        }

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
    public List<Product> update(List<Product> entitiesForModify) {
        // Реализация обновления продуктов
        System.out.println("Обновление списка продуктов еще не реализовано.");
        return entitiesForModify;
    }
}

