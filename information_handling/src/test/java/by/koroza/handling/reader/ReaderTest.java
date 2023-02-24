package by.koroza.handling.reader;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.handling.exception.CustomException;

public class ReaderTest {
	private Reader reader;
	private static final String FILE_PATH_CORRECT_WITH_TEXT_OPTIONAL = "src/test/resources/text_optional.txt";
	private static final String FILE_PATH_CORRECT_EMPTY = "src/test/resources/text_empty_file.txt";
	private static final String FILE_PATH_INCORRECT = "src/main/resources/text";

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		this.reader = new Reader();
	}

	@DataProvider(name = "providerIncorrectFilePaths")
	private Object[] providerIncorrectFilePaths() {
		return new Object[] { null, FILE_PATH_INCORRECT };
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.reader.Reader#readTextFromFile(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerIncorrectFilePaths", expectedExceptions = CustomException.class, description = "This test-method testing if input parameters: null or incorrect file path. Expected result - CustomException.class")
	public void testReadTextFromIncorrectFilePath(String path) throws CustomException {
		this.reader.readTextFromFile(path);
	}

	@DataProvider(name = "providerCorrectFilePaths")
	private Object[][] providerCorrectFilePaths() {
		String textFilePathWithTextOpttional = "	It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularised in the 5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.	It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.	It is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a page when looking at its layout.	Bye.";
		return new Object[][] { { FILE_PATH_CORRECT_WITH_TEXT_OPTIONAL, textFilePathWithTextOpttional },
				{ FILE_PATH_CORRECT_EMPTY, "" } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.reader.Reader#readTextFromFile(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(dataProvider = "providerCorrectFilePaths", description="This test-method testing methd if give to parameters correct file path. Expected results: if file empty - return empty string of String.class, if file has text - return string with text from file of String.class")
	public void testReadTextFromCorrectFile(String path, String expected) throws CustomException {
		String actual = this.reader.readTextFromFile(path);
		assertEquals(actual, expected);
	}

	/**
	 */
	@AfterClass
	public void tearDownAfterClass() {
		this.reader = null;
	}
}