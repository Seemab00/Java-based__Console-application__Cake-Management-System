package ccakeordermanagementsystem;

public class Address {
    private String houseNumber;
    private String streetNumber;
    private String city;

    public Address(String houseNumber, String streetNumber, String city) {
        this.houseNumber = houseNumber;
        this.streetNumber = streetNumber;
        this.city = city;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void displayDetails() {
        System.out.println("House Number: " + houseNumber);
        System.out.println("Street Number: " + streetNumber);
        System.out.println("City: " + city);
    }
}