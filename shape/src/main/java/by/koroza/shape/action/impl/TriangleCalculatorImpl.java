package by.koroza.shape.action.impl;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.koroza.shape.action.TriangleCalculator;
import by.koroza.shape.entity.Point;
import by.koroza.shape.entity.Triangle;

import static java.lang.Math.pow;

public class TriangleCalculatorImpl implements TriangleCalculator {
	private static final Logger LOGGER = LogManager.getLogger();

	@Override
	public double rounding(double number, int numberDecimalPlaces) {
		String format = "%." + numberDecimalPlaces + "f";
		String numberRounded = String.format(format, number);
		String numberRoundedReplaced = numberRounded.replace(",", ".");
		LOGGER.log(Level.DEBUG,
				new StringBuilder().append("The number ").append(number).append(" has been rounded to ")
						.append(numberDecimalPlaces).append(" decimal places. ").append("\n").append("Result = ")
						.append(numberRoundedReplaced).toString());
		return Double.parseDouble(numberRoundedReplaced);
	}

	@Override
	public double calcAreaTriangle(Triangle triangle) {
		double area = 0.5 * (abs((triangle.getPointB().getX() - triangle.getPointA().getX())
				* (triangle.getPointC().getY() - triangle.getPointA().getY())
				- (triangle.getPointC().getX() - triangle.getPointA().getX())
						* (triangle.getPointB().getY() - triangle.getPointA().getY())));
		LOGGER.log(Level.INFO, new StringBuilder().append("The area of the triangle { ").append(triangle.toString())
				.append(" } was calculated. ").append("\n").append("Result = ").append(area).toString());
		return area;
	}

	@Override
	public double calcPerimeterTriangle(Triangle triangle) {
		double perimeter = triangle.getSideAB() + triangle.getSideBC() + triangle.getSideCA();
		LOGGER.log(Level.INFO,
				new StringBuilder().append("The perimeter of the triangle { ").append(triangle.toString())
						.append(" } was calculated. ").append("\n").append("Result = ").append(perimeter).toString());
		return perimeter;
	}

	@Override
	public double calcSideTriangle(Point pointOne, Point pointTwo) {
		double side = abs(sqrt(pow(pointOne.getX() - pointTwo.getX(), 2) + pow(pointOne.getY() - pointTwo.getY(), 2)));
		LOGGER.log(Level.DEBUG, new StringBuilder().append(
				"The side of the triangle between the points was calculated, the coordinates of which are: first point [ ")
				.append(pointOne.toString()).append(" ]; second point [ ").append(pointTwo.toString()).append(" ].")
				.append("\n").append("Result = ").append(side).toString());
		return side;
	}
}