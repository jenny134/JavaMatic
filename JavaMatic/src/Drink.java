import java.util.List;

public class Drink {

	public String name;
	public List<Ingredient> ingredientList;
	public List<Integer> quantity;
	public Double totalPrice;
	
	public Drink(String name, List<Ingredient> ingredientList, List<Integer> quantity) {
		this.name = name;
		this.ingredientList = ingredientList;
		this.quantity = quantity;
		this.totalPrice = calculatePrice();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public List<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}
	
	public Double calculatePrice() {
		Double cost = 0.0;
		for(int i = 0; i< quantity.size(); i++) {
			cost+=quantity.get(i)*ingredientList.get(i).unitPrice;
		}
		return cost;
	}
	
	
	
}
