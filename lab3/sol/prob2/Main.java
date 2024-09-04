package lab3.sol.prob2;

public class Main {
    public static void main(String[] args) {
        Apartment apt1 = new Apartment(1000);
        Apartment apt2 = new Apartment(1200);
        Apartment apt3 = new Apartment(800);

        Building building1 = new Building(500);
        building1.addApartment(apt1);
        building1.addApartment(apt2);

        Building building2 = new Building(300);
        building2.addApartment(apt3);

        Landlord landlord = new Landlord();
        landlord.addBuilding(building1);
        landlord.addBuilding(building2);

        double totalProfit = landlord.calculateTotalProfit();
        System.out.println("Total Monthly Profit: $" + totalProfit);
    }
}
