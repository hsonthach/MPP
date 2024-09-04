package creditcard;

public class RewardAccount {
    private String rewardAccountId;
    private int rewardPoints;

    // Constructor, getters, and setters
    public RewardAccount(String rewardAccountId, int rewardPoints) {
        this.rewardAccountId = rewardAccountId;
        this.rewardPoints = rewardPoints;
    }

    @Override
    public String toString() {
        return "Reward Account ID: " + rewardAccountId + "\nReward Points: " + rewardPoints;
    }
}
