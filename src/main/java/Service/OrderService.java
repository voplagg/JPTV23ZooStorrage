package Service;


import ee.ivkhkdev.Customer;
import ee.ivkhkdev.Order;
import ee.ivkhkdev.PetStore;
import ee.ivkhkdev.Product;

public class OrderService {
    private PetStore petStore; // Ссылка на объект PetStore

    // Конструктор класса OrderService
    public OrderService(PetStore petStore) {
        this.petStore = petStore; // Инициализация объекта PetStore
    }

    // Метод для создания нового заказа
    public Order createOrder(Customer customer) {
        Order order = new Order(customer); // Создание нового заказа для клиента
        petStore.addOrder(order); // Добавление заказа в PetStore
        return order; // Возврат созданного заказа
    }

    // Метод для добавления продукта в заказ
    public void addProductToOrder(Order order, Product product, int quantity) {
        order.addProduct(product, quantity); // Добавление продукта и его количества в заказ
    }

    // Метод для получения общей суммы заказа
    public double getOrderTotal(Order order) {
        return order.getTotalAmount(); // Возврат общей суммы заказа
    }

    // Метод для завершения заказа
    public void completeOrder(Order order) {
        // Здесь можно добавить логику завершения заказа, например, отправку уведомлений
    }
}

