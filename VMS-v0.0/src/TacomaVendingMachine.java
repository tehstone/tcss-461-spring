import java.*;
import java.io.*;
import java.util.*;
import java.text.*;

class TacomaVendingMachine {
	Recipe[] recipeArray;
	Ingredients data = new Ingredients(0, 0, 0, 0, 0);
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
		data.setUnits_bou(0);
		data.setUnits_cho(0);
		data.setUnits_cof(0);
		data.setUnits_mil(0);
		data.setUnits_sug(0);
		// Deleting history
		totalDrinksSold = 0;
	}

	public void AddInventory() {

		ObjectInputStream input = null;
		String line = "";
		int num = 0;
		int inv_sug;
		int inv_mil;
		int inv_cof;
		int inv_cho;
		int inv_bou;
		System.out.println("");
		System.out.println("");
		try {
			System.out.println("Enter units of sugar: ");
			try {
				if ((line = br.readLine()) == null) {
					System.out
							.println("Please enter an amount next time, going back to Main Menu");
					mainMenu();
					return;
				} else {
					inv_sug = Integer.parseInt(line);
					data.setUnits_sug(data.getUnits_sug() + inv_sug);
				}
			} catch (NumberFormatException n) {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
			System.out.println("Enter units of milk: ");
			try {
				if ((line = br.readLine()) == null) {
				} else {
					inv_mil = Integer.parseInt(line);
					data.setUnits_mil(data.getUnits_mil() + inv_mil);
				}
			} catch (NumberFormatException n) {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
			System.out.println("Enter units of coffee: ");
			try {
				if ((line = br.readLine()) == null) {
				} else {
					inv_cof = Integer.parseInt(line);
					data.setUnits_cof(data.getUnits_cof() + inv_cof);
				}
			} catch (NumberFormatException n) {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
			System.out.println("Enter units of chocolate: ");
			try {
				if ((line = br.readLine()) == null) {
				} else {
					inv_cho = Integer.parseInt(line);
					data.setUnits_cho(data.getUnits_cho() + inv_cho);
				}
			} catch (NumberFormatException n) {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
			System.out.println("Enter units of bouillon: ");
			try {
				if ((line = br.readLine()) == null) {
				} else {
					inv_bou = Integer.parseInt(line);
					data.setUnits_bou(data.getUnits_bou() + inv_bou);
				}
			} catch (NumberFormatException n) {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
		} catch (IOException e) {
		}
		System.out.println();
		System.out.println("Inventory added, thank you");
		mainMenu();
		return;
	}

	public void CheckInventory() {
		System.out.println("");
		System.out.println("Sugar: " + data.getUnits_sug());
		System.out.println("Milk: " + data.getUnits_mil());
		System.out.println("Coffee: " + data.getUnits_cof());
		System.out.println("Chocolate: " + data.getUnits_cho());
		System.out.println("Bouillon: " + data.getUnits_bou());
		System.out.println("");
		mainMenu();
		return;
	}

	public int checkRecipes() {
		for (int i = 0; i < 6; i++) {
			if (recipeArray[i].name == "") {
				return i;
			}
		}
		return 13;
	}// end checkRecipes
		// adds a recipe

	public void AddRecipe() throws NumberFormatException {
		int empty = 0;

		InputStreamReader in = new InputStreamReader(System.in);
		// check to see if there is space in array. returns 13 if space is
		// unavailable
		empty = checkRecipes();
		if (empty == 13) {
			System.out.println("Already 6 recipes made, no more!");
			System.out.println("");
			mainMenu();
			return;
		} else {
			i = empty;
		}
		// Variables to hold input
		String rec_name = "";
		String temp = ""; // holds name
		int numtemp = 0; // error checking for integer input
		double rec_price = 0.0;
		int rec_sugar = 0;
		int rec_milk = 0;
		int rec_coffee = 0;
		int rec_chocolate = 0;
		int rec_bouillon = 0;
		try {
			// get name
			System.out.println("");
			System.out.println("Enter name of recipe:");
			temp = br.readLine();
			if (temp == null) {
				System.out
						.println("Please enter a name next time, going back to Main Menu");
				mainMenu();
				return;
			} else {
				rec_name = temp;
			}
			System.out
					.println("Enter price of recipe, in decimal format (0.00):");
			System.out.print("$ ");
			try {
				if ((temp = br.readLine()) == null) {
				} else {
					rec_price = Double.parseDouble(temp);
				}
			} catch (NumberFormatException n) {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
			System.out.println("Enter units of sugar:");
			try {
				if ((temp = br.readLine()) == null) {
				} else {
					rec_sugar = Integer.parseInt(temp);
				}
			} catch (NumberFormatException n) {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
			// get milk
			System.out.println("Enter units of milk:");
			numtemp = br.read();
			if (Character.isDigit((char) numtemp)) {
				rec_milk = (numtemp - 48);
			} else {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
			temp = br.readLine();
			// get coffee
			System.out.println("Enter units of coffee:");
			numtemp = br.read();
			if (Character.isDigit((char) numtemp)) {
				rec_coffee = (numtemp - 48);
			} else {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
			temp = br.readLine();
			System.out.println("Enter units of chocolate:");
			numtemp = br.read();
			if (Character.isDigit((char) numtemp)) {
				rec_chocolate = (numtemp - 48);
			} else {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
			temp = br.readLine();
			System.out.println("Enter units of bouillon:");
			numtemp = br.read();
			if (Character.isDigit((char) numtemp)) {
				rec_bouillon = (numtemp - 48);
			} else {
				System.out
						.println("Please enter an amount next time, going back to Main Menu");
				mainMenu();
				return;
			}
			temp = br.readLine();
			System.out.println("Name: " + rec_name + "\n Price: " + rec_price
					+ "\n Sugar: " + rec_sugar + "\n Milk: " + rec_milk
					+ "\n Coffee: " + rec_coffee + "\n Chocolate: "
					+ rec_chocolate + "\n Bouillon: " + rec_bouillon);
		} catch (IOException e) {
		}
		recipeArray[i] = new Recipe(rec_name, rec_price, rec_sugar, rec_milk,
				rec_coffee, rec_chocolate, rec_bouillon);
		i++;
		mainMenu();
		return;
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
				if (recipeArray[item].sugar <= data.getUnits_sug()
						&& recipeArray[item].milk <= data.getUnits_mil()
						&& recipeArray[item].coffee <= data.getUnits_cof()
						&& recipeArray[item].chocolate <= data.getUnits_cho()
						&& recipeArray[item].bouillon <= data.getUnits_bou()) {//
					// gets money
					difference = money - recipeArray[item].price;
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
		data.setUnits_sug(data.getUnits_sug() - recipeArray[item].sugar);
		data.setUnits_mil(data.getUnits_mil() - recipeArray[item].milk);
		data.setUnits_cof(data.getUnits_cof() - recipeArray[item].coffee);
		data.setUnits_cho(data.getUnits_cho() - recipeArray[item].chocolate);
		data.setUnits_bou(data.getUnits_bou() - recipeArray[item].bouillon);
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