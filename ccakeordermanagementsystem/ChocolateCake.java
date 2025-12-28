package ccakeordermanagementsystem;

public class ChocolateCake extends Cake {
    public ChocolateCake(double price) {
        super("Chocolate", price);
    }

    public void displayDetails() {
        System.out.println("Chocolate Cake - Price: " + getPrice());
    }
}