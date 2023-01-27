package by.koroza.shape.repository.specifications.square;

import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.entity.Point;
import by.koroza.shape.repository.TriangleSpecification;

public class FourthSquareSpecification implements TriangleSpecification {

	@Override
	public boolean specify(AbstractFigure abstractFigure) {
		boolean result = true;
		for (Point point : abstractFigure.getPoints()) {
			if ((point.getX() < 0) || (point.getY() > 0)) {
				result = false;
			}
		}
		return result;
	}
}