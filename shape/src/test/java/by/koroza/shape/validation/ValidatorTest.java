package by.koroza.shape.validation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.shape.entity.Point;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.exception.CuctomException;

public class ValidatorTest {
	private static final String STRING_FILE_PATH_FOLDER_INCORRECT_TXT = "src/test.sdf/resources/coordinates/coordinatesTest.txt";
	private static final String STRING_FILE_PATH_CORRECT_TXT = "src/test/resources/coordinates/coordinatesTest.txt";
	private static final String STRING_FILE_PATH_FILE_INCORRECT = "src/test/resources/coordinates/coordinatesTest";
	private static final String STRING_INCORRECT_COORDINATE = "-1,-1 0v,0 1sdef,1ewa";
	private static final String STRING_CORRECT_COORDINATE = "-2,-1 0,0 5,4";

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
	}

	/**
	 */
	@DataProvider(name = "createrPathsTXT")
	public Object[][] createrPathsTXT() {
		return new Object[][] { { null, false }, { "", false }, { STRING_FILE_PATH_FOLDER_INCORRECT_TXT, false },
				{ STRING_FILE_PATH_FILE_INCORRECT, false }, { STRING_FILE_PATH_CORRECT_TXT, true } };
	}

	/**
	 */
	@DataProvider(name = "createrCoordinates")
	public Object[][] createrLinesCoordinates() {
		return new Object[][] { { null, false }, { "  ", false }, { STRING_INCORRECT_COORDINATE, false },
				{ STRING_CORRECT_COORDINATE, true } };
	}

	/**
	 * @throws CuctomException
	 */
	@DataProvider(name = "createrTriangles")
	public Object[][] createrTriangles() throws CuctomException {
		Triangle incorrectTreangle = new Triangle.TriangleBuilder()
				.setPointA(new Point.PointBuilder().setX(-1).setY(-1).build())
				.setPointB(new Point.PointBuilder().setX(0).setY(0).build())
				.setPointC(new Point.PointBuilder().setX(1).setY(1).build()).build();
		Triangle correctTreangle = new Triangle.TriangleBuilder()
				.setPointA(new Point.PointBuilder().setX(-2).setY(-1).build())
				.setPointB(new Point.PointBuilder().setX(0).setY(0).build())
				.setPointC(new Point.PointBuilder().setX(5).setY(4).build()).build();
		return new Object[][] { { incorrectTreangle, false }, { correctTreangle, true } };
	}

	/**
	 * @throws CuctomException
	 */
	@DataProvider(name = "createrTrianglesPoints")
	public Object[][] createrTrianglesPoints() throws CuctomException {
		Triangle correctTriangle = new Triangle.TriangleBuilder()
				.setPointA(new Point.PointBuilder().setX(-2).setY(-1).build())
				.setPointB(new Point.PointBuilder().setX(0).setY(0).build())
				.setPointC(new Point.PointBuilder().setX(5).setY(4).build()).build();
		Triangle triangleA = new Triangle.TriangleBuilder().setPointA(null)
				.setPointB(new Point.PointBuilder().setX(0).setY(0).build())
				.setPointC(new Point.PointBuilder().setX(5).setY(4).build()).build();
		Triangle triangleB = new Triangle.TriangleBuilder()
				.setPointA(new Point.PointBuilder().setX(-2).setY(-1).build()).setPointB(null)
				.setPointC(new Point.PointBuilder().setX(5).setY(4).build()).build();
		Triangle triangleC = new Triangle.TriangleBuilder()
				.setPointA(new Point.PointBuilder().setX(-2).setY(-1).build())
				.setPointB(new Point.PointBuilder().setX(0).setY(0).build()).setPointC(null).build();
		Triangle triangle = new Triangle.TriangleBuilder().setPointA(null).setPointB(null).setPointC(null).build();
		return new Object[][] { { null, false }, { triangleA, false }, { triangleB, false }, { triangleC, false },
				{ triangle, false }, { correctTriangle, true } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.validation.Validator#isCorrectPath(java.lang.String)}.
	 */
	@Test(dataProvider = "createrPathsTXT", description = "This method get file path and checking a file path before if correct this file path - return true, else - false")
	public void testIsCorrectPath(String path, boolean expected) {
		boolean actual = Validator.isCorrectPath(path);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.validation.Validator#isCorrectCoordinates(java.lang.String)}.
	 */
	@Test(dataProvider = "createrCoordinates", description = "This method get line of coordinates and checking her, before if correct line return true, else - false")
	public void testIsCorrectCoordinates(String lineCoordinate, boolean expected) {
		boolean actual = Validator.isCorrectCoordinates(lineCoordinate);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.validation.Validator#isExistTriangle(by.koroza.shape.entity.Triangle)}.
	 * 
	 * @throws CuctomException
	 */
	@Test(expectedExceptions = CuctomException.class, description = "This method get object of class Triangle and checking him, before if this triangle with these coordinates exist - return true, else - false")
	public void testIsExistIncorrectTriangle() throws CuctomException {
		Triangle incorrectTreangle = new Triangle.TriangleBuilder()
				.setPointA(new Point.PointBuilder().setX(-1).setY(-1).build())
				.setPointB(new Point.PointBuilder().setX(0).setY(0).build())
				.setPointC(new Point.PointBuilder().setX(1).setY(1).build()).build();
		Validator.isExistTriangle(incorrectTreangle);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.validation.Validator#isExistTriangle(by.koroza.shape.entity.Triangle)}.
	 * 
	 * @throws CuctomException
	 */
	@Test(description = "This method get object of class Triangle and checking him, before if this triangle with these coordinates exist - return true, else - false")
	public void testIsExistCorrectTriangle() throws CuctomException {
		Triangle correctTreangle = new Triangle.TriangleBuilder()
				.setPointA(new Point.PointBuilder().setX(-2).setY(-1).build())
				.setPointB(new Point.PointBuilder().setX(0).setY(0).build())
				.setPointC(new Point.PointBuilder().setX(5).setY(4).build()).build();
		boolean actual = Validator.isExistTriangle(correctTreangle);
		boolean expected = true;
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.validation.Validator#isInitAllPoints(by.koroza.shape.entity.Triangle)}.
	 */
	@Test(dataProvider = "createrTrianglesPoints", description = "This method get object of class Triangle and checking initialisation points of triangle, before if this triangle  have non-initialized points - return true, else - false")
	public void testIsInitAllPoints(Triangle triangle, boolean expected) {
		boolean actual = Validator.isInitAllPoints(triangle);
		assertEquals(actual, expected);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
	}
}