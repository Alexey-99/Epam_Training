package by.koroza.shape.repository.specifications;

import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.repository.TriangleSpecification;

public class TriangleClassSpecification implements TriangleSpecification {

	@Override
	public boolean specify(AbstractFigure abstractFigure) {
		return abstractFigure.getClass().equals(Triangle.class);
	}
}