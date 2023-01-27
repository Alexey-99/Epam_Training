package by.koroza.shape.calculation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.koroza.shape.action.impl.TriangleCalculatorImpl;
import by.koroza.shape.entity.Point;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.exception.CuctomException;

public class TriangleCalculatorImplTest {
	private TriangleCalculatorImpl calculator;
	private Triangle triangle;
	private int numberDecimalPlaces = 3;

	/**
	 * @throws CuctomException
	 */
	@BeforeClass
	public void setUpBeforeClass() throws CuctomException {
		calculator = new TriangleCalculatorImpl();
		triangle = new Triangle.TriangleBuilder().setPointA(new Point.PointBuilder().setX(-2).setY(-1).build())
				.setPointB(new Point.PointBuilder().setX(0).setY(0).build())
				.setPointC(new Point.PointBuilder().setX(5).setY(4).build()).build();
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.action.impl.TriangleCalculatorImpl#rounding(double, int)}.
	 */
	@Test(description = "This method rounds to n decimal places")
	public void testRounding() {
		double number = 5.36156516161;
		double expected = 5.362;
		double actual = calculator.rounding(number, numberDecimalPlaces);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.action.impl.TriangleCalculatorImpl#calcAreaTriangle(by.koroza.shape.entity.Triangle)}.
	 */
	@Test(description = "This method calculates area of triangle and return result")
	public void testCalcAreaTriangle() {
		double expected = 1.5;
		double actual = calculator.calcAreaTriangle(triangle);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.action.impl.TriangleCalculatorImpl#calcPerimeterTriangle(by.koroza.shape.entity.Triangle)}.
	 */
	@Test(description = "This method calculates perimeter of triangle and return result")
	public void testCalcPerimeterTriangle() {
		double expected = 17.242;
		double actual = calculator.rounding(calculator.calcPerimeterTriangle(triangle), numberDecimalPlaces);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.action.impl.TriangleCalculatorImpl#calcSideTriangle(by.koroza.shape.entity.Point, by.koroza.shape.entity.Point)}.
	 */
	@Test(description = "This method calculates length side of triangle and return result")
	public void testCalcSideTriangle() {
		double expected = 2.236;
		double actual = calculator.rounding(calculator.calcSideTriangle(triangle.getPointA(), triangle.getPointB()),
				numberDecimalPlaces);
		assertEquals(actual, expected);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		calculator = null;
		triangle = null;
	}
}