public class Recipe {
	String name;
	double price;
	int timesSold;
	public Ingredients ingredients;

	public Recipe() {

		ingredients = new Ingredients();
		for (int i = 0; i < ingredients.myItems.length; i++) {
			ingredients.setItemAmount(ingredients.myItems[i], 0);
		}
		name = "";
		price = 0.0;
		timesSold = 0;
	}

	public Recipe(String name, double price, int sugar, int milk, int coffee,
			int chocolate, int bouillon) {
		ingredients = new Ingredients();
		ingredients.setItemAmount(ingredients.myItems[0], sugar);
		ingredients.setItemAmount(ingredients.myItems[1], milk);
		ingredients.setItemAmount(ingredients.myItems[2], coffee);
		ingredients.setItemAmount(ingredients.myItems[3], chocolate);
		ingredients.setItemAmount(ingredients.myItems[4], bouillon);
		this.name = name;
		this.price = price;
		timesSold = 0;
	}
	
	/**
	 * Public method to return the change to the user. 
	 * @param money received
	 * @param change given
	 * 
	 */
	public double getChange(final double money) {
		return money - this.price;
	}
}