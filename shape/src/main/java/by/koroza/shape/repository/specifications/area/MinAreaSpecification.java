package by.koroza.shape.repository.specifications.area;

import by.koroza.shape.action.impl.TriangleCalculatorImpl;
import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.repository.TriangleSpecification;

public class MinAreaSpecification implements TriangleSpecification {
	private double minArea;

	public MinAreaSpecification(double minArea) {
		this.minArea = minArea;
	}

	@Override
	public boolean specify(AbstractFigure abstractFigure) {
		boolean result = true;
		if (abstractFigure.getClass().equals(Triangle.class)) {
			double area = new TriangleCalculatorImpl().calcAreaTriangle((Triangle) abstractFigure);
			if (area < this.minArea) {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}
}