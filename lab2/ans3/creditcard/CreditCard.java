package creditcard;

public class CreditCard {
    private String cardNumber;
    private double creditLimit;
    private RewardAccount rewardAccount; // Optional association

    // Constructor
    public CreditCard(String cardNumber, double creditLimit) {
        this.cardNumber = cardNumber;
        this.creditLimit = creditLimit;
        this.rewardAccount = null; // No reward account initially
    }

    // Method to add a RewardAccount
    public void addRewardAccount(RewardAccount rewardAccount) {
        this.rewardAccount = rewardAccount;
    }

    // Getters
    @Override
    public String toString() {
        return "Credit Card Number: " + cardNumber + "\nCredit Limit: $" + creditLimit + "\n";
    }

    public RewardAccount getRewardAccount() {
        return rewardAccount;
    }
}