package ee.ivkhkdev;

public class Product {
    private String name; //название продукта
    private double price; //цена
    private int quantity; //количество
    private int soldQuantity; // Сколько было продано (для рейтинга)

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.soldQuantity = 0; // Изначально ничего не продано
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void increaseSoldQuantity(int quantity) {
        this.soldQuantity += quantity;
    }

    // Метод для подсчёта общей суммы по продукту
    public double getTotalSales() {
        return soldQuantity * price;
    }

    @Override
    public String toString() { //вывод инфо
        return "Продукт: " + name + ", Цена: " + price + "$, Количество: " + quantity + ", Продано: " + soldQuantity;
    }

    public void setDiscount(int i) {
    }
}