package by.koroza.training.taskone.reader;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.array.exception.ArrayException;
import by.koroza.array.reader.ReaderStream;

public class ReaderStreamTest {
	private static final String FILE_PATH_CORRECT_HAVE_CORRECT_LINE = "src/test/resources/part2/text_have_correct_line.txt";
	private File fileCorrectHaveCorrectLine;
	private static final String FILE_PATH_CORRECT_NOT_HAVE_CORRECT_LINE = "src/test/resources/part2/text_not_have_correct_line.txt";
	private File fileCorrectNotHaveCorrectLine;
	private static final String FILE_PATH_CORRECT_NOT_HAVE_LINES = "src/test/resources/part2/text_not_have_lines.txt";
	private File fileCorrectNotHaveLines;
	private static final String FILE_PATH_INCORRECT = "src/test/resources/part2/text.txt";
	private File fileIncorrect;
	ReaderStream read;

	@BeforeClass
	public void setUp() {
		this.read = new ReaderStream();
		fileCorrectHaveCorrectLine = new File(FILE_PATH_CORRECT_HAVE_CORRECT_LINE);
		fileCorrectNotHaveCorrectLine = new File(FILE_PATH_CORRECT_NOT_HAVE_CORRECT_LINE);
		fileCorrectNotHaveLines = new File(FILE_PATH_CORRECT_NOT_HAVE_LINES);
		fileIncorrect = new File(FILE_PATH_INCORRECT);
	}

	@DataProvider(name = "providerOfFiles")
	public Object[][] providerFiles() {
		return new Object[][] { { "1 9 2 -1 0 -5 8", fileCorrectHaveCorrectLine },
				{ null, fileCorrectNotHaveCorrectLine }, { null, fileCorrectNotHaveLines } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.reader.ReaderStream#readLine(java.io.File)}.
	 * 
	 * @throws ArrayException
	 * @throws IOException
	 */
	@Test(dataProvider = "providerOfFiles", description = "The method reading lines from file and return: if found correct line - return her, if not to found correct line - return null, if not to found file by pass - throw new ArrayException")
	public void testReadLineFromCorrectFiles(String expected, File file) throws ArrayException, IOException {
		String actual = this.read.readLine(file);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.reader.ReaderStream#readLine(java.io.File)}.
	 * 
	 * @throws ArrayException
	 * @throws IOException
	 */
	@Test(expectedExceptions = ArrayException.class, description = "The method reading lines from file and return: if found correct line - return her, if not to found correct line - return null, if not to found file by pass - throw new ArrayException")
	public void testReadLineFromIncorrectLine() throws ArrayException, IOException {
		this.read.readLine(fileIncorrect);
	}

	@AfterClass
	public void tearDown() {
		this.read = null;
		fileCorrectHaveCorrectLine = null;
		fileCorrectNotHaveCorrectLine = null;
		fileCorrectNotHaveLines = null;
		fileIncorrect = null;
	}
}