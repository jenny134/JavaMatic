import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
	
	public List<Drink> menu;
	public List<Ingredient> inventory;
	
	public CoffeeMachine(List<Drink> menu, List<Ingredient> inventory) {
		this.menu = menu;
		this.inventory = inventory;
	}
		
	
	public List<Drink> getMenu() {
		return menu;
	}


	public List<Ingredient> getInventory() {
		return inventory;
	}

	public void setMenu(List<Drink> drink) {
		this.menu = drink;
	}

	public void setInventory(List<Ingredient> inventory) {
		this.inventory = inventory;
	}
	public void addDrink(Drink drink){
		menu.add(drink);
	}
	
	public void addIngredient(Ingredient ingredient) {
		inventory.add(ingredient);
	}
	
	public void printMenu() {
		List<Drink> drinks = this.menu;
		int size = drinks.size();
		for(int i=0; i<size; i++) {
			Drink item = drinks.get(i);			
			System.out.print(i+1);
			System.out.print(", ");
			System.out.print(item.getName());
			System.out.print(", $");
			System.out.print(String.format("%.2f", item.totalPrice));
			System.out.print(", ");
			if(checkStock(i)) {
				System.out.println("True");
			}else {
				System.out.println("False");
			}
			

		}
	}
	
	public void printInventory() {
		List<Ingredient> inventories = this.inventory;
		for(Ingredient item: inventories) {
			System.out.print(item.getName());
			System.out.print(",");
			System.out.println(item.getUnit());
		}
	}
	
	public boolean checkStock(int number) {
		
		List<Ingredient> required = this.menu.get(number).ingredientList;
		List<Integer> quantity = this.menu.get(number).quantity;
		
		List<Ingredient> inStock = this.inventory;
		
		for(int a=0; a<required.size(); a++) {
			
			for(int b =0; b<inStock.size(); b++) {
				if(required.get(a).equals(inStock.get(b))) {

					if(inStock.get(b).getUnit()<quantity.get(a)) {
						return false;
					}
				}
			}
			
		}
		return true;
		
		
	}
	
	public static void main(String[] args) {
		
		Ingredient CoffeeIngredient = new Ingredient("Coffee", 0.75);
		Ingredient DecafCoffeeIngredient = new Ingredient("Decaf Coffee", 0.75);
		Ingredient Sugar = new Ingredient("Sugar", 0.25);
		Ingredient Cream = new Ingredient("Cream", 0.25);
		Ingredient SteamedMilk = new Ingredient("Steamed Milk", 0.35);
		Ingredient FoamedMilk = new Ingredient("Foamed Milk", 0.35);
		Ingredient Espresso = new Ingredient("Espresso", 1.10);
		Ingredient Cocoa = new Ingredient("Cocoa", 0.90);
		Ingredient WhippedCream = new Ingredient("WhippedCream", 1.00);
		
		List<Ingredient> ingredientsCoffee = new ArrayList<Ingredient>();
		List<Integer> qua = new ArrayList<Integer>();
		ingredientsCoffee.add(CoffeeIngredient);
		qua.add(3);
		ingredientsCoffee.add(Sugar);
		qua.add(1);
		ingredientsCoffee.add(Cream);
		qua.add(1);		
		Drink Coffee = new Drink("Coffee", ingredientsCoffee, qua);
		
		List<Ingredient> ingredientsDecafCoffee = new ArrayList<Ingredient>();
		List<Integer> qua2 = new ArrayList<Integer>();
		ingredientsDecafCoffee.add(DecafCoffeeIngredient);
		qua2.add(3);
		ingredientsDecafCoffee.add(Sugar);
		qua2.add(1);
		ingredientsDecafCoffee.add(Cream);
		qua2.add(1);		
		Drink DecafCoffee = new Drink("Decaf Coffee", ingredientsDecafCoffee, qua2);
		
		List<Ingredient> ingredientsCaffeLatte = new ArrayList<Ingredient>();
		List<Integer> qua3 = new ArrayList<Integer>();
		ingredientsCaffeLatte.add(Espresso);
		qua3.add(2);
		ingredientsCaffeLatte.add(SteamedMilk);
		qua3.add(1);		
		Drink CaffeLatte = new Drink("Caffe Latte", ingredientsCaffeLatte, qua3);
		
		List<Ingredient> ingredientsCaffeAmericano = new ArrayList<Ingredient>();
		List<Integer> qua4 = new ArrayList<Integer>();
		ingredientsCaffeAmericano.add(Espresso);
		qua4.add(3);	
		Drink CaffeAmericano = new Drink("Caffe Americano", ingredientsCaffeAmericano, qua4);
		
		List<Ingredient> ingredientsCaffeMocha = new ArrayList<Ingredient>();
		List<Integer> qua5 = new ArrayList<Integer>();
		ingredientsCaffeMocha.add(Espresso);
		qua5.add(1);
		ingredientsCaffeMocha.add(Cocoa);
		qua5.add(1);
		ingredientsCaffeMocha.add(SteamedMilk);
		qua5.add(1);		
		ingredientsCaffeMocha.add(WhippedCream);
		qua5.add(1);
		Drink CaffeMocha = new Drink("Caffe Mocha", ingredientsCaffeMocha, qua5);
		

		List<Ingredient> ingredientsCappuccino = new ArrayList<Ingredient>();
		List<Integer> qua6 = new ArrayList<Integer>();
		ingredientsCappuccino.add(Espresso);
		qua6.add(2);
		ingredientsCappuccino.add(SteamedMilk);
		qua6.add(1);
		ingredientsCappuccino.add(FoamedMilk);
		qua6.add(1);		
		Drink Cappuccino = new Drink("Cappuccino", ingredientsCappuccino, qua6);
		
		List<Drink> menuList = new ArrayList<Drink>();
		menuList.add(CaffeMocha);
		menuList.add(CaffeAmericano);
		menuList.add(CaffeLatte);
		menuList.add(DecafCoffee);
		menuList.add(Coffee);
		menuList.add(Cappuccino);
		
		
		List<Ingredient> inventoryList = new ArrayList<>();
		inventoryList.add(WhippedCream);
		inventoryList.add(CoffeeIngredient);
		inventoryList.add(DecafCoffeeIngredient);
		inventoryList.add(Sugar);
		inventoryList.add(Cream);
		inventoryList.add(FoamedMilk);
		inventoryList.add(SteamedMilk);
		inventoryList.add(Espresso);
		inventoryList.add(Cocoa);
		
		CoffeeMachine cm = new CoffeeMachine(menuList, inventoryList);
		cm.printInventory();
		cm.printMenu();

		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
			
			String entered = input.next();
			if(entered.matches("^[1-9][0-9]*") && Integer.parseInt(entered)<=cm.getMenu().size()){
				
				int index = Integer.parseInt(entered);
				Drink order = cm.getMenu().get(index-1);
				System.out.print("Dispensing: ");
				System.out.println(order.getName());
				

				
				if(cm.checkStock(index-1)) {
					
					for(int k = 0; k< order.getIngredientList().size(); k++) {
					
						for(int j =0; j< cm.getInventory().size(); j++) {
							
							if(cm.getInventory().get(j).getName().equals(order.getIngredientList().get(k).getName())) {
								int current = cm.getInventory().get(j).getUnit();
								int subtract = order.getQuantity().get(k);
								cm.getInventory().get(j).setUnit(current-subtract);
							}
							
						}
					}
				}else {
					System.out.println("Out of Stock: "+ cm.getMenu().get(index).getName());
				}
				
				cm.printInventory();

				
			}else {
			
			
			
				if(entered.equalsIgnoreCase("q")) {
				
					input.close();
				
				}else if(entered.equalsIgnoreCase("r")) {
				
					for(Ingredient item: cm.getInventory()) {
						item.setUnit(10);
					}
				
					cm.printInventory();
				
				}else {
					System.out.println("Invalid selection: " + entered);
				}
			
			}
			cm.printInventory();
			cm.printMenu();
			
		}
		
			
		
	}

}
