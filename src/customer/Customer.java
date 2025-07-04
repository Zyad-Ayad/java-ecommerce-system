package customer;

public class Customer {
    private String name;
    double balance;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }
    public void subtractBalance(double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }

    public String getName() {
        return name;
    }


}
