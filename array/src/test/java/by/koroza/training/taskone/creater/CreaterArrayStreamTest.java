package by.koroza.training.taskone.creater;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.array.creater.CreaterArrayStream;
import by.koroza.array.entity.CustomArray;
import by.koroza.array.exception.ArrayException;

public class CreaterArrayStreamTest {
	private static final String FILE_PATH_CORRECT_HAVE_CORRECT_LINE = "src/test/resources/part2/text_have_correct_line.txt";
	private File fileCorrectHaveCorrectLine;
	private static final String FILE_PATH_CORRECT_NOT_HAVE_CORRECT_LINE = "src/test/resources/part2/text_not_have_correct_line.txt";
	private File fileCorrectNotHaveCorrectLine;
	private static final String FILE_PATH_CORRECT_NOT_HAVE_LINES = "src/test/resources/part2/text_not_have_lines.txt";
	private File fileCorrectNotHaveLines;
	private static final String FILE_PATH_INCORRECT = "src/test/resources/part2/text.txt";
	private File fileIncorrect;
	private CustomArray emptyCustomArray;
	private CreaterArrayStream createrArrayStream;

	@BeforeClass
	public void setUp() {
		this.createrArrayStream = new CreaterArrayStream();
		this.emptyCustomArray = new CustomArray();
		this.fileCorrectHaveCorrectLine = new File(FILE_PATH_CORRECT_HAVE_CORRECT_LINE);
		this.fileCorrectNotHaveCorrectLine = new File(FILE_PATH_CORRECT_NOT_HAVE_CORRECT_LINE);
		this.fileCorrectNotHaveLines = new File(FILE_PATH_CORRECT_NOT_HAVE_LINES);
		this.fileIncorrect = new File(FILE_PATH_INCORRECT);
	}

	@DataProvider(name = "providerOfFiles")
	public Object[][] providerFiles() throws ArrayException {
		return new Object[][] { { new CustomArray(1, 9, 2, -1, 0, -5, 8), fileCorrectHaveCorrectLine },
				{ emptyCustomArray, fileCorrectNotHaveCorrectLine }, { emptyCustomArray, fileCorrectNotHaveLines } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.creater.CreaterArrayStream#createrArrayFromFile(java.io.File)}.
	 * 
	 * @throws ArrayException
	 * @throws IOException
	 */
	@Test(dataProvider = "providerOfFiles", description = "The method reads lines from a file and if found correct line - return object of class CustomArray with elements array double type from found line, if not to found correct line - return empty object of class CustomArray, if not to found file by pass - throw new ArrayException")
	public void testCreaterArrayFromCorrectFile(CustomArray expected, File file) throws ArrayException, IOException {
		CustomArray actual = this.createrArrayStream.createrArrayFromFile(file);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.creater.CreaterArrayStream#createrArrayFromFile(java.io.File)}.
	 * 
	 * @throws ArrayException
	 * @throws IOException
	 */
	@Test(expectedExceptions = ArrayException.class, description = "The method reads lines from a file and if found correct line - return object of class CustomArray with elements array double type from found line, if not to found correct line - return empty object of class CustomArray, if not to found file by pass - throw new ArrayException")
	public void testCreaterArrayFromIncorrectFile() throws ArrayException, IOException {
		this.createrArrayStream.createrArrayFromFile(fileIncorrect);
	}

	@AfterClass
	public void tearDown() {
		this.createrArrayStream = null;
		this.emptyCustomArray = null;
		this.fileCorrectHaveCorrectLine = null;
		this.fileCorrectNotHaveCorrectLine = null;
		this.fileCorrectNotHaveLines = null;
		this.fileIncorrect = null;
	}
}