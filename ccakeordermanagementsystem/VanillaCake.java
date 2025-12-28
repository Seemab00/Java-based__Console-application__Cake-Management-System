package ccakeordermanagementsystem;

public class VanillaCake extends Cake {
    public VanillaCake(double price) {
        super("Vanilla", price);
    }

    public void displayDetails() {
        System.out.println("Vanilla Cake - Price: " + getPrice());
    }
}