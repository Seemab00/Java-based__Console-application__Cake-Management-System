package ccakeordermanagementsystem;

public class Order {
    private static int idCounter = 1;
    private int orderId;
    private String cakeFlavour;
    private int quantity;
    private double price;
    private Customer customer;

    public Order(String cakeFlavour, int quantity, double price, Customer customer) {
        this.orderId = idCounter++;
        this.cakeFlavour = cakeFlavour;
        this.quantity = quantity;
        this.price = price;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCakeFlavour() {
        return cakeFlavour;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void updateOrder(String cakeFlavour, int quantity, double price) {
        this.cakeFlavour = cakeFlavour;
        this.quantity = quantity;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Cake Flavour: " + cakeFlavour);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: Rs. " + price);
        System.out.println("Total Price: Rs. " + getTotalPrice());
    }
}