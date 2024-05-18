import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CPPFoodDelivery {
    private List<Customer> customers = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();
    private List<Restaurant> restaurants = new ArrayList<>();

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void listAllDrivers() {
        drivers.forEach(driver -> System.out.println(driver.getName() + " - " + driver.getCounty() + " Shift: " + driver.getShiftStart() + " to " + driver.getShiftEnd()));
    }

    public void listAvailableDrivers() {
        drivers.stream()
            .filter(Driver::isAvailable)
            .forEach(driver -> System.out.println(driver.getName() + " - Available for shift."));
    }

    public void listRestaurants() {
        restaurants.forEach(restaurant -> System.out.println(restaurant.getName() + " - Cuisine: " + restaurant.getCuisineType() + " Hours: " + restaurant.getOpenTime() + " to " + restaurant.getCloseTime() + " - County: " + restaurant.getCounty()));
    }

    public void placeOrder(Scanner scanner) {
        System.out.println("Select a restaurant by number:");
        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + " - " + restaurants.get(i).getName());
        }
        int restaurantChoice = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline left-over

        Restaurant chosenRestaurant = restaurants.get(restaurantChoice);
        if (!chosenRestaurant.isOpen()) {
            System.out.println("Sorry, the restaurant is currently closed.");
            return;
        }

        ArrayList<Meal> menu = chosenRestaurant.getMenu();
        System.out.println("Select meals by numbers (comma-separated, no spaces):");
        for (int i = 0; i < menu.size(); i++) {
            Meal meal = menu.get(i);
            System.out.println((i + 1) + " - " + meal.getName() + " (Fats: " + meal.getFats() + ", Carbs: " + meal.getCarbs() + ", Protein: " + meal.getProtein() + ")");
        }
        String[] mealChoices = scanner.nextLine().split(",");
        ArrayList<Meal> selectedMeals = new ArrayList<>();
        for (String choice : mealChoices) {
            int mealIndex = Integer.parseInt(choice.trim()) - 1;
            selectedMeals.add(menu.get(mealIndex));
        }

        System.out.println("Select a customer by number:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + " - " + customers.get(i).getName());
        }
        int customerChoice = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline left-over

        Customer chosenCustomer = customers.get(customerChoice);

        List<Driver> availableDrivers = drivers.stream()
            .filter(driver -> driver.isAvailable() && driver.getCounty().equals(chosenRestaurant.getCounty()))
            .collect(Collectors.toList());
        
        if (availableDrivers.isEmpty()) {
            System.out.println("No available drivers in the restaurant's county.");
            return;
        }

        System.out.println("Select a driver by number:");
        for (int i = 0; i < availableDrivers.size(); i++) {
            System.out.println((i + 1) + " - " + availableDrivers.get(i).getName());
        }
        int driverChoice = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline left-over

        Driver chosenDriver = availableDrivers.get(driverChoice);

        Meal[] mealsArray = new Meal[selectedMeals.size()];
        selectedMeals.toArray(mealsArray);
        Order newOrder = new Order(chosenRestaurant, chosenCustomer, mealsArray, chosenDriver);
        newOrder.setPickUpTime();
        newOrder.setDeliveryTime();
        System.out.println("Order placed successfully.");
        System.out.println("Order Details: " + newOrder);
    }


    public static void main(String[] args) {
        CPPFoodDelivery platform = new CPPFoodDelivery();

        // Create and register restaurants
        Restaurant r1 = new Restaurant("Taco Bell", "123 Taco Way", "LA County", "Mexican", LocalTime.of(8, 0), LocalTime.of(22, 0));
        Restaurant r2 = new Restaurant("Thai Spice", "456 Pad Thai Rd", "Orange County", "Thai", LocalTime.of(10, 0), LocalTime.of(20, 0));
        Restaurant r3 = new Restaurant("Burger House", "789 Burger Blvd", "LA County", "American", LocalTime.of(11, 0), LocalTime.of(23, 0));
        Restaurant r4 = new Restaurant("Sushi Land", "321 Sushi St", "San Bernardino County", "Japanese", LocalTime.of(9, 0), LocalTime.of(21, 0));
        platform.registerRestaurant(r1);
        platform.registerRestaurant(r2);
        platform.registerRestaurant(r3);
        platform.registerRestaurant(r4);

        // Create and register drivers
        Driver d1 = new Driver("John Doe", "111 Driver Lane", "LA County", 1);
        Driver d2 = new Driver("Jane Smith", "222 Driver Lane", "Orange County", 2);
        Driver d3 = new Driver("Jim Beam", "333 Driver Lane", "San Bernardino County", 3);
        Driver d4 = new Driver("Jill Hill", "444 Driver Lane", "LA County", 1);
        Driver d5 = new Driver("Liam McCabe", "555 Driver Lane", "LA County", 1);
        Driver d6 = new Driver("Brian Baker", "666 Driver Lane", "Orange Countyy", 2);
        Driver d7 = new Driver("Estevan Delgado", "777 Driver Lane", "San Bernardino County", 3);
        Driver d8 = new Driver("Michael Chon", "888 Driver Lane", "Orange County", 2);
        platform.registerDriver(d1);
        platform.registerDriver(d2);
        platform.registerDriver(d3);
        platform.registerDriver(d4);
        platform.registerDriver(d5);
        platform.registerDriver(d6);
        platform.registerDriver(d7);
        platform.registerDriver(d8);

        // Create and register customers
        Customer c1 = new Customer("Alice Wonderland", "123 Main St", "LA County", "None");
        Customer c2 = new Customer("Bob Builder", "456 Main St", "Orange County", "Vegetarian");
        Customer c3 = new Customer("Charlie Brown", "789 Main St", "San Bernardino County", "Gluten-Free");
        Customer c4 = new Customer("Daisy Duck", "101 Main St", "LA County", "Vegan");
        platform.registerCustomer(c1);
        platform.registerCustomer(c2);
        platform.registerCustomer(c3);
        platform.registerCustomer(c4);

        // Simulate order placements
//        try {
//            Meal[] meals = new Meal[]{new Meal("Burrito", new String[]{"Cheese", "Sour Cream"}, 30, 40, 20)};
//            Order order = new Order(r1, c1, meals, d1);
//            order.setPickUpTime();
//            order.setDeliveryTime();
//            System.out.println("Order placed successfully.");
//        } catch (IllegalStateException e) {
//            System.out.println(e.getMessage());
//        }
        
        Scanner scanner = new Scanner(System.in);

        // Initialization of entities goes here (omitted for brevity)

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1 - List all drivers");
            System.out.println("2 - List available drivers");
            System.out.println("3 - List all restaurants");
            System.out.println("4 - Place an order");
            System.out.println("0 - Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    platform.listAllDrivers();
                    break;
                case 2:
                    platform.listAvailableDrivers();
                    break;
                case 3:
                    platform.listRestaurants();
                    break;
                case 4:
                    platform.placeOrder(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
