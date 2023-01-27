package by.koroza.shape.repository.specifications;

import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.repository.TriangleSpecification;

public class IdSpecification implements TriangleSpecification {
	private int id;

	public IdSpecification(int searchId) {
		this.id = searchId;
	}

	@Override
	public boolean specify(AbstractFigure abstractFigure) {
		return abstractFigure.getId() == id;
	}
}