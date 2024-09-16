package prob2.intfaces2;

import java.util.ArrayList;

public class EquilateralTriangle implements ClosedCurve,Polygon{
    private double side;
    public EquilateralTriangle(double side) {
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public ArrayList<Double> getSides() {
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(side);
        sides.add(side);
        sides.add(side);
        return sides;
    }

    @Override
    public double computePerimeter() {
        return Polygon.super.computePerimeter();
    }
}
