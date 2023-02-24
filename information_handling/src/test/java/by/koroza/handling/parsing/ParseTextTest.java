
package by.koroza.handling.parsing;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.koroza.handling.create.CreaterTextClass;
import by.koroza.handling.entity.Text;
import by.koroza.handling.exception.CustomException;
import by.koroza.handling.parsing.impl.ParseText;

public class ParseTextTest {
	private Text textObjectExpexted;
	private String textString;
	private ParseText parseText;

	/**
	 */
	@BeforeClass
	public void setUpBeforeClass() {
		this.textObjectExpexted = new CreaterTextClass().createText();
		this.textString = """
					It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in
				the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software
				like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!
					It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using
				Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like
				readable English?
					It is a established fact that a reader will be of a page when looking at its layout...
					Bye бандерлоги.
						""";
		this.parseText = new ParseText();
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.parsing.impl.ParseText#parse(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(expectedExceptions = CustomException.class, description = "This method get text of String.class and parse text after return Text of Text.class, if he getting null - CuctomException.class")
	public void testParseInputNull() throws CustomException {
		this.parseText.parse(null);
	}

	/**
	 * Test method for
	 * {@link by.koroza.handling.parsing.impl.ParseText#parse(java.lang.String)}.
	 * 
	 * @throws CustomException
	 */
	@Test(description = "This method get text of String.class and parse text after return Text of Text.class, if he getting null - CuctomException.class")
	public void testParse() throws CustomException {
		Text actual = this.parseText.parse(textString);
		assertEquals(actual, textObjectExpexted);
	}

	/**
	 * */
	@AfterClass
	public void tearDownAfterClass() {
		this.textObjectExpexted = null;
		this.textString = null;
		this.parseText = null;
	}
}