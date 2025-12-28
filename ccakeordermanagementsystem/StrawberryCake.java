package ccakeordermanagementsystem;

public class StrawberryCake extends Cake {
    public StrawberryCake(double price) {
        super("Strawberry", price);
    }

    public void displayDetails() {
        System.out.println("Strawberry Cake - Price: " + getPrice());
    }
}