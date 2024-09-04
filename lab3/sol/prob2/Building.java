package lab3.sol.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Apartment> apts;
    private final double maintenanceCost;

    public Building(double maintenanceCost) {
        this.apts = new ArrayList<>();
        this.maintenanceCost = maintenanceCost;
    }

    public double calculateProfit() {
        double totalRent = apts.stream().mapToDouble(Apartment::rent).sum();
        return totalRent - maintenanceCost;
    }

    public void addApartment(Apartment apt) {
        apts.add(apt);
    }
}
