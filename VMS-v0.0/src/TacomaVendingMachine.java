import java.*;
import java.io.*;
import java.util.*;
import java.text.*;

class TacomaVendingMachine {
	Recipe[] recipeArray;
	Ingredients data = new Ingredients();
	int i = 0;
	double money = 0;
	double extra = 0;
	double difference = 0;
	int item = 0;
	int totalDrinksSold = 0;
	public BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));
	public PrintStream ps;

	public TacomaVendingMachine() {
		clearAll();
		startVend();
	}

	/**
	 * 
	 */
	public void startVend() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(" TACOMA VENDING MACHINE ");
		System.out.println(" version 1.2 ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		mainMenu();
	}

	public void setSystemIn(boolean withInputStream, ByteArrayInputStream b1,
			PrintStream ps1) {
		if (withInputStream) {
			System.setIn(b1);
			ps = ps1;
		}
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void clearAll() {
		// Deleting recipes
		recipeArray = new Recipe[6];

		// Deleting stock
		data = new Ingredients();

		// Deleting history
		totalDrinksSold = 0;
	}

	public void AddInventory() {

		System.out.println("");
		System.out.println("");

		try {
			for (int i = 0; i < data.myItems.length; i++) {
				data.setItemAmount(data.myItems[i],
						addInventoryItem(data.myItems[i]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("Inventory added, thank you");
		mainMenu();

	}

	/**
	 * @throws IOException
	 */
	public int addInventoryItem(final String theItemName) throws IOException {
		String line;
		int item_units = 0;
		System.out.println("Enter units of " + theItemName + ": ");
		try {
			line = br.readLine();
			item_units = Integer.parseInt(line);
			// data.setUnits_sug(data.getUnits_sug() + Integer.parseInt(line));

		} catch (NumberFormatException n) {
			System.out
					.println("Please enter an amount next time, going back to Main Menu");
			mainMenu();

		} catch (NullPointerException e) {
			System.out.println("No data is bad data...");
			System.out.println("Back to main menu");
			mainMenu();
		}
		return item_units;
	}

	public void CheckInventory() {
		System.out.println("");
		for (int i = 0; i < data.myItems.length; i++) {
			System.out.println(data.myItems[i] + ": "
					+ data.getItemAmount(data.myItems[i]));
		}
		System.out.println("");
		mainMenu();
		return;
	}

	public int checkRecipes() {
		for (int i = 0; i < 6; i++) {
			if (recipeArray[i] == null) {
				return i;
			}
		}
		return 13;
	}// end checkRecipes
		// adds a recipe

	private double getRecipePrice() {
		System.out.println("Enter price of recipe, in decimal format (0.00):");
		System.out.print("$ ");
		double price = 0;
		try {
			price = Double.parseDouble(br.readLine());

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		return price;
	}

	private String getRecipeName() {
		String temp = null;
		System.out.println("");
		System.out.println("Enter name of recipe:");
		try {
			temp = br.readLine();
			if (temp == null) {
				System.out
						.println("Please enter a name next time, going back to Main Menu");
				mainMenu();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}

	private Recipe setRecipeInfo() {

		Recipe newRecipe = new Recipe();
		newRecipe.price = getRecipePrice();
		newRecipe.name = getRecipeName();
		try {
			for (int i = 0; i < newRecipe.ingredients.myItems.length; i++) {
				System.out.println("Enter units of "
						+ newRecipe.ingredients.myItems[i] + ": ");
				int numtemp;

				numtemp = br.read();

				if (Character.isDigit((char) numtemp)) {
					newRecipe.ingredients.setItemAmount(
							newRecipe.ingredients.myItems[i], (numtemp - 48));
				} else {
					System.out
							.println("Please enter an amount next time, going back to Main Menu");
					mainMenu();
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return newRecipe;
	}

	public void AddRecipe() throws NumberFormatException {
		int empty = checkRecipes();
		System.out.println("");
		System.out.println("");
		if (empty == 13) {
			System.out.println("Already 6 recipes made, no more!");
			System.out.println("");
			mainMenu();

		} else {

			recipeArray[empty] = setRecipeInfo();

			System.out.println();
			System.out.println("Inventory added, thank you");
			mainMenu();
		}

		System.out.println("Name: " + recipeArray[empty].name + "\n Price: "
				+ recipeArray[empty].price + "\n Sugar: "
				+ recipeArray[empty].ingredients.getItemAmount("sugar")
				+ "\n Milk: "
				+ recipeArray[empty].ingredients.getItemAmount("milk")
				+ "\n Coffee: "
				+ recipeArray[empty].ingredients.getItemAmount("coffee")
				+ "\n Chocolate: "
				+ recipeArray[empty].ingredients.getItemAmount("chocolate")
				+ "\n Bouillon: "
				+ recipeArray[empty].ingredients.getItemAmount("bouillon"));

		i++;
		mainMenu();
	}// end AddRecipe

	public void DeleteRecipe() throws NumberFormatException {
		String num = "";
		int num_select = 0;
		System.out.println("Select which recipe to delete: ");
		for (int n = 0; n < 6; n++) {
			if (recipeArray[n].name != "") {
				System.out.println(" " + n + ": " + recipeArray[n].name);
			}
		}
		System.out.println(" 6: Cancel");
		try {
			try {
				System.out.println("");
				num = br.readLine();
				if (num == null) {
					System.out.println("whoops");
					mainMenu();
					return;
				} else {
					num_select = Integer.parseInt(num);
				}
			} catch (NumberFormatException e) {
				System.out.println("Incorrect input, return to main menu.");
				mainMenu();
				return;
			}
		} catch (IOException n) {
		}
		if (num_select == 6) {
			mainMenu();
		}
		if (num_select > 5) {
			System.out.println("Sorry, please choose again.");
			DeleteRecipe();
			return;
		}
		if (recipeArray[num_select].name == "") {
			System.out.println("");
			System.out.println("There's no recipe to delete.");
			System.out.println("");
			mainMenu();
			return;
		}

		recipeArray[num_select] = null;
		System.out.println("Recipe deleted!");
		mainMenu();
		return;
	}

	public void BuyItem() {
		String line = "";

		System.out.println("Please select item to buy: ");
		for (int n = 0; n < 6; n++) {
			if (recipeArray[n] != null) {
				System.out.println(" " + n + ": " + recipeArray[n].name + " $ "
						+ recipeArray[n].price);
			} else {
				System.out.println(" " + n + ":" + " No recipe.");
			}
		}
		try {
			try {
				System.out.println("");
				line = br.readLine();
				item = Integer.parseInt(line);
				if (item > 5 || item < 0) {
					System.out
							.println("Incorrect input, returning to main menu");
					mainMenu();
					return;
				}
				System.out.println(recipeArray[item].name + " $"
						+ recipeArray[item].price);
				System.out.println("Please enter amount of money deposited: ");
				System.out.print("$ ");
				line = br.readLine();
				money = Double.parseDouble(line);
			} catch (NumberFormatException n) {
				System.out.println("Incorect input, returning to main menu.");
				mainMenu();
				return;
			}
		} catch (IOException e) {
		}
		checkItem();
		return;
	}// end BuyItem

	public void checkItem() {//

		String num = "";
		try {
			try {
				boolean lessThan = true;
				int index = 0;
				while (lessThan
						&& index < recipeArray[item].ingredients.myItems.length) {
					lessThan = (recipeArray[item].ingredients
							.getItemAmount(data.myItems[index]) <= data
							.getItemAmount(data.myItems[index]));
					index++;
				}
				if (lessThan) {//
					// gets money
					difference = recipeArray[item].getChange(money);
				} else {
					System.out.println("Insufficient inventory.");
					System.out.println("Change returned: " + money);
					mainMenu();
					return;
				}
				if (difference == 0) {//
					System.out.println(recipeArray[item].name + " dispensed.");
					System.out.println("");
					recipeArray[item].timesSold += 1;
					totalDrinksSold = totalDrinksSold + 1;
				}// end ==0
				if (difference > 0) {//
					System.out.println("Change returned: $" + difference);
					System.out.println(recipeArray[item].name + " dispensed.");
					System.out.println("");
					totalDrinksSold = totalDrinksSold + 1;
					recipeArray[item].timesSold += 1;
				}// end >0
				if (difference < 0) {// (1)
					difference = 0 - difference;
					System.out
							.println("Insufficient money deposited. Please deposit "
									+ difference);
					difference = 0 - difference;
					System.out.println("Please enter amount: ");
					System.out.print("$ ");
					num = br.readLine();
					extra = Double.parseDouble(num);
					money += extra;
					difference = money - recipeArray[item].price;
					while (difference <= 0) {
						if (difference == 0) {//
							System.out.println(recipeArray[item].name
									+ " dispensed.");
							System.out.println("");
							totalDrinksSold = totalDrinksSold + 1;
							recipeArray[item].timesSold += 1;
							break;
						}// end ==0
						if (difference < 0) {// (2)
							System.out.println("Change returned: " + money);
							System.out
									.println("Sorry, but you only get two chances."
											+ "\nReturning to Main Menu");
							System.out.println("");
							mainMenu();
							return;
						}// end <0(2)
					}// end <0(1)
					if (difference > 0) {//

						System.out.println("Change returned: $" + difference);
						System.out.println(recipeArray[item].name
								+ " dispensed.");
						System.out.println("");
						totalDrinksSold = totalDrinksSold + 1;
						recipeArray[item].timesSold += 1;
					}// end >0
				}
			} catch (NumberFormatException n) {
				System.out.println("Incorrect input, returning to main menu.");
				mainMenu();
				return;
			}
		} catch (IOException e) {
		}
		for (int i = 0; i < data.myItems.length; i++) {
			data.setItemAmount(
					data.myItems[i],
					data.getItemAmount(data.myItems[i])
							- recipeArray[item].ingredients
									.getItemAmount(data.myItems[i]));
		}
		System.out.println("Thank You.");
		mainMenu();
		return;
	}// end checkItem
		// displays the customer analysis

	public void CustomerAnalysis() {
		double percentSold = 0.0;
		System.out.println("total drinks sold: " + totalDrinksSold);
		for (int i = 0; i < 6; i++) {
			if (recipeArray[i].name != "") {
				if (totalDrinksSold > 0) {
					percentSold = (((double) recipeArray[i].timesSold / (double) totalDrinksSold) * 100);
					System.out.println("Item name: " + recipeArray[i].name
							+ " Quantity Sold: " + recipeArray[i].timesSold
							+ " % Sold: " + percentSold);
					recipeArray[i].timesSold = 0;
				} else {
					System.out
							.println("No "
									+ recipeArray[i].name
									+ " have been bought at this time, returning to main menu.");
				}
			}
		}
		totalDrinksSold = 0;
		mainMenu();
		return;
	}

	// displays the main menu
	public void mainMenu() {
		String temp = "";
		int selection = 0;

		System.out.println("");
		System.out.println("Please enter an action...");
		System.out.println("1 = Add Recipe");
		System.out.println("2 = Delete Recipe");
		System.out.println("3 = Add Inventory");
		System.out.println("4 = Check Inventory");
		System.out.println("5 = Buy Item");
		System.out.println("6 = Customer Analysis");
		System.out.println("7 = Exit");
		System.out.println("");
		System.out.print("=> ");
		try {
			try {
				temp = br.readLine();
				selection = Integer.parseInt(temp);
				if (selection == 1) {
					AddRecipe();
				}
				if (selection == 2) {
					DeleteRecipe();
				}
				if (selection == 3) {
					AddInventory();
				}
				if (selection == 4) {
					CheckInventory();
				}
				if (selection == 5) {
					BuyItem();
				}
				if (selection == 6) {
					CustomerAnalysis();
				}
				if (selection == 7) {
					if (ps != null)
						ps.close();
					else
						System.exit(1);
				}

			} catch (NumberFormatException n) {

			}
		} catch (IOException e) {
		}
	}// end mainMenu

	public int exit() {
		return 0;
	}

	// the main function; it sets up the array to hold recipes.
	public static void main(String[] arg) throws Exception {
		new TacomaVendingMachine();
	}

}