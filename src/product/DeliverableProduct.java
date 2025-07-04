package product;

public class DeliverableProduct extends Product implements Deliverable {
    private double weight;

    public DeliverableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

}
