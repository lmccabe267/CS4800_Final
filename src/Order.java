import java.time.LocalDateTime;

public class Order {
    private Restaurant restaurant;
    private Customer customer;
    private Meal[] meals;
    private Driver driver;
    private LocalDateTime orderCreateTime;
    private LocalDateTime pickUpTime;
    private LocalDateTime deliveryTime;

    public Order(Restaurant restaurant, Customer customer, Meal[] meals, Driver driver) {
        if (restaurant.isOpen() && driver.isAvailable()) {
            this.restaurant = restaurant;
            this.customer = customer;
            this.meals = meals;
            this.driver = driver;
            this.orderCreateTime = LocalDateTime.now();
        } else {
            throw new IllegalStateException("Order cannot be created. Restaurant or driver not available.");
        }
    }

    public void setPickUpTime() {
        this.pickUpTime = LocalDateTime.now();
    }

    public void setDeliveryTime() {
        this.deliveryTime = LocalDateTime.now();
    }
}
