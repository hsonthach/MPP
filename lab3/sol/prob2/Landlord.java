package lab3.sol.prob2;

import java.util.List;
import java.util.ArrayList;

public class Landlord {
    private List<Building> bldgs = new ArrayList<>();

    public void addBuilding(Building bldg) {
        bldgs.add(bldg);
    }

    public double calculateTotalProfit() {
        return bldgs.stream().mapToDouble(Building::calculateProfit).sum();
    }
}
