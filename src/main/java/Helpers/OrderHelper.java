package Helpers;

import Magazin.Customer;
import Magazin.Order;
import Magazin.PetStore;
import Magazin.Product;

public class OrderHelper {
    private PetStore store; // Экземпляр магазина

    // Конструктор класса
    public OrderHelper(PetStore store) {
        this.store = store; // Инициализация магазина
    }

    // Метод для создания заказа
    public Order createOrder(Customer customer) {
        return new Order(customer); // Создание нового заказа с указанным клиентом
    }

    // Метод для добавления продукта в заказ
    public void addProductToOrder(Order order, Product product, int quantity) {
        order.addProduct(product, quantity); // Добавление продукта с заданным количеством в заказ
    }

    // Метод для расчёта общей суммы заказа
    public String calculateTotal(Order order) {
        return order.getTotalAmount(); // Возврат общей суммы заказа
    }

    // Метод для сохранения заказа
    public void saveOrder(Order order) {
        store.addOrder(order); // Добавление заказа в магазин
    }
}
