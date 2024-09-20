package lab9.prob9;

import java.util.List;
import java.util.Optional;

import lab9.prob9.Dish.Type;

public final class Main {
	public static void main(String[] args) {
		boolean isVegetarian = Dish.menu.stream().anyMatch(Dish::isVegetarian);
		System.out.println("Is there any Vegetarian meal available: " + isVegetarian);
		
		boolean isHealthy = Dish.menu.stream().anyMatch(c -> c.getCalories() < 1000);
		System.out.println("Is there any healthy menu have calories less than 1000: " + isHealthy);
		
		boolean isUnhealthy = Dish.menu.stream().anyMatch(c -> c.getCalories() > 1000);
		System.out.println("Is there any unhealthy menu have  calories greater than 1000: " + isUnhealthy);
		
		Optional<Dish> meatDish = Dish.menu.stream().filter(c -> c.getType() == Type.MEAT).findFirst();
		System.out.println("find and return the first item for the type of MEAT: " + meatDish);
		
		System.out.println("calculateTotalCalories() in the menu using reduce: " + calculateTotalCalories(Dish.menu));
		
		System.out.println("calculateTotalCaloriesMethodReference()in the menu using MethodReferences: " + calculateTotalCaloriesMethodReference(Dish.menu));
	}
	
	private static int calculateTotalCalories(List<Dish> dishes) {
		return dishes.stream().map(dish -> dish.getCalories()).reduce(0, (sum, c) -> sum + c);
	}
	
	private static int calculateTotalCaloriesMethodReference(List<Dish> dishes) {
		return dishes.stream().map(Dish::getCalories).reduce(0, Integer::sum);
	}
}
