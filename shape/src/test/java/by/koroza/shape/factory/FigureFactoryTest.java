/**
 * 
 */
package by.koroza.shape.factory;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.shape.entity.AbstractFigure;
import by.koroza.shape.entity.Point;
import by.koroza.shape.entity.Triangle;
import by.koroza.shape.exception.CuctomException;
import by.koroza.shape.exception.FileException;

public class FigureFactoryTest {
	private static final String STRING_FILE_PATH_FOLDER_INCORRECT_TXT = "src/test.sdf/resources/coordinates/coordinatesTest.txt";
	private static final String STRING_FILE_PATH_CORRECT_TXT_WITH_FIGURES = "src/test/resources/coordinates/coordinatesWithFiguresTest.txt";
	private static final String STRING_FILE_PATH_CORRECT_TXT_WITHOUT_FIGURES = "src/test/resources/coordinates/coordinatesWithoutFiguresTest.txt";
	private static final String STRING_FILE_PATH_FILE_INCORRECT = "src/test/resources/coordinates/coordinatesTest";
	private static final String STRING_NAME_FIGURE = "triangle";
	private FigureFactory factory;
	private List<AbstractFigure> emptyList;
	private List<AbstractFigure> listWithCorrectTriangles;

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		factory = new FigureFactory();
		emptyList = new ArrayList<>();
		listWithCorrectTriangles = new ArrayList<>();
	}

	/**
	 */
	@DataProvider(name = "createrIncorrectPathsTXT")
	public String[] createrIncorrectPathsTXT() {
		return new String[] { null, "", "    ", STRING_FILE_PATH_FOLDER_INCORRECT_TXT,
				STRING_FILE_PATH_FILE_INCORRECT };
	}

	/**
	 * @throws CuctomException
	 */
	@DataProvider(name = "createrCorrectPathsTXTAndResult")
	public Object[][] createrCorrectPathsTXT() throws CuctomException {
		listWithCorrectTriangles.add(
				new Triangle.TriangleBuilder().setId(4).setPointA(new Point.PointBuilder().setX(5).setY(4.31).build())
						.setPointB(new Point.PointBuilder().setX(4.532).setY(0).build())
						.setPointC(new Point.PointBuilder().setX(700.25).setY(800.66).build()).build());
		listWithCorrectTriangles.add(
				new Triangle.TriangleBuilder().setId(5).setPointA(new Point.PointBuilder().setX(-2).setY(-1).build())
						.setPointB(new Point.PointBuilder().setX(0).setY(0).build())
						.setPointC(new Point.PointBuilder().setX(5).setY(4).build()).build());
		return new Object[][] { { STRING_FILE_PATH_CORRECT_TXT_WITH_FIGURES, listWithCorrectTriangles },
				{ STRING_FILE_PATH_CORRECT_TXT_WITHOUT_FIGURES, emptyList } };
	}

	/**
	 */
	@DataProvider(name = "createrIncorrectFigureName")
	public String[] createrIncorrectFigureName() {
		return new String[] { null, "", "    ", "square" };
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.factory.FigureFactory#createFiguresFromFile(java.lang.String, java.lang.String)}.
	 * 
	 * @throws CuctomException
	 * @throws FileException
	 */
	@Test(dataProvider = "createrIncorrectPathsTXT", expectedExceptions = FileException.class, description = "This method get string file path and name figure then if file path correct, reading lines from file and make figures from coordinates from this file after this operation if exist this figure aff to List with figure, else Exception.class")
	public void testCreateFiguresFromFileWithIncorrectFilePath(String filePath) throws FileException, CuctomException {
		factory.createFiguresFromFile(STRING_NAME_FIGURE, filePath);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.factory.FigureFactory#createFiguresFromFile(java.lang.String, java.lang.String)}.
	 * 
	 * @throws CuctomException
	 * @throws FileException
	 */
	@Test(dataProvider = "createrCorrectPathsTXTAndResult", description = "This method get string file path and name figure then if file path correct, reading lines from file and make figures from coordinates from this file after this operation if exist this figure aff to List with figure, else Exception.class")
	public void testCreateFiguresFromFileWithCcorrectFilePath(String filePath, List<AbstractFigure> expected)
			throws FileException, CuctomException {
		List<? extends AbstractFigure> actual = factory.createFiguresFromFile(STRING_NAME_FIGURE, filePath);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.factory.FigureFactory#createFiguresFromFile(java.lang.String, java.lang.String)}.
	 * 
	 * @throws CuctomException
	 * @throws FileException
	 */
	@Test(dataProvider = "createrIncorrectFigureName", expectedExceptions = CuctomException.class, description = "This method get string file path and name figure then if file path correct, reading lines from file and make figures from coordinates from this file after this operation if exist this figure aff to List with figure, else Exception.class")
	public void testCreateFiguresFromFileWithIncorrectNameFigure(String figureName)
			throws FileException, CuctomException {
		factory.createFiguresFromFile(figureName, STRING_FILE_PATH_CORRECT_TXT_WITH_FIGURES);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		factory = null;
		emptyList = null;
		listWithCorrectTriangles = null;
	}
}