package by.koroza.shape.entity;

import by.koroza.shape.action.impl.TriangleCalculatorImpl;
import by.koroza.shape.enums.TypeBySides;
import by.koroza.shape.enums.TypeByСorners;
import by.koroza.shape.exception.CuctomException;
import by.koroza.shape.validation.Validator;

import static java.lang.Math.pow;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Triangle extends AbstractFigure {
	private final Point[] points = new Point[3];
	private double sideAB;
	private double sideBC;
	private double sideCA;
	private TypeBySides typeOnSides;
	private TypeByСorners typeOnСorners;
	private static final String STRING_COORDINATES = "Coordinates of triangle: ";
	private static final String STRING_TYPE_BY_SIDES = "Type of triangle on the sides: ";
	private static final String STRING_NOT_HAVE_TYPE = "doesn't have type.";
	private static final String STRING_TYPE_BY_CORNERS = "Type of triangle on the corners: ";
	private static final String STRING_NEXT_LINE = "\n";
	private static final String WARN_NOT_EXIST_TRIANGLE = "The triangle with these coordinates doesn't exist.";
	private static final Logger LOGGER = LogManager.getLogger();

	public Triangle() {
		super();
	}

	public Triangle(double xPointA, double yPointA, double xPointB, double yPointB, double xPointC, double yPointC)
			throws CuctomException {
		super();
		this.points[0] = new Point(xPointA, yPointA);
		this.points[1] = new Point(xPointB, yPointB);
		this.points[2] = new Point(xPointC, yPointC);
		initSides();
		if (Validator.isExistTriangle(this)) {
			this.typeOnSides = initTypeOnSides();
			this.typeOnСorners = initTypeOnСorners();
			super.getAnalytics().update(this);
		} else {
			LOGGER.log(Level.WARN, WARN_NOT_EXIST_TRIANGLE);
			throw new CuctomException(WARN_NOT_EXIST_TRIANGLE);
		}
	}

	@Override
	public Point[] getPoints() {
		return points;
	}

	public Point getPointA() {
		return this.points[0];
	}

	public void setPointA(Point pointA) throws CuctomException {
		this.points[0] = pointA;
		if (Validator.isInitAllPoints(this)) {
			initSides();
			if (Validator.isExistTriangle(this)) {
				this.typeOnSides = initTypeOnSides();
				this.typeOnСorners = initTypeOnСorners();
				super.getAnalytics().update(this);
			} else {
				LOGGER.log(Level.WARN, WARN_NOT_EXIST_TRIANGLE);
				throw new CuctomException(WARN_NOT_EXIST_TRIANGLE);
			}
		}
	}

	public Point getPointB() {
		return this.points[1];
	}

	public void setPointB(Point pointB) throws CuctomException {
		this.points[1] = pointB;
		if (Validator.isInitAllPoints(this)) {
			initSides();
			if (Validator.isExistTriangle(this)) {
				this.typeOnSides = initTypeOnSides();
				this.typeOnСorners = initTypeOnСorners();
				super.getAnalytics().update(this);
			} else {
				LOGGER.log(Level.WARN, WARN_NOT_EXIST_TRIANGLE);
				throw new CuctomException(WARN_NOT_EXIST_TRIANGLE);
			}
		}
	}

	public Point getPointC() {
		return this.points[2];
	}

	public void setPointC(Point pointC) throws CuctomException {
		this.points[2] = pointC;
		if (Validator.isInitAllPoints(this)) {
			initSides();
			if (Validator.isExistTriangle(this)) {
				this.typeOnSides = initTypeOnSides();
				this.typeOnСorners = initTypeOnСorners();
				super.getAnalytics().update(this);
			} else {
				LOGGER.log(Level.WARN, WARN_NOT_EXIST_TRIANGLE);
				throw new CuctomException(WARN_NOT_EXIST_TRIANGLE);
			}
		}
	}

	public double getSideAB() {
		return sideAB;
	}

	public double getSideBC() {
		return sideBC;
	}

	public double getSideCA() {
		return sideCA;
	}

	public void initSides() {
		TriangleCalculatorImpl calc = new TriangleCalculatorImpl();
		this.sideAB = calc.calcSideTriangle(this.points[0], this.points[1]);
		this.sideBC = calc.calcSideTriangle(this.points[1], this.points[2]);
		this.sideCA = calc.calcSideTriangle(this.points[2], this.points[0]);
	}

	private TypeBySides initTypeOnSides() {
		TypeBySides type = null;
		if ((this.sideAB == this.sideBC) && (this.sideBC == this.sideCA)) {
			type = TypeBySides.EQUILATERAL;
		} else if ((this.sideAB == this.sideBC) || (this.sideBC == this.sideCA) || (this.sideCA == this.sideAB)) {
			type = TypeBySides.ISOSCELES;
		} else {
			type = TypeBySides.VERSATILE;
		}
		return type;
	}

	private TypeByСorners initTypeOnСorners() {
		TypeByСorners type = null;
		if (((pow(this.sideCA, 2) + pow(this.sideBC, 2) - pow(this.sideAB, 2)) > 0)
				&& ((pow(this.sideAB, 2) + pow(this.sideBC, 2) - pow(this.sideCA, 2)) > 0)
				&& ((pow(this.sideCA, 2) + pow(this.sideAB, 2) - pow(this.sideBC, 2)) > 0)) {
			type = TypeByСorners.ACUTE;
		} else if (((pow(this.sideCA, 2) + pow(this.sideBC, 2) - pow(this.sideAB, 2)) == 0)
				|| ((pow(this.sideAB, 2) + pow(this.sideBC, 2) - pow(this.sideCA, 2)) == 0)
				|| ((pow(this.sideCA, 2) + pow(this.sideAB, 2) - pow(this.sideBC, 2)) == 0)) {
			type = TypeByСorners.RECTANGULAR;
		} else if (((pow(this.sideCA, 2) + pow(this.sideBC, 2) - pow(this.sideAB, 2)) < 0)
				|| ((pow(this.sideAB, 2) + pow(this.sideBC, 2) - pow(this.sideCA, 2)) < 0)
				|| ((pow(this.sideCA, 2) + pow(this.sideAB, 2) - pow(this.sideBC, 2)) < 0)) {
			type = TypeByСorners.OBTUSE;
		}
		return type;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = result * PRIME + super.hashCode();
		result = result * PRIME + (this.points != null ? this.points.hashCode() : 1);
		result = result * PRIME + Double.hashCode(this.sideAB);
		result = result * PRIME + Double.hashCode(this.sideBC);
		result = result * PRIME + Double.hashCode(this.sideCA);
		result = result * PRIME + (this.typeOnSides != null ? this.typeOnSides.hashCode() : 1);
		result = result * PRIME + (this.typeOnСorners != null ? this.typeOnСorners.hashCode() : 1);
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!super.equals(object)) {
			return false;
		}
		Triangle otherTriangle = (Triangle) object;
		if (this.points == null) {
			if (otherTriangle.points != null) {
				return false;
			}
		} else {
			for (int i = 0; i < this.points.length; i++) {
				if (this.points[i] == null) {
					if (otherTriangle.points[i] != null) {
						return false;
					}
				} else if (!this.points[i].equals(otherTriangle.points[i])) {
					return false;
				}
			}
		}
		if (this.sideAB != otherTriangle.sideAB) {
			return false;
		}
		if (this.sideBC != otherTriangle.sideBC) {
			return false;
		}
		if (this.sideCA != otherTriangle.sideCA) {
			return false;
		}
		if (this.typeOnSides == null) {
			if (otherTriangle != null) {
				return false;
			}
		} else if (!this.typeOnSides.equals(otherTriangle.typeOnSides)) {
			return false;
		}
		if (this.typeOnСorners == null) {
			if (otherTriangle.typeOnСorners != null) {
				return false;
			}
		} else if (!this.typeOnСorners.equals(otherTriangle.typeOnСorners)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString()).append(STRING_NEXT_LINE);
		builder.append(STRING_COORDINATES).append(Arrays.toString(this.points)).append(STRING_NEXT_LINE);
		builder.append(STRING_TYPE_BY_SIDES)
				.append(this.typeOnSides != null ? this.typeOnSides.toString().toLowerCase() : STRING_NOT_HAVE_TYPE)
				.append(STRING_NEXT_LINE);
		builder.append(STRING_TYPE_BY_CORNERS)
				.append(this.typeOnСorners != null ? this.typeOnСorners.toString().toLowerCase() : STRING_NOT_HAVE_TYPE)
				.append(STRING_NEXT_LINE);
		return builder.toString();
	}

	public static class TriangleBuilder {
		private Triangle triangle;

		public TriangleBuilder() {
			triangle = new Triangle();
		}

		public TriangleBuilder setId(int id) {
			triangle.setId(id);
			return this;
		}

		public TriangleBuilder setPointA(Point pointA) throws CuctomException {
			triangle.setPointA(pointA);
			return this;
		}

		public TriangleBuilder setPointB(Point pointB) throws CuctomException {
			triangle.setPointB(pointB);
			return this;
		}

		public TriangleBuilder setPointC(Point pointC) throws CuctomException {
			triangle.setPointC(pointC);
			return this;
		}

		public Triangle build() {
			return triangle;
		}
	}
}