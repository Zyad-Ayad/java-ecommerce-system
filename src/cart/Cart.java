package cart;
import java.util.ArrayList;
import java.util.List;
import product.Product;
public class Cart {

    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product item, int quantity) {
        // first check if the there are any items of this item type in the cart
        for (CartItem cartItem : items) {
            if (cartItem.getProduct().equals(item)) {
                cartItem.getProduct().addQuantity(quantity);
                return;
            }
        }

        // creat a new CartItem if not found
        CartItem newItem = new CartItem(item, quantity);
        items.add(newItem);
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public List<CartItem> getItems() {
        return items;
    }

}
