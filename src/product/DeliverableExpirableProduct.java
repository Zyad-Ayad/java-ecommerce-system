package product;

import java.time.LocalDate;
public class DeliverableExpirableProduct extends ExpirableProduct implements Deliverable {
    private double weight;

    public DeliverableExpirableProduct(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    
}
