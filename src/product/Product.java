package product;


public class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    
    public void subtractQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            throw new IllegalArgumentException("Insufficient quantity available.");
        }
    }

    public boolean isAvailable(int quantity) {
        return this.quantity >= quantity;
    }

    public boolean isExpired() {
        return false; // i will override this in expirable products later
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
}
