package by.koroza.shape.repository.specifications.perimeter;

import by.koroza.shape.action.impl.TriangleCalculatorImpl;
import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.repository.TriangleSpecification;

public class BetweenMinMaxPerimeterSpecification implements TriangleSpecification {
	private double minPerimeter;
	private double maxPerimeter;

	public BetweenMinMaxPerimeterSpecification(double minPerimeter, double maxPerimeter) {
		this.minPerimeter = minPerimeter;
		this.maxPerimeter = maxPerimeter;
	}

	@Override
	public boolean specify(AbstractFigure abstractFigure) {
		boolean result = true;
		if (abstractFigure.getClass().equals(Triangle.class)) {
			double perimeter = new TriangleCalculatorImpl().calcPerimeterTriangle((Triangle) abstractFigure);
			if ((perimeter < this.minPerimeter) || (perimeter > this.maxPerimeter)) {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}
}