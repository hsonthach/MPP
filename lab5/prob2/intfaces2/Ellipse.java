package prob2.intfaces2;

public class Ellipse implements ClosedCurve {
    private double semiMajorAxis;
    private double semiMinorAxis;

    public Ellipse(double semiMajorAxis, double semiMinorAxis) {
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }
    @Override
    public double computePerimeter() {
        return 4 * (Math.PI * semiMajorAxis * semiMinorAxis + (semiMajorAxis - semiMinorAxis)) / (semiMajorAxis + semiMinorAxis);
    }
}
