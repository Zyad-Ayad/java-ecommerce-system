package cart;

import product.Product;

public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (product.isExpired()) {
            throw new IllegalArgumentException("Cannot add expired product to cart");
        }
        if (!product.isAvailable(quantity)) {
            throw new IllegalArgumentException("Insufficient quantity available for product: " + product.getName());
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        if (!product.isAvailable(quantity+ this.quantity)) {
            throw new IllegalArgumentException("Insufficient quantity available for product: " + product.getName());
        }
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("Cannot remove more than available quantity");
        }
        this.quantity -= quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
