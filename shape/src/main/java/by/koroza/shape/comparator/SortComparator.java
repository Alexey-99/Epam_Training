package by.koroza.shape.comparator;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;

import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.exception.CuctomException;

public enum SortComparator {
	ID, FIRST_X, FIRST_Y, AREA, PERIMETER;

	public Comparator<AbstractFigure> getComparator() throws CuctomException {
		return switch (this) {
		case ID -> Comparator.comparingInt(AbstractFigure::getId);
		case FIRST_X ->
			Comparator.comparingDouble((ToDoubleFunction<AbstractFigure>) figure -> figure.getPoints()[0].getX());
		case FIRST_Y ->
			Comparator.comparingDouble((ToDoubleFunction<AbstractFigure>) figure -> figure.getPoints()[0].getY());
		case AREA ->
			Comparator.comparingDouble((ToDoubleFunction<AbstractFigure>) figure -> figure.getAnalytics().getArea());
		case PERIMETER -> Comparator
				.comparingDouble((ToDoubleFunction<AbstractFigure>) figure -> figure.getAnalytics().getPerimeter());
		};
	}
}