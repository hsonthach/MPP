package creditcard;

public class Main {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard("CC987654", 10000.0);

        // no credit card reward account
        System.out.println(creditCard);
        System.out.println(creditCard.getRewardAccount());

//         Add a RewardAccount to the creditcard.CreditCard
        creditCard.addRewardAccount(new RewardAccount("RA123456", 5000));

        // Display details of the credit card
        System.out.println(creditCard);
        System.out.println(creditCard.getRewardAccount());
    }

}
