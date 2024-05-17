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
    
    private String getMealString() {
    	String str = "";
    	for(Meal meal: meals) {
    		str += meal.getName() + "\n";
    	}
    	return str;
    }
    
    public String toString() {
    	String str = "Customer: " + customer.getName() + "\nRestaurant: " + restaurant.getName() + "\nMeals: " + getMealString() + "Driver: " + driver.getName();
    	return str;
    }
}
