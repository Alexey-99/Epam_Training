package by.koroza.shape.action;

import by.koroza.shape.entity.Point;
import by.koroza.shape.entity.Triangle;

public interface TriangleCalculator {

	public double rounding(double number, int numberDecimalPlaces);

	public double calcAreaTriangle(Triangle triangle);

	public double calcPerimeterTriangle(Triangle triangle);

	public double calcSideTriangle(Point pointOne, Point pointTwo);
}