package Magazin;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount; // скидка в процентах

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = 0.0; // По умолчанию скидка 0%
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price * (1 - discount / 100); // Цена с учетом скидки
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " - " + getPrice() + "$ в наличии: " + quantity;
    }
}

