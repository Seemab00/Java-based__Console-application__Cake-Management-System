package ccakeordermanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person implements User {
    private int age;
    private Address address;
    private String username;
    private String password;
    private List<Order> orders;

    public Customer(String name, String contactNumber, int age, Address address, String username, String password) {
        super(name, contactNumber);
        this.age = age;
        this.address = address;
        this.username = username;
        this.password = password;
        this.orders = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getpassword() {
        return password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("~~ Logged in Successfully ~~");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Age: " + age);
        System.out.println("Contact Number: " + getContactNumber());
        address.displayDetails();
    }
}