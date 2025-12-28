package ccakeordermanagementsystem;

public class Admin extends Person implements User {
    private String username;
    private String password;

    public Admin(String name, String contactNumber, String username, String password) {
        super(name, contactNumber);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getpassword() {
        return password;
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
        System.out.println("Contact Number: " + getContactNumber());
    }
}