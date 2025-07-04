import customer.Customer;
import cart.Cart;
import service.Checkout;
import product.DeliverableProduct;
import product.ExpirableProduct;
import product.DeliverableExpirableProduct;
import product.Product;
import java.time.LocalDate;


public class App {
    public static void main(String[] args) throws Exception {
        Customer customer = new Customer("Zyad M. Ayad", 999999);

        // deliverable products
        DeliverableProduct laptop = new DeliverableProduct("Laptop", 1500, 5, 2000);
        DeliverableProduct phone = new DeliverableProduct("Phone", 500, 10, 300);
        DeliverableProduct tablet = new DeliverableProduct("Tablet", 800, 8, 500);
        // expirable Deliverable products
        DeliverableExpirableProduct milk = new DeliverableExpirableProduct("Milk", 2, 100, LocalDate.of(2025, 10, 30), 1000);
        DeliverableExpirableProduct bread = new DeliverableExpirableProduct("Bread", 1, 50, LocalDate.of(2025, 10, 25), 500);
        // normal products
        Product bookPDF = new Product("Book", 20, 30);
        // Expirable product that is not deliverable 
        ExpirableProduct phoneCard = new ExpirableProduct("Phone Card", 10, 20, LocalDate.of(2025, 11, 1));

        // create a cart
        Cart cart = new Cart();
        // add items to the cart
        cart.addItem(laptop, 1);
        cart.addItem(phone, 2);
        cart.addItem(tablet, 1);
        cart.addItem(milk, 5);
        cart.addItem(bread, 10);
        cart.addItem(bookPDF, 3);
        cart.addItem(phoneCard, 20);

        //checkout

        try {
            Checkout.checkout(customer, cart);
        } catch (IllegalArgumentException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }


    }
}
