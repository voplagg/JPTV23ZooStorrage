package Magazin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer; // Клиент, сделавший заказ
    private List<Product> products; // Список товаров
    private List<Integer> quantities; // Список количеств товаров
    private BigDecimal totalAmount; // Общая сумма заказа

    // Конструктор класса Order
    public Order(Customer customer) {
        this.customer = customer; // Инициализация клиента
        this.products = new ArrayList<>(); // Инициализация списка товаров
        this.quantities = new ArrayList<>(); // Инициализация списка количеств
        this.totalAmount = BigDecimal.ZERO; // Инициализация суммы заказа
    }

    // Метод для добавления продукта в заказ
    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() >= quantity) { // Проверка наличия достаточного количества товара
            product.setQuantity(product.getQuantity() - quantity); // Уменьшение количества товара на складе
            BigDecimal productTotal = BigDecimal.valueOf(product.getPrice()).multiply(BigDecimal.valueOf(quantity)); // Расчёт стоимости добавляемого товара
            totalAmount = totalAmount.add(productTotal).setScale(2, RoundingMode.HALF_UP); // Округление до сотых

            // Добавляем продукт и количество в соответствующие списки
            products.add(product);
            quantities.add(quantity);
        } else {
            System.out.println("Недостаточное количество товара: " + product.getName());
        }
    }

    // Метод для получения общей суммы заказа
    public String getTotalAmount() {
        return totalAmount.setScale(2, RoundingMode.HALF_UP).toString(); // Возврат суммы как строки с двумя знаками после запятой
    }

    public void displayPurchasedItems() {
        System.out.println("Купленные товары:");
        for (int i = 0; i < products.size(); i++) { // Перебор всех товаров в заказе
            Product product = products.get(i);
            int quantity = quantities.get(i);
            System.out.println(product.getName() + " (Количество: " + quantity + ")"); // Вывод информации о товаре
        }
    }

    // Метод для установки клиента
    public void setCustomer(Customer customer) {
        this.customer = customer;
    } // Установка клиента для заказа
    // Метод для получения клиента
    public Customer getCustomer() {
        return customer;
    } // Возврат клиента, сделавшего заказ
}






