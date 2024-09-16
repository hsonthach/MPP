package prob3;

interface RestaurantInterface {
    String getRestaurantName();
    double calculateDeliveryCharge(double distance);

    static void printFormattedData(String restaurantName, String customerName, double orderAmount, double deliveryCharge, double discount, double totalAfterDiscount) {
        System.out.printf("Restaurant: %s\nCustomer: %s\nOrder Amount: $%.2f\nDelivery Charge: $%.2f\nDiscount Applied: $%.2f\nTotal after Discount: $%.2f\n\n",
                restaurantName, customerName, orderAmount, deliveryCharge, discount, totalAfterDiscount);
    }
}