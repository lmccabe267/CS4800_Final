import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

public class Restaurant extends Person {
    private String cuisineType;
    private LocalTime openTime;
    private LocalTime closeTime;
    private ArrayList<Meal> menu = new ArrayList<Meal>();

    public Restaurant(String name, String address, String county, String cuisineType, LocalTime openTime, LocalTime closeTime) {
        super(name, address, county);
        this.cuisineType = cuisineType;
        this.openTime = openTime;
        this.closeTime = closeTime;
        
        // Add Random Meals
        String[] mealNames = {"Pasta Bolognese", "Chicken Curry", "Vegetable Stir Fry", "Beef Tacos", "Salmon Salad", "Veggie Burger", "Shrimp Paella", "Lamb Kebabs", "Quinoa Salad", "Pork Schnitzel"};
        String[] allToppings = {"Cheese", "Olives", "Tomatoes", "Lettuce", "Onions", "Peppers", "Mushrooms", "Bacon", "Cilantro", "Avocado"};
        Random random = new Random();

        for(int i = 0; i < 10; i++) {
            // Generate a random index and select a meal name
            String randomName = mealNames[random.nextInt(mealNames.length)];
            String[] randomToppings = new String[3];
            for (int z = 0; z < 3; z++) {
                int index = random.nextInt(allToppings.length);
                randomToppings[z] =
                		allToppings[index];
            }
            
            this.addMenuItem(new Meal(randomName, randomToppings, 0, 0, 0));
        }
        
    }

    public boolean isOpen() {
        LocalTime now = LocalTime.now();
        return !now.isBefore(openTime) && !now.isAfter(closeTime);
    }

	public String getCuisineType() {
		return cuisineType;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public ArrayList<Meal> getMenu() {
		return menu;
	}
	
	public boolean addMenuItem(Meal item) {
		menu.add(item);
		
		return true;
	}
    
    
}
