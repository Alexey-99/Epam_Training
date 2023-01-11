package by.koroza.training.taskone.parser;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.array.parser.Parser;

public class ParserTest {
	private Parser parser;

	@BeforeClass
	public void setUp() {
		this.parser = new Parser();
	}

	@DataProvider(name = "createrStrings")
	public Object[][] createrStrings() {
		return new Object[][] { { new double[] { 1, 9, 2, -1, 0, -5, 8 }, "1 9 2 -1 0 -5 8" },
				{ new double[0], null } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.parser.Parser#parseLine(java.lang.String)}.
	 */
	@Test(dataProvider = "createrStrings", description = "This method parse string to double number and return: if input string - return array double types, else null - return empty array double types")
	public void testParseLine(double[] expected, String line) {
		double[] actual = this.parser.parseLine(line);
		assertEquals(actual, expected);
	}

	@AfterClass
	public void tearDown() {
		this.parser = null;
	}
}