package by.koroza.shape.repository;

import by.koroza.shape.entity.AbstractFigure;

@FunctionalInterface
public interface TriangleSpecification {

	boolean specify(AbstractFigure abstractFigure);
}