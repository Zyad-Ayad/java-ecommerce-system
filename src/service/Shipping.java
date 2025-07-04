package service;

import java.util.List;
import cart.CartItem;
import product.Deliverable;
import product.DeliverableProduct;

public class Shipping {
    private Shipping() {
    }

    public static final double SHIPPING_RATE = 30.0; // per kg

    public static double shippingCost(List<CartItem> items) {
        double totalWeight = 0.0;

        if (items.isEmpty()) {
            throw new IllegalArgumentException("No items to ship");
        }

        for (CartItem item : items) {
            if (item.getProduct() instanceof Deliverable) {
                Deliverable deliverable = (Deliverable) item.getProduct();
                totalWeight += deliverable.getWeight() * item.getQuantity();
            } else {
                throw new IllegalArgumentException("Item is not deliverable: " + item.getProduct().getName());
            }
        }

        totalWeight /= 1000;

        return totalWeight * SHIPPING_RATE;
    }

    public static void ship(List<CartItem> items) {
        if (items.isEmpty()) {
            throw new IllegalArgumentException("No items to ship");
        }

        shippingCost(items); // just to make sure all items are deliverable 

        System.out.println("** Shipment notice **");

        double totalWeight = 0;

        for (CartItem item : items) {
            Deliverable product = (Deliverable) item.getProduct();
            int quantity = item.getQuantity();

        System.out.printf("%dx %-12s\t", quantity, product.getName());
        System.out.printf("%.0fg\n", product.getWeight() * quantity);

            totalWeight += product.getWeight() * quantity;
        }

        System.out.printf("Total package weight %.3fkg\n\n", totalWeight / 1000);
    }

}
