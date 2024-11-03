package Magazin;

public class PurchasedItem {
    private Product product;
    private int quantity;

    public PurchasedItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " (Количество: " + quantity + ")";
    }
}
