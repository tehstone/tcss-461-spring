
public class Ingredients {
	private int units_sug;
	private int units_mil;
	private int units_cof;
	private int units_cho;
	private int units_bou;

	public Ingredients(int units_sug, int units_mil, int units_cof,
			int units_cho, int units_bou) {
		this.units_sug = units_sug;
		this.units_mil = units_mil;
		this.units_cof = units_cof;
		this.units_cho = units_cho;
		this.units_bou = units_bou;
	}

	public int getUnits_sug() {
		return units_sug;
	}

	public void setUnits_sug(int units_sug) {
		this.units_sug = units_sug;
	}

	public int getUnits_mil() {
		return units_mil;
	}

	public void setUnits_mil(int units_mil) {
		this.units_mil = units_mil;
	}

	public int getUnits_cof() {
		return units_cof;
	}

	public void setUnits_cof(int units_cof) {
		this.units_cof = units_cof;
	}

	public int getUnits_cho() {
		return units_cho;
	}

	public void setUnits_cho(int units_cho) {
		this.units_cho = units_cho;
	}

	public int getUnits_bou() {
		return units_bou;
	}

	public void setUnits_bou(int units_bou) {
		this.units_bou = units_bou;
	}
}