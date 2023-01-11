package by.koroza.training.taskone.creater;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.array.creater.CreaterArray;
import by.koroza.array.entity.CustomArray;
import by.koroza.array.exception.ArrayException;

public class CreaterArrayTest {
	private static final String FILE_PATH_CORRECT_HAVE_CORRECT_LINE = "src/test/resources/part2/text_have_correct_line.txt";
	private File fileCorrectHaveCorrectLine;
	private static final String FILE_PATH_CORRECT_NOT_HAVE_CORRECT_LINE = "src/test/resources/part2/text_not_have_correct_line.txt";
	private File fileCorrectNotHaveCorrectLine;
	private static final String FILE_PATH_CORRECT_NOT_HAVE_LINES = "src/test/resources/part2/text_not_have_lines.txt";
	private File fileCorrectNotHaveLines;
	private static final String FILE_PATH_INCORRECT = "src/test/resources/part2/text.txt";
	private File fileIncorrect;
	private CustomArray emptyCustomArray;
	private CreaterArray createrArray;

	@BeforeClass
	public void setUpBeforeClass() {
		this.createrArray = new CreaterArray();
		this.fileCorrectHaveCorrectLine = new File(FILE_PATH_CORRECT_HAVE_CORRECT_LINE);
		this.fileCorrectNotHaveCorrectLine = new File(FILE_PATH_CORRECT_NOT_HAVE_CORRECT_LINE);
		this.fileCorrectNotHaveLines = new File(FILE_PATH_CORRECT_NOT_HAVE_LINES);
		this.fileIncorrect = new File(FILE_PATH_INCORRECT);
		this.emptyCustomArray = new CustomArray();
	}

	@DataProvider(name = "providerOfFiles")
	public Object[][] providerFiles() throws ArrayException {
		return new Object[][] { { new CustomArray(1, 9, 2, -1, 0, -5, 8), this.fileCorrectHaveCorrectLine },
				{ this.emptyCustomArray, this.fileCorrectNotHaveCorrectLine },
				{ this.emptyCustomArray, this.fileCorrectNotHaveLines } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.creater.CreaterArray#createrArrayFromFile(java.io.File)}.
	 * 
	 * @throws ArrayException
	 */
	@Test(dataProvider = "providerOfFiles", description = "The method reads lines from a file and if found correct line - return object of class CustomArray with elements array double type from found line, if not to found correct line - return empty object of class CustomArray, if not to found file by pass - throw new ArrayException")
	public void testCreaterArrayFromCorrectFile(CustomArray expected, File file) throws ArrayException {
		CustomArray actual = this.createrArray.createrArrayFromFile(file);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.creater.CreaterArray#createrArrayFromFile(java.io.File)}.
	 * 
	 * @throws ArrayException
	 */
	@Test(expectedExceptions = ArrayException.class, description = "The method reads lines from a file and if found correct line - return object of class CustomArray with elements array double type from found line, if not to found correct line - return empty object of class CustomArray, if not to found file by pass - throw new ArrayException")
	public void testCreaterArrayFromIncorrectFile() throws ArrayException {
		this.createrArray.createrArrayFromFile(this.fileIncorrect);
	}

	@AfterClass
	public void tearDownAfterClass() {
		this.createrArray = null;
		this.fileCorrectHaveCorrectLine = new File(FILE_PATH_CORRECT_HAVE_CORRECT_LINE);
		this.fileCorrectNotHaveCorrectLine = new File(FILE_PATH_CORRECT_NOT_HAVE_CORRECT_LINE);
		this.fileCorrectNotHaveLines = new File(FILE_PATH_CORRECT_NOT_HAVE_LINES);
		this.fileIncorrect = new File(FILE_PATH_INCORRECT);
		this.emptyCustomArray = new CustomArray();
	}
}