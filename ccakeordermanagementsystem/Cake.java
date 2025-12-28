package ccakeordermanagementsystem;

public class Cake {
    private String flavour;
    private double price;

    public Cake(String flavour, double price) {
        this.flavour = flavour;
        this.price = price;
    }

    public String getFlavour() {
        return flavour;
    }

    public double getPrice() {
        return price;
    }
}