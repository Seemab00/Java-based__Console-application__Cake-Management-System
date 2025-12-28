package ccakeordermanagementsystem;
import java.util.*;
import java.io.*;
public class Menu {
private List<Customer> customers;
private List<Admin> admins;
private List<Order> orders;
private List<Cake> cakes;

public Menu() {
customers = new ArrayList<>();
admins = new ArrayList<>();
orders = new ArrayList<>();
cakes = new ArrayList<>();
initializeCakes();
}

private void initializeCakes() {
cakes.add(new ChocolateCake(900));
cakes.add(new VanillaCake(900));
cakes.add(new StrawberryCake(900));
}

public void registerCustomer(Customer customer) {
customers.add(customer);
System.out.println("~~ Registration Completed ~~");
}

public Customer loginCustomer(String username, String
password) {
for (Customer customer : customers) {
if (customer.getUsername().equals(username)) {
if (customer.getpassword().equals(password)) {
return customer;
} else {
System.out.println("Invalid password.");
return null;
}
}
}
System.out.println("Customer not found.");
return null;
}
public void registerAdmin(Admin admin) {
admins.add(admin);
System.out.println("~~ Admin Registration Completed ~~");
}
public Admin loginAdmin(String username, String password)
{
for (Admin admin : admins) {
if (admin.getUsername().equals(username)) {
if (admin.getpassword().equals(password)) {
return admin;
} else {
System.out.println("Invalid password.");
return null;
}
}
}
System.out.println("Admin not found.");
return null;
}
public void placeOrder(Customer customer, String
cakeFlavour, int quantity) {
Cake selectedCake = null;
for (Cake cake : cakes) {
if (cake.getFlavour().equalsIgnoreCase(cakeFlavour)) {
selectedCake = cake;
break;
}
}
if (selectedCake != null) {
Order order = new Order(cakeFlavour, quantity, selectedCake.getPrice(), customer);
orders.add(order);
customer.addOrder(order);
System.out.println("~~ Order Placed ~~");
order.displayDetails();
} else {
System.out.println("Invalid cake flavour selected.");
}
}
public void viewOrders(Customer customer) {
for (Order order : customer.getOrders()) {
order.displayDetails();
}
}
public void updateOrder(int orderId, String cakeFlavour, int
quantity, double price) {
for (Order order : orders) {
if (order.getOrderId() == orderId) {
order.updateOrder(cakeFlavour, quantity, price);
System.out.println("~~ Order Updated ~~");
order.displayDetails();
return;
}
}
System.out.println("Order not found.");
}
public void deleteOrder(int orderId) {
orders.removeIf(order -> order.getOrderId() == orderId);
System.out.println("~~ Order Deleted Successfully ~~");
}
public void viewAllOrders() {
for (Order order : orders) {
order.displayDetails();
}
}
public void viewAllCustomers() {
for (Customer customer : customers) {
customer.displayDetails();
}
}
public void updateCustomerDetails(String username, String
name, String contactNumber, int age, Address address) {
for (Customer customer : customers) {
if (customer.getUsername().equals(username)) {
customer.setName(name);
customer.setContactNumber(contactNumber);
customer.setAge(age);
customer.setAddress(address);
System.out.println("~~ Customer Details Updated ~~");
return;
}
}
System.out.println("Customer not found.");
}
public void deleteCustomer(String username) {
customers.removeIf(customer ->
customer.getUsername().equals(username));
System.out.println("~~ Customer Deleted Successfully ~~");
}
// Main Menu
public void mainMenu() {
Scanner scanner = new Scanner(System.in);
while (true) {
System.out.println("---------------------------");
System.out.println("|                         |");
System.out.println("|      -- You are --      |");
System.out.println("|                         |");
System.out.println("|      1. Customer        |");
System.out.println("|      2. Admin           |");
System.out.println("|      3. Exit            |");
System.out.println("|                         |");
System.out.println("---------------------------");
System.out.print("Enter your choice (1 - 3): ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume newline
switch (choice) {
case 1: customerMenu();
break;
case 2: adminMenu();
break;
case 3: System.out.println("Exiting...");
return;
default: System.out.println("Invalid choice. Please try again.");
}
}
}
private void customerMenu() {
Scanner scanner = new Scanner(System.in);
while (true) {
System.out.println("---------------------------");
System.out.println("|                         |");
System.out.println("|    -- You Want to --    |");
System.out.println("|                         |");
System.out.println("|     1. Register         |");
System.out.println("|     2. Login            |");
System.out.println("|     3. Exit             |");
System.out.println("|                         |");
System.out.println("---------------------------");
System.out.print("Enter your choice (1 - 3): ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume newline
switch (choice) {
case 1: registerCustomer();
break;
case 2: loginCustomer();
break;
case 3: System.out.println("Returning to main menu...");
return;
default: System.out.println("Invalid choice. Please try again.");
}
}
}
private void registerCustomer() {
Scanner scanner = new Scanner(System.in);
System.out.println("-----------------------------------------------------------------");
System.out.println("|                                                               |");
System.out.println("|   -- You're Required to give the following Information --     |");
System.out.println("|                                                               |");
System.out.print("|               1. Name: ");
String name = scanner.nextLine();
System.out.print("|               2. Age: ");
int age = scanner.nextInt();
scanner.nextLine(); // Consume newline
System.out.print("|               3. Contact no.: ");
String contactNumber = scanner.nextLine();
System.out.print("|               4. House no.: ");
String houseNumber = scanner.nextLine();
System.out.print("|               5. Street no.: ");
String streetNumber = scanner.nextLine();
System.out.print("|               6. City: ");
String city = scanner.nextLine();
System.out.print("|               7. User-name: ");
String username = scanner.nextLine();
System.out.print("|               8. Password: ");
String password = scanner.nextLine();
System.out.println("|                                                               |");
System.out.println("|                  ~~ Registration Completed ~~                 |");
System.out.println("|                                                               |");
System.out.println("-----------------------------------------------------------------");
Address address = new Address(houseNumber, streetNumber, city);
Customer customer = new Customer(name, contactNumber, age, address, username, password);
registerCustomer(customer);
}
private void loginCustomer() {
Scanner scanner = new Scanner(System.in);
System.out.println("---------------------------------------------------------");
System.out.println("|                                                       |");
System.out.println("|              -- Enter the following --                |");
System.out.println("|                                                       |");
System.out.print("|                  1. User-name: ");
String username = scanner.nextLine();
System.out.print("|                  2. Password: ");
String password = scanner.nextLine();
System.out.println("|                                                       |");
System.out.println("---------------------------------------------------------");
Customer customer = loginCustomer(username, password);
if (customer != null) {
customerOrderMenu(customer);
}
}
private void customerOrderMenu(Customer customer) {
Scanner scanner = new Scanner(System.in);
while (true) {
System.out.println("--------------------------------------------------");
System.out.println("|                                                |");
System.out.println("|                -- Your Menu --                 |");
System.out.println("|                                                |");
System.out.println("|                1. Place Order                  |");
System.out.println("|                2. View Orders                  |");
System.out.println("|                3. Logout                       |");
System.out.println("|                                                |");
System.out.println("--------------------------------------------------");
System.out.print("Enter your choice (1 - 3): ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume newline
while (true) {
System.out.println("--------------------------------------------------");
System.out.println("|                                                |");
System.out.println("|                   -- Your Menu --              |");
System.out.println("|                                                |");
System.out.println("|         1. Chocolate cake       Rs.900         |");
System.out.println("|         2. Vanilla cake         Rs.900         |");
System.out.println("|         3. Strawberry cake      Rs.900         |");
System.out.println("|                                                |");
System.out.println("--------------------------------------------------");
System.out.print("Enter your choice (1 - 3): ");
int option = scanner.nextInt();
scanner.nextLine(); // Consume newline
Cake selectedCake = null;
switch (option) {
case 1 : selectedCake = new ChocolateCake(900);
break;
case 2 : selectedCake = new VanillaCake(900);
break;
case 3 : selectedCake = new StrawberryCake(900);
break;
default : {
System.out.println("Invalid choice. Please try again.");
continue; // Restart the loop
}
}
System.out.print("Enter the Quantity: ");
int quantity = scanner.nextInt();
scanner.nextLine(); // Consume newline
placeOrder(customer, selectedCake.getFlavour(), quantity);
System.out.print("Do you want to view your order(yes/no): ");
if (scanner.nextLine().equalsIgnoreCase("yes")) {
viewOrders(customer);
}
System.out.print("Do you want to update your order(yes/no): ");
if (scanner.nextLine().equalsIgnoreCase("yes")) {
System.out.print("Enter the Order ID to update: ");
int orderId = scanner.nextInt();
scanner.nextLine(); // Consume newline
System.out.print("Enter new Cake Flavour: ");
String newFlavour = scanner.nextLine();
System.out.print("Enter new Quantity: ");
int newQuantity = scanner.nextInt();
scanner.nextLine(); // Consume newline
System.out.print("Enter new Price: ");
double newPrice = scanner.nextDouble();
scanner.nextLine(); // Consume newline
updateOrder(orderId, newFlavour, newQuantity, newPrice);
}
System.out.print("Do you want to delete your order(yes/no): ");
if (scanner.nextLine().equalsIgnoreCase("yes")) {
System.out.print("Enter the Order ID to delete: ");
int orderId = scanner.nextInt();
scanner.nextLine(); // Consume newline
deleteOrder(orderId);
}
System.out.print("Do you want to exit to customer menu(yes/no): ");
if (scanner.nextLine().equalsIgnoreCase("yes")) {
return;
}
System.out.print("Do you want to place another order(yes/no): ");
if (!scanner.nextLine().equalsIgnoreCase("yes")) {
break;
}
}
}
}
private void adminMenu() {
Scanner scanner = new Scanner(System.in);
while (true) {
System.out.println("---------------------------");
System.out.println("|                         |");
System.out.println("|     -- Admin Menu --    |");
System.out.println("|                         |");
System.out.println("|     1. Login            |");
System.out.println("|     2. Register         |");
System.out.println("|     3. Exit             |");
System.out.println("|                         |");
System.out.println("---------------------------");
System.out.print("Enter your choice (1 - 3): ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume newline
switch (choice) {
case 1: loginAdmin();
break;
case 2: registerAdmin();
break;
case 3: System.out.println("Returning to main menu...");
return;
default: System.out.println("Invalid choice. Please try again.");
}
}
}
private void registerAdmin() {
Scanner scanner = new Scanner(System.in);
System.out.println("-----------------------------------------------------------------");
System.out.println("|                                                               |");
System.out.println("|                  -- Admin Registration --                     |");
System.out.println("|                                                               |");
System.out.print("|             Enter Admin Name: ");
String name = scanner.nextLine();
System.out.print("|             Enter Admin Username: ");
String username = scanner.nextLine();
System.out.print("|             Enter Admin Password: ");
String password = scanner.nextLine();
System.out.print("|             Enter Admin Contact Number: ");
String contactNumber = scanner.nextLine();
System.out.println("|                                                               |");
System.out.println("|                ~~ Admin Registration Completed ~~             |");
System.out.println("|                                                               |");
System.out.println("-----------------------------------------------------------------");
// Create an instance of Admin with the provided details
Admin admin = new Admin(name, contactNumber, username, password );
// Register the admin
registerAdmin(admin);
}
private void loginAdmin() {
Scanner scanner = new Scanner(System.in);
System.out.println("---------------------------------------------------------");
System.out.println("|                                                       |");
System.out.println("|             -- Enter the following --                 |");
System.out.println("|                                                       |");
System.out.print("|                  1. User-name: ");
String username = scanner.nextLine();
System.out.print("|                  2. Password: ");
String password = scanner.nextLine();
System.out.println("|                                                       |");
System.out.println("---------------------------------------------------------");
Admin admin = loginAdmin(username, password);
if (admin != null) {
adminManagementMenu(admin);
}
}
private void adminManagementMenu(Admin admin) {
Scanner scanner = new Scanner(System.in);
while (true) {
System.out.println("------------------------------------------------");
System.out.println("|                                              |");
System.out.println("|                -- Your Menu --               |");
System.out.println("|                                              |");
System.out.println("|               1. Update Order                |");
System.out.println("|               2. Delete Order                |");
System.out.println("|               3. View All Orders             |");
System.out.println("|               4. View All Customers          |");
System.out.println("|               5. Update Customer Details     |");
System.out.println("|               6. Delete Customer             |");
System.out.println("|               7. Logout                      |");
System.out.println("|                                              |");
System.out.println("------------------------------------------------");
System.out.print("Enter your choice (1 - 7): ");
int choice = scanner.nextInt();
scanner.nextLine(); // Consume newline
switch (choice) {
case 1: updateOrder();
break;
case 2: deleteOrder();
break;
case 3: viewAllOrders();
break;
case 4: viewAllCustomers();
break;
case 5: updateCustomerDetails();
break;
case 6: deleteCustomer();
break;
case 7: System.out.println("Logging out...");
return;
default: System.out.println("Invalid choice. Please try again.");
}
}
}
private void updateOrder() {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter Order ID to update: ");
int orderId = scanner.nextInt();
scanner.nextLine(); // Consume newline
System.out.print("Enter new cake flavour: ");
String cakeFlavour = scanner.nextLine();
System.out.print("Enter new quantity: ");
int quantity = scanner.nextInt();
System.out.print("Enter new price: ");
double price = scanner.nextDouble();
scanner.nextLine(); // Consume newline
updateOrder(orderId, cakeFlavour, quantity, price);
}
private void deleteOrder() {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter Order ID to delete: ");
int orderId = scanner.nextInt();
scanner.nextLine(); // Consume newline
deleteOrder(orderId);
}
private void updateCustomerDetails() {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter Customer Username to update: ");
String username = scanner.nextLine();
System.out.print("Enter new name: ");
String name = scanner.nextLine();
System.out.print("Enter new contact number: ");
String contactNumber = scanner.nextLine();
System.out.print("Enter new age: ");
int age = scanner.nextInt();
scanner.nextLine(); // Consume newline
System.out.print("Enter new house number: ");
String houseNumber = scanner.nextLine();
System.out.print("Enter new street number: ");
String streetNumber = scanner.nextLine();
System.out.print("Enter new city: ");
String city = scanner.nextLine();
Address address = new Address(houseNumber, streetNumber, city);
updateCustomerDetails(username, name, contactNumber, age, address);
}
private void deleteCustomer() {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter Customer Username to delete: ");
String username = scanner.nextLine();
deleteCustomer(username);
}
}