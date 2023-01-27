package by.koroza.shape.repository.specifications.area;

import by.koroza.shape.action.impl.TriangleCalculatorImpl;
import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.repository.TriangleSpecification;

public class BetweenMinMaxAreaSpecification implements TriangleSpecification {
	private double minArea;
	private double maxArea;

	public BetweenMinMaxAreaSpecification(double minArea, double maxArea) {
		this.minArea = minArea;
		this.maxArea = maxArea;
	}

	@Override
	public boolean specify(AbstractFigure abstractFigure) {
		boolean result = true;
		if (abstractFigure.getClass().equals(Triangle.class)) {
			double area = new TriangleCalculatorImpl().calcAreaTriangle((Triangle) abstractFigure);
			if ((area < this.minArea) || (area > this.maxArea)) {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}
}