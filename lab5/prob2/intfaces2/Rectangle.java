package prob2.intfaces2;

import java.util.ArrayList;

public class Rectangle implements ClosedCurve, Polygon {
	private double length, width;
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public ArrayList<Double> getSides() {
		return new ArrayList<Double>() {
			{
				add(length);
				add(width);
				add(length);
				add(width);
			}
		};
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double computePerimeter() {
		return Polygon.super.computePerimeter();
	}
}
