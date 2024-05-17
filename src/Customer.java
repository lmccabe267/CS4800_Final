public class Customer extends Person {
    private String dietaryRestrictions;

    public Customer(String name, String address, String county, String dietaryRestrictions) {
        super(name, address, county);
        this.dietaryRestrictions = dietaryRestrictions;
    }
}
