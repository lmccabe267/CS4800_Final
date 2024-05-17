public class Meal {
    private String name;
    private String[] toppings;
    private int fats;
    private int carbs;
    private int protein;

    public Meal(String name, String[] toppings, int fats, int carbs, int protein) {
        this.name = name;
        this.toppings = toppings;
        this.fats = fats;
        this.carbs = carbs;
        this.protein = protein;
    }

	public String getName() {
		return name;
	}

	public String[] getToppings() {
		return toppings;
	}

	public int getFats() {
		return fats;
	}

	public int getCarbs() {
		return carbs;
	}

	public int getProtein() {
		return protein;
	}
    
    
}
