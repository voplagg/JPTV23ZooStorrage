package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.interfaces.Input;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements Service<Customer> {
    private List<Customer> customers; // Список покупателей
    private Input input;              // Поле для ввода данных

    // Конструктор, который принимает объект Input для считывания данных
    public CustomerService(Input input) {
        customers = new ArrayList<>(); // Инициализация пустого списка покупателей
        this.input = input;            // Инициализация поля input
    }

    @Override
    public boolean add() {
        // Добавление покупателя
        System.out.print("Введите имя покупателя: ");
        String name = input.nextLine(); // Считываем имя

        System.out.print("Введите фамилию покупателя: ");
        String surname = input.nextLine(); // Считываем фамилию

        System.out.print("Введите телефон покупателя: ");
        String phone = input.nextLine(); // Считываем телефон

        System.out.print("Введите ID покупателя: ");
        String ID = input.nextLine(); // Считываем ID

        // Создаем покупателя с введенными данными
        Customer customer = new Customer(name, surname, phone, ID);

        customers.add(customer); // Добавляем покупателя в список
        return true;
    }

    @Override
    public boolean print() {
        // Печать всех покупателей
        if (customers.isEmpty()) {
            System.out.println("Нет зарегистрированных покупателей.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer); // Используется метод toString()
            }
        }
        return true;
    }

    @Override
    public boolean edit() {
        // Редактирование покупателя (пока не реализовано)
        return false;
    }

    @Override
    public boolean remove() {
        // Удаление покупателя (пока не реализовано)
        return false;
    }

    @Override
    public List<Customer> list() {
        return customers; // Возвращаем список всех зарегистрированных покупателей
    }

    @Override
    public List<Customer> SortedCustomer() {
        return List.of();
    }
}


