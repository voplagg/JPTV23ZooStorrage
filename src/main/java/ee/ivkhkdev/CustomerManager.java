package ee.ivkhkdev;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers; //список клиентов

    public CustomerManager() {
        customers = new ArrayList<>(); //Конструктор инициализирует пустой список customers, в котором будут храниться объекты клиентов.
    }

    public void addCustomer(Customer customer) {
        customers.add(customer); //Метод добавляет нового клиента в список customers. Он принимает объект Customer и добавляет его в коллекцию.
    }

    public Customer findCustomerByPhone(String phone) {
        for (Customer customer : customers) {
            if (customer.getPhone().equals(phone)) { //Метод ищет клиента по номеру телефона. Если клиент с таким номером телефона существует в списке, возвращается объект Customer. Если клиента нет, метод возвращает null.
                return customer;
            }
        }
        return null; // Если не найден
    }

    public void showAllCustomers() {
        if (customers.isEmpty()) { //Метод выводит информацию о всех клиентах в списке.
            System.out.println("Нет зарегистрированных покупателей.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // Рейтинг покупателей по количеству покупок
    public void showCustomerRating() {
        customers.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getTotalPurchases(), c1.getTotalPurchases()))
                .forEach(customer -> System.out.println(customer));
    }

    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) { //Метод ищет клиента по имени
            if (customer.getName().equals(name)) {
                return customer;
            }
        }

    return null;}

    public List<Customer> getCustomers() {
        return customers; //Метод возвращает список всех клиентов, хранящихся в объекте CustomerManager.
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
        List<Order> orders = new ArrayList<>();
        return orders; //Этот метод принимает объект Customer и должен возвращать список заказов (Order), сделанных этим клиентом.
    }
}

