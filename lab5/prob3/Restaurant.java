package prob3;

class Restaurant implements RestaurantInterface {
    private String restaurantName;
    private double distance;
    private double deliveryRate;

    public Restaurant(String restaurantName, double distance, double deliveryRate) {
        this.restaurantName = restaurantName;
        this.distance = distance;
        this.deliveryRate = deliveryRate;
    }

    @Override
    public String getRestaurantName() {
        return restaurantName;
    }

    @Override
    public double calculateDeliveryCharge(double distance) {
        return deliveryRate;
    }

    public double calculateDiscount(double orderAmount) {
        return orderAmount > 100 ? orderAmount * 0.05 : 0.0;
    }
}