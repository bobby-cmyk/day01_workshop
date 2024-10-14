package shoppingcart;

import java.util.ArrayList;

public class ShoppingCart {
    
    // Use arraylist to store items
    private ArrayList<String> items;

    public ShoppingCart() {
        // Dont need to have parameters to initialise the cart
        items = new ArrayList<>();
    }

    // Method to add items into cart
    // able to add more than one item, separated by commas
    public void add(String toAdd) {
        String[] toAddItems = toAdd.split(",");

        for (int i = 0; i < toAddItems.length; i++) {
            String toAddItem = toAddItems[i].trim();
            if (toAddItem.isEmpty()) {
                continue;
            }
            items.add(toAddItem);
            System.out.printf(">>> %s added to cart\n", toAddItem);
        }
    }

    public void list() {
        if (items.isEmpty()) {
            System.out.println(">>> Your cart is empty");
        }

        else {
            for (int i = 0; i < items.size(); i++) {
                System.out.printf(">>> %d. %s\n", i+1, items.get(i));
            }
        }
    }

    public void delete(int itemNumber) {
        int index = itemNumber - 1;
        if (index < 0 || index >= items.size()) {
            System.out.println(">>> Incorrect item index");
        }
        else {
            String itemToDelete = items.get(index);
            items.remove(index);
            System.out.printf(">>> %s removed from cart\n", itemToDelete);
        }
    }
}
