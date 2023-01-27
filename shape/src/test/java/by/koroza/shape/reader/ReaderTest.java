package by.koroza.shape.reader;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.shape.exception.FileException;

public class ReaderTest {
	private static final String STRING_FILE_PATH_FOLDER_INCORRECT_TXT = "src/test.sdf/resources/coordinates/coordinatesTest.txt";
	private static final String STRING_FILE_PATH_CORRECT_TXT_WITH_FIGURE = "src/test/resources/coordinates/coordinatesWithFiguresTest.txt";
	private static final String STRING_FILE_PATH_FILE_INCORRECT = "src/test/resources/coordinates/coordinatesTest";
	private Reader reader;

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		reader = new Reader();
	}

	@DataProvider(name = "createrIncorrectPathsTXT")
	public String[] createrPathsTXT() {
		return new String[] { null, "", "    ", STRING_FILE_PATH_FOLDER_INCORRECT_TXT,
				STRING_FILE_PATH_FILE_INCORRECT };
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.reader.Reader#getCorrectCoordinates(java.lang.String)}.
	 * 
	 * @throws FileException
	 */
	@Test(dataProvider = "createrIncorrectPathsTXT", expectedExceptions = FileException.class, description = "This method get path file and reading lines coordinates from file and return if found correct line or lines - List<String> with lines, if not to found correct lines - empty List<String>, if incorrect file path or file does not exist - an error FileException.class will appear.")
	public void testGetIncorrectCoordinates(String path) throws FileException {
		reader.getCorrectCoordinates(path);
	}

	/**
	 * Test method for
	 * {@link by.koroza.shape.reader.Reader#getCorrectCoordinates(java.lang.String)}.
	 * 
	 * @throws FileException
	 */
	@Test(description = "This method get path file and reading lines coordinates from file and return if found correct line or lines - List<String> with lines, if not to found correct lines - empty List<String>, if incorrect file path or file does not exist - an error FileException.class will appear.")
	public void testGetCorrectCoordinates() throws FileException {
		List<String> actual = reader.getCorrectCoordinates(STRING_FILE_PATH_CORRECT_TXT_WITH_FIGURE);
		List<String> expected = new ArrayList<>();
		expected.add("-1,-1 0,0 1,1");
		expected.add("5,4.31 4.532,0 700.25,800.66");
		expected.add("-2,-1 0,0 5,4");
		assertEquals(actual, expected);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		reader = null;
	}
}