package service;
import customer.Customer;
import cart.Cart;
import cart.CartItem;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import product.Deliverable;
public class Checkout {

    private Checkout() {} // so no one can create an object of this class (static)

    public static void checkout(Customer customer, Cart cart) {
        if (cart.getItems().isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        // before starting i will check if the customer has enough balance, and if all items are available and not expired
        
        double totalPrice = cart.getTotalPrice();
        if (customer.getBalance() < totalPrice) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        for (CartItem item : cart.getItems()) {
            if (!item.getProduct().isAvailable(item.getQuantity())) {
                throw new IllegalArgumentException("Insufficient quantity available for product: " + item.getProduct().getName());
            }
            if (item.getProduct().isExpired()) {
                throw new IllegalArgumentException("Cannot checkout expired product: " + item.getProduct().getName());
            }
        }


        // shiiping itms LIST
        List<CartItem> deliverableItems = cart.getItems().stream()
            .filter(item -> item.getProduct() instanceof Deliverable)
            .collect(Collectors.toList());
        
        double shippingCost = 0;
        if (!deliverableItems.isEmpty()) {
            shippingCost = Shipping.shippingCost(deliverableItems);
        }

        if (customer.getBalance() < totalPrice + shippingCost) {
            throw new IllegalArgumentException("Insufficient balance after adding shipping cost");
        }

        customer.subtractBalance(totalPrice);

        if (!deliverableItems.isEmpty()) {
            Shipping.ship(deliverableItems);
        }

        System.out.println("** Checkout notice **");

        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s\t", item.getQuantity(), item.getProduct().getName());
            System.out.printf("%.2f\n", item.getTotalPrice());
            item.getProduct().subtractQuantity(item.getQuantity());
        }

        System.out.println("-------------------\n");
        
        //subtotal 
        System.out.printf("Subtotal: %.2f\n", totalPrice);
        if (shippingCost > 0) {
            System.out.printf("Shipping cost: %.2f\n", shippingCost);
        }
        double total = totalPrice + shippingCost;
        System.out.printf("Total: %.2f\n", total);
        
    }
}
