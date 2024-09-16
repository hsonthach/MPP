package prob3;

import java.util.ArrayList;
import java.util.Random;

public class FoodDeliverySystem {
    public static void main(String[] args) {
        // Create an ArrayList of Restaurants
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Sushi Palace", 5.0, 10.0));
        restaurants.add(new Restaurant("Pizza Corner", 3.5, 6.0));
        restaurants.add(new Restaurant("Burger World", 4.0, 7.75));

        // Create an ArrayList of Customers
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John Doe", 60));
        customers.add(new Customer("Jane Smith", 40));
        customers.add(new Customer("Bob Johnson", 80));

        // Print welcome message
        System.out.println("Welcome to the Food Delivery System!");

        Random random = new Random();
        for (Restaurant restaurant : restaurants) {
            for (Customer customer : customers) {
                System.out.println("Processing order for Customer: " + customer.getCustomerName() + " at Restaurant: " + restaurant.getRestaurantName());

                // Check loyalty status
                String loyaltyStatus = customer.isLoyalCustomer() ? "Loyal Customer" : "New Customer";
                System.out.println("Customer Loyalty Status: " + loyaltyStatus);

                // Generate random order amount
                double orderAmount = 50 + (150 * random.nextDouble());

                // Calculate delivery charge and discount
                double deliveryCharge = restaurant.calculateDeliveryCharge(restaurant.getRestaurantName().length());  // Assuming length of name as a mock distance
                double discount = restaurant.calculateDiscount(orderAmount);
                double totalAfterDiscount = orderAmount + deliveryCharge - discount;

                // Print formatted data
                RestaurantInterface.printFormattedData(restaurant.getRestaurantName(), customer.getCustomerName(), orderAmount, deliveryCharge, discount, totalAfterDiscount);
            }
        }
    }
}
