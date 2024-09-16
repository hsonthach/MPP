package prob3;

interface CustomerInterface {
    String getCustomerName();
    int getLoyaltyPoints();

    default boolean isLoyalCustomer() {
        return getLoyaltyPoints() > 50;
    }
}

