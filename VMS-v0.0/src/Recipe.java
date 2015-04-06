public class Recipe {
	String name;
	double price;
	int sugar;
	int milk;
	int coffee;
	int chocolate;
	int bouillon;
	int timesSold;

	public Recipe() {
		name = "";
		price = 0.0;
		sugar = 0;
		milk = 0;
		coffee = 0;
		chocolate = 0;
		bouillon = 0;
		timesSold = 0;
	}

	public Recipe(String name, double price, int sugar, int milk, int coffee,
			int chocolate, int bouillon) {
		this.name = name;
		this.price = price;
		this.sugar = sugar;
		this.milk = milk;
		this.coffee = coffee;
		this.chocolate = chocolate;
		this.bouillon = bouillon;
		timesSold = 0;
	}
}