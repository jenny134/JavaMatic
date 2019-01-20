
public class Ingredient {
	
	public String name;
	public Double unitPrice;
	public int unit = 10;


	public Ingredient(String name, Double unitPrice) {
		
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnit() {
		return this.unit;
	}
	
	public void setUnit(int unit) {
		this.unit = unit;
	}

}
