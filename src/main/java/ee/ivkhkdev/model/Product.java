package ee.ivkhkdev.model;

public class Product {
    private String name; //название продукта
    private double price; //цена
    private int quantity; //количество

    public Product() {
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

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


    @Override
    public String toString() { //вывод инфо
        return "Продукт: " + name + ", Цена: " + price + "$, Количество: " + quantity;
    }

}