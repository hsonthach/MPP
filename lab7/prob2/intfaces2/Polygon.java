package prob2.intfaces2;

import java.util.ArrayList;

public interface Polygon {
    public ArrayList<Double> getSides();
    default double computePerimeter(){
        ArrayList<Double> sides = getSides();
        return sides.stream().reduce((double) 0, Double::sum);
    }
}
