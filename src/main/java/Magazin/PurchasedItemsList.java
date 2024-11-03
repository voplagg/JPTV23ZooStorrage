package Magazin;

import java.util.ArrayList;
import java.util.List;

public class PurchasedItemsList {
    private List<PurchasedItem> purchasedItems;

    public PurchasedItemsList() {
        purchasedItems = new ArrayList<>();
    }

    public void addPurchasedItem(Product product, int quantity) {
        purchasedItems.add(new PurchasedItem(product, quantity));
    }

    public void displayPurchasedItems() {
        System.out.println("Список купленных товаров:");
        for (PurchasedItem item : purchasedItems) {
            System.out.println(item);
        }
    }
}

