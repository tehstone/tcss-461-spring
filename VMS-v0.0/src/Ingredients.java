public class Ingredients {
	public String[] myItems = new String[] { "sugar", "milk", "coffee",
			"chocolate", "bouillon" };
	private int[] myItemAmounts = new int[] { 0, 0, 0, 0, 0 };

	public Ingredients() {

	}

	public void setItemAmount(final String item, final int amount) {
		switch (item) {
		case "sugar":
			myItemAmounts[0] = amount;
			break;
		case "milk":
			myItemAmounts[1] = amount;
			break;
		case "coffee":
			myItemAmounts[2] = amount;
			break;
		case "chocolate":
			myItemAmounts[3] = amount;
			break;
		case "bouillon":
			myItemAmounts[4] = amount;
			break;
		default:
			break;
		}
	}

	public int getItemAmount(final String item) {
		int temp = 0;
		switch (item) {
		case "sugar":
			temp = myItemAmounts[0];
			break;
		case "milk":
			temp = myItemAmounts[1];
			break;
		case "coffee":
			temp = myItemAmounts[2];
			break;
		case "chocolate":
			temp = myItemAmounts[3];
			break;
		case "bouillon":
			temp = myItemAmounts[4];
			break;
		default:
			break;
		}

		return temp;
	}

}