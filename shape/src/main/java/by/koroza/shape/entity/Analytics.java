package by.koroza.shape.entity;

import by.koroza.shape.action.impl.TriangleCalculatorImpl;
import by.koroza.shape.observer.AnalyticsObserver;

public class Analytics implements AnalyticsObserver {
	private static final String STRING_PERIMETER = "Perimeter: ";
	private static final String STRING_AREA = "Area: ";
	private static final String STRING_NEXT_LINE = "\n";
	private double perimeter;
	private double area;

	public Analytics() {
	}

	public Analytics(double perimeter, double area) {
		this.perimeter = perimeter;
		this.area = area;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public void update(AbstractFigure figure) {
		TriangleCalculatorImpl calculator = new TriangleCalculatorImpl();
		if (figure.getClass().equals(Triangle.class)) {
			this.perimeter = calculator.calcPerimeterTriangle((Triangle) figure);
			this.area = calculator.calcAreaTriangle((Triangle) figure);
		}
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + Double.hashCode(this.perimeter);
		result = result * PRIME + Double.hashCode(this.area);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (!getClass().equals(object.getClass())) {
			return false;
		}
		Analytics otherAnalytics = (Analytics) object;
		if (this.perimeter != otherAnalytics.perimeter) {
			return false;
		}
		if (this.area != otherAnalytics.area) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(STRING_PERIMETER).append(this.perimeter).append(STRING_NEXT_LINE);
		builder.append(STRING_AREA).append(this.area);
		return builder.toString();
	}
}