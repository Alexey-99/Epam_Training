package by.koroza.shape.repository.specifications.perimeter;

import by.koroza.shape.action.impl.TriangleCalculatorImpl;
import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.repository.TriangleSpecification;

public class MaxPerimeterSpecification implements TriangleSpecification {
	private double maxPerimeter;

	public MaxPerimeterSpecification(double maxPerimeter) {
		this.maxPerimeter = maxPerimeter;
	}

	@Override
	public boolean specify(AbstractFigure abstractFigure) {
		boolean result = true;
		if (abstractFigure.getClass().equals(Triangle.class)) {
			double perimeter = new TriangleCalculatorImpl().calcPerimeterTriangle((Triangle) abstractFigure);
			if (perimeter > this.maxPerimeter) {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}
}