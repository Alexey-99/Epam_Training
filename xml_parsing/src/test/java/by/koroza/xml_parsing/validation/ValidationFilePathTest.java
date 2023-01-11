package by.koroza.xml_parsing.validation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidationFilePathTest {
	private static final String STRING_FILE_PATH_FOLDER_INCORRECT_XML = "src/test.sdf/resources/xml_files/flowers.xml";
	private static final String STRING_FILE_PATH_CORRECT_XML = "src/test/resources/xml_files/flowers.xml";
	private static final String STRING_FILE_PATH_FOLDER_INCORRECT_XSD = "src/test.sdf/resources/xml_files/flowers.xsd";
	private static final String STRING_FILE_PATH_CORRECT_XSD = "src/test/resources/xml_files/flowers.xsd";
	private static final String STRING_FILE_PATH_FILE_INCORRECT = "src/test/resources/xml_files/flowers";

	@BeforeClass
	public void setUp() {
	}

	@DataProvider(name = "createrPathsXML")
	public Object[][] createrPathsXML() {
		return new Object[][] { { null, false }, { "", false }, { STRING_FILE_PATH_FOLDER_INCORRECT_XML, false },
				{ STRING_FILE_PATH_FILE_INCORRECT, false }, { STRING_FILE_PATH_CORRECT_XML, true } };
	}

	@DataProvider(name = "createrPathsXSD")
	public Object[][] createrPathsXSD() {
		return new Object[][] { { null, false }, { "", false }, { STRING_FILE_PATH_FOLDER_INCORRECT_XSD, false },
				{ STRING_FILE_PATH_FILE_INCORRECT, false }, { STRING_FILE_PATH_CORRECT_XSD, true } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.xml_parsing.validation.ValidationFilePath#validFilePathXML(java.lang.String)}.
	 */
	@Test(dataProvider = "createrPathsXML", description = "This method check file path and return true if correct path, if incorrect path return false")
	public void testValidFilePathXML(String path, boolean expected) {
		boolean actual = ValidationFilePath.validFilePathXML(path);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.xml_parsing.validation.ValidationFilePath#validFilePathXSD(java.lang.String)}.
	 */
	@Test(dataProvider = "createrPathsXSD", description = "This method check file path and return true if correct path, if incorrect path return false")
	public void testValidFilePathXSD(String path, boolean expected) {
		boolean actual = ValidationFilePath.validFilePathXSD(path);
		assertEquals(actual, expected);
	}

	@AfterClass
	public void tearDown() {
	}
}