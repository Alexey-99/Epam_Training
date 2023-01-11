package by.koroza.training.taskone.validation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.array.validation.Validation;

public class ValidationTest {

	@DataProvider(name = "createrArrayLines")
	public Object[][] createArrayLines() {
		return new Object[][] { { true, new String[] { "1", "9", "2", "-1", "0", "-5", "8" } },
				{ false, new String[] { "1gfbf", "9", "2a", "-1", "a0s", "-5", "8" } }, { false, new String[] {} } };
	}

	@DataProvider(name = "createrLines")
	public Object[][] createLines() {
		return new Object[][] { { true, "1 9 2 -1 0 -5 8" }, { false, "1gfbf 9 2a -1 a0s -5 8" }, { false, "" } };
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.validation.Validation#validReadLines(String[] lines)}.
	 */
	@Test(dataProvider = "createrArrayLines", description = "This method check to read line. If lines incorrect - return false, if correct lines - return true")
	public void testValidReadLines(boolean expected, String... array) {
		boolean actual = Validation.validReadLines(array);
		assertEquals(actual, expected);
	}

	/**
	 * Test method for
	 * {@link by.koroza.array.validation.Validation#validReadLinesStream(String line)}.
	 */
	@Test(dataProvider = "createrLines", description = "This method check to read line. If line incorrect - return false, if correct line - return true")
	public void testValidReadLinesStream(boolean expected, String line) {
		boolean actual = Validation.validReadLinesStream(line);
		assertEquals(actual, expected);
	}
}