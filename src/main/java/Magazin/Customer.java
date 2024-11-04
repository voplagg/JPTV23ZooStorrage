package Magazin;

public class Customer {
    private String name; //имя клиента
    private String phone; // номер телефона

    // Конструктор класса Customer
    public Customer(String name, String phone) {
        this.name = name; // Инициализация имени клиента
        this.phone = phone; // Инициализация телефона клиента
    }

    // Метод для получения имени клиента
    public String getName() {
        return name;
    } // Возврат имени клиента

    // Метод для получения телефона клиента
    public String getPhone() {
        return phone;
    } // Возврат телефона клиента

    // Переопределение метода toString для удобного отображения информации о клиенте
    @Override
    public String toString() {
        return "Клиент: " + name + ", Телефон: " + phone;
    } // Форматированный вывод информации о клиенте
}
